package Miguel.a_proyectoprueba;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class InfoPedidoController implements Initializable {

	public InfoPedidoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@FXML
	private Label pedido;

	@FXML
	private ImageView back;

	//cambia de vista a menu cuando se clika back
	@FXML
	private void switchToBack() throws IOException {
		App.setRoot("menu");
	}
	
	//cuando inizia la vita el label pedido receibe como texto un string del pedido de CamareroEleccion
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pedido.setText(CamareroEleccionController.infoPedido());

	}

}
