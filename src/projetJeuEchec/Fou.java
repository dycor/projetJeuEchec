package projetJeuEchec;

import java.awt.Image;
//CODE DE DYLAN ET MEHDI
public class Fou extends Piece{

	public Fou(String couleur) {
		super(couleur,"Fou");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estValide(Position debut, Position fin) {
		// TODO Auto-generated method stub

		return ((Math.abs((debut.getX()- fin.getX())) - Math.abs((debut.getY()- fin.getY()))) == 0);
	}

	@Override
	public boolean cheminBloque(Case[][] echiquier, Position depart, Position fin) {
		// TODO Auto-generated method stub
		
		if(echiquier[fin.getX()][fin.getY()].getPiece()!=null)
			if(echiquier[fin.getX()][fin.getY()].getPiece().getCouleur() == this.couleur)
				return true;
		
		if(fin.getX()>depart.getX()) {
			int x = depart.getX()+1;
			if(fin.getY()>depart.getY()) {
				for(int y = (depart.getY()+1);y<fin.getY() ;y++) {
					if(echiquier[x][y].getPiece() != null)
						return true;
					x++;
				}
			}
			if(fin.getY()<depart.getY()) {
				for(int y = (depart.getY()-1);y>fin.getY() ;y--) {
					if(echiquier[x][y].getPiece() != null)
						return true;
					x++;
				}
			}
		}
		
		if(fin.getX()<depart.getX()) {
			int x = depart.getX()-1;
			if(fin.getY()>depart.getY()) {
				for(int y = (depart.getY()+1);y<fin.getY() ;y++) {
					if(echiquier[x][y].getPiece() != null)
						return true;
					x--;
				}
			}
			
			if(fin.getY()<depart.getY()) {
				for(int y = (depart.getY()-1);y>fin.getY() ;y--) {
					if(echiquier[x][y].getPiece() != null)
						return true;
					x--;
				}
			}
			
		}
		
		

		return false;
	}

}
