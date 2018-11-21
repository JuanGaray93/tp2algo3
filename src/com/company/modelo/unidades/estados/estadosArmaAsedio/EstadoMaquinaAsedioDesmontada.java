package com.company.modelo.unidades.estados.estadosArmaAsedio;

public class EstadoMaquinaAsedioDesmontada extends EstadoMaquinaAsedio {
	
	public EstadoMaquinaAsedioDesmontada(int vida,int costo, MaquinaAsedio maquinaAsedio) {
		
		this.VIDA_MAXIMA = vida;
		this.setVidaActual(VIDA_MAXIMA);
		this.COSTO =  costo;
		this.montada = false;
		this.maquinaAsedio = maquinaAsedio;
		ataque = new Ataque(75,0);
	
	}
	
	public void desmontar() throws MaquinaDesmontadaException {
		throw new MaquinaDesmontadaException("la maquina de asedio ya esta desmontada");
	}

	public EstadoMaquinaAsedioMontada montar() {
		return new EstadoMaquinaAsedioMontada(maquinaAsedio.getVidaActual(), COSTO , maquinaAsedio);
	}
	
	public void moverA(maquinaAsedio) {
		maquinaAsedio.moverA();
	}
	
	public void atacar(Edificio enemigo) throws MaquinaDesmontadaException {
		throw new MaquinaDesmontadaException("la maquina de asedio no puede atacar desmontada");
	
	}
}
