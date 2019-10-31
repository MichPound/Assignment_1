package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;

import static Assignment.Main.shows;

public class ControllerAddShow {
    public TextField showTitle;
    public DatePicker startDate;
    public DatePicker endDate;
    public Slider runTime;
    public Label time;
    public TextField balcony;
    public TextField circle;
    public TextField stalls;

    public void setTime(MouseEvent mouseEvent) {
        time.setText("(" + (((int) runTime.getValue())) + ") " + "Minutes");
    }

    public void add(ActionEvent actionEvent) {
        String title = showTitle.getText();
        String sDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String eDate = endDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int rTime = ((int) runTime.getValue());
        shows.addItem(new Show(title, sDate, eDate, rTime, Integer.valueOf(balcony.getText()), Integer.valueOf(circle.getText()), Integer.valueOf(stalls.getText())));

        Main.updateShows();
        Main.setMain();
    }

    public void cancel1(ActionEvent actionEvent) {
        Main.setMain();
    }
}
