/*
 * AUTHOR: Sameen Islam
 * QUEEN MARY UNIVERSITY OF LONDON
 * 
 */
package app;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sameenislam
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
        System.out.println("\n\nshowing main menu");

    }

    public static void showScene(ActionEvent event, String url) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(url));
        scene = new Scene(root);
        // now place scene on stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        System.out.println("\n\nshowing " + url);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    } 
}
