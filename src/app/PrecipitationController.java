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
import javafx.util.Duration;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author sameenislam
 */
public class PrecipitationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Label lblCurrentTime;
    @FXML
    public Label lblCurrentCondition; // i.e. rain, snow, etc.
    @FXML
    public Label lblPrecipLevel; // i.e. 30mm
    @FXML
    public Label lblCurrentTemp;
    @FXML
    public AnchorPane precPane = new AnchorPane();
    @FXML
    public ImageView imgCurrentCondition;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTime();
        showTemperature();
        showPrecip();
        showIcon();
        showConditions();
        

        // detects whether mouse is being right-clicked
        // used for invoking the main menu
        precPane.setOnMousePressed(new EventHandler<MouseEvent>() {
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
    } // END initialize
    
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
    
    public void goHome() throws IOException{
       Main.showMainMenu();
    }
    
   // get current temperature
    private void showTemperature() {
        System.out.print("Loading temperature... ");
        // extract the current temp from array
        Double curTemp = 0.0;
        try {
            curTemp = Weather.getCurrentTemperature();
            System.out.print("[OK!]");
            //System.out.print("->"+curTemp);
        } catch (Exception e) {
            System.out.println("[FAIL!]");
        }
//        Double tem = Double.parseDouble(curTemp);
        int temp = (int)Math.round(curTemp);
        // display this in the label
        lblCurrentTemp.setText(temp + "°");
    }
    
    public void showPrecip() {
        System.out.print("Loading precipication level...");
        String precip = "0.00";
        try {
        precip = Weather.precipIntensity();
        System.out.print("[OK!]\n");
        } catch (Exception e) {
            System.out.print("[FAIL!]\n");
        }
        // display this in the label
        lblPrecipLevel.setText(precip + " inches/hr");
    }
    
    public void showConditions() {
        System.out.print("\nLoading current conditions...");
        String cn = "";
        try {
        cn = Weather.currentSummary();
        System.out.print("[OK!]\n");
        } catch (Exception e) {
            System.out.print("[FAIL!]\n");
        }
        cn = cn.replace("\"", "");
        lblCurrentCondition.setText(cn);
    }

    private void showIcon() {
        String[] imgPath = 
        {"/app/res/clear-sunny.png", // sunny [0]
         "/app/res/clear-night.png", // moon  [1]
         "/app/res/cloud-rain.png",  // rainy cloud [2]
         "/app/res/cloudy.png",      // cloud [3]
         "/app/res/fog.png", // fog [4]
         "/app/res/partly-cloudy.png",
         "/app/res/partly-cloudy-night.png"}; // partly cloudy moon [6]
        //File file = new File("/app/res/tick.png");
        //Image imgSafe = new Image(getClass().getResource("/app/res/tick.png").toString());
        //imgConditions.setImage(imgSafe);
        
        System.out.print("\nLoading weather icon... ");
        String icon = "";
        try {
        icon = Weather.getIconType(); 
        //System.out.println("Icon type="+icon);
        System.out.print("[OK!]\n");
        if(icon.equals("clear-day")) {
            // set sunny icon
            Image img = new Image(getClass().getResource(imgPath[0]).toString());
            imgCurrentCondition.setImage(img);
        } else if(icon.equals("clear-night")) {
            // set moon icon
            Image img = new Image(getClass().getResource(imgPath[1]).toString());
            imgCurrentCondition.setImage(img);
        } else if(icon.equals("rain")) {
            // set rain icon
            Image img = new Image(getClass().getResource(imgPath[2]).toString());
            imgCurrentCondition.setImage(img);
        } else if(icon.equals("snow")) {
            // set snow icon
            System.out.println("Icon not supported!");
        } else if(icon.equals("sleet")) {
            // set sleet icon
            System.out.println("Icon not supported!");
        } else if(icon.equals("wind")) {
            // set windy icon
            Image img = new Image(getClass().getResource(imgPath[0]).toString());
            imgCurrentCondition.setImage(img);
            
        } else if(icon.equals("fog")) {
            // set fog icon
            Image img = new Image(getClass().getResource(imgPath[4]).toString());
            imgCurrentCondition.setImage(img);
        } else if(icon.equals("partly-cloudy-day")) {
            // partly cloudy icon
            Image img = new Image(getClass().getResource(imgPath[5]).toString());
            imgCurrentCondition.setImage(img);
        } else if(icon.equals("partly-cloudy-night")) {
            Image img = new Image(getClass().getResource(imgPath[6]).toString());
            imgCurrentCondition.setImage(img);
        } else if(icon.equals("hail")) {
            System.out.println("Icon not supported!");
            
        } else if(icon.equals("thunderstorm")) {
            System.out.println("Icon not supported!");
        } else {
           System.out.print("\nNo weather icon found!"); 
        }
        } catch (Exception e) {
            System.out.print("[FAIL!]\n");
        }
        icon = icon.replace("\"", "");
//        imgCurrentCondition.setImage(icon);
    }
    
}
