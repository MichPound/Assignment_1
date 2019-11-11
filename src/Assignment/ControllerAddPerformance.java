package Assignment;

import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

import static Assignment.Main.shows;

public class ControllerAddPerformance {
    public static ControllerAddPerformance addPerformanceController;
    public DatePicker pDate;
    public SplitMenuButton pTime;
    public TextField pTitle;
    public ListView<String> selectShow;

    public void matinee(ActionEvent actionEvent) {
        pTime.setText("Matinee");
    }

    public void evening(ActionEvent actionEvent) {
        pTime.setText("Evening");
    }

    public void addPerformance(ActionEvent actionEvent) {
        if (!pTitle.getText().equals("") && pDate.getValue() != null && !pTime.getText().equals("Select Time") && selectShow.getSelectionModel().getSelectedIndex() != -1) {
            int selected = selectShow.getSelectionModel().getSelectedIndex();
            CustomNode temp = (CustomNode) shows.get(selected + 1);
            Show theShow = (Show) temp.getContents();

            String title = pTitle.getText();
            String date = pDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String time = pTime.getText();
            theShow.addPerformance(new Performance(title, date, time));

            reset();
            Main.setMain();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data Error");
            alert.setContentText("Please ensure you have entered all information correctly");
            alert.showAndWait();
        }
    }

    public void reset() {
        selectShow.getSelectionModel().clearSelection();
        pTitle.setText("");
        pDate.setValue(null);
        pTime.setText("Select Time");
    }

    public void cancel2(ActionEvent actionEvent) {
        reset();
        Main.setMain();
    }

    public void initialize() {
        addPerformanceController = this;
    }
}
