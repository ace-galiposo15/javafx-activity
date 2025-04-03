package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private double num1= 0, num2= 0;
    @FXML
    private String operator= "";

    @FXML
    private Label display;

    @FXML
    private void onNumberClick(javafx.event.ActionEvent event){
        Button button = (Button)event.getSource();
        display.setText(display.getText()+ button.getText());
    }
    @FXML
    private void onOperatorClick(javafx.event.ActionEvent event){
        Button button = (Button)event.getSource();
        num1 = Double.parseDouble(display.getText());
        operator = button.getText();
        display.setText("");
    }

    @FXML
    private void onEqualClick() {
        num2 = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num2 != 0 ? num1 / num2 : 0; break;
        }

        display.setText(String.valueOf(result));
    }
    @FXML
    private void onClearClick() {
        display.setText("");
        num1 = num2 = 0;
        operator = "";
    }
    @FXML
    private void onBackspaceClick() {
        String text = display.getText();
        if (!text.isEmpty()) {
            display.setText(text.substring(0, text.length() - 1));
        }
    }
}


