package Assignment;

import Lists.CustomList;
import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static Assignment.Main.shows;

public class ControllerAddBooking {
    public static ControllerAddBooking addBookingController;

    public TextField bookName;
    public TextField bookSeats;
    public int seatType;
    public ListView<String> bookShow;
    public ListView<String> bookPerformance;

    public void cancel3(ActionEvent actionEvent) {
        Main.setMain();
    }

    public void initialize(){
        addBookingController=this;
    }

    public void contiguous(ActionEvent actionEvent) {
        seatType = 0;
    }

    public void scattered(ActionEvent actionEvent) {
        seatType = 1;
    }

    public void bookedShow(MouseEvent mouseEvent) {

        bookPerformance.getItems().clear();

        int selected = bookShow.getSelectionModel().getSelectedIndex();
        CustomNode tempShow = (CustomNode)shows.get(selected+1);
        Show theShow = (Show) tempShow.getContents();
        for (Performance p : theShow.getPerformances()) {
            bookPerformance.getItems().add(p.getTitle());
        }
    }

    public void performanceSelected(MouseEvent mouseEvent) {




    }

    public void addBooking(ActionEvent actionEvent) {
        int selected = bookShow.getSelectionModel().getSelectedIndex();
        CustomNode tempShow = (CustomNode)shows.get(selected+1);
        Show theShow = (Show) tempShow.getContents();
        int per = bookPerformance.getSelectionModel().getSelectedIndex();
        CustomNode tempPer = (CustomNode)theShow.getPerformances().get(per+1);
        Performance thePerformance = (Performance) tempPer.getContents();

        thePerformance.addBooking(new Booking(bookName.getText(), Integer.valueOf(bookSeats.getText()), seatType));
        Main.setMain();
    }
}
