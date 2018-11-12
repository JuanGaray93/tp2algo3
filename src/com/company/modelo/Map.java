package modelo;

	public class Map extends Board{
		
		public Map(int i,int j) {
			super(new Size(i,j));
	
		}
		
		public boolean isItSize(int i,int j){
			
			return sizeMap.getRows() == i & sizeMap.getColumns() == j;
			
		}
		
		public void placeUnit(Positionable pj,Position pos) {
			boxes.positionIn(pos, pj);
		}
		
		public void placeBuild(Positionable build,Position centerPos) {
			boxes.positionIn(centerPos, build);
		}

	}
