package projetJeuEchec;

import java.awt.Image;

public class Pion extends Piece {
	private boolean premierCoup = true;
	public Pion(String couleur,Image img) {
		super(couleur,img);
	}
	 
	 public Pion(String couleur) {
			super(couleur,"Pion");
			// TODO Auto-generated constructor stub
		}
	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
		
		if(this.couleur == "bleu") {
			if(premierCoup && ((fin.getX()-debut.getX()) == 2) && ((fin.getY()-debut.getY()) == 0)) {
				premierCoup =false;
				return true;
			}
				
			return ((fin.getX()-debut.getX()) == 1);
		}
		
		if(this.couleur == "rouge") {
			if(premierCoup && ((debut.getX()-fin.getX()) == 2) && ((debut.getY()-fin.getY()) == 0)) {
				premierCoup =false;
				return true;
			}
				
			return ((debut.getX()-fin.getX()) == 1);
		}
		
		// Rajouter le cas ou il y'a un pion à manger
		return false;
	}
}
