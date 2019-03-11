package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import static java.lang.Math.PI;


public class Controller {

    @FXML
    private Label radResult;

    @FXML
    private Button radsubmitbtn;

    @FXML
    private TextField radtextfield;


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
    @FXML
    private boolean validateInput(String input){
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    private void displayResult(){
        if (validateInput(radtextfield.getText())){

            calculate();

        }else {
            radResult.setText("Błędne dane");
        }
        radtextfield.clear();


    }
    private void calculate(){
        double rad = normalize(Double.valueOf(radtextfield.getText()));
        int q = quarter(rad);
        switch (q){
            case 1:break;
            case 2:rad = PI-rad;break;
            case 3:rad=rad-PI;break;
            case 4:rad = 2.0 * PI - rad;break;
        }
        double result= 0;
        int sign =-1;
        for (int i = 1; i <11 ; i++) {
            if(i%2!=0){
                result +=(-1*sign)*(Math.pow(rad,i)/power(i));
                sign *=-1;
                System.out.println(result+"                 err"+deviation(rad,result));
            }
            switch (q){
                case 3:result*=-1;break;
                case 4:result*=-1;break;
            }
            radResult.setText("result:  "+result);
        }
    }
     private long power(int n){
        if(n<1){
            return 1;
        }
        return n* power(n-1);
    }

    private int quarter(double rad){
        if (rad >= 0.0 && rad < PI / 2.0){
            return 1;
        }else  if ( rad >= PI / 2.0 && rad < PI){
            return 2;
        }else if( rad >= PI && rad < PI * 3.0 / 2.0){
            return 3;
        }else
            return 4;
    }
    private double normalize(double rad){
        double result;
        double divider = Math.floor(rad/(2.0*PI));
        if( rad >= 0.0) {
            result = rad - (divider * 2.0 * PI);
        } else {
            result = rad - (divider * 2.0 * PI) + 2.0 * PI;
        }
        return result;
    }
    private  double deviation(double rad, double result){
        double correct = Math.sin(rad);
        return correct-result;
    }





}
