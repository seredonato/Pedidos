package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.AdministradorExceptionAgregarProducto;
import Restaurante.AdministradorExceptionEliminarProducto;
import Restaurante.AdministradorExceptionProductoNoEncontrado;
import Restaurante.Categoria;
import Restaurante.Cliente;
import Restaurante.ExceptionProductoInexistente;
import Restaurante.Pedido;
import Restaurante.Producto;
import Restaurante.Restaurante;
import Restaurante.Sistema;
import Restaurante.SistemaExceptionNoCreaUsuario;
import Restaurante.SistemaExceptionNoEncuentraUsuario;

public class TestAdministrador {

	@Test
	public void admAgregarProductos() throws SistemaExceptionNoEncuentraUsuario, SistemaExceptionNoCreaUsuario,
			AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 4);
		a1.agregarProductos(p2, r1);

		Boolean valorObtenido = a1.agregarProductos(p1, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);
		System.out.println("----- PRODUCTOS AGREGADOS-----");
		r1.mostrarCarta();

	}

	// 2 Ingresar productos fallo

	@Test(expected = AdministradorExceptionAgregarProducto.class)
	public void admNoAgregarProductos() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Restaurante Cafeteria = new Restaurante("Cafeteria", "123456");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		a1.agregarProductos(p1, Cafeteria);

		a1.agregarProductos(p1, Cafeteria);

	}

	// 2 Ingresar productos fallo por id repetida

	@Test(expected = AdministradorExceptionAgregarProducto.class)
	public void admNoAgregarProductosIdRepetida() throws SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Restaurante Cafeteria = new Restaurante("Cafeteria", "123456");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 20, 2);

		a1.agregarProductos(p1, Cafeteria);
		a1.agregarProductos(p2, Cafeteria);
	}

	@Test
	public void eliminarProductos() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionEliminarProducto {
		Sistema sistema = new Sistema();
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c1);
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		sistema.crearNuevoUsuario(a1);
		sistema.loguearUsuario("MarceloGomez123@gmail.com", "123123");
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 5);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 4);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);

		Boolean valorObtenido = a1.eliminarProducto(4, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);

	}

	@Test(expected = AdministradorExceptionEliminarProducto.class)
	public void eliminarProductoNoValido() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionEliminarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 5);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		a1.eliminarProducto(85, r1);

	}

	@Test
	// 4 Buscar productos//
	public void buscarProductos() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionProductoNoEncontrado {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 5);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);

		Boolean valorObtenido = a1.buscarProducto(4, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test(expected = AdministradorExceptionProductoNoEncontrado.class)
	public void buscarProductoQueNoExiste() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionProductoNoEncontrado {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 5);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.buscarProducto(6, r1);

	}
	// 5 Buscar producto que no existe//

	@Test(expected = AdministradorExceptionProductoNoEncontrado.class)
	public void eliminarProductoQueNoExiste() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionProductoNoEncontrado {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 5);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);

		Boolean valorObtenido = a1.buscarProducto(10, r1);
		Boolean valorEsperado = false;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test(expected = AdministradorExceptionProductoNoEncontrado.class)
	public void eliminarProductosYBuscarlo() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, AdministradorExceptionProductoNoEncontrado,
			AdministradorExceptionEliminarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 5);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		a1.eliminarProducto(4, r1);
		a1.buscarProducto(4, r1);

	}

	// MOSTRAR LISTADO DE TODOS LOS PRODUCTOS
	@Test
	public void verListado() throws SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 5);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		System.out.println("----->LISTADO<-------");
		r1.mostrarCarta();

	}

	@Test
	public void verEstadoPedido() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 8);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		a1.finalizarPedido(pedido);

		System.out.println("pedido Finalizado " + c1.verEstado(pedido));

	}

}