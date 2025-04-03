package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;




public class TrafficLightController {
    @FXML
    private Circle redLight;
    @FXML
    private Circle yellowLight;
    @FXML
    private Circle greenLight;

    private Timeline timeline;



    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO,
    }


    private TrafficLightColor currentColor = TrafficLightColor.STOP;

    private TrafficLightColor getCurrentColor() {
        return currentColor;
    }

    private void setCurrentColor(TrafficLightColor currentColor) {
        this.currentColor = currentColor;
    }

    @FXML
    private void initialize(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    ///  What happens if the time is up
    private void onTimerChange() {
        switch (currentColor){
            case STOP -> currentColor=TrafficLightColor.HOLD;
            case HOLD -> currentColor=TrafficLightColor.GO;
            case GO -> currentColor=TrafficLightColor.STOP;

        }
        updateLights();
    }
    private void updateLights() {
        redLight.setFill(currentColor == TrafficLightColor.STOP ? Color.RED : Color.DARKGRAY);
        yellowLight.setFill(currentColor == TrafficLightColor.HOLD ? Color.YELLOW : Color.DARKGRAY);
        greenLight.setFill(currentColor == TrafficLightColor.GO ? Color.LIMEGREEN : Color.DARKGRAY);
    }

}
