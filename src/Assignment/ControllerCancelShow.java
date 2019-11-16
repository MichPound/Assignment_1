package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import static Assignment.Main.shows;

public class ControllerCancelShow {
    public static ControllerCancelShow cancelShowController;

    public ListView<String> removeShow;

    public void removingShow(ActionEvent actionEvent) {
        if (removeShow.getSelectionModel().getSelectedIndex() != -1) {
            int index = removeShow.getSelectionModel().getSelectedIndex();
            shows.remove(index);
            removeShow.getSelectionModel().clearSelection();
            Main.updateShows();
            Main.setMain();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Show Selected");
            alert.setContentText("Please select a show first");
            alert.showAndWait();
        }
    }

    public void cancel6(ActionEvent actionEvent) {
        removeShow.getSelectionModel().clearSelection();
        Main.setCancelFacility();
    }

    public void initialize() {
        cancelShowController = this;
    }
}
