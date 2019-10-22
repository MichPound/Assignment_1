package Assignment;

import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;

import static Assignment.Main.shows;

public class ControllerCancelPerformance {

    public static ControllerCancelPerformance cancelPerformanceController;
    public ListView<String> selectShow;
    public ListView<String> selectPerformance;

    public void listPerformances(MouseEvent mouseEvent) {
        int selected = selectShow.getSelectionModel().getSelectedIndex();
        CustomNode temp = (CustomNode) shows.get(selected + 1);
        Show theShow = (Show) temp.getContents();

        for (Performance p : theShow.getPerformances()) {
            selectPerformance.getItems().add(p.getTitle());
        }
    }

    public void cancelPerformance(ActionEvent actionEvent) {
        int selected = selectShow.getSelectionModel().getSelectedIndex();
        CustomNode temp = (CustomNode)shows.get(selected+1);
        Show theShow = (Show) temp.getContents();

        int per = selectPerformance.getSelectionModel().getSelectedIndex();

        theShow.getPerformances().remove(per);
        selectPerformance.getItems().clear();
        Main.setMain();
    }

    public void cancel7(ActionEvent actionEvent) {
        Main.setCancelFacility();
    }

    public void initialize(){
        cancelPerformanceController=this;
    }
}
