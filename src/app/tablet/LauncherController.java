/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tablet;

import app.tablet.Launcher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author sameenislam
 */
public class LauncherController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void loadMobile() {
        new Launcher().showMobile();
    }
    
    public void loadTablet() {
        System.out.print("Unsupported action!");
    }
    
}
