package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class ControllerAddPerformance {

    public DatePicker pDate;
    public SplitMenuButton pTime;
    public TextField pTitle;
    public ListView selectShow;

    public void matinee(ActionEvent actionEvent) {
        pTime.setText("Matinee");
    }

    public void evening(ActionEvent actionEvent) {
        pTime.setText("Evening");
    }

    public void addPerformance(ActionEvent actionEvent) {
        selectShow.getItems().add(pTitle.getText() + ", " + pDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ", " + pTime.getText());
        selectShow.getSelectionModel().getSelectedIndex();
    }

    public void cancel2(ActionEvent actionEvent) {
        Main.setMain();
    }
}
