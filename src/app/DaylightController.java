/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author sameenislam
 */
public class DaylightController implements Initializable {

    @FXML 
    public Label lblCurrentTemp; 
    public Label lblCurrentTime;
    public Label lblDawnTime;
    public Label lblDuskTime;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTime();
        showTemperature();
        showDawnTime();
        showDuskTime();
    }    
    
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
    } // END showTime
    
    // get current temperature
    private void showTemperature() {
        System.out.print("Loading temperature... ");
        // extract the current temp from array
        Double curTemp = 0.0;
        try {
            curTemp = Weather.getCurrentTemperature();
            System.out.print("[OK!]\n");
            //System.out.print("->"+curTemp);
        } catch (Exception e) {
            System.out.println("[FAIL!]\n");
        }
        int temp = (int)Math.round(curTemp);
        // display this in the label
        lblCurrentTemp.setText(temp + "°");
    }
    
    private void showDawnTime() {
        System.out.print("Loading sunriseTime... ");
        String dawnT = "";
        try {
            dawnT = Weather.getSunriseTime();
            dawnT = dawnT.substring(0, dawnT.length() - 3);
            System.out.print("[OK!]\n");
            lblDawnTime.setText(dawnT);
        } catch (Exception e) {
            System.out.println("[FAIL!]\n");
        }
    }
    
    private void showDuskTime() {
        System.out.print("Loading sunsetTime... ");
        String duskT = "";
        try {
            duskT = Weather.getSunsetTime();
            duskT = duskT.substring(0, duskT.length() - 3);
            System.out.print("[OK!]\n");
            lblDuskTime.setText(duskT);
        } catch (Exception e) {
            System.out.println("[FAIL!]\n");
        }
    }
    
    //TODO: sunset time implementation
    
    public void goHome() throws IOException{
       Main.showMainMenu();
    }
    
}
