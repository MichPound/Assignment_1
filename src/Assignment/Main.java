package Assignment;

import Lists.CustomList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Scene main, addShow, addPerformance, addBooking, viewFacility, cancelFacility, cancelShow, cancelPerformance, cancelBooking;
    private static Stage setStage;
    public static CustomList<Show> shows = new CustomList<>();
    //public static CustomList<Performance> performances = new CustomList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        setStage = primaryStage;
        primaryStage.setTitle("Assignment_1");

        Parent root1 = FXMLLoader.load(getClass().getResource("main.fxml"));
        main = new Scene(root1, 650, 400);

        Parent root2 = FXMLLoader.load(getClass().getResource("addShow.fxml"));
        addShow = new Scene(root2, 369, 342);

        Parent root3 = FXMLLoader.load(getClass().getResource("addPerformance.fxml"));
        addPerformance = new Scene(root3, 359, 326);

        Parent root4 = FXMLLoader.load(getClass().getResource("addBooking.fxml"));
        addBooking = new Scene(root4, 600, 400);

        Parent root5 = FXMLLoader.load(getClass().getResource("viewFacilities.fxml"));
        viewFacility = new Scene(root5, 904, 475);

        Parent root6 = FXMLLoader.load(getClass().getResource("cancelFacility.fxml"));
        cancelFacility = new Scene(root6, 174, 255);

        Parent root7 = FXMLLoader.load(getClass().getResource("cancelShow.fxml"));
        cancelShow = new Scene(root7, 235, 310);

        Parent root8 = FXMLLoader.load(getClass().getResource("cancelPerformance.fxml"));
        cancelPerformance = new Scene(root8, 235, 374);

        Parent root9 = FXMLLoader.load(getClass().getResource("cancelBooking.fxml"));
        cancelBooking = new Scene(root9, 600, 400);

        setStage.setScene(main);
        primaryStage.show();
    }

    static void setMain() {
        setStage.setScene(main);
    }

    static void setAddShow() {
        setStage.setScene(addShow);
    }

    static void setAddPerformance() {
        setStage.setScene(addPerformance);
    }

    static void setAddBooking() {
        setStage.setScene(addBooking);
    }

    static void setViewFacility() {
        setStage.setScene(viewFacility);
        ControllerViewFacilities.viewFacilitiesController.startView();
    }

    static void setCancelFacility() {
        setStage.setScene(cancelFacility);
    }

    static void setCancelShow() {
        setStage.setScene(cancelShow);
    }

    static void setCancelPerformance() {
        setStage.setScene(cancelPerformance);
    }

    static void setCancelBooking() {
        setStage.setScene(cancelBooking);
    }



    static void updateLists(){
        ControllerMain.maincontroller.listShows.getItems().clear();
        ControllerAddPerformance.addPerformanceController.selectShow.getItems().clear();
        ControllerViewFacilities.viewFacilitiesController.viewShows.getItems().clear();
        ControllerCancelShow.cancelShowController.removeShow.getItems().clear();
        ControllerAddBooking.addBookingController.bookShow.getItems().clear();

        for (Show s : shows) {

            ControllerMain.maincontroller.listShows.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");
            ControllerAddPerformance.addPerformanceController.selectShow.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");
            ControllerViewFacilities.viewFacilitiesController.viewShows.getItems().add(s.getTitle());
            ControllerCancelShow.cancelShowController.removeShow.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate());
            ControllerAddBooking.addBookingController.bookShow.getItems().add(s.getTitle());

//            for (Performance p : s.getPerformances()) {
//                System.out.println(p.getTitle() + p.getDate() + p.getTime());
//            }
        }
    }











    public static void main(String[] args) {
        launch(args);
    }
}
