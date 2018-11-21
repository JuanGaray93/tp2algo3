package com.company.modelo.unidades.estados.estadosArmaAsedio;

public class EstadoMaquinaAsedioMontada extends EstadoMaquinaAsedio {

	public EstadoMaquinaAsedioMontada(int vida,int costo, MaquinaAsedio maquinaAsedio) {
		
		this.VIDA_MAXIMA = vida;
		this.setVidaActual(VIDA_MAXIMA);
		this.COSTO =  costo;
		this.montada = true;
		this.maquinaAsedio = maquinaAsedio;
		ataque = new Ataque(75,0);
	
	}
	
	public EstadoMaquinaAsedioDesmontada desmontar() {
		return new EstadoMaquinaAsedioDesmontada(maquinaAsedio.getVidaActual(), COSTO , maquinaAsedio);
	}
	
	public EstadoMaquinaAsedioMontada montar()  throws MaquinaMontadaException {
		throw new MaquinaMontadaException("la maquina de asedio ya esta montada");
	}
	
	public void moverA() throws MaquinaMontadaException {
		throw new MaquinaMontadaException("la maquina de asedio no se puede mover porque esta montada");
	}
	
	public void atacar(Edificio enemigo){
		ataque.atacar(enemigo);
	}

}
