/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author sameenislam
 */
public class CrosswindsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Label lblCurrentTime;
    @FXML
    public Label lblTemperature;
    @FXML
    public AnchorPane crwPan = new AnchorPane();

    // displays the current time in 24hr format (HH:mm)
    public void showTime() {
        System.out.println("Loading clock");
        //final DateFormat format = DateFormat.getInstance();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Calendar cal = Calendar.getInstance();

                lblCurrentTime.setText(simpleDateFormat.format(cal.getTime()));
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    // get current temperature
    private void showTemperature() {
        System.out.print("Loading temperature... ");
        // extract the current temp from array
        String curTemp = "0";
        try {
            curTemp = Weather.currentTemperature();
            System.out.print("[OK!]");
        } catch (Exception e) {
            System.out.println("[FAIL!]");
        }
        Double tem = Double.parseDouble(curTemp);
        curTemp = (int)Math.round(tem) + "";
        // display this in the label
        lblTemperature.setText(curTemp + "°");
    }
    
    public void goHome() throws IOException{
       Main.showMainMenu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTime();
        showTemperature();
        
        // load crosswind data...
        
        System.out.println();
        // detects whether mouse is being right-clicked
        // used for invoking the main menu
        crwPan.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.isSecondaryButtonDown()) {
                    // invoke main menu
                    try {
                        Main.showMainMenu();
                    } catch (IOException e) {
                        System.out.println("An I/O exception occurred!");
                    }
                }
            }
        });
    }  
    
}
