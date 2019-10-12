package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ControllerMain {

    public void addShow(ActionEvent actionEvent) {
        Main.setAddShow();
    }

    public static TextField showTitle;

    public void addPerformance(ActionEvent actionEvent) {
        Main.setAddPerformance();
    }

    public void addBooking(ActionEvent actionEvent) {
        Main.setAddBooking();
    }

    public void viewFacilities(ActionEvent actionEvent) {
        Main.setViewFacility();
    }

    public void cancelFacilities(ActionEvent actionEvent) {
        Main.setCancelFacility();
    }

    public void resetFacilities(ActionEvent actionEvent) {
    }
}
