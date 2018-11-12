package modelo;

public class Box {

	private Position position;
	
	public Box(Position posIni){
		position = posIni;
	}
	
	public void pushUnitIn(Positionable positionable, Position pos) {
		if(position.itIsFree(pos)) {
			positionable.position(pos);
		}
	}

}
