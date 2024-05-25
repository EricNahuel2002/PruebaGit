package ar.edu.unlam.paquetetest;

public class TareaEnCurso extends Tarea{
	public TareaEnCurso(Integer idTarea, String nombre) {
		super(idTarea,nombre);
		setEstado(Estado.EN_CURSO);
	}
	
	@Override
	public Boolean asignarUsuarioQueLaToma(Integer idUsuarioQueLaToma) {
		if(getEstado() != Estado.EN_CURSO) {
			setIdUsuarioQueLaToma(idUsuarioQueLaToma);
			return true;
		}
		return false;
	}
}
