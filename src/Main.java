import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by sameenislam on 09/03/2016.
 */
public class Main extends Application {

    private static Stage window;
    private static Scene mainMenuScene,
            scene, precipitationScene, riskScene, daylightScene, crosswindsScene, visibilityScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Weather2Day");
        showMainMenu();

    }

    public static void showMainMenu() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("MainMenu.fxml"));
        window.setTitle("Weather2Day");
        window.setScene(new Scene(root));
        window.show();
        System.out.println("showing main menu");

    }

    public static void showTemperature(ActionEvent event) throws IOException {
        Parent temperatureRoot = FXMLLoader.load(Main.class.getResource("temperature.fxml"));
        scene = new Scene(temperatureRoot);
        // now place scene on stage
        Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homeStage.setScene(scene);
        homeStage.show();
        System.out.println("showing temperature");
    }

    public static void showPrecipitation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("precipitation.fxml"));
        scene = new Scene(root);
        // now place scene on stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("showing precipitation");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
