package Model;

public class Pedido {
	private int id;
	private int id_mesa;
	
	//constructor con atributos
	public Pedido(int id, int id_mesa) {
		super();
		this.id = id;
		this.id_mesa = id_mesa;
	}
	//constructor por defecto
	public Pedido() {
		super();
		this.id = 0;
		this.id_mesa = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_mesa() {
		return id_mesa;
	}

	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}

	@Override
	public String toString() {
		return "Nº Pedido=" + id + ", Mesa=" + id_mesa;
	}

}
