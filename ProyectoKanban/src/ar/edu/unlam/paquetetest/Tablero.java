package ar.edu.unlam.paquetetest;

import java.util.ArrayList;

public class Tablero {

	private String nombre;
	private ArrayList <Tarea> tareas;
	private ArrayList <Usuario> usuarios;
	public Tablero(String nombre) {
		this.nombre = nombre;
		tareas = new ArrayList<>();
		usuarios = new ArrayList<>();
	}
	

	public Boolean agregarTarea(Tarea tarea) {
		return tareas.add(tarea);
	}

	public Boolean agregarUsuario(Usuario usuario) {
		return usuarios.add(usuario);
	}

	public Boolean tomarTarea(Integer idUsuario, Integer idTarea) {
		Tarea tareaEncontrada = this.buscarTarea(idTarea);
		Usuario usuarioEncontrado = this.buscarUsuario(idUsuario);
		
		return tareaEncontrada.asignarUsuarioQueLaToma(usuarioEncontrado.getId());
	}

	private Usuario buscarUsuario(Integer idUsuario) {
		for(Usuario usuario: usuarios) {
			if(usuario.getId().equals(idUsuario)) {
				return usuario;
			}
		}
		return null;
	}

	private Tarea buscarTarea(Integer idTarea) {
		for (Tarea tarea : tareas) {
			if(tarea.getId().equals(idTarea)) {
				return tarea;
			}
		}
		return null;
	}

	public Tarea obtenerTarea(Integer idTarea) {
		Tarea tarea = this.buscarTarea(idTarea);
		return tarea;
	}

	public void cambiarEstadoDeUnaTarea(Integer idTarea, Integer idUsuario, Estado estado) {
		switch(estado) {
		case PENDIENTE:
			Tarea tareaEncontrada = this.buscarTarea(idTarea);
			tareaEncontrada.setEstado(Estado.PENDIENTE);
			break;
		case EN_CURSO:
			tareaEncontrada = this.buscarTarea(idTarea);
			tareaEncontrada.setEstado(Estado.EN_CURSO);
			break;
		case FINALIZADA:
			tareaEncontrada = this.buscarTarea(idTarea);
			tareaEncontrada.setEstado(Estado.FINALIZADA);
			break;
		}
	}

}
