package Assignment;

import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

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
        int selected = selectShow.getSelectionModel().getSelectedIndex();
        CustomNode temp = (CustomNode) shows.get(selected + 1);
        Show theShow = (Show) temp.getContents();

        String title = pTitle.getText();
        String date = pDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String time = pTime.getText();
        theShow.addPerformance(new Performance(title, date, time));

        Main.setMain();
    }

    public void cancel2(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize() {
        addPerformanceController = this;
    }
}
