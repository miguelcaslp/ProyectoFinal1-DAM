package Model;

public class Empleado {
	private String user;
	private String password;
	private String trabajo;
	
	//contructor por defecto
	public Empleado() {
		this.user = "nadie";
		this.password = "nada";
		this.trabajo = "nada";
	}
	
	//constructor con atricutos 
	public Empleado(String user, String password, String trabajo) {
		super();
		this.user = user;
		this.password = password;
		this.trabajo = trabajo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	@Override
	public String toString() {
		return "Empleado [user=" + user + ", password=" + password + ", trabajo=" + trabajo + "]";
	}

}
