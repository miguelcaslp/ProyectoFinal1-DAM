package ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import Model.Empleado;
import Utils.Connect;

public class EmpleadoDao {
	private Connection miconexion;

	public EmpleadoDao() {
		miconexion = Connect.getConnection();
	}

	public boolean insert(Empleado ob) {
		this.miconexion = Connect.getConnection();
		return false;
	}
	
	/**
	 * Obtiene un Empleado a traves de su usuario
	 * @param user nombre del usuario
	 * @return empleado asociado al nombre de usuario que se le pasa
	 */
	public Empleado get(String user) {
		//se crea Empleado
		Empleado l = null;
		//sentencia sql
		String sql = "SELECT user,password,trabajo FROM empleados WHERE user=?";

		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			sentencia.setString(1, user);
			ResultSet miRs = sentencia.executeQuery();
			l = new Empleado();
			miRs.next();
			//se obtiene los datos del select y se añaden al Empleado
			l.setUser(miRs.getString("user"));
			l.setPassword(miRs.getString("password"));
			l.setTrabajo(miRs.getString("trabajo"));
			;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return l;
	}

	/**
	 * comprueba que el usuario y contraseña coinciden con un reguistro de la bd
	 * @param user nombre de usuario
	 * @param pass nombre de contraseña
	 * @return boolean si coincide o no
	 */
	public boolean validUser(String user, String pass) {
		//sentencia sql
		String sql = "SELECT user,password FROM empleados WHERE user=? and password=?";
		boolean result = false;
		try {
			PreparedStatement sentencia = miconexion.prepareStatement(sql);
			sentencia.setString(1, user);
			sentencia.setString(2, pass);
			ResultSet miRs = sentencia.executeQuery();
			//se crea un empleado por defecto
			Empleado l = new Empleado();
			miRs.next();
			//se obtiene los datos del select y se añaden al Empleado
			l.setUser(miRs.getString("user"));
			l.setPassword(miRs.getString("password"));
			//si el usuario tiene un usuario y una contraseña diferente a la del
			//usuario por defecto signifia que hay un empleado asociado a ese user y password
			if (l.getUser() != "nadie" && l.getPassword() != "nada") {
				//se devuelve true ya que existe el usuario
				result = true;
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}


}
