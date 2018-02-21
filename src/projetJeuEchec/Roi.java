package projetJeuEchec;

import java.awt.Image;
//CODE DE DYLAN ET MEHDI
public class Roi extends Piece{

	public Roi(String couleur) {
		super(couleur,"Roi");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
		return (((debut.getY() -fin.getY()) == 1)||((debut.getY() -fin.getY()) == -1)||((debut.getY() -fin.getY()) == 0) && ((debut.getX() -fin.getX()) == 1)||((debut.getX() -fin.getX()) == -1)||((debut.getY() -fin.getY()) == 0));
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
