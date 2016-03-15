import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sameenislam on 09/03/2016.
 */
public class MainMenuController implements Initializable {

    @FXML
    public void btnQuitHandler() {
        System.exit(1);
    }
    private String url;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
