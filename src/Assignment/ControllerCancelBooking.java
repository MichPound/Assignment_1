package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static Assignment.Main.*;

public class ControllerCancelBooking {

    public ListView<String> viewShows;
    public ListView<String> viewPerformances;
    public ListView<String> viewBookings;

    public static ControllerCancelBooking cancelBookingController;
    public ChoiceBox<String> balconyChoice;
    public ChoiceBox<String> circleChoice;
    public ChoiceBox<String> stallChoice;


    public void startView() {
        viewShows.getSelectionModel().clearSelection();
        viewPerformances.getItems().clear();
        viewBookings.getItems().clear();
        balconyChoice.getItems().clear();
        circleChoice.getItems().clear();
        stallChoice.getItems().clear();
    }

    public void showSelected(MouseEvent mouseEvent) {
        viewPerformances.getItems().clear();
        viewBookings.getItems().clear();
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
        if (viewShows.getSelectionModel().getSelectedIndex() != -1) {
            int selected = viewShows.getSelectionModel().getSelectedIndex();
            int per = viewPerformances.getSelectionModel().getSelectedIndex();

            viewBookings.getItems().clear();
            if (listOfPerformances(selected, per).getBooking().getSize() > 0) {
                for (Booking b : listOfPerformances(selected, per).getBooking()) {
                    viewBookings.getItems().add(b.getName());
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data not defined");
            alert.setContentText("Please make sure you have selected a show");
            alert.showAndWait();
        }
    }

    public void bookSelected(MouseEvent mouseEvent) {
        try {
            balconyChoice.getItems().clear();
            circleChoice.getItems().clear();
            stallChoice.getItems().clear();
            int selected = viewShows.getSelectionModel().getSelectedIndex();
            int per = viewPerformances.getSelectionModel().getSelectedIndex();
            int book = viewBookings.getSelectionModel().getSelectedIndex();

            listOfBookings(selected, per, book).getSeatPlan().get2(10000);
            for (int i = 0; i < listOfBookings(selected, per, book).getSeatPlan().getSize(); i++) {
                if (listOfBookings(selected, per, book).getSeatPlan().get2(i).contains("B")) {
                    balconyChoice.getItems().add(listOfBookings(selected, per, book).getSeatPlan().get2(i));
                } else if (listOfBookings(selected, per, book).getSeatPlan().get2(i).contains("C")) {
                    circleChoice.getItems().add(listOfBookings(selected, per, book).getSeatPlan().get2(i));
                } else {
                    stallChoice.getItems().add(listOfBookings(selected, per, book).getSeatPlan().get2(i));
                }
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data not defined");
            alert.setContentText("Please select a performance with bookings");
            alert.showAndWait();
        }
    }

    public void cancelSelected(ActionEvent actionEvent) {
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        int per = viewPerformances.getSelectionModel().getSelectedIndex();
        int book = viewBookings.getSelectionModel().getSelectedIndex();

        String toBeRemovedB = String.valueOf(balconyChoice.getSelectionModel().getSelectedItem());
        String toBeRemovedC = String.valueOf(circleChoice.getSelectionModel().getSelectedItem());
        String toBeRemovedS = String.valueOf(stallChoice.getSelectionModel().getSelectedItem());
        for (int i = 0; i < listOfBookings(selected, per, book).getSeatPlan().getSize(); i++) {
            if (listOfBookings(selected, per, book).getSeatPlan().get2(i).equalsIgnoreCase(toBeRemovedB)) {
                listOfBookings(selected, per, book).getSeatPlan().remove(i);
            } else if (listOfBookings(selected, per, book).getSeatPlan().get2(i).equalsIgnoreCase(toBeRemovedC)) {
                listOfBookings(selected, per, book).getSeatPlan().remove(i);
            } else if (listOfBookings(selected, per, book).getSeatPlan().get2(i).equalsIgnoreCase(toBeRemovedS)) {
                listOfBookings(selected, per, book).getSeatPlan().remove(i);
            }
        }
        startView();
    }

    public void cancelBooking(ActionEvent actionEvent) {
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        int per = viewPerformances.getSelectionModel().getSelectedIndex();
        int book = viewBookings.getSelectionModel().getSelectedIndex();
        listOfPerformances(selected, per).getBooking().remove(book);
        startView();
        Main.updateShows();
        Main.setMain();
    }

    public void cancel8(ActionEvent actionEvent) {
        Main.setCancelFacility();
    }

    public void returnHome(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize() {
        cancelBookingController = this;
    }
}
