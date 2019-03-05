package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


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


}
