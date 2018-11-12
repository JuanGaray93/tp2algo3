package modelo;

public class Position {

	private int row, column;
	
	public boolean itIsFree(Position pos) {
		
		return pos.withRow(this.row) & pos.withColumn(this.column);
	}
	
	public boolean withRow(int row) {
		return this.row == row;
	}
	
	public boolean withColumn(int column) {
		return this.column == column;
	}

}
