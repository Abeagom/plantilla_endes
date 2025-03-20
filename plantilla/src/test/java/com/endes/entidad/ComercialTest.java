package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComercialTest {
	
	Comercial c;
	
	@BeforeEach
	void setUp() throws Exception {
		c = new Comercial ("11111111H", "Juan", "Pérez", 1000.00, 2.00);
	}

	@Test
	@DisplayName("Prueba del método getVentas")
	void testGetVentas() {
		double resultadoEsperado= 2.00;
		assertEquals(resultadoEsperado, c.getVentas(), "Las ventas no coinciden");
	}
	
	@Test
	@DisplayName("Prueba del método setVentas con un valor válido")
	void testSetVentasValido() {
		double resultadoEsperado= 10.00;
		c.setVentas(10.00);
		assertEquals(resultadoEsperado, c.getVentas(), "Las ventas no coinciden");
	}
	
	@Test
	@DisplayName("Prueba del método setVentas con un valor no válido")
	void testSetVentasNoValido() {
		String resultadoEsperado= "Las ventas no pueden ser negativas";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> c.setVentas(-10));
		assertEquals(resultadoEsperado, exception.getMessage(), "El método ha permitido un valor negativo");
	}
	
	@Test
	@DisplayName("Prueba del método calcularExtra")
	void testCalcularExtra() {
		double resultadoEsperado= 0.20;
		assertEquals(resultadoEsperado, c.calcularExtra(), "Los extras no coinciden");
	}
	
	@Test
	@DisplayName("Prueba del método getSueldo")
	void testGetSueldo() {
		//Resultado esperado con ventas actuales
		double resultadoEsperado= 1000.20;
		assertEquals(resultadoEsperado, c.getSueldo(), "Los sueldos no coinciden");
		
		//Calculamos con otro número de ventas
		c.setVentas(1000);
		double resultadoEsperado2=1100.00;
		assertEquals(resultadoEsperado2, c.getSueldo(), "Los sueldos no coinciden");
	}

}
