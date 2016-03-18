/*
 * AUTHOR: Sameen Islam
 * QUEEN MARY UNIVERSITY OF LONDON - 2016
 */
package app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sameenislam
 */
public class Launcher extends Application {
    private Stage stage;
    
     private static Launcher instance;

    public Launcher() {
        instance = this;
    }
    
    public static Launcher getInstance() {
        return instance;
    } // END getInstance
    
    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(Launcher.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            scene.getStylesheets().add(Launcher.class.getResource("res/style.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    } // END replaceSceneContent
    
     private void showLauncher() {
        try {
            replaceSceneContent("launcher.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // END showLauncher
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            showLauncher();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // END start
    
    public static void main(String[] args) {
        launch(args);
    } // END main

   
    
}
