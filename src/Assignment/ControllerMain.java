package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.util.Optional;

import static Assignment.Main.shows;

public class ControllerMain {
    public static ControllerMain mainController;

//    public ListView<String> listShows;

    public void addShow(ActionEvent actionEvent) {
        Main.setAddShow();
    }

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

    public void saveLists(ActionEvent actionEvent) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save");
        alert.setContentText("This will save the current shows displayed, and will overwrite the previous save");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Main.save();
        }
    }

    public void loadLists(ActionEvent actionEvent) throws Exception {
        Main.load();
        Main.updateShows();
    }

    public void initialize() {
        mainController = this;
    }
}
