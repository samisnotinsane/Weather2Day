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

    public void btnTempHandler(ActionEvent event) throws IOException {
       Main.showTemperature(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
