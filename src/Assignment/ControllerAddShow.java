package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

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
        if (!Pattern.matches("[0-9.]+", balcony.getText()) || !Pattern.matches("[0-9.]+", circle.getText()) || !Pattern.matches("[0-9.]+", stalls.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incorrect Pricing");
            alert.setContentText("Please ensure you have entered the seating cost correctly");
            alert.showAndWait();
        } else {
            if (!showTitle.getText().equals("") && startDate.getValue() != null && endDate.getValue() != null && runTime.getValue() != 0) {
                String title = showTitle.getText();
                String sDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                String eDate = endDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                int rTime = ((int) runTime.getValue());
                shows.addItem(new Show(title, sDate, eDate, rTime, Double.valueOf(balcony.getText()), Double.valueOf(circle.getText()), Double.valueOf(stalls.getText())));


//                    if(sDate.charAt(3) == eDate.charAt(3) && sDate.charAt(4) == eDate.charAt(4)){
//                        System.out.println("Same Month");
//                        if(sDate.charAt(0) == eDate.charAt(0) && sDate.charAt(1) == eDate.charAt(1)){
//                            System.out.println("Same Day");
//                        }
//                    }


                Main.updateShows();
                reset();
                Main.setMain();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Data Error");
                alert.setContentText("Please ensure you have entered all information correctly");
                alert.showAndWait();
            }
        }
    }

    public void reset() {
        showTitle.setText("");
        startDate.setValue(null);
        endDate.setValue(null);
        runTime.setValue(0);
        time.setText("0");
        balcony.setText("");
        circle.setText("");
        stalls.setText("");
    }

    public void cancel1(ActionEvent actionEvent) {
        reset();
        Main.setMain();
    }
}
