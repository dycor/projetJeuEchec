package projetJeuEchec;

import java.awt.Image;

public class Reine extends Piece{


	public Reine(String couleur, Image img) {
		super(couleur, img);
		// TODO Auto-generated constructor stub
	}

	public Reine(String couleur) {
		super(couleur,"Reine");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
//		(  ( Math.abs(debut.getY()- fin.getY()) - Math.abs(debut.getY()- fin.getY()) ) == 0  );
		return (((fin.getX()==debut.getX()) && (fin.getY()!=debut.getY()))  || ((fin.getX()!=debut.getX()) && (fin.getY()==debut.getY())) ||((debut.getX()-fin.getX()) == (debut.getY()-fin.getY()))||(  ( Math.abs(debut.getY()- fin.getY()) - Math.abs(debut.getY()- fin.getY()) ) == 0  ));

	}

}
