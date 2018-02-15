package projetJeuEchec;

import java.awt.Image;

public class Tour extends Piece{

	
	public Tour(String couleur, Image img) {
		super(couleur, img);
		// TODO Auto-generated constructor stub
	}
	
	public Tour(String couleur) {
		super(couleur,"Tour");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
		
		return (((fin.getX()==debut.getX()) && (fin.getY()!=debut.getY()))  || ((fin.getX()!=debut.getX()) && (fin.getY()==debut.getY())));
	}

}
