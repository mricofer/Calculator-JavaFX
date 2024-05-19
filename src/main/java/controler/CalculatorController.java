package controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Operaciones;

public class CalculatorController implements Initializable {

    @FXML
    private Button btnOperar;

    @FXML
    private TextField txtOp1;

    @FXML
    private TextField txtOp2;

    @FXML
    private TextField txtResultado;

    @FXML
    private RadioButton rbtnSuma;
    private RadioButton rbtnResta;
    private RadioButton rbtnMultiplicacion;
    private RadioButton rbtnDivision;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        rbtnSuma.setToggleGroup(tg);
        rbtnResta.setToggleGroup(tg);
        rbtnMultiplicacion.setToggleGroup(tg);
        rbtnDivision.setToggleGroup(tg);
    }

    @FXML
    private void operar(ActionEvent event) {
        try{
            double op1 = Double.parseDouble(txtOp1.getText());
            double op2 = Double.parseDouble(txtOp2.getText());

            Operaciones op = new Operaciones(op1, op2);

            if(rbtnSuma.isSelected()){
                txtResultado.setText(String.valueOf(op.sumar()));
            }else if(rbtnResta.isSelected()){
                txtResultado.setText(String.valueOf(op.restar()));
            }else if(rbtnMultiplicacion.isSelected()){
                txtResultado.setText(String.valueOf(op.multiplicar()));
            }else if(rbtnDivision.isSelected()){
                if (op2 == 0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No se puede dividir por cero");
                    alert.showAndWait();
                } else {
                txtResultado.setText(String.valueOf(op.dividir()));
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Seleccione una operación");
                alert.showAndWait();
            }

        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }

}
