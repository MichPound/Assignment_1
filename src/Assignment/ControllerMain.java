package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class ControllerMain {
    public ControllerAddShow controllerAddShow;
    public static ControllerMain maincontroller;

    public ListView<String> listShows;

    public void addShow(ActionEvent actionEvent) {
        Main.setAddShow();
    }

//    public static TextField showTitle;

    public void addPerformance(ActionEvent actionEvent) {
        Main.setAddPerformance();
    }

    public void addBooking(ActionEvent actionEvent) {
        Main.setAddBooking();
    }

    public void viewFacilities(ActionEvent actionEvent) {
        Main.setViewFacility();
    }

    public void cancelFacilities(ActionEvent actionEvent) {
        Main.setCancelFacility();
    }

    public void resetFacilities(ActionEvent actionEvent) {
    }

    public void addList(String list){
        listShows.getItems().add(list);
    }

    public void initialize(){
        maincontroller=this;
    }
}
