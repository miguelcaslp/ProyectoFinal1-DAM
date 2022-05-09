package Miguel.a_proyectoprueba;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PagarCuentaController implements Initializable {
	@FXML
	private Label pedido;
	@FXML
	private Label total;
	@FXML
	private Button cancelar;
	@FXML
	private Button pagar;

	//se cambia de vista a camareroEleccion cuando se clika cacelar
	@FXML
	private void switchToBack() throws IOException {
		App.setRoot("camareroEleccion");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//muestra un texto con todo el pedido 
		pedido.setText(CamareroEleccionController.infoPedido());
		//muestra el precio de todo el pedido
		total.setText(String.valueOf(CamareroEleccionController.infoPrecio()));

	}
}
