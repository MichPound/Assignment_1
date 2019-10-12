package Assignment;

import Lists.CustomList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;

import java.time.format.DateTimeFormatter;

public class ControllerAddShow {

    private CustomList<Show> shows = new CustomList<>();
    public TextField showTitle;
    public DatePicker startDate;
    public DatePicker endDate;
    public Slider runTime;
    public Label time;
    private int balconyCost;
    private int circleCost;
    private int stallsCost;


    public void cancel1(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void setTime(DragEvent mouseEvent) {
        time.setText("(" + (((int) runTime.getValue())) + ") " + "Minutes");
    }

    public void b12(ActionEvent actionEvent) {
        balconyCost = 12;
    }

    public void b13(ActionEvent actionEvent) {
        balconyCost = 13;
    }

    public void b14(ActionEvent actionEvent) {
        balconyCost = 14;
    }

    public void b15(ActionEvent actionEvent) {
        balconyCost = 15;
    }

    public void b16(ActionEvent actionEvent) {
        balconyCost = 16;
    }

    public void b17(ActionEvent actionEvent) {
        balconyCost = 17;
    }

    public void b18(ActionEvent actionEvent) {
        balconyCost = 18;
    }

    public void b19(ActionEvent actionEvent) {
        balconyCost = 19;
    }

    public void b20(ActionEvent actionEvent) {
        balconyCost = 20;
    }

    public void c12(ActionEvent actionEvent) {
        circleCost = 12;
    }

    public void c13(ActionEvent actionEvent) {
        circleCost = 13;
    }

    public void c14(ActionEvent actionEvent) {
        circleCost = 14;
    }

    public void c15(ActionEvent actionEvent) {
        circleCost = 15;
    }

    public void c16(ActionEvent actionEvent) {
        circleCost = 16;
    }

    public void c17(ActionEvent actionEvent) {
        circleCost = 17;
    }

    public void c18(ActionEvent actionEvent) {
        circleCost = 18;
    }

    public void c19(ActionEvent actionEvent) {
        circleCost = 19;
    }

    public void c20(ActionEvent actionEvent) {
        circleCost = 20;
    }

    public void s12(ActionEvent actionEvent) {
        stallsCost = 12;
    }

    public void s13(ActionEvent actionEvent) {
        stallsCost = 13;
    }

    public void s14(ActionEvent actionEvent) {
        stallsCost = 14;
    }

    public void s15(ActionEvent actionEvent) {
        stallsCost = 15;
    }

    public void s16(ActionEvent actionEvent) {
        stallsCost =  16;
    }

    public void s17(ActionEvent actionEvent) {
        stallsCost = 17;
    }

    public void s18(ActionEvent actionEvent) {
        stallsCost = 18;
    }

    public void s19(ActionEvent actionEvent) {
        stallsCost = 19;
    }

    public void s20(ActionEvent actionEvent) {
        stallsCost = 20;
    }


    public void add(ActionEvent actionEvent) {
        String title = showTitle.getText();
        String sDate = startDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String eDate = endDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int rTime = ((int) runTime.getValue());
        shows.addItem(new Show(title, sDate, eDate, rTime, balconyCost, circleCost, stallsCost));
        System.out.println("Title: " + title + ", Start Date: " + eDate+ ", End Date: " + eDate + ", Run Time: " + rTime + " Minutes" + ", Balcony Cost: $" + balconyCost + ", Circle Cost: $" + circleCost + ", Stalls Cost: $" + stallsCost);
    }

}
