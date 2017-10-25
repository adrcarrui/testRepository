//Programa
public class ObjectMaze {

	private int col;
	private int fil;
	private String[][] laberinto; 

	public ObjectMaze(int col, int fil) {
		this.col=col;
		this.fil=fil;
		laberinto = new String[fil][col];
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getFil() {
		return fil;
	}

	public void setFil(int fil) {
		this.fil = fil;
	}

	public void treasurePosition() {
		int posx,posy;
		posx = (int) (Math.random()*(col));
		posy = (int) (Math.random()*(fil));
		while(posx<=1 || posx>=col-1)
		{posx = (int) (Math.random()*(col));}
		while(posy<=1 || posy>=fil-1)
		{posy = (int) (Math.random()*(fil));}
		laberinto[posy][posx]="*";
	}

	public void userPosition() {
		int x= (int) (Math.random()*(col));
		laberinto[0][x]="o";
	}

	public void innerWallsPosition() {
		for(int i=1;i<col-1;i++) {
			for(int j=1;j<fil-1;j++) {
				double random = Math.random();
				if (random > 0.5)
					laberinto[j][i]="/";
				else
					laberinto[j][i]="\\";
			}
		}
	}

	public void createMaze() {
		for(int i=0;i<col;i++) {
			laberinto[fil-1][i]="_";
			laberinto[0][i]="_";
			for(int j=1;j<fil;j++) {

				laberinto[j][0]="|";
				laberinto[j][col-1]="|";
			}
			laberinto[fil-1][0]=" ";
			laberinto[fil-1][col-1]=" ";
		}
		innerWallsPosition();
		treasurePosition();
		userPosition();

	}
	public void drawMaze() {
		for(int i=0;i<col;i++) {
			System.out.print("\n");
			for(int j=0;j<fil;j++) {
				System.out.print(laberinto[i][j]);
			}
		}

	}
}