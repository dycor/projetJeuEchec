package projetJeuEchec;
//CODE DE DYLAN ET MEHDI
import java.awt.Image;

public class Pion extends Piece {
	private boolean premierCoup = true;

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
			if((fin.getX()-debut.getX()) == 1)
				premierCoup =false;
			return ((fin.getX()-debut.getX()) == 1);
		}
		
		if(this.couleur == "rouge") {
			if(premierCoup && ((debut.getX()-fin.getX()) == 2) && ((debut.getY()-fin.getY()) == 0)) {
				premierCoup =false;
				return true;
			}
			if((debut.getX()-fin.getX()) == 1)
				premierCoup =false;
			return ((debut.getX()-fin.getX()) == 1);
		}
		
		// Rajouter le cas ou il y'a un pion à manger
		return false;
	}

	@Override
	public boolean cheminBloque(Case[][] echiquier, Position depart, Position fin) {
		// TODO Auto-generated method stub
		
		
		if(echiquier[fin.getX()][fin.getY()].getPiece()!=null)
			if(echiquier[fin.getX()][fin.getY()].getPiece().getCouleur() == this.couleur)
				return true;

		if(premierCoup && this.couleur == "rouge")
			return (echiquier[fin.getX()+1][fin.getY()].getPiece() ==null);
		
		if(premierCoup && this.couleur == "bleu")
			return (echiquier[fin.getX()-1][fin.getY()].getPiece() !=null);
		return false;
	}
}
