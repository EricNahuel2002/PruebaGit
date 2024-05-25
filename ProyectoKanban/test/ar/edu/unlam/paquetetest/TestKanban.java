package ar.edu.unlam.paquetetest;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.Test;

public class TestKanban {
	
	@Test
	public void queSePuedaCrearUnTablero() {
		Tablero tablero = new Tablero("Kanban");
		
		assertNotNull(tablero);
	}
	
	@Test
	public void queSePuedaAgregarUnaTareaAlTablero() {
		Tablero tablero = new Tablero("Kanban");
		Integer idTarea = 23;
		Tarea tarea  = new Tarea(idTarea);
		
		Boolean tareaAgregada = tablero.agregarTarea(tarea);
		
		assertTrue(tareaAgregada);
	}
	
	@Test
	public void queSePuedaAgregarUnUsuarioAlTablero() {
		Tablero tablero = new Tablero("Kanban");
		Integer idUsuario = 65;
		Usuario usuario = new Usuario(idUsuario);
		
		Boolean usuarioAgregado = tablero.agregarUsuario(usuario);
		
		assertTrue(usuarioAgregado);
	}
	
	
	@Test
	public void queUnUsuarioPuedaTomarUnaTarea() {
		Tablero tablero = new Tablero("Kanban");
		Usuario usuario = new Usuario(12);
		String nombre = "Comer";
		Integer idTarea = 23;
		Tarea tarea = new Tarea(idTarea,nombre);
		tablero.agregarTarea(tarea);
		tablero.agregarUsuario(usuario);
		Integer idUsuario = 32;
		Usuario otroUsuario = new Usuario(idUsuario);
		tablero.agregarUsuario(otroUsuario);
		
		Boolean tareaTomadaPorUsuario = tablero.tomarTarea(otroUsuario.getId(),tarea.getId());
		
		assertTrue(tareaTomadaPorUsuario);
	}
	
	@Test
	public void queUnUsuarioPuedaCambiarElEstadoDeUnaTarea() {
		Tablero tablero = new Tablero("Kanban");
		Usuario usuario = new Usuario(12);
		String nombre = "Comer";
		Integer idTarea = 23;
		Tarea tarea = new Tarea(idTarea,nombre);
		tablero.agregarTarea(tarea);
		tablero.agregarUsuario(usuario);
		Integer idUsuario = 32;
		Usuario otroUsuario = new Usuario(idUsuario);
		tablero.agregarUsuario(otroUsuario);
		tablero.tomarTarea(otroUsuario.getId(),tarea.getId());
		
		tablero.cambiarEstadoDeUnaTarea(idTarea,idUsuario,Estado.FINALIZADA);
		Tarea tareaObtenida = tablero.obtenerTarea(idTarea);
		
		
		assertEquals(Estado.FINALIZADA,tareaObtenida.getEstado());
	}
	
	@Test
	public void queUnaTareaEnCursoNoPuedaSerTomada() {
		Tablero tablero = new Tablero("Kanban");
		Usuario usuario = new Usuario(12);
		String nombre = "Comer";
		Integer idTarea = 23;
		TareaEnCurso tarea = new TareaEnCurso(idTarea,nombre);
		tablero.agregarTarea(tarea);
		tablero.agregarUsuario(usuario);
		tablero.tomarTarea(usuario.getId(),tarea.getId());
		tablero.cambiarEstadoDeUnaTarea(idTarea,usuario.getId(),Estado.EN_CURSO);
		Integer otroIdUsuario = 63;
		Usuario otroUsuario2 = new Usuario(otroIdUsuario);
		tablero.agregarUsuario(otroUsuario2);
		
		Boolean tareaTomada = tablero.tomarTarea(otroUsuario2.getId(), idTarea);
		
		assertFalse(tareaTomada);
	}
	

}
