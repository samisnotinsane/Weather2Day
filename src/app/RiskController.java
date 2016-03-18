/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Toolkit;
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
import java.lang.Object;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author sameenislam
 */
public class RiskController implements Initializable {

    
    @FXML
    public Label lblCurrentTemp;
    @FXML
    public Label lblCurrentTime;
    @FXML
    public Label lblRiskType;
    @FXML
    public ImageView imgConditions;
    public ImageView imgRisk;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTime();
        showTemperature();
        showRisk();
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
//        Double tem = Double.parseDouble(curTemp);
        int temp = (int)Math.round(curTemp);
        // display this in the label
        lblCurrentTemp.setText(temp + "°");
    }
    
     public void goHome() throws IOException{
       Main.showMainMenu();
    }
     
     public void showRisk() {
         try {
            System.out.print("Loading risk data... ");
            boolean rsk = Weather.isPrecip(); // returns false if no risk
            System.out.print("[OK!]\n");
            
            if(!rsk) { // 
                // safe
                System.out.print("Setting image as safe... ");
                File file = new File("/app/res/tick.png");
                Image imgSafe = new Image(getClass().getResource("/app/res/tick.png").toString());
                imgConditions.setImage(imgSafe);
                lblRiskType.setText("Optimum conditions");
                System.out.print("[OK!]\n");
            } else {
                // set off safety signals
                System.out.print("Setting image as unsafe... ");
                File file = new File("/app/res/close.png");
                Image imgRisk = new Image(getClass().getResource("/app/res/close.png").toString());
                imgConditions.setImage(imgRisk);
                lblRiskType.setText("Hazardous conditions!");
                System.out.print("[OK!]\n");
            }
         } catch (Exception e) {
             System.out.println("[FAIL!]\n");
         }
     }
}
