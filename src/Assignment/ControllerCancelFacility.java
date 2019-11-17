package Assignment;

import javafx.event.ActionEvent;

//Options for cancelling
public class ControllerCancelFacility {

    public void cancelShow(ActionEvent actionEvent) {
        Main.setCancelShow();
    }

    public void CancelPerformance(ActionEvent actionEvent) {
        Main.setCancelPerformance();
    }

    public void cancelBooking(ActionEvent actionEvent) {
        Main.setCancelBooking();
    }

    public void cancel5(ActionEvent actionEvent) {
        Main.setMain();
    }
}
