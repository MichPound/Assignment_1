package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static Assignment.Main.listOfShows;

public class ControllerCancelPerformance {

    static ControllerCancelPerformance cancelPerformanceController;
    public ListView<String> selectShow;
    public ListView<String> selectPerformance;

    public void startView() {
        reset();
    }

    public void listPerformances(MouseEvent mouseEvent) {
        selectPerformance.getItems().clear();
        int selected = selectShow.getSelectionModel().getSelectedIndex();
        if (listOfShows(selected).getPerformances().getSize() > 0) {
            for (Performance p : listOfShows(selected).getPerformances()) {
                selectPerformance.getItems().add(p.getTitle());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Performance Stored");
            alert.setContentText("There is no performances stored for that show");
            alert.showAndWait();
            reset();
        }
    }

    public void cancelPerformance(ActionEvent actionEvent) {
        if (selectShow.getSelectionModel().getSelectedIndex() == -1 || selectPerformance.getSelectionModel().getSelectedIndex() == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data not defined");
            alert.setContentText("Please select a show/performance first");
            alert.showAndWait();
        } else {
            int selected = selectShow.getSelectionModel().getSelectedIndex();
            int per = selectPerformance.getSelectionModel().getSelectedIndex();
            listOfShows(selected).getPerformances().remove(per);
            selectPerformance.getItems().clear();
            reset();
            Main.setMain();
        }
    }

    private void reset() {
        selectShow.getSelectionModel().clearSelection();
        selectPerformance.getSelectionModel().clearSelection();
    }

    public void cancel7(ActionEvent actionEvent) {
        reset();
        Main.setCancelFacility();
    }

    public void initialize() {
        cancelPerformanceController = this;
    }
}
