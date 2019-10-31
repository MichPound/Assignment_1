package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static Assignment.Main.listOfShows;

public class ControllerCancelPerformance {

    static ControllerCancelPerformance cancelPerformanceController;
    public ListView<String> selectShow;
    public ListView<String> selectPerformance;

    public void listPerformances(MouseEvent mouseEvent) {
        selectPerformance.getItems().clear();
        int selected = selectShow.getSelectionModel().getSelectedIndex();
        for (Performance p : listOfShows(selected).getPerformances()) {
            selectPerformance.getItems().add(p.getTitle());
        }
    }

    public void cancelPerformance(ActionEvent actionEvent) {
        int selected = selectShow.getSelectionModel().getSelectedIndex();
        int per = selectPerformance.getSelectionModel().getSelectedIndex();
        listOfShows(selected).getPerformances().remove(per);
        selectPerformance.getItems().clear();
        Main.setMain();
    }

    public void cancel7(ActionEvent actionEvent) {
        Main.setCancelFacility();
    }

    public void initialize() {
        cancelPerformanceController = this;
    }
}
