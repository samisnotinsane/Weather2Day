/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTime();
        showTemperature();
        showPrecip();
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
    
    private void showTemperature() {
        System.out.println("Loading temperature");
        // extract the current temp from array
        String curTemp = Weather.currentTemperature();
        Double tem = Double.parseDouble(curTemp);
        
        curTemp = (int)Math.round(tem) + "";
      
        // display this in the label
        lblCurrentTemp.setText(curTemp + "°");
    }
    
    public void showPrecip() {
        System.out.println("Loading precipication level");
        //Weather.currently();
        String precip = Weather.precipIntensity();
        // display this in the label
        lblPrecipLevel.setText(precip + " mm/hr");
    }
    
    public void showConditions() {
        System.out.println("Loading current conditions");
        String cn = Weather.currentSummary();
        cn = cn.replace("\"", "");
        lblCurrentCondition.setText(cn);
    }
    
}
