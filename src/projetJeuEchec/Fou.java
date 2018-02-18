package projetJeuEchec;

import java.awt.Image;

public class Fou extends Piece{

	public Fou(String couleur,Image img) {
		super(couleur,img);
		// TODO Auto-generated constructor stub
	}
	
	public Fou(String couleur) {
		super(couleur,"Fou");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub

		return ((Math.abs((debut.getX()- fin.getX())) - Math.abs((debut.getY()- fin.getY()))) == 0);
	}

}
