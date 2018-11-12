package modelo;

public class Size {
	
	private int rows, columns;
	
	public Size(int i, int j) {
		this.setRows(i);
		this.setColumns(j);
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
}
