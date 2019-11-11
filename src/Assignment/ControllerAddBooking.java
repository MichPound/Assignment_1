package Assignment;

import Lists.CustomList;
import Lists.CustomNode;
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
    public int seatType;
    public ListView<String> bookShow;
    public ListView<String> bookPerformance;
    public GridPane bookingGridS;
    public GridPane bookingGridC;
    public GridPane bookingGridB;
    private ToggleButton S = new ToggleButton();
    private ToggleButton C = new ToggleButton();
    private ToggleButton B = new ToggleButton();
    private CustomList<ToggleButton> stalls = new CustomList<ToggleButton>();
    private CustomList<ToggleButton> circle = new CustomList<ToggleButton>();
    private CustomList<ToggleButton> balcony = new CustomList<ToggleButton>();
    private CustomList<String> seatList;
    private CustomList<String> allSeats;

    public void startView() {

        bookPerformance.getItems().clear();
        seatList = new CustomList<>();
        int seat = 40;
        int bal = 24;
        int checkS = 0;
        int checkC = 0;
        int checkB = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 9; c >= 0; c--) {
                S = new ToggleButton("S" + seat);
                S.setId("S" + seat);
                S.setOnAction(this::ButtonClicked);
                stalls.addItem(S);
                if (checkS <= 40) {
                    bookingGridS.add(stalls.get2(0), c, r);
                    S.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    checkS++;
                }
                if (seat <= 30) {
                    C = new ToggleButton("C" + seat);
                    C.setId("C" + seat);
                    C.setOnAction(this::ButtonClicked);
                    circle.addItem(C);
                    if (checkC <= 30) {
                        bookingGridC.add(circle.get2(0), c, r);
                        C.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                        checkC++;
                    }
                }
                if (bal <= 24) {
                    if (!(c == 0 || c == 9)) {
                        B = new ToggleButton("B" + bal);
                        B.setId("B" + bal);
                        B.setOnAction(this::ButtonClicked);
                        balcony.addItem(B);
                        if (checkB <= 23) {
                            bookingGridB.add(balcony.get2(0), c, r);
                            B.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            checkB++;
                        }
                        bal--;
                    }
                }
                seat--;
            }
        }

        int fullness = seatList.getSize();
        for (int i = 0; i < fullness; i++) {
            seatList.remove(0);
        }
    }

    public void continuous(ActionEvent actionEvent) {
        seatType = 0;
    }

    public void scattered(ActionEvent actionEvent) {
        seatType = 1;
    }

    public void bookedShow(MouseEvent mouseEvent) {
        bookPerformance.getItems().clear();

        int selected = bookShow.getSelectionModel().getSelectedIndex();
        CustomNode tempShow = (CustomNode) shows.get(selected + 1);
        Show theShow = (Show) tempShow.getContents();
        if (theShow.getPerformances().getSize() > 0) {
            for (Performance p : theShow.getPerformances()) {
                bookPerformance.getItems().add(p.getTitle());
            }
        } else {
            bookShow.getSelectionModel().clearSelection();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Performance Stored");
            alert.setContentText("There is no performances stored for that show, please add performance before adding a booking");
            alert.showAndWait();
        }
    }

    public void bookedPerformance(MouseEvent mouseEvent) {
        int selected = bookShow.getSelectionModel().getSelectedIndex();
        int per = bookPerformance.getSelectionModel().getSelectedIndex();
        allSeats = new CustomList<>();

        for (Booking b : listOfPerformances(selected, per).getBooking()) {
            int size = b.getSeatPlan().getSize();
            for (int i = 0; i < size; i++) {
                allSeats.addItem(b.getSeatPlan().get2(i));
                System.out.println(b.getSeatPlan().get2(i));
            }
        }
        for (int k = 0; k < allSeats.getSize(); k++) {
            for (int s = 0; s < stalls.getSize(); s++) {
                if (stalls.get2(s).getText().equalsIgnoreCase(allSeats.get2(k))) {
                    stalls.get2(s).setStyle("-fx-background-color:#a81e13");
                }
            }
            for (int c = 0; c < circle.getSize(); c++) {
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

    public void ButtonClicked(ActionEvent actionEvent) {
        if ((((ToggleButton) actionEvent.getSource()).getStyle().equals("-fx-background-color:#a81e13"))) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seat selected");
            alert.setContentText("This seat is already selected, please select another");
            alert.showAndWait();
        } else {
            if ((((ToggleButton) actionEvent.getSource()).getText().equals("X"))) {
                System.out.println(((ToggleButton) actionEvent.getSource()).getId());
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

    public void testAdd(ActionEvent actionEvent) {
        System.out.println("---------------------------------------------------");
        if (seatList.getSize() > 0) {
            for (int i = 0; i < seatList.getSize(); i++) {
                System.out.println(seatList.get2(i));
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public void addBooking(ActionEvent actionEvent) {
        double cost = 0;
        int selected = bookShow.getSelectionModel().getSelectedIndex();
        int per = bookPerformance.getSelectionModel().getSelectedIndex();

        int length = seatList.getSize();

        for (int i = 0; i < length; i++) {
            if (seatList.get2(i).contains("B")) {
                cost = cost + listOfShows(selected).getbCost();
                System.out.println("B = " + listOfShows(selected).getbCost());
            }
            if (seatList.get2(i).contains("C")) {
                cost = cost + listOfShows(selected).getcCost();
            }
            if (seatList.get2(i).contains("S")) {
                cost = cost + listOfShows(selected).getsCost();
            }
        }

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

        listOfPerformances(selected, per).addBooking(new Booking(bookName.getText(), id, seatList.getSize(), seatType, cost, seatList));
        Main.setMain();
    }

    public void cancel3(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize() {
        addBookingController = this;
    }
}
