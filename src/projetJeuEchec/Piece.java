package projetJeuEchec;
//CODE DE DYLAN ET MEHDI
import java.awt.Image;

public abstract class Piece {
	protected String couleur,nom;

	public Piece(String couleur,String nom) {
		this.couleur = couleur;
		this.nom = nom;
	}


	public String getCouleur() {
		return this.couleur;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setCouleur(String couleur) {
			this.couleur = couleur;
	}
	
	public abstract boolean estValide(Position debut, Position fin);
	public abstract boolean cheminBloque(Case echiquier[][] ,Position depart , Position fin);
}
	
