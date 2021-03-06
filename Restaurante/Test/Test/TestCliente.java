package Test;

import org.junit.Assert;
import org.junit.Test;

import Restaurante.Administrador;
import Restaurante.AdministradorExceptionAgregarProducto;
import Restaurante.Categoria;
import Restaurante.Cliente;
import Restaurante.ClienteExceptionNoPedidos;
import Restaurante.ExceptionProductoInexistente;
import Restaurante.Pedido;
import Restaurante.Producto;
import Restaurante.Restaurante;
import Restaurante.Sistema;
import Restaurante.SistemaExceptionNoCreaUsuario;
import Restaurante.SistemaExceptionNoEncuentraUsuario;

public class TestCliente {

	@Test
	public void pedirProducto() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
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
		Boolean valorObtenido = c1.pedirProducto(4, pedido, r1);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test(expected = ExceptionProductoInexistente.class)
	public void pedirProductoInexistente() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 5);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 1);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		Boolean valorObtenido = c1.pedirProducto(8, pedido, r1);
		Boolean valorEsperado = false;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void pedirCuenta() throws ClienteExceptionNoPedidos, ExceptionProductoInexistente,
			SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		Integer valorObtenido = c1.pedirCuenta(pedido, r1);
		Double valorEsperado = 610.0;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void pedirCuentaSinPedirNada() throws ClienteExceptionNoPedidos, ExceptionProductoInexistente,
			SistemaExceptionNoCreaUsuario, SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 5);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 2);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		Integer valorObtenido = c1.pedirCuenta(pedido, r1);
		Double valorEsperado = 0.0;
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void mostrarCuenta() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		System.out.println("---PEDIDO---");
		c1.mostrarPedido(pedido);
	}

	@Test
	public void mostrarCuentaVacia() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
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
		Pedido pedido = new Pedido(4, r1);
		System.out.println("---PEDIDO VACIO---");
		c1.mostrarPedido(pedido);
	}

	@Test
	public void eliminarPedido() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
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
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		System.out.println("----eliminar Producto-----");
		c1.eliminarPedidoCompleto(pedido);
		c1.mostrarPedido(pedido);
		System.out.println("---------");

	}

	@Test
	public void eliminarPedidoInexistente() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		System.out.println("----eliminar Producto-----");
		c1.eliminarPedidoCompleto(pedido);
		c1.mostrarPedido(pedido);
		System.out.println("---------");
	}

	@Test
	public void pagarPedido() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		c1.pagar(pedido);
		c1.pedirProducto(6, pedido, r1);
		System.out.println("---------MOSTRAR PEDIDO ACTUAL-------");
		c1.mostrarPedido(pedido);
	}

	@Test
	public void verHistorial() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		c1.pagar(pedido);
		c1.pedirProducto(6, pedido, r1);
		System.out.println("---------Historial-------");
		c1.verHistorial();
	}

	@Test
	public void eliminarUnProductoDelPedido() throws SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, SistemaExceptionNoCreaUsuario, ExceptionProductoInexistente {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		c1.pedirProducto(6, pedido, r1);
		Boolean valorObtenido = c1.eliminarProducto(pedido, 6);
		Boolean valorEsperado = true;
		Assert.assertEquals(valorEsperado, valorObtenido);
		System.out.println("Mostrar nueva lista");
		c1.mostrarPedido(pedido);
		System.out.println("----------");
	}

	@Test(expected = ExceptionProductoInexistente.class)

	public void eliminarUnProductoDelPedidoQueNoEstaEnElPedido() throws SistemaExceptionNoEncuentraUsuario,
			AdministradorExceptionAgregarProducto, SistemaExceptionNoCreaUsuario, ExceptionProductoInexistente {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.eliminarProducto(pedido, 3);
		System.out.println("Mostrar nueva lista");
		c1.mostrarPedido(pedido);
		System.out.println("----------");
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

		System.out.println("Estado del pedio " + c1.verEstado(pedido));
	}

	public void mostrarCuenta2() throws ExceptionProductoInexistente, SistemaExceptionNoCreaUsuario,
			SistemaExceptionNoEncuentraUsuario, AdministradorExceptionAgregarProducto {
		Cliente c1 = new Cliente("123", "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
		Sistema sistema = new Sistema();
		sistema.crearNuevoUsuario(c1);
		sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
		Administrador a1 = new Administrador("456", "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
		Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500, 2);
		Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50, 4);
		Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500, 3);
		Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60, 6);
		Restaurante r1 = new Restaurante("Cafeteria", "123456");
		a1.agregarProductos(p1, r1);
		a1.agregarProductos(p2, r1);
		a1.agregarProductos(p3, r1);
		a1.agregarProductos(p4, r1);
		Pedido pedido = new Pedido(4, r1);
		c1.pedirProducto(6, pedido, r1);
		c1.pedirProducto(4, pedido, r1);
		c1.pedirProducto(2, pedido, r1);
		System.out.println("---PEDIDO---");
		sistema.cerrarSesiondeUsuario();
		Cliente c2 = new Cliente("456", "Marcelo", "martinez", "Marcelo@hotmail.com", "123luciamartinez");
		sistema.crearNuevoUsuario(c2);
		sistema.loguearUsuario("Marcelo@hotmail.com", "123luciamartinez");
		Pedido pedido2 = new Pedido(4, r1);
		c2.pedirProducto(6, pedido2, r1);
		c2.pedirProducto(4, pedido2, r1);
		c2.pedirProducto(2, pedido2, r1);
		c2.mostrarPedido(pedido2);

	}
}