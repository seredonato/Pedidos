package Restaurante;

import java.util.TreeSet;

public class Restaurante {
	
	TreeSet<Producto> productos = new TreeSet<Producto>();
	TreeSet<Producto> productosPedidos = new TreeSet<Producto>();

	// NO HACE FALTA NINGUN METODO Q DISTINGA LOS NUMEROS DE IDENTIFICACION PARA Q
	// HAYA REPETIDOS
	// PORQ LO HACE EL MISMO TREESET
	// ESTA ORDENADO PARA FACILITAR EL INGRESO DEL PRODUCTO YA QUE SE TIENE QUE
	// INGRESAR ID

	private String nombre2;
	private String cuit2;

	public Restaurante(String nombre2, String cuit2) {
		this.nombre2 = nombre2;
		this.cuit2 = cuit2;
	}

	// MUESTRA TODA LA ARRAY
	public Boolean mostrarCarta() {
		Integer contador = 0;
		for (Producto P : productos) {
			if (productos == null) {
				return false;
			}
			System.out.println(P.hashCode() + " -- " + P.toString());
		}
		return false;
	}

	public EstadoPedido verEstado(Pedido pedido) { // HACER QUE EL PEDIDO TENGA UNA ID Y BUSCARLO POR ID
		return pedido.getEstado();
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getCuit2() {
		return cuit2;
	}

	public void setCuit2(String cuit2) {
		this.cuit2 = cuit2;
	}

}