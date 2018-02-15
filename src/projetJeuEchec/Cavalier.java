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
		return false;
	}

}
