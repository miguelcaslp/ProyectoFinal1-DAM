package ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Articulo;
import Model.P_Articulo;
import Model.Pedido;
import Utils.Connect;

public class P_ArticuloDao {
	/**
	 * inserta un P_articulo en la bd
	 * @param ob P_Articul a insertar
	 * @return true si se ha insertado correctamente
	 */
	public static boolean insert(P_Articulo ob) {
		//abre conexion
		Connection miconexion = Connect.getConnection();
		//boolean a devolver
		boolean result = false;
		//sentencia sql
		String sql = "INSERT INTO p_articulo (id_p,id_a,cantidad,estado) VALUES (?,?,?,?)";
		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			//se insertan los datos en la sentencis sql
			sentencia.setInt(1, ob.getPedidido().getId());
			sentencia.setInt(2, ob.getArticulo().getId());
			sentencia.setInt(3, ob.getCantidad());
			sentencia.setInt(4, ob.isEstado());
			sentencia.executeUpdate();
			//si despues de actualizar no habido fallo el result es true y significa que 
			//todo ha ido correcto 
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * devuelve un Arraylist de todos los P_Articulo que tiene asociado un id de pedido
	 * @param pedido tiene el id con el que se van a identificar los id_Pedidos
	 * @return Arraylist de todos los P_Articulo
	 */
	public static ArrayList<P_Articulo> get(Pedido pedido) {
		Connection miconexion = Connect.getConnection();
		ArrayList<P_Articulo> a = null;
		//se obtiene el id del pedido
		int idp = pedido.getId();
		//sentenia sql
		String sql = "SELECT id_a,cantidad,estado FROM p_articulo WHERE id_p=?";

		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			//se inserta el id en la sentencia 
			sentencia.setInt(1, idp);
			ResultSet miRs = sentencia.executeQuery();
			a = new ArrayList<P_Articulo>();
			//mientras tenga resguistros la consulta se añadiran P_Articulos
			while (miRs.next()) {
				//se obtiene los datos 
				int id_a = miRs.getInt("id_a");
				Articulo art_aux = ArticuloDao.get(id_a);
				int cant_aux = miRs.getInt("cantidad");
				int est_aux = miRs.getInt("estado");
				//se crea el P_Articulo
				P_Articulo auxi = new P_Articulo(pedido, art_aux, cant_aux, est_aux);
				//se añade al arraylist
				a.add(auxi);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} 
		return a;
	}

	/**
	 * se pasa el articulo que se quier aumentar la cantidad y el pedido con el id asociado 
	 * @param pedido tiene la id asociada al P_Articulo
	 * @param art articulo que del P_Articulo que se quiere aumentar la cantidad
	 */
	public static void addCantidad(Pedido pedido, Articulo art) {
		Connection miconexion = Connect.getConnection();
		//se obtiene los ids de ambos
		int idp = pedido.getId();
		int ida = art.getId();
		//sentencia sql
		String sql = "UPDATE p_articulo SET cantidad = (SELECT cantidad FROM p_articulo WHERE p_articulo.id_p = ? AND p_articulo.id_a = ?) + 1 WHERE p_articulo.id_p = ? AND p_articulo.id_a = ?";

		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			//se insertan los valores valores 
			sentencia.setInt(1, idp);
			sentencia.setInt(2, ida);
			sentencia.setInt(3, idp);
			sentencia.setInt(4, ida);
			//se actualiza
			sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		} 

	}

	/**
	 * Devuelve true o false segun si el pedido esta terminado o no
	 * @param id_pedido id del pedido que queremos saber si esta acabao o no
	 * @return true si esta acabado y false si no
	 */
	public static boolean EstadoFinish(int id_pedido) {
		Connection miconexion = Connect.getConnection();
		String sql = "SELECT id_p FROM p_articulo WHERE id_p=? and estado=0 limit 1 ";
		int noUse = -1;
		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			//se inserta el id
			sentencia.setInt(1, id_pedido);
			ResultSet miRs = sentencia.executeQuery();
			miRs.next();
			//se obtiene el id del pedido y se iguala al int anteriormente creado
			noUse = miRs.getInt("id_p");
			//si noUse no es igual a -1 significa que el pedido no esta acabado
			if (noUse != -1) {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} 
		return true;
	}

	/**
	 * se elimina pedido pasado en la bd
	 * @param pedido es el pedido a eliminar
	 */
	public static void eliminaPedido(Pedido pedido) {
		Connection miconexion = Connect.getConnection();
		//se obtiene el id del pedido a eliminar
		int id = pedido.getId();
		String sql = "DELETE FROM p_articulo where id_p=?";
		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			// se pasa el id a la sentencia 
			sentencia.setInt(1, id);
			//se actualiza
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} 

	}
	
	
	

}
