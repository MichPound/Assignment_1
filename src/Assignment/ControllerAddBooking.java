package Assignment;

import Lists.CustomList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.UUID;

import static Assignment.Main.*;

public class ControllerAddBooking {

    public static ControllerAddBooking addBookingController;

    public TextField bookName;
    public ListView<String> bookShow;
    public ListView<String> bookPerformance;
    public GridPane bookingGridS;
    public GridPane bookingGridC;
    public GridPane bookingGridB;
    private CustomList<ToggleButton> stalls = new CustomList<ToggleButton>();
    private CustomList<ToggleButton> circle = new CustomList<ToggleButton>();
    private CustomList<ToggleButton> balcony = new CustomList<ToggleButton>();
    private CustomList<String> seatList;

    //Used to set up fresh scene
    public void startView() {
        bookShow.getSelectionModel().clearSelection();
        bookName.setText("");
        bookPerformance.getItems().clear();
        createTable();
    }

    //Creates a new table of toggle buttons
    private void createTable() {
        seatList = new CustomList<>();
        int seat = 40;
        int bal = 24;
        int checkS = 0;
        int checkC = 0;
        int checkB = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 9; c >= 0; c--) {
                ToggleButton s = new ToggleButton("S" + seat);
                s.setId("S" + seat);
                s.setOnAction(this::ButtonClicked);
                stalls.addItem(s);
                if (checkS <= 40) {
                    bookingGridS.add(stalls.get2(0), c, r);
                    s.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    checkS++;
                }
                if (seat <= 30) {
                    ToggleButton c1 = new ToggleButton("C" + seat);
                    c1.setId("C" + seat);
                    c1.setOnAction(this::ButtonClicked);
                    circle.addItem(c1);
                    if (checkC <= 30) {
                        bookingGridC.add(circle.get2(0), c, r);
                        c1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                        checkC++;
                    }
                }
                if (bal <= 24) {
                    if (!(c == 0 || c == 9)) {
                        ToggleButton b = new ToggleButton("B" + bal);
                        b.setId("B" + bal);
                        b.setOnAction(this::ButtonClicked);
                        balcony.addItem(b);
                        if (checkB <= 23) {
                            bookingGridB.add(balcony.get2(0), c, r);
                            b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            checkB++;
                        }
                        bal--;
                    }
                }
                seat--;
            }
        }

    }

    //Allows for the selection of a show and loads in performances
    public void bookedShow(MouseEvent mouseEvent) {
        bookPerformance.getItems().clear();
        int selected = bookShow.getSelectionModel().getSelectedIndex();
        Show theShow = shows.get2(selected);

        if (theShow.getPerformances().getSize() > 0) {
            for (Performance p : theShow.getPerformances()) {
                bookPerformance.getItems().add(p.getTitle());
            }
            createTable();
        } else {
            bookShow.getSelectionModel().clearSelection();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Performance Stored");
            alert.setContentText("There is no performances stored for that show, please add performance before adding a booking");
            alert.showAndWait();
        }
    }

    //Allows for the selection of a performance and colours all booked seats red
    public void bookedPerformance(MouseEvent mouseEvent) {
        int selected = bookShow.getSelectionModel().getSelectedIndex();
        int per = bookPerformance.getSelectionModel().getSelectedIndex();
        CustomList<String> allSeats = new CustomList<>();

        for (Booking b : listOfPerformances(selected, per).getBooking()) {
            int size = b.getSeatPlan().getSize();
            for (int i = 0; i < size; i++) {
                allSeats.addItem(b.getSeatPlan().get2(i));
            }
        }
        createTable();
        for (int k = 0; k < allSeats.getSize(); k++) {
            for (int s = 0; s < 40; s++) {
                if (stalls.get2(s).getText().equalsIgnoreCase(allSeats.get2(k))) {
                    stalls.get2(s).setStyle("-fx-background-color:#a81e13");
                }
            }
            for (int c = 0; c < 30; c++) {
                if (circle.get2(c).getText().equalsIgnoreCase(allSeats.get2(k))) {
                    circle.get2(c).setStyle("-fx-background-color:#a81e13");
                }
            }
            for (int b = 0; b < balcony.getSize(); b++) {
                if (balcony.get2(b).getText().equalsIgnoreCase(allSeats.get2(k))) {
                    balcony.get2(b).setStyle("-fx-background-color:#a81e13");
                }
            }
        }
    }

    //Stops double booking of seats, if seat is selectable it is added to linked list, if already in the linked list it removes it from the linked list
    //Sets seat colour appropriately
    private void ButtonClicked(ActionEvent actionEvent) {
        if (bookShow.getSelectionModel().getSelectedIndex() == -1 && bookPerformance.getSelectionModel().getSelectedIndex() == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Data");
            alert.setContentText("Please select a performance before selecting a seat");
            alert.showAndWait();
        } else {
            if ((((ToggleButton) actionEvent.getSource()).getStyle().equals("-fx-background-color:#a81e13"))) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Seat selected");
                alert.setContentText("This seat is already selected, please select another");
                alert.showAndWait();
            } else {
                if ((((ToggleButton) actionEvent.getSource()).getText().equals("X"))) {
                    ((ToggleButton) actionEvent.getSource()).setText(((ToggleButton) actionEvent.getSource()).getId());

                    for (int i = 0; i < seatList.getSize(); i++) {
                        if (seatList.get2(i).contains(((ToggleButton) actionEvent.getSource()).getId())) {
                            seatList.remove(i);
                        }
                    }
                } else {
                    ((ToggleButton) actionEvent.getSource()).setText("X");
                    seatList.addItem(((ToggleButton) actionEvent.getSource()).getId());
                }
            }
        }
    }

    //Validates all information is correct, generates unique ID and adds the new booking to the performance selected
    public void addBooking(ActionEvent actionEvent) {
        if (!bookName.getText().equals("") && bookShow.getSelectionModel().getSelectedIndex() != -1 && bookPerformance.getSelectionModel().getSelectedIndex() != -1 && seatList.getSize() != 0) {
            int selected = bookShow.getSelectionModel().getSelectedIndex();
            int per = bookPerformance.getSelectionModel().getSelectedIndex();
            String id = UUID.randomUUID().toString();
            String oldIds = "";

            for (Performance p : listOfShows(selected).getPerformances()) {
                int size = p.getBooking().getSize();
                for (int i = 0; i < size; i++) {
                    oldIds = oldIds + p.getBooking().get2(i).getId();
                }
            }
            while (oldIds.contains(id)) {
                id = UUID.randomUUID().toString();
            }
            listOfPerformances(selected, per).addBooking(new Booking(bookName.getText(), id, seatList));
            Main.setMain();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data Error");
            alert.setContentText("Please ensure you have entered all information correctly");
            alert.showAndWait();
        }
    }

    //Exits to menu
    public void cancel3(ActionEvent actionEvent) {
        Main.setMain();
    }

    //Initializes class
    public void initialize() {
        addBookingController = this;
    }
}
