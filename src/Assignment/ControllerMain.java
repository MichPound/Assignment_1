package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static Assignment.Main.shows;

public class ControllerMain {
    public static ControllerMain mainController;

    //Changes to the add show scene
    public void addShow(ActionEvent actionEvent) {
        Main.setAddShow();
    }

    //Checks if any shows are stored, if so changes to the add performance scene
    public void addPerformance(ActionEvent actionEvent) {
        if (shows.getSize() > 0) {
            Main.setAddPerformance();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Shows Stored");
            alert.setContentText("There is no shows in the system, please add a show to be able to add a performance");
            alert.showAndWait();
        }
    }

    //Checks if any performances are stored, if so changes to the add booking scene
    public void addBooking(ActionEvent actionEvent) {
        if (shows.getSize() > 0) {
            Main.setAddBooking();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Shows Stored");
            alert.setContentText("There is no shows in the system, please add a show before adding a booking");
            alert.showAndWait();
        }
    }

    //Checks if any shows are stored, if so changes to the view facilities scene
    public void viewFacilities(ActionEvent actionEvent) {
        if (shows.getSize() > 0) {
            Main.setViewFacility();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Shows Stored");
            alert.setContentText("There is no shows in the system");
            alert.showAndWait();
        }
    }

    //Checks if any shows are stored, if so changes to the cancel facilities scene
    public void cancelFacilities(ActionEvent actionEvent) {
        if (shows.getSize() > 0) {
            Main.setCancelFacility();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Shows Stored");
            alert.setContentText("There is no shows in the system");
            alert.showAndWait();
        }
    }

    //Displays an alert saying that this will clear anything stores in the system, if ok selected all shows removed therefore all performances and bookings removed too
    //To keep the clean systemt he user would then have to save to completely over right the old save
    public void resetFacilities(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Reset");
        alert.setContentText("This will remove all shows from the program, if you save after this all shows will be permanently removed from storage");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            int reset = shows.getSize();
            for (int i = 0; i < reset; i++) {
                shows.remove(0);
                Main.updateShows();
            }
        }
    }

    //Displays an alert saying that this will over write any current save, if ok selected save to xml file
    public void saveLists(ActionEvent actionEvent) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save");
        alert.setContentText("This will save the current shows displayed, and will overwrite the previous save");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Main.save();
        }
    }

    //Loads from xml file
    public void loadLists(ActionEvent actionEvent) throws Exception {
        Main.load();
        Main.updateShows();
    }

    public void initialize() {
        mainController = this;
    }
}
