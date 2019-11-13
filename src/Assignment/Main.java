package Assignment;

import Lists.CustomList;
import Lists.CustomNode;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main extends Application {

    public static Scene main, addShow, addPerformance, addBooking, viewFacility, cancelFacility, cancelShow, cancelPerformance, cancelBooking;
    private static Stage setStage;
    public static CustomList<Show> shows = new CustomList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        setStage = primaryStage;
        primaryStage.setTitle("Assignment_1");

        Parent root1 = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        main = new Scene(root1, 650, 400);

        Parent root2 = FXMLLoader.load(getClass().getResource("../fxml/addShow.fxml"));
        addShow = new Scene(root2, 369, 342);

        Parent root3 = FXMLLoader.load(getClass().getResource("../fxml/addPerformance.fxml"));
        addPerformance = new Scene(root3, 359, 326);

        Parent root4 = FXMLLoader.load(getClass().getResource("../fxml/addBooking.fxml"));
        addBooking = new Scene(root4, 600, 500);
        root4.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());

        Parent root5 = FXMLLoader.load(getClass().getResource("../fxml/viewFacilities.fxml"));
        viewFacility = new Scene(root5, 904, 475);
        root5.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());

        Parent root6 = FXMLLoader.load(getClass().getResource("../fxml/cancelFacility.fxml"));
        cancelFacility = new Scene(root6, 174, 255);

        Parent root7 = FXMLLoader.load(getClass().getResource("../fxml/cancelShow.fxml"));
        cancelShow = new Scene(root7, 235, 310);

        Parent root8 = FXMLLoader.load(getClass().getResource("../fxml/cancelPerformance.fxml"));
        cancelPerformance = new Scene(root8, 235, 374);

        Parent root9 = FXMLLoader.load(getClass().getResource("../fxml/cancelBooking.fxml"));
        cancelBooking = new Scene(root9, 600, 412);
        root9.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());

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
        ControllerAddBooking.addBookingController.startView();
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
        ControllerCancelBooking.cancelBookingController.startView();
    }

    static void updateShows() {
        ControllerMain.mainController.listShows.getItems().clear();
        ControllerAddPerformance.addPerformanceController.selectShow.getItems().clear();
        ControllerViewFacilities.viewFacilitiesController.viewShows.getItems().clear();
        ControllerCancelShow.cancelShowController.removeShow.getItems().clear();
        ControllerCancelPerformance.cancelPerformanceController.selectShow.getItems().clear();
        ControllerAddBooking.addBookingController.bookShow.getItems().clear();
        ControllerCancelBooking.cancelBookingController.viewShows.getItems().clear();

        for (Show s : shows) {
            ControllerMain.mainController.listShows.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");
            ControllerAddPerformance.addPerformanceController.selectShow.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate() + ", " + s.getTime() + " Minutes");
            ControllerViewFacilities.viewFacilitiesController.viewShows.getItems().add(s.getTitle());
            ControllerCancelShow.cancelShowController.removeShow.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate());
            ControllerCancelPerformance.cancelPerformanceController.selectShow.getItems().add(s.getTitle() + ", " + s.getsDate() + " to " + s.geteDate());
            ControllerAddBooking.addBookingController.bookShow.getItems().add(s.getTitle());
            ControllerCancelBooking.cancelBookingController.viewShows.getItems().add(s.getTitle());
        }
    }

    static Show listOfShows(int input) {
        CustomNode temp = (CustomNode) shows.get(input + 1);
        Show theShow = (Show) temp.getContents();//--------------------------------why?

        return theShow;

    }

    static Performance listOfPerformances(int input, int input2) {
        CustomNode tempPer = (CustomNode) listOfShows(input).getPerformances().get(input2 + 1);
        Performance thePerformance = (Performance) tempPer.getContents();//----------------again why?

        return thePerformance;
    }

    static Booking listOfBookings(int input, int input2, int input3) {
        CustomNode tempBook = (CustomNode) listOfPerformances(input, input2).getBooking().get(input3 + 1);
        Booking theBooking = (Booking) tempBook.getContents();//.....................whywhywhy?

        return theBooking;
    }

    public static void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("shows.xml"));
        out.writeObject(shows);
        out.close();
    }

    public static void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("shows.xml"));
        shows = (CustomList<Show>) is.readObject();
        is.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
