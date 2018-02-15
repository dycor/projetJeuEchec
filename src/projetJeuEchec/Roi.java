package projetJeuEchec;

import java.awt.Image;

public class Roi extends Piece{

	public Roi(String couleur, Image img) {
		super(couleur,img);
		// TODO Auto-generated constructor stub
	}

	public Roi(String couleur) {
		super(couleur,"Roi");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
		return (((debut.getY() -fin.getY()) == 1)|((debut.getY() -fin.getY()) == -1) & ((debut.getX() -fin.getX()) == 1)|((debut.getX() -fin.getX()) == -1));
	}

}
