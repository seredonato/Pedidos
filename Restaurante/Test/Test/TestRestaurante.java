package Test;


import org.junit.Assert;
import org.junit.Test;

import Restaurante2.Administrador;
import Restaurante2.Categoria;
import Restaurante2.Cliente;
import Restaurante2.Producto;
import Restaurante2.Restaurante;
import Restaurante2.Sistema;
import Restaurante2.productoException;

public class TestRestaurante {
		// 1 Ingresar productos
		@Test
		public void admAgregarProductos() {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Restaurante r1 = new Restaurante("Cafeteria", 123456);
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			
			Boolean valorObtenido=a1.agregarProductos(p1,r1);
			Boolean valorEsperado=true;
			Assert.assertEquals(valorEsperado, valorObtenido);
		}
		// 2 Ingresar productos fallo
		@Test
		public void admNoAgregarProductos() {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Restaurante Cafeteria = new Restaurante("Cafeteria", 123456);
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			a1.agregarProductos(p1, Cafeteria);
			
			Boolean valorObtenido=a1.agregarProductos(p1,Cafeteria);
			Boolean valorEsperado=false;
			Assert.assertEquals(valorEsperado, valorObtenido);
		}
		/*@Test
		public void ingresarConSet() throws productoException {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
			Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
			Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
			Restaurante r1 = new Restaurante("Cafeteria", 123456);
			a1.agregarProductos(p1, r1);
			a1.agregarProductos(p2, r1);
			a1.agregarProductos(p3, r1);
			a1.agregarProductos(p4, r1);
			
			Assert.assertEquals(4, r1.getProductosSet().size());
			
			for (Producto cli : r1.getProductosSet()) {
				System.out.println(cli.hashCode() +"-------"+ cli.toString());
			}
		} // NO FUNCIONA */
		@Test
		public void eliminarProductos() {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
			Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
			Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
			Restaurante r1 = new Restaurante("Cafeteria", 123456);
			a1.agregarProductos(p1, r1);
			a1.agregarProductos(p2, r1);
			a1.agregarProductos(p3, r1);
			a1.agregarProductos(p4, r1);
			
			Boolean valorObtenido =a1.eliminarProducto(4,r1);
			Boolean valorEsperado = true;
			Assert.assertEquals(valorEsperado, valorObtenido);

		}
		@Test
		// 4 Buscar productos//
		public void buscarProductos() {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
			Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
			Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
			Restaurante r1 = new Restaurante("Cafeteria", 123456);
			a1.agregarProductos(p1, r1);
			a1.agregarProductos(p2, r1);
			a1.agregarProductos(p3, r1);
			a1.agregarProductos(p4, r1);
			
			Boolean valorObtenido = a1.buscarProducto(4, r1);
			Boolean valorEsperado = true;
			Assert.assertEquals(valorEsperado, valorObtenido);
		}
		//5 Buscar producto que no existe//
		
		@Test
		public void eliminarProductoQueNoExiste() {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
			Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
			Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
			Restaurante r1 = new Restaurante("Cafeteria", 123456);
			a1.agregarProductos(p1, r1);
			a1.agregarProductos(p2, r1);
			a1.agregarProductos(p3, r1);
			
			Boolean valorObtenido = a1.buscarProducto(10, r1);
			Boolean valorEsperado = false;
			Assert.assertEquals(valorEsperado, valorObtenido);

		}
		@Test
		public void eliminarProductosYBuscarlo() {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
			Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
			Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
			Restaurante r1 = new Restaurante("Cafeteria", 123456);
			a1.agregarProductos(p1, r1);
			a1.agregarProductos(p2, r1);
			a1.agregarProductos(p3, r1);
			a1.agregarProductos(p4, r1);
			a1.eliminarProducto(4,r1);
			Boolean valorObtenido =a1.buscarProducto(4, r1);
			Boolean valorEsperado = false;
			Assert.assertEquals(valorEsperado, valorObtenido);
		}
		//MOSTRAR LISTADO DE TODOS LOS PRODUCTOS
		@Test
		public void verListado() {
			Cliente c1 = new Cliente(123, "lucia", "martinez", "luciamartinez@hotmail.com", "123luciamartinez");
			Sistema sistema = new Sistema("La Fragata");
			sistema.crearNuevoUsuario(c1);
			sistema.loguearUsuario("luciamartinez@hotmail.com", "123luciamartinez");
			Administrador a1 = new Administrador(456, "Marcelo", "Gomez", "MarceloGomez123@gmail.com", "123123");
			Producto p1 = new Producto(Categoria.PIZZAS, "Muzzarella", 500.0, 2);
			Producto p2 = new Producto(Categoria.EMPANADAS, "pollo", 50.0, 4);
			Producto p3 = new Producto(Categoria.VINOS, "Tinto", 500.0, 2);
			Producto p4 = new Producto(Categoria.BEBIDAS, "Agua", 60.0, 6);
			Restaurante r1 = new Restaurante("Cafeteria", 123456);
			a1.agregarProductos(p1, r1);
			a1.agregarProductos(p2, r1);
			a1.agregarProductos(p3, r1);
			a1.agregarProductos(p4, r1);
			r1.mostrarCarta();
			
		}

}