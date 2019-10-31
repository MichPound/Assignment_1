package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static Assignment.Main.*;

public class ControllerViewFacilities {
    public static ControllerViewFacilities viewFacilitiesController;

    public ListView<String> viewShows;
    public ListView<String> viewPerformances;
    public ListView<String> viewBookings;
    public Label showTitle;
    public Label showTime;
    public Label startDate;
    public Label endDate;
    public Label bCost;
    public Label cCost;
    public Label sCost;
    public Label performanceTitle;
    public Label performanceDate;
    public Label performanceTime;
    public Label bookName;
    public Label seats;
    public Label seatType;

    public void startView() {
        viewPerformances.getItems().clear();
        viewBookings.getItems().clear();
        showTitle.setText("Title");
        showTime.setText("Time");
        startDate.setText("Start Date");
        endDate.setText("End Date");
        bCost.setText("Cost");
        cCost.setText("Cost");
        sCost.setText("Cost");
        performanceTitle.setText("Title");
        performanceDate.setText("Date");
        performanceTime.setText("Time");
        bookName.setText("Name");
        seats.setText("Seats");
        seatType.setText("Type");
    }

    public void showSelected(MouseEvent mouseEvent) {
        startView();
        int selected = viewShows.getSelectionModel().getSelectedIndex();

        showTitle.setText(listOfShows(selected).getTitle());
        showTime.setText(listOfShows(selected).getTime() + " Minutes");
        startDate.setText(listOfShows(selected).getsDate());
        endDate.setText(listOfShows(selected).geteDate());
        bCost.setText("Balcony: $" + listOfShows(selected).getbCost());
        cCost.setText("Circle: $" + listOfShows(selected).getcCost());
        sCost.setText("Stalls: $" + listOfShows(selected).getsCost());

        if (listOfShows(selected).getPerformances().getSize() > 0) {
            for (Performance p : listOfShows(selected).getPerformances()) {
                viewPerformances.getItems().add(p.getTitle());
                System.out.println(p.getTitle());
            }
        }
    }

    public void performanceSelected(MouseEvent mouseEvent) {
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        int per = viewPerformances.getSelectionModel().getSelectedIndex();

        performanceTitle.setText(listOfPerformances(selected, per).getTitle());
        performanceDate.setText(listOfPerformances(selected, per).getDate());
        performanceTime.setText(listOfPerformances(selected, per).getTime());

        viewBookings.getItems().clear();
        if (listOfPerformances(selected, per).getBooking().getSize() > 0) {
            for (Booking b : listOfPerformances(selected, per).getBooking()) {
                viewBookings.getItems().add(b.getName());
            }
        }
    }

    public void bookSelected(MouseEvent mouseEvent) {
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        int per = viewPerformances.getSelectionModel().getSelectedIndex();
        int book = viewBookings.getSelectionModel().getSelectedIndex();

        bookName.setText(listOfBookings(selected, per, book).getName());
        seats.setText(String.valueOf(listOfBookings(selected, per, book).getSeats()));
        if (listOfBookings(selected, per, book).getsType() == 0) {
            seatType.setText("Continuous");
        } else {
            seatType.setText("Scattered");
        }
    }

    public void cancel4(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize() {
        viewFacilitiesController = this;
    }
}
