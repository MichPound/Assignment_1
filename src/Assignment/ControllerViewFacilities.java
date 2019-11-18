package Assignment;

import Lists.CustomList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import static Assignment.Main.*;

public class ControllerViewFacilities {
    public static ControllerViewFacilities viewFacilitiesController;

    public ListView<String> viewShows, viewPerformances, viewBookings;
    public Label showTitle, showTime, startDate, endDate, bCost, cCost, sCost, performanceTitle, performanceDate, performanceTime, bookName, seats,  bookingCost, id, performanceBooks, performanceCost;
    public GridPane bookingGridS, bookingGridC, bookingGridB;

    private CustomList<Button> stalls = new CustomList<Button>();
    private CustomList<Button> circle = new CustomList<Button>();
    private CustomList<Button> balcony = new CustomList<Button>();
    private CustomList<String> allSeats;

    //Used to set up fresh scene
    public void startView() {
        viewPerformances.getItems().clear();
        viewBookings.getItems().clear();
        resetShow();
        resetPerformance();
        resetBooking();
        buttonTable();
    }

    //Creates a new table of buttons
    private void buttonTable() {
        int seat = 40;
        int bal = 24;
        int checkS = 0, checkC = 0, checkB = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 9; c >= 0; c--) {
                Button s = new Button("S" + seat);
                s.getStyleClass().add("custom-button");
                stalls.addItem(s);
                if (checkS <= 40) {
                    bookingGridS.add(stalls.get2(0), c, r);
                    checkS++;
                }
                if (seat <= 30) {
                    Button c1 = new Button("C" + seat);
                    c1.setId("C" + seat);
                    c1.getStyleClass().add("custom-button");
                    circle.addItem(c1);
                    if (checkC <= 30) {
                        bookingGridC.add(circle.get2(0), c, r);
                        checkC++;
                    }
                }
                if (bal <= 24) {
                    if (!(c == 0 || c == 9)) {
                        Button b = new Button("B" + bal);
                        b.setId("B" + bal);
                        b.getStyleClass().add("custom-button");
                        balcony.addItem(b);
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

    //Allows for the selection of a show, sets all show details and loads in performances
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
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Performance Stored");
            alert.setContentText("There is no performances stored for that show");
            alert.showAndWait();
            startView();
        }
    }

    //Allows for the selection of a performance, sets all performance details and loads in bookings
    //Sets all seat booked to red on a new table
    public void performanceSelected(MouseEvent mouseEvent) {
        buttonTable();
        resetBooking();

        try {
            int selected = viewShows.getSelectionModel().getSelectedIndex();
            int per = viewPerformances.getSelectionModel().getSelectedIndex();

            double fullCost = 0.0;
            viewBookings.getItems().clear();
            if (listOfPerformances(selected, per).getBooking().getSize() > 0) {
                allSeats = new CustomList<String>();

                for (Booking b : listOfPerformances(selected, per).getBooking()) {
                    double tempCost = 0.0;

                    int length = b.getSeatPlan().getSize();
                    for (int i = 0; i < length; i++) {
                        if (b.getSeatPlan().get2(i).contains("B")) {
                            tempCost = tempCost + listOfShows(selected).getbCost();
                        }
                        if (b.getSeatPlan().get2(i).contains("C")) {
                            tempCost = tempCost + listOfShows(selected).getcCost();
                        }
                        if (b.getSeatPlan().get2(i).contains("S")) {
                            tempCost = tempCost + listOfShows(selected).getsCost();
                        }
                    }

                    viewBookings.getItems().add(b.getName());
                    fullCost = fullCost + tempCost;

                    int size = b.getSeatPlan().getSize();
                    for (int i = 0; i < size; i++) {
                        allSeats.addItem(b.getSeatPlan().get2(i));
                    }
                }
                colorTable(allSeats, "-fx-background-color:#a81e13");
            }
            performanceTitle.setText(listOfPerformances(selected, per).getTitle());
            performanceDate.setText(listOfPerformances(selected, per).getDate());
            performanceTime.setText(listOfPerformances(selected, per).getTime());
            performanceBooks.setText("Bookings made: " + listOfPerformances(selected, per).getBooking().getSize());
            performanceCost.setText("Performance total: $" + fullCost);

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data not defined");
            alert.setContentText("Please select a show first");
            alert.showAndWait();
            startView();
        }
    }

    //Allows for the selection of a booking, sets all booking details and sets all seats in that booking to blue
    public void bookSelected(MouseEvent mouseEvent) {
        colorTable(allSeats, "-fx-background-color:#a81e13");
        try {
            int selected = viewShows.getSelectionModel().getSelectedIndex();
            int per = viewPerformances.getSelectionModel().getSelectedIndex();
            int book = viewBookings.getSelectionModel().getSelectedIndex();
            bookName.setText(listOfBookings(selected, per, book).getName());
            seats.setText("Seats: " + listOfBookings(selected, per, book).getSeatPlan().getSize());

            double cost = 0;
            int length = listOfBookings(selected, per, book).getSeatPlan().getSize();
            for (int i = 0; i < length; i++) {
                if (listOfBookings(selected, per, book).getSeatPlan().get2(i).contains("B")) {
                    cost = cost + listOfShows(selected).getbCost();
                }
                if (listOfBookings(selected, per, book).getSeatPlan().get2(i).contains("C")) {
                    cost = cost + listOfShows(selected).getcCost();
                }
                if (listOfBookings(selected, per, book).getSeatPlan().get2(i).contains("S")) {
                    cost = cost + listOfShows(selected).getsCost();
                }
            }

            bookingCost.setText("$" + cost);
            id.setText((String.valueOf(listOfBookings(selected, per, book).getId())));
            CustomList<String> booked = listOfBookings(selected, per, book).getSeatPlan();

            if (booked.getSize() > 0) {
                for (int i = 0; i < booked.getSize(); i++) {
                    colorTable(booked, "-fx-background-color:#0a7ab9");
                }
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data not defined");
            alert.setContentText("Please select a show and a performance first");
            alert.showAndWait();
            startView();
        }
    }

    //This is used to change the colour of the seating table
    public void colorTable(CustomList<String> list, String color) {
        for (int k = 0; k < list.getSize(); k++) {
            for (int s = 0; s < 40; s++) {
                if (stalls.get2(s).getText().equalsIgnoreCase(list.get2(k))) {
                    stalls.get2(s).setStyle(color);
                }
            }
            for (int c = 0; c < 30; c++) {
                if (circle.get2(c).getText().equalsIgnoreCase(list.get2(k))) {
                    circle.get2(c).setStyle(color);
                }
            }
            for (int b = 0; b < balcony.getSize(); b++) {
                if (balcony.get2(b).getText().equalsIgnoreCase(list.get2(k))) {
                    balcony.get2(b).setStyle(color);
                }
            }
        }
    }

    //This resets all show details
    private void resetShow() {
        showTitle.setText("Title");
        showTime.setText("Time");
        startDate.setText("Start Date");
        endDate.setText("End Date");
        bCost.setText("Cost");
        cCost.setText("Cost");
        sCost.setText("Cost");
    }

    //This resets all performance details
    private void resetPerformance() {
        performanceTitle.setText("Title");
        performanceDate.setText("Date");
        performanceTime.setText("Time");
        performanceBooks.setText("Bookings Made: No.");
        performanceCost.setText("Performance Total: Cost");
    }

    //This resets all booking details
    private void resetBooking() {
        bookName.setText("Name");
        seats.setText("Seats");
        bookingCost.setText("Cost");
        id.setText("Booking Unique Identifier");
    }

    //Exits to menu
    public void cancel4(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize() {
        viewFacilitiesController = this;
    }
}
