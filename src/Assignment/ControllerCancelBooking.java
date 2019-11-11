package Assignment;

import Lists.CustomList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import static Assignment.Main.*;

public class ControllerCancelBooking {

    public ListView<String> viewShows;
    public ListView<String> viewPerformances;
    public ListView<String> viewBookings;
    public GridPane bookingGridB;
    public GridPane bookingGridC;
    public GridPane bookingGridS;

    public static ControllerCancelBooking cancelBookingController;

    private ToggleButton S = new ToggleButton();
    private ToggleButton C = new ToggleButton();
    private ToggleButton B = new ToggleButton();
    private CustomList<ToggleButton> stalls = new CustomList<ToggleButton>();
    private CustomList<ToggleButton> circle = new CustomList<ToggleButton>();
    private CustomList<ToggleButton> balcony = new CustomList<ToggleButton>();

    public void startView() {
        int seat = 40;
        int bal = 24;
        int checkS = 0, checkC = 0, checkB = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 9; c >= 0; c--) {
                S = new ToggleButton("S" + seat);
                S.getStyleClass().add("custom-button");
                stalls.addItem(S);
                if (checkS <= 40) {
                    bookingGridS.add(stalls.get2(0), c, r);
                    checkS++;
                }
                if (seat <= 30) {
                    C = new ToggleButton("C" + seat);
                    C.setId("C" + seat);
                    C.getStyleClass().add("custom-button");
                    circle.addItem(C);
                    if (checkC <= 30) {
                        bookingGridC.add(circle.get2(0), c, r);
                        checkC++;
                    }
                }
                if (bal <= 24) {
                    if (!(c == 0 || c == 9)) {
                        B = new ToggleButton("B" + bal);
                        B.setId("B" + bal);
                        B.getStyleClass().add("custom-button");
                        balcony.addItem(B);
                        if (checkB <= 23) {
                            bookingGridB.add(balcony.get2(0), c, r);
                            checkB++;
                        }
                        bal--;
                    }
                }
                seat--;
            }
        }
    }

    public void showSelected(MouseEvent mouseEvent) {
        viewPerformances.getItems().clear();
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        if (listOfShows(selected).getPerformances().getSize() > 0) {
            for (Performance p : listOfShows(selected).getPerformances()) {
                viewPerformances.getItems().add(p.getTitle());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Performance Stored");
            alert.setContentText("There is no performances stored for that show");
            alert.showAndWait();
        }
    }

    public void performanceSelected(MouseEvent mouseEvent) {
        try {
            int selected = viewShows.getSelectionModel().getSelectedIndex();
            int per = viewPerformances.getSelectionModel().getSelectedIndex();

            viewBookings.getItems().clear();
            if (listOfPerformances(selected, per).getBooking().getSize() > 0) {
                for (Booking b : listOfPerformances(selected, per).getBooking()) {
                    viewBookings.getItems().add(b.getName());
                }
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data not defined");
            alert.setContentText("Please select a show first");
            alert.showAndWait();
        }
    }

    public void bookSelected(MouseEvent mouseEvent) {
        try {
            int selected = viewShows.getSelectionModel().getSelectedIndex();
            int per = viewPerformances.getSelectionModel().getSelectedIndex();
            int book = viewBookings.getSelectionModel().getSelectedIndex();

            CustomList<String> test = listOfBookings(selected, per, book).getSeatPlan();
            if (test.getSize() > 0) {
                for (int i = 0; i < test.getSize(); i++) {
                    for (int k = 0; k < test.getSize(); k++) {
                        for (int s = 0; s < stalls.getSize(); s++) {
                            if (stalls.get2(s).getText().equalsIgnoreCase(test.get2(k))) {
                                stalls.get2(s).setStyle("-fx-background-color:#0a7ab9");
                            }
                        }
                        for (int c = 0; c < circle.getSize(); c++) {
                            if (circle.get2(c).getText().equalsIgnoreCase(test.get2(k))) {
                                circle.get2(c).setStyle("-fx-background-color:#0a7ab9");
                            }
                        }
                        for (int b = 0; b < balcony.getSize(); b++) {
                            if (balcony.get2(b).getText().equalsIgnoreCase(test.get2(k))) {
                                balcony.get2(b).setStyle("-fx-background-color:#0a7ab9");
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data not defined");
            alert.setContentText("Please select a show and a performance first");
            alert.showAndWait();
        }
    }

    public void cancelBooking(ActionEvent actionEvent) {
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        int per = viewPerformances.getSelectionModel().getSelectedIndex();
        int book = viewBookings.getSelectionModel().getSelectedIndex();
        listOfPerformances(selected, per).getBooking().remove(book);
        Main.updateShows();
        Main.setMain();
    }

    public void cancel8(ActionEvent actionEvent) {
        Main.setCancelFacility();
    }

    public void initialize() {
        cancelBookingController = this;
    }


}
