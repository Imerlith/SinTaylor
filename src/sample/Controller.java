package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.math.BigInteger;


public class Controller {

    @FXML
    private Label radResult;

    @FXML
    private Button radsubmitbtn;

    @FXML
    private TextField radtextfield;
    @FXML
    private Slider radslider;

    @FXML
    void radbtnOnClick(ActionEvent event){
        displayResult();
    }
    @FXML
    void onEnter(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            displayResult();
        }

    }
    private boolean validateInput(String input){
        return input.matches("-?\\d+(\\.\\d+)?/-?\\d+(\\.\\d+)?") || input.matches("-?\\d+(\\.\\d+)?");
    }
    private void displayResult(){
        if (validateInput(radtextfield.getText())){
            radResult.setText(radtextfield.getText()+" "+(int)radslider.getValue());

        }else {
            radResult.setText("Błędne dane");
        }
        radtextfield.clear();

    }
    private void calculate(){
       int numberOfElements = (int)radslider.getValue();
       String toCalc = radtextfield.getText();
       double toFind = Double.valueOf(toCalc);
       //TODO zmienic by sprawdzalo z ktorej karty wyslano i czy podano ulamek z /
        BigDecimal result = new BigDecimal(toCalc);
        for (int i = 1; i <=numberOfElements ; i++) {
            double temp;
            result = result.add(new BigDecimal())
        }
    }
    private BigInteger factorial(int n){
        if (n<0){
            return new BigInteger("0");
        }else {

        }
    }




}
