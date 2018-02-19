package projetJeuEchec;

public class Joueur {
	private String nom;
	private boolean tour;
	private int nbPiece;
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.tour = true;
		this.nbPiece = 16;
	}
	
	public boolean getTour() {
		return this.tour;
	}
	
	public void setTour(boolean tour) {
		this.tour = tour;
	}
	
	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}
	
	public int  getNbPiece() {
		return this.nbPiece;
	}
	
	public String getNom() {
		return this.nom;
	}
	
}
