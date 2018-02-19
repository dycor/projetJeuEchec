package projetJeuEchec;

import java.awt.Image;

public class Cavalier extends Piece{

	public Cavalier(String couleur,Image img) {
		super(couleur, img);
		// TODO Auto-generated constructor stub
	}
	
	public Cavalier(String couleur) {
		super(couleur,"Cavalier");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
		
		// X - 2 & ( Y-1 | Y+1) 
		int x = debut.getX() -fin.getX();
		int y = (debut.getY() -fin.getY());
		
		// ((x == -2) & (y == -1))
		// ((x == -2) & (y == 1))
		return ( ((x == 2) & (y == -1)) || ((x == 2) & (y == 1))||((x == -2) & (y == -1))||((x == -2) & (y == 1)));
	}

}
