package Assignment;

import Lists.CustomList;
import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

import static Assignment.Main.*;

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
       // selectShow.getItems().add(pTitle.getText() + ", " + pDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ", " + pTime.getText());
       int selected = selectShow.getSelectionModel().getSelectedIndex();
       //System.out.println(selected);

       //System.out.println(shows.get(selected));


        CustomNode temp = (CustomNode)shows.get(selected+1);
//        if(temp.getContents() instanceof Show){
//            System.out.println("Yes its a show");
//        }
        Show theShow = (Show) temp.getContents();
        System.out.println(theShow.getTitle()+ " <----------------------------------------");

        String title = pTitle.getText();
        String date = pDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String time = pTime.getText();


        theShow.addPerformance(new Performance(title,date,time));
        //System.out.println((Show)temp.getContents()+ " <----------------------------------------");

        //System.out.println(theShow.getPerformances());
        for (Performance p : theShow.getPerformances()) {
            System.out.println(p.getTitle() + p.getDate() + p.getTime());
        }







//        public void list() {
//            for (Show s : shows) {
//                showList.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");
//                // ((ListView)main.getRoot().lookup("#mainlist")).getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");//Method one
//                ControllerMain.maincontroller.listShows.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");         //Method Two
//                ControllerAddPerformance.addPerformanceController.selectShow.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");
//
//
//            }







        Main.setMain();
    }

    public void cancel2(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize(){
        addPerformanceController=this;
    }
}
