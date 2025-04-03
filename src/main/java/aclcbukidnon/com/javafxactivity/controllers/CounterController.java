package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {
    private int count =0;
    @FXML
    private Label LabelCounter;

    @FXML
    private void initialize() {
        updateCounter();
    }

    @FXML
    private void onClickIncrement() {
        count++;
        updateCounter();
    }

    @FXML
    private void onClickDicrement() {
        count--;
        updateCounter();
    }

    private void updateCounter() {
        LabelCounter.setText(String.valueOf(count));
    }
}
