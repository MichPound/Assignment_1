package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

public class ControllerMain {
    public static ControllerMain mainController;

    public ListView<String> listShows;

    public void addShow(ActionEvent actionEvent) {
        Main.setAddShow();
    }

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

    public void addList(String list) {
        listShows.getItems().add(list);
    }

    public void saveLists(ActionEvent actionEvent) throws Exception {
        Main.save();
    }

    public void loadLists(ActionEvent actionEvent) throws Exception {
        Main.load();
        Main.updateShows();
    }

    public void initialize() {
        mainController = this;
    }

}
