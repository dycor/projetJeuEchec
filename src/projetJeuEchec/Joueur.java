package projetJeuEchec;

public class Joueur {
	private String nom;
	private boolean tour;
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.tour = true;
	}
	
	public boolean getTour() {
		return this.tour;
	}
	
	public void setTour(boolean tour) {
		this.tour = tour;
	}
	
}
