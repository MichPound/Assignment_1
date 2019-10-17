package Assignment;

import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static Assignment.Main.*;

public class ControllerViewFacilities {
    public static ControllerViewFacilities viewFacilitiesController;

    public Label showTitle;
    public Label showTime;
    public Label startDate;
    public Label endDate;
    public Label bCost;
    public Label cCost;
    public Label sCost;
    public ListView<String> viewShows;
    public ListView<String> viewPerformances;
    public Label performanceTitle;
    public Label performanceDate;
    public Label performanceTime;

    public void startView(){
//        int selected = viewShows.getSelectionModel().getSelectedIndex();
//        CustomNode tempShow = (CustomNode)shows.get(selected+1);
//        Show theShow = (Show) tempShow.getContents();
//        for (Performance p : theShow.getPerformances()) {
//            viewPerformances.getItems().add(p.getTitle());
//        }
    }

    public void showSelected(MouseEvent mouseEvent) {

        viewPerformances.getItems().clear();

        int selected = viewShows.getSelectionModel().getSelectedIndex();
        CustomNode tempShow = (CustomNode)shows.get(selected+1);
        Show theShow = (Show) tempShow.getContents();
        for (Performance p : theShow.getPerformances()) {
            viewPerformances.getItems().add(p.getTitle());




            showTitle.setText(theShow.getTitle());
            showTime.setText(theShow.getTime() + " Minutes");
            startDate.setText(theShow.getsDate());
            endDate.setText(theShow.geteDate());
            bCost.setText("Balcony: $" + theShow.getbCost());
            cCost.setText("Circle: $" + theShow.getcCost());
            sCost.setText("Stalls: $" + theShow.getsCost());
        }
    }

    public void performanceSelected(MouseEvent mouseEvent) {
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        CustomNode tempShow = (CustomNode)shows.get(selected+1);
        Show theShow = (Show) tempShow.getContents();
        int per = viewPerformances.getSelectionModel().getSelectedIndex();
        CustomNode tempPer = (CustomNode)theShow.getPerformances().get(per+1);
        Performance thePerformance = (Performance) tempPer.getContents();

        performanceTitle.setText(thePerformance.getTitle());
        performanceDate.setText(thePerformance.getDate());
        performanceTime.setText(thePerformance.getTime());
    }

  //  public void viewItems(ActionEvent actionEvent) {
//        int selected = viewShows.getSelectionModel().getSelectedIndex();
//        CustomNode tempShow = (CustomNode)shows.get(selected+1);
//        Show theShow = (Show) tempShow.getContents();
//
////        showTitle.setText(theShow.getTitle());
////        showTime.setText(theShow.getTime() + " Minutes");
////        startDate.setText(theShow.getsDate());
////        endDate.setText(theShow.geteDate());
////        bCost.setText("Balcony: $" + theShow.getbCost());
////        cCost.setText("Circle: $" + theShow.getcCost());
////        sCost.setText("Stalls: $" + theShow.getsCost());
//
//
//
//
//
//        int per = viewPerformances.getSelectionModel().getSelectedIndex();
//        CustomNode tempPer = (CustomNode)theShow.getPerformances().get(per+1);
//        Performance thePerformance = (Performance) tempPer.getContents();
//
//        performanceTitle.setText(thePerformance.getTitle());
//        performanceDate.setText(thePerformance.getDate());
//        performanceTime.setText(thePerformance.getTime());

       // System.out.println(thePerformance.getTitle());
   // }

    public void cancel4(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize(){
        viewFacilitiesController=this;
    }



}
