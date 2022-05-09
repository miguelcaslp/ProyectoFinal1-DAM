package Miguel.a_proyectoprueba;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Empleado;
import ModelDao.EmpleadoDao;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PrimaryController implements Initializable {
	EmpleadoDao eDao = new EmpleadoDao();

	@FXML
	private ImageView button;
	@FXML
	private TextField user;
	@FXML
	private TextField password;
	@FXML
	private ImageView buttonExit;
	@FXML
	private Label button2Exit;

	//verificael usuario en la bd y si es correcto lo cambia a una vista
	@FXML
	private void logIn() throws IOException {
		//se obtiene el usuario y contraseña
		String usuario = user.getText();
		String pass = password.getText();
		//verifica el usuario
		boolean valid = eDao.validUser(usuario, pass);
		Empleado e = null;
		// si esta en la bd
		if (valid == true) {
			//se obtiene un usuario a traves del nombre de usuario
			e = eDao.get(usuario);
			//se obtien el trabajo que tiene 
			String trabajo = e.getTrabajo();
			//si el trabajo es camarero la vista cambia a mesas
			if (trabajo.equals("camarero")) {
				App.setRoot("mesas");
			} else if (e.getTrabajo() == "cocinero") {

			}
		}

	}

	@FXML
	public void exit() {
		handle();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void handle() {
		Platform.exit();
		System.exit(0);
	}

}
