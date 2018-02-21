package projetJeuEchec;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;
//CODE DE DYLAN ET MEHDI
public class Case extends JButton{
	private Position pos;
	private Piece piece;
	
	public Case(Position pos) {
		super();
		this.pos = pos;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
		if(piece != null){
			this.setText(piece.getNom());
			if(piece.getCouleur() == "bleu" ) {
				this.setForeground(Color.blue);
			}
			else {
				this.setForeground(Color.red);
			}
		} else {
			this.setText(null);
		}
		
	}

	public Position getPos() {
		return pos;
	}

	public Piece getPiece() {
		return piece;
	}
}
