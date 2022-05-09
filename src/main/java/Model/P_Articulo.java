package Model;

import java.util.ArrayList;


public class P_Articulo {
	private Pedido pedido;
	private Articulo articulo;
	private int cantidad;
	private int estado;

	//constructor con atricutos 
	public P_Articulo(Pedido pedidido, Articulo articulo, int cantidad, int estado) {
		super();
		this.pedido = pedidido;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.estado = estado;
	}
	
	//contructor por defecto
	public P_Articulo() {
		super();
		this.pedido = new Pedido();
		this.articulo = new Articulo();
		this.cantidad = 0;
		this.estado = 0;
	}

	public Pedido getPedidido() {
		return pedido;
	}

	public void setPedidido(Pedido pedidido) {
		this.pedido = pedidido;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int isEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return pedido + ", " + articulo + ", cantidad=" + cantidad;
	}

	/**
	 * compueba y devuelve si el P_Articulo esta en el ArrayList
	 * @param p_art Arraylist con P_Articulos
	 * @return true si el P_Articulo esta en la arraylist
	 */
	public boolean equalArray(ArrayList<P_Articulo> p_art) {
		//si el arraylist no esta vacio 
		if (!p_art.isEmpty()) {
			//recorre el arraylist
			for (P_Articulo a : p_art) {
				//si uno de los articulos son iguales devuelve true 
				if (a.getArticulo().equals(this.articulo)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * devuelve un string de un Arraylist de P_Articulos
	 * @param p_art ArrayList que vaa recorrer 
	 * @return string de los P_articulos 
	 */
	public static String ArraytoString(ArrayList<P_Articulo> p_art) {
		String total = "";
		for (P_Articulo a : p_art) {
			//obtiene un string del P_Articulo
			String par = a.toString();
			//se acumulan todos los strings 
			total = total + par + "\n";
		}
		return total;
	}
	
	/**
	 * suma el precion de todos los P_Articuls de todos los articulos 
	 * @param p_art Arraylist con P_Articulos
	 * @return
	 */
	public static int ArraytoPrice(ArrayList<P_Articulo> p_art) {
		int total=0;
		//recorre el arraylist
		for(P_Articulo a  : p_art) {
				Articulo aux = a.getArticulo();
				int cantidad=a.getCantidad();
				int price=aux.getPrecio();
				//calcula el precio * la cantidad de producto
				total+=(price*cantidad);
			}
		return total;
	}
		
	
	
	
	
	
	
	
	
	
	
	

	
}
