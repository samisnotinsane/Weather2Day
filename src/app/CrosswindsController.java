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
import javafx.scene.image.ImageView;

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
    public Label lblWindDir;
    public Label lblWindSpeed;
    @FXML
    public AnchorPane crwPan = new AnchorPane();
    @FXML
    public ImageView imgWindDirection;

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
        lblTemperature.setText(temp + "°");
    }
    
    public void goHome() throws IOException{
       Main.showMainMenu();
    }
    
    // gets the wind bearing and sets view components appropriately
    public void getBearing() {
        Double wb = 0.0;
        try {
            System.out.print("Loading wind bearing... ");
            wb = Weather.getWindBearing();
            System.out.print("[OK!]\n");
            if(wb==0 || wb==360) {
                lblWindDir.setText("N");
            } else if(wb<90 && wb>0) {
                lblWindDir.setText("NE");
                imgWindDirection.setRotate(imgWindDirection.getRotate()+45);
            } else if(wb==90) {
                lblWindDir.setText("E");
                imgWindDirection.setRotate(imgWindDirection.getRotate()+90);
            } else if(wb>90 && wb<180) {
                lblWindDir.setText("SE");
                imgWindDirection.setRotate(imgWindDirection.getRotate()+135);
            } else if(wb==180) {
                lblWindDir.setText("S");
                imgWindDirection.setRotate(imgWindDirection.getRotate()+180);
            } else if(wb>180 && wb<270) {
                lblWindDir.setText("SW");
                imgWindDirection.setRotate(imgWindDirection.getRotate()+225);
            } else if(wb==270) {
                lblWindDir.setText("W");
                imgWindDirection.setRotate(imgWindDirection.getRotate()+270);
            } else if(wb>270 && wb<360) {
                lblWindDir.setText("NW");
                imgWindDirection.setRotate(imgWindDirection.getRotate()+315);
            } else {
                lblWindDir.setText("-");
            }
            
        } catch(Exception e) {
            System.out.println("[FAIL!]\n");
        }

    } // END getBearing
    
    public void getWindSpeed() {
        Double ws = 0.0;
        try {
            System.out.print("Loading wind speed... ");
            ws = Weather.getWindSpeed();
            System.out.print("[OK!]\n");
            String wss = ws.toString()+"";
            lblWindSpeed.setText(wss + " mph");
        } catch(Exception e) {
            System.out.println("[FAIL!]\n");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTime();
        showTemperature();
        getBearing();
        getWindSpeed();
        
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
