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
    public static CustomList<Performance> performances = new CustomList<>();

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
        cancelShow = new Scene(root7, 235, 374);

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

    public static void main(String[] args) {
        launch(args);
    }
}
