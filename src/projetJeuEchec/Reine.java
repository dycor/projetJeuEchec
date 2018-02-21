package projetJeuEchec;

import java.awt.Image;
//CODE DE DYLAN ET MEHDI
public class Reine extends Piece{

	public Reine(String couleur) {
		super(couleur,"Reine");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub
		return (((fin.getX()==debut.getX()) && (fin.getY()!=debut.getY()))  || ((fin.getX()!=debut.getX()) && (fin.getY()==debut.getY())) ||((debut.getX()-fin.getX()) == (debut.getY()-fin.getY()))||(Math.abs((debut.getX()- fin.getX())) - Math.abs((debut.getY()- fin.getY()))) == 0);

	}

	@Override
	public boolean cheminBloque(Case[][] echiquier, Position depart, Position fin) {
		// TODO Auto-generated method stub
		
		if(echiquier[fin.getX()][fin.getY()].getPiece()!=null)
			if(echiquier[fin.getX()][fin.getY()].getPiece().getCouleur() == this.couleur)
				return true;
		
		if(echiquier[fin.getX()][fin.getY()].getPiece()!=null)
			if(echiquier[fin.getX()][fin.getY()].getPiece().getCouleur() == this.couleur)
				return true;
		
		if((depart.getY()-fin.getY() == 0)) {
			if(this.couleur == "bleu") {
				for(int i = depart.getX()+1 ;i<fin.getX();i++) {
					if(echiquier[i][depart.getY()].getPiece() != null)
						return true;
				}
			}
			if(this.couleur == "rouge") {
				for(int i = depart.getX()-1 ;i>fin.getX();i--) {
					if(echiquier[i][depart.getY()].getPiece() != null)
						return true;
				}
			}
			
		}
		
		if((depart.getX()-fin.getX() == 0)) {
			if(depart.getY()<fin.getY()) {
				for(int i = depart.getY()+1;i< fin.getY();i++) {
					if(echiquier[depart.getX()][i].getPiece() != null)
						return true;
				}
			}
			if(depart.getY()>fin.getY()) {
				for(int i = depart.getY()-1;i> fin.getY();i--) {
					if(echiquier[depart.getX()][i].getPiece() != null)
						return true;
				}
			}
		}

		return false;
	}

}
