package com.company.modelo.unidades.estados;

public abstract class EstadoUnidad {

	protected static Integer VIDA_MAXIMA;
	protected static Integer COSTO;
	protected static Integer vidaActual;

	public EstadoUnidad() {
		// TODO Jony: manejar atributos, el constructor podría tener pasados por parámetro los atributos al instanciar.
		// TODO Jony: Que todos los estados de unidad manejen esa lógica
	}
	
	public void recibirDanio(Integer montoDeDanio) {
		this.vidaActual -= montoDeDanio;
	}

    public abstract EstadoUnidad actualizar() throws Exception;
}
