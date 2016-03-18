/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author sameenislam
 */
public class MainMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public Label lblCurrentTemp;
    
     @FXML
    public void btnQuitHandler() {
        System.exit(0);
    }
    private String url;
    private Double curTemp = 0.0;

    // opens temperature screen
    public void btnTempHandler(ActionEvent event) throws IOException {
        url = "temperature.fxml";
        Main.showScene(event, url);
    }

    // opens crosswind screen
    public void btnCrwHandler(ActionEvent event) throws IOException {
        url = "crosswinds.fxml";
        Main.showScene(event, url);
    }

    // opens risk screen
    public void btnRiskHandler(ActionEvent event) throws IOException {
        url = "risk.fxml";
        Main.showScene(event, url);
    }

    // opens daylight screen
    public void btnDaylHandler(ActionEvent event) throws IOException {
        url = "daylight.fxml";
        Main.showScene(event, url);
    }

    // opens visibility screen
    public void btnVisHandler(ActionEvent event) throws IOException {
        url = "visibility.fxml";
        Main.showScene(event, url);
    }

    // opens precipitation screen
    public void btnPrecHandler(ActionEvent event) throws IOException {
        url = "precipitation.fxml";
        Main.showScene(event, url);
    }
    
    // get current temperature
    private void showTemperature() {
        System.out.print("Loading temperature... ");
        // extract the current temp from array
        
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if(curTemp == 0.0) {
                showTemperature();
            }
        } catch (Exception e) {
            System.out.println("Unable to load weather data. Check internet connection.");
        }
    }  
    
}
