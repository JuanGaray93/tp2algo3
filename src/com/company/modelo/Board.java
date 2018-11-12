package modelo;

public class Board {
	
	protected Size sizeMap;
	protected Boxes boxes;
	
	public Board(Size sizeNew){
		this.setSizeMap(sizeNew);
	}

	public Size getSizeMap() {
		return sizeMap;
	}

	public void setSizeMap(Size sizeMap) {
		this.sizeMap = sizeMap;
	}
}
