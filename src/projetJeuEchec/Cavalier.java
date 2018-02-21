package projetJeuEchec;

import java.awt.Image;
//CODE DE DYLAN ET MEHDI
public class Cavalier extends Piece{
	
	public Cavalier(String couleur) {
		super(couleur,"Cavalier");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
		
		int x = debut.getX() -fin.getX();
		int y = (debut.getY() -fin.getY());
		
		return ( ((x == 2) & (y == -1)) || ((x == 2) & (y == 1))||((x == -2) & (y == -1))||((x == -2) & (y == 1)));
	}

	@Override
	public boolean cheminBloque(Case[][] echiquier, Position depart, Position fin) {
		// TODO Auto-generated method stub
		
		if(echiquier[fin.getX()][fin.getY()].getPiece()!=null)
			if(echiquier[fin.getX()][fin.getY()].getPiece().getCouleur() == this.couleur)
				return true;
		
		return false;
	}

}
