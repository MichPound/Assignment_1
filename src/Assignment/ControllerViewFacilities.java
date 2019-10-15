package Assignment;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

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

    public void startView(){
        showTitle.setText(shows.head.getContents().getTitle());
        showTime.setText(shows.head.getContents().getTime() + " Minutes");
        startDate.setText(shows.head.getContents().getsDate());
        endDate.setText(shows.head.getContents().geteDate());
        bCost.setText("Balcony: $" + shows.head.getContents().getbCost());
        cCost.setText("Circle: $" + shows.head.getContents().getcCost());
        sCost.setText("Stalls: $" + shows.head.getContents().getcCost());

    }

    public void cancel4(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize(){
        viewFacilitiesController=this;
    }
}
