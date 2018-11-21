package com.company.modelo.unidades.estados.estadosArmaAsedio;

public class EstadoMaquinaAsedio extends EstadoUnidad{
		
		private Boolean montada;
		MaquinaAsedio maquinaAsedio;
		private Ataque ataque;
		
	
		public EstadoMaquinaAsedio(int vida,int costo,MaquinaAsedio maquinaAsedio) {
			
			this.VIDA_MAXIMA = vida;
			this.setVidaActual(VIDA_MAXIMA);
			this.COSTO =  costo;
			this.montada = false;
			this.maquinaAsedio = maquinaAsedio;
			ataque = new Ataque(75,0);
		
		}
		
		public boolean estaMontada() {
			return montada;
		}
		
		

}
