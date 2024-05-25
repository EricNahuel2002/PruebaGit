package ar.edu.unlam.paquetetest;

import java.util.Objects;

public class Tarea {

	private Integer id;
	private String nombre;
	private Integer idUsuarioCreador;
	private Integer idUsuarioQueLaToma;
	private Estado estado;

	public Tarea(Integer idTarea, String nombre) {
		this.id = idTarea;
		this.nombre = nombre;
	}

	public Tarea(Integer idTarea, String nombre, Integer idUsuarioCreador, Estado estado) {
		this.id = idTarea;
		this.nombre = nombre;
		this.idUsuarioCreador = idUsuarioCreador;
		this.estado = estado;
	}

	public Tarea(Integer idTarea) {
		this.id = idTarea;
	}

	public Integer getId() {
		return id;
	}

	public Boolean asignarUsuarioQueLaToma(Integer idUsuarioQueLaToma) {
		this.idUsuarioQueLaToma = idUsuarioQueLaToma;
		return true;
	}

	public Integer getIdUsuarioCreador() {
		return idUsuarioCreador;
	}

	public void setIdUsuarioCreador(Integer idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}

	public Integer getIdUsuarioQueLaToma() {
		return idUsuarioQueLaToma;
	}

	public void setIdUsuarioQueLaToma(Integer idUsuarioQueLaToma) {
		this.idUsuarioQueLaToma = idUsuarioQueLaToma;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idUsuarioCreador, idUsuarioQueLaToma, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		return Objects.equals(id, other.id) && Objects.equals(idUsuarioCreador, other.idUsuarioCreador)
				&& Objects.equals(idUsuarioQueLaToma, other.idUsuarioQueLaToma) && Objects.equals(nombre, other.nombre);
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}



}
