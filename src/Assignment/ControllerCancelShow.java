package Assignment;

import Lists.CustomList;
import Lists.CustomNode;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

import java.time.format.DateTimeFormatter;

import static Assignment.Main.shows;

public class ControllerCancelShow {
    public static ControllerCancelShow cancelShowController;

    public ListView<String> removeShow;

    public void cancel6(ActionEvent actionEvent) {
        Main.setCancelFacility();
    }

    public void removingShow(ActionEvent actionEvent) {
        int index = removeShow.getSelectionModel().getSelectedIndex();


        //CustomNode temp = (CustomNode)shows.get(index+1);
        //Show theShow = (Show) temp.getContents();
        shows.remove(index);

        for (Show s : shows) {
            System.out.println(s.getTitle()+"<-------------------------------------------");

        }
        System.out.println("-----------------------------------------------");


        Main.updateLists();
        Main.setMain();
    }

    public void initialize(){
        cancelShowController=this;
    }
}
