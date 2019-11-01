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

import static Assignment.Main.shows;

public class ControllerAddBooking {

    public static ControllerAddBooking addBookingController;

    public TextField bookName;
    public TextField bookSeats;
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

    public void cancel3(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize() {
        addBookingController = this;
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
                    bookingGridS.add(stalls.get2(1), c, r);
                    S.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    checkS++;
                }
                if (seat <= 30) {
                    C = new ToggleButton("C" + seat);
                    C.setId("C" + seat);
                    C.setOnAction(this::ButtonClicked);
                    circle.addItem(C);
                    if (checkC <= 30) {
                        bookingGridC.add(circle.get2(1), c, r);
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
                            bookingGridB.add(balcony.get2(1), c, r);
                            B.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            checkB++;
                        }
                        bal--;
                    }
                }
                seat--;
            }
        }

    }

    CustomList<String> test = new CustomList<>();

    public void ButtonClicked(ActionEvent actionEvent) {
        //   System.out.println(((ToggleButton) actionEvent.getSource()).getId());
//        ((ToggleButton) actionEvent.getSource()).getStyleClass().add("toggle-button");
        // if(((ToggleButton) actionEvent.getSource()).isFocused()){
        if ((((ToggleButton) actionEvent.getSource()).getText().contains("S"))) {
            ((ToggleButton) actionEvent.getSource()).setText("X");
            test.addItem(((ToggleButton) actionEvent.getSource()).getId());
        } else if ((((ToggleButton) actionEvent.getSource()).getText().contains("X"))) {
            ((ToggleButton) actionEvent.getSource()).setText(((ToggleButton) actionEvent.getSource()).getId());
            for (int i = 0; i < 10; i++) {//..........................................................................
                if (((CustomNode) test.get(i)).getContents().toString().contains(((ToggleButton) actionEvent.getSource()).getId())) {
                    test.remove(i);
                    System.out.println("this for loop is actually doing something");
                }
            }
            //remove from list
        }
        // }
        if (test.getSize() > 0) {
            for (int i = 0; i < test.getSize(); i++) {
                System.out.println(test.get2(i));
            }
        }
        System.out.println("---------------------------------------------------");
    }


    public void mousePressed(MouseEvent mouseEvent) {
//        System.out.println("its actually doing something");
//        for (int index = 0; index < stalls.size(); index++) {
//            if (stalls.get(index).isSelected()) {
//                stalls.get(index).setStyle("-fx-border-color: rgb(0,0,0);-fx-background-color: rgba(192,0,1,0.93); ");
//            }
//        }
    }

    public void getGridB(MouseEvent mouseEvent) {
        //B.setStyle("-fx-border-color: rgb(0,0,0);-fx-background-color: rgba(192,0,1,0.93); ");
        //System.out.println(bookingGridB.);
        //stalls.get(40 - 6).setStyle("-fx-border-color: rgb(0,0,0);-fx-background-color: rgba(192,0,1,0.93); ");
    }


    public void addBooking(ActionEvent actionEvent) {
        int selected = bookShow.getSelectionModel().getSelectedIndex();
        CustomNode tempShow = (CustomNode) shows.get(selected + 1);
        Show theShow = (Show) tempShow.getContents();
        int per = bookPerformance.getSelectionModel().getSelectedIndex();
        CustomNode tempPer = (CustomNode) theShow.getPerformances().get(per + 1);
        Performance thePerformance = (Performance) tempPer.getContents();

        thePerformance.addBooking(new Booking(bookName.getText(), Integer.valueOf(bookSeats.getText()), seatType));
        Main.setMain();
    }


}
