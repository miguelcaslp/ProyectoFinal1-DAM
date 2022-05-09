package Miguel.a_proyectoprueba;

import java.util.ArrayList;

import Model.Articulo;
import Model.P_Articulo;
import ModelDao.ArticuloDao;
import ModelDao.P_ArticuloDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ModificaPedidoController {
	@FXML
	private VBox bebidas;
	
	//muestra todas los Articulos que el cliente ha pedido 
	@FXML
	private void mostrarPedido() {
		//seobtien un Arraylist con lo P_Articulos que teine el pedido 
		ArrayList<P_Articulo> bdArticulos = P_ArticuloDao.get(ElegirAlimentoController.getPedido());
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		for(P_Articulo p_art:bdArticulos) {
				//se guardan todos los articulos en un arralist de articulos
				articulos.add(p_art.getArticulo());		
			}
		for (Articulo aux : articulos) {
			//se crean los botones por cada articulo con el nombre del articulo en el boton
			Button articulo = new Button();
			Font myFont1 = new Font("Serif", 20);
			articulo.setFont(myFont1);
			String nombre = aux.getNombre();
			articulo.setText(nombre);
			bebidas.getChildren().add(articulo);
		}
	}
}
