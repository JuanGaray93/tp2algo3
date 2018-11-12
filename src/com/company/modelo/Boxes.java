package modelo;

public class Boxes {
	
	private Box boxes[]; 
	
	public Boxes(int size) {
		boxes =  new Box[size];
	}
	
	public void positionIn(Position pos, Positionable pj) {
		for(int i=0;i<boxes.length;i++) {
			boxes[i].pushUnitIn(pj,pos);
		}
	}

}
