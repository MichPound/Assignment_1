package Assignment;

import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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

    public void startView(){
    }

    public void viewItems(ActionEvent actionEvent) {
        int selected = viewShows.getSelectionModel().getSelectedIndex();
        CustomNode temp = (CustomNode)shows.get(selected+1);
        Show theShow = (Show) temp.getContents();


        showTitle.setText(theShow.getTitle());
        showTime.setText(theShow.getTime() + " Minutes");
        startDate.setText(theShow.getsDate());
        endDate.setText(theShow.geteDate());
        bCost.setText("Balcony: $" + theShow.getbCost());
        cCost.setText("Circle: $" + theShow.getcCost());
        sCost.setText("Stalls: $" + theShow.getsCost());
    }

    public void cancel4(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize(){
        viewFacilitiesController=this;
    }


}
