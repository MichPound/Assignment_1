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

    //Sets time accordingly
    public void matinee(ActionEvent actionEvent) {
        pTime.setText("Matinee");
    }

    public void evening(ActionEvent actionEvent) {
        pTime.setText("Evening");
    }

    //Validates all information is correct, checks dates/times and adds the new performance to the show selected
    public void addPerformance(ActionEvent actionEvent) {
        boolean resume = true;
        if (!pTitle.getText().equals("") && pDate.getValue() != null && !pTime.getText().equals("Select Time") && selectShow.getSelectionModel().getSelectedIndex() != -1) {
            int selected = selectShow.getSelectionModel().getSelectedIndex();
            String title = pTitle.getText();
            String date = pDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String time = pTime.getText();

            //Checks to see if there is already a performance on at that time
            for (Show s : shows) {
                for (int i = 0; i < s.getPerformances().getSize(); i++) {
                    if (s.getPerformances().get2(i).getDate().matches(date) && s.getPerformances().get2(i).getTime().matches(time)) {
                        resume = false;
                    }
                }
            }

            //if the isn't a performance already on then it continues to try to add the new performance
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

    //Used to reset fields and clean the scene
    private void reset() {
        selectShow.getSelectionModel().clearSelection();
        pTitle.setText("");
        pDate.setValue(null);
        pTime.setText("Select Time");
    }

    //Exits to menu
    public void cancel2(ActionEvent actionEvent) {
        reset();
        Main.setMain();
    }

    //Initializes class
    public void initialize() {
        addPerformanceController = this;
    }
}
