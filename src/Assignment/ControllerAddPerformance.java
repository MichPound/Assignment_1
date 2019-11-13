package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

import static Assignment.Main.listOfShows;
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
        boolean resume = true;
        if (!pTitle.getText().equals("") && pDate.getValue() != null && !pTime.getText().equals("Select Time") && selectShow.getSelectionModel().getSelectedIndex() != -1) {
            int selected = selectShow.getSelectionModel().getSelectedIndex();
            String title = pTitle.getText();
            String date = pDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String time = pTime.getText();

            for (Show s : shows) {
                for (int i = 0; i < s.getPerformances().getSize(); i++) {
                    if (s.getPerformances().get2(i).getDate().matches(date) && s.getPerformances().get2(i).getTime().matches(time)) {
                        resume = false;
                    }
                }
            }

            if (resume) {
                listOfShows(selected).addPerformance(new Performance(title, date, time));
                reset();
                Main.setMain();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Clash");
                alert.setContentText("This date already has a performance at that time, please select different time or date");
                alert.showAndWait();
            }
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
