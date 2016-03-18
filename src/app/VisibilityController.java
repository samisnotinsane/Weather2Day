/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author sameenislam
 */
public class VisibilityController implements Initializable {

    @FXML
    public Label lblCurrentTime;
    public Label lblCurrentTemp;
    public Label lblSafetyInfo;
    public Label lblVisibilityDistance;
    public ImageView imgSafetyIcon;
    private final Double safetyThreshold
            = 0.12427424; // In the UK, 200m (0.12427424mi) is minimum
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTime();
        showTemperature();
        Weather.getVisibility();
        showSafety();
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
        System.out.print("Loading temperature...");
        // extract the current temp from array
        Double curTemp = 0.0;
        try {
            curTemp = Weather.getCurrentTemperature();
            System.out.print("[OK!]\n");
        } catch (Exception e) {
            System.out.println("[FAIL!]\n");
        }
        int temp = (int)Math.round(curTemp);
        // display this in the label
        lblCurrentTemp.setText(temp + "°");
    }
    
    public void goHome() throws IOException{
       Main.showMainMenu();
    }

    private void showSafety() {  
        Double visibilityDist = 0.0;
        try {
            System.out.print("Loading visibility data...");  
            visibilityDist = Weather.getVisibility();
            System.out.print("[OK!]\n");
            lblVisibilityDistance.setText(visibilityDist+" mi");
            // determine if vis. level is unsafe
            if(visibilityDist<=safetyThreshold) {
                System.out.println("visibilityDist<=safetyThreshold");
                // unsafe vis. condition, raise alert
                lblSafetyInfo.setText("Danger");
                System.out.print("Setting image as safe... ");
                File file = new File("src/app/res/close.png");
                Image imgUnsafe = new Image(file.toURI().toString());
                imgSafetyIcon.setImage(imgUnsafe);
                System.out.print("[OK!]\n");
                
            } else {
                // safe conditions
                lblSafetyInfo.setText("Safe");
                System.out.print("Setting image as safe... ");
                File file = new File("src/app/res/tick.png");
                Image imgSafe = new Image(file.toURI().toString());
                imgSafetyIcon.setImage(imgSafe);
                System.out.print("[OK!]\n");
            }
        } catch (Exception e) {
            System.out.println("[FAIL!]\n");
        }
        int temp = (int)Math.round(visibilityDist);
        // display this in the label
        lblCurrentTemp.setText(temp + "°");
    }

    private void showVisibility() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
