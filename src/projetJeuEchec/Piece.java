package projetJeuEchec;

import java.awt.Image;

public abstract class Piece {
	protected String couleur,nom;
	protected Image img; //new ImageIcon("PATH/TO/FILES/nomdelimage.ext")

	
	public Piece(String couleur,Image img) {
		this.couleur = couleur;
		this.img = img;
	}
	
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
}
	
