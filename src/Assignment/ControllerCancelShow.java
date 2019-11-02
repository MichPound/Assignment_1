package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

import static Assignment.Main.shows;

public class ControllerCancelShow {
    public static ControllerCancelShow cancelShowController;

    public ListView<String> removeShow;

    public void removingShow(ActionEvent actionEvent) {
        int index = removeShow.getSelectionModel().getSelectedIndex();
        shows.remove(index);

        Main.updateShows();
        Main.setMain();
    }

    public void cancel6(ActionEvent actionEvent) {
        removeShow.getSelectionModel().clearSelection();
        Main.setCancelFacility();
    }

    public void initialize() {
        cancelShowController = this;
    }
}
