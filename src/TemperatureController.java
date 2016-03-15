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

/**
 * Created by sameenislam on 14/03/2016.
 */
public class TemperatureController implements Initializable {
    @FXML
    public Label lblCurrentTime;
    @FXML
    public AnchorPane tempPan = new AnchorPane();

    // displays the current time in 24hr format (HH:mm)
    public void showTime() {
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

    // detects whether mouse is being clicked and being kept held
    // used for invoking the main menu
    // code source: http://stackoverflow.com/questions/25601266/how-to-achieve-javafx-mouse-event-push-and-hold
//    private void addPressAndHoldHandler(Node node, Duration holdTime, EventHandler<MouseEvent> handler) {
//        class Wrapper<T> { T content ; }
//        Wrapper<MouseEvent> eventWrapper = new Wrapper<>();
//
//        PauseTransition holdTimer = new PauseTransition(holdTime);
//        holdTimer.setOnFinished(event -> handler.handle(eventWrapper.content));
//
//
//        node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
//            eventWrapper.content = event ;
//            holdTimer.playFromStart();
//        });
//        node.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> holdTimer.stop());
//        node.addEventHandler(MouseEvent.DRAG_DETECTED, event -> holdTimer.stop());
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTime();

        // detects whether mouse is being right-clicked
        // used for invoking the main menu
        tempPan.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.isSecondaryButtonDown()) {
                    System.out.println("secondary engaged");
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
