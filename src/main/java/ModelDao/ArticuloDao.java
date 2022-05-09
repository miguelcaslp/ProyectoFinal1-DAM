package ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Articulo;
import Utils.Connect;

public class ArticuloDao {
	/**
	 * recibe un id y devuelve el articulo asociaado a esa id
	 * @param id es el id asociado al articulo a buscar
	 * @return articulo con el id pasado
	 */
	public static Articulo get(Integer id) {
		//se abre coneccion
		Connection miconexion = Connect.getConnection();
		//se crea el articulo que se va a devolver
		Articulo a = null;
		//sentecia sql a ejecutar
		String sql = "SELECT id,nombre,precio,tipo FROM articulo WHERE id=?";

		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			sentencia.setInt(1, id);
			ResultSet miRs = sentencia.executeQuery();
			a = new Articulo();
			miRs.next();
			//se obtiene los datos del select y se añaden al Artuculo
			a.setId(miRs.getInt("id"));
			a.setNombre(miRs.getString("nombre"));
			a.setPrecio(miRs.getInt("precio"));
			a.setTipo(miRs.getInt("tipo"));

		} catch (Exception e) {
			// TODO: handle exception
		} 
		return a;
	}
	/**
	 * recibe un nombre y devuelve el articulo asociaado a ese nombre
	 * @param nombre es el nombre asociado al articulo a buscar
	 * @return articulo con el nombre pasado
	 */
	public static Articulo get(String nombre) {
		//se abre conexion
		Connection miconexion = Connect.getConnection();
		//se crea articulo que se va a devolver
		Articulo a = null;
		//sentenca sql a ejecutar
		String sql = "SELECT id,nombre,precio,tipo FROM articulo WHERE nombre=?";

		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			ResultSet miRs = sentencia.executeQuery();
			a = new Articulo();
			miRs.next();
			//se obtiene los datos del select y se añaden al Artuculo
			a.setId(miRs.getInt("id"));
			a.setNombre(miRs.getString("nombre"));
			a.setPrecio(miRs.getInt("precio"));
			a.setTipo(miRs.getInt("tipo"));

		} catch (Exception e) {
			// TODO: handle exception
		} 
		return a;
	}
	
	/**
	 * devuelve un arraylist de articulos que sean bebidas
	 * @return Arraylit de bebidas
	 */
	public static ArrayList<Articulo> getBebidas() {
		//se abre conexion
		Connection miconexion = Connect.getConnection();
		//se crea arraylist
		ArrayList<Articulo> a = null;
		//sentencia de sql
		String sql = "SELECT id,nombre,precio,tipo FROM articulo WHERE tipo=0";

		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			ResultSet miRs = sentencia.executeQuery();
			a = new ArrayList<Articulo>();
			//se recorren los resultados de la bd hasta que no haya ninguno
			while (miRs.next()) {
				//se crea un articulo 
				Articulo aux = new Articulo();
				//se insertan los valores obtenidos
				aux.setId(miRs.getInt("id"));
				aux.setNombre(miRs.getString("nombre"));
				aux.setPrecio(miRs.getInt("precio"));
				aux.setTipo(miRs.getInt("tipo"));
				
				//se añade al arraylist
				a.add(aux);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}
	
	/**
	 * devuelve un arraylist de articulos que sean comida
	 * @return Arraylit de comidas
	 */
	public static ArrayList<Articulo> getComidas() {
		Connection miconexion = Connect.getConnection();
		ArrayList<Articulo> a = null;
		String sql = "SELECT id,nombre,precio,tipo FROM articulo WHERE tipo=1";

		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			ResultSet miRs = sentencia.executeQuery();
			a = new ArrayList<Articulo>();
			while (miRs.next()) {
				Articulo aux = new Articulo();
				aux.setId(miRs.getInt("id"));
				aux.setNombre(miRs.getString("nombre"));
				aux.setPrecio(miRs.getInt("precio"));
				aux.setTipo(miRs.getInt("tipo"));

				a.add(aux);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} 
		return a;
	}
	
	
	
}
