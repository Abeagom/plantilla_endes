package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la clase Plantilla.
 */
class PlantillaTest {
    private Plantilla plantilla;
    private Comercial c;
    private Tecnico t;

    @BeforeEach
    @DisplayName("Inicialización de la plantilla de empleados")
    void setUp() {
        plantilla = new Plantilla();
        c = new Comercial ("11111111H", "Juan", "Pérez", 1000.00, 2.00);
        t = new Tecnico ("11111112H", "Pepe", "Campos", 1000.00, 1);
    }

    /**
     * Prueba que verifica que no se puedan contratar empleados con el mismo DNI.
     */
<<<<<<< HEAD
=======

>>>>>>> doc/javadoc
    @Test
    @DisplayName("No permite contratar empleados con el mismo DNI")
    void testContratarEmpleado_Duplicado() {
        Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
        Empleado tecnico2 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); // Mismo DNI que el primero

        // Se permite el primer contrato
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico1));

        // Intentar contratar otro empleado con el mismo DNI debería lanzar una excepción
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(tecnico2));

        // Verificar el mensaje de la excepción
        assertEquals("El empleado con DNI 11111111H ya está contratado", ex.getMessage());
    }
    
	@Test
	@DisplayName("Prueba del método contratarEmpleado")
	void testContratarEmpleados() {
		int resultadoEsperado = 1;
		List<Empleado> empleados = new ArrayList();
		plantilla.contratarEmpleado(c);
		plantilla.contratarEmpleado(t);
		empleados = plantilla.getEmpleadosPorNombre("Juan");
		assertEquals(resultadoEsperado, empleados.size() , "El empleado no ha sido agregado correctamente");
	}
	
	@Test
	@DisplayName("Prueba del método getEmpleadosPorNombre")
	void testGetEmpleadosPorNombre() {
		List<Empleado> empleados = new ArrayList();
		plantilla.contratarEmpleado(c);
		plantilla.contratarEmpleado(t);
		empleados = plantilla.getEmpleadosPorNombre("Juan");
		String resultadoEsperado = "Juan";
		assertEquals(resultadoEsperado,empleados.get(0).getNombre(), "El empleado no ha sido agregado correctamente");
	}
	
}