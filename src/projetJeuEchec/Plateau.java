package projetJeuEchec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Choix d'un Singleton car ca permet d'avoir une instance unique d'une classe
public class Plateau extends JFrame implements ActionListener{
	final static int NB_CASES_AXE = 8;
	private Case echiquier[][];
	private Position depart = null,fin = null;
	private Piece pieceMvt ;
	private JPanel cases =  new JPanel();
	
	// On initialise l'�chequier avec des cases vides
	private Plateau() {
		this.setTitle("Jeu d'echec");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		echiquier = new Case[NB_CASES_AXE][NB_CASES_AXE];
		    
		
		JPanel legendeCol =  new JPanel();
		JPanel legendeLigne =  new JPanel();
		
		cases.setLayout(new GridLayout(NB_CASES_AXE,NB_CASES_AXE));
		legendeLigne.setLayout(new GridLayout(NB_CASES_AXE,0));
		legendeCol.setLayout(new GridLayout(0,NB_CASES_AXE));
		
		//On rempli le panel Cases
		boolean blanc = true;
	    for(int i = 0; i < NB_CASES_AXE; i++) {
	    	 for(int j = 0; j<NB_CASES_AXE; j++) {
	    		 Position pos = new Position(i,j);
	    		 Case c = new Case(pos);
	    		 if(blanc) {
	    			 c.setBackground(Color.WHITE);
	    		 }else {
	    			 c.setBackground(Color.LIGHT_GRAY);
	    		 }
    			 blanc = !blanc;
    			 c.addActionListener(this);
    			 this.echiquier[i][j]=c;
    			 
	    		 
	    	 }
	    	 blanc = !blanc;
	    }
	    this.initialiserPieces();
	    for(int i = 0; i < NB_CASES_AXE; i++) {
	    	 for(int j = 0; j<NB_CASES_AXE; j++) {
	    		 cases.add( this.echiquier[i][j]);
	    	 }
	    	
	    }
	    
	   
	    
	    // On ajoute la legende des colonnes
	    legendeCol.add(new JLabel("A"));
	    legendeCol.add(new JLabel("B"));
	    legendeCol.add(new JLabel("C"));
	    legendeCol.add(new JLabel("D"));
	    legendeCol.add(new JLabel("E"));
	    legendeCol.add(new JLabel("F"));
	    legendeCol.add(new JLabel("G"));
	    legendeCol.add(new JLabel("H"));
	    
	    
	    // On ajoute la l�gende des lignes
	    
	    for(int i=1; i<=NB_CASES_AXE;i++) {
	    	legendeLigne.add(new JLabel(Integer.toString( i)));
	    }
//	    this.add(cases);
	    
	    //On ajoute les cases et l�gende 
	    //Au centre
	    this.getContentPane().add(cases,BorderLayout.CENTER);
	    
	    //Au Sud
	    this.getContentPane().add(legendeCol, BorderLayout.SOUTH);

	    // A  l'est
	    this.getContentPane().add(legendeLigne, BorderLayout.EAST);

	    
		this.setVisible(true);
		
	}
	

	
	private static class PlateauHolder
    {       
        private final static Plateau instance = new Plateau();
    }
	
	 public static Plateau getInstance()
	 {
	        return PlateauHolder.instance;
	 }
	 
	 void initialiserPieces(){
		 
		 // On ajoute les pions
		 for(int i=0 ;i< NB_CASES_AXE;i++) {
			 this.echiquier[1][i].setPiece(new Pion("bleu"));
			 this.echiquier[6][i].setPiece(new Pion("rouge"));

		 }
		 
		 //On ajoute les tours
		 this.echiquier[0][0].setPiece(new Tour("bleu"));
		 this.echiquier[0][7].setPiece(new Tour("bleu"));
		 this.echiquier[7][0].setPiece(new Tour("rouge"));
		 this.echiquier[7][7].setPiece(new Tour("rouge"));
		 
		//On ajoute les cavaliers
		 this.echiquier[0][1].setPiece(new Cavalier("bleu"));
		 this.echiquier[0][6].setPiece(new Cavalier("bleu"));
		 this.echiquier[7][1].setPiece(new Cavalier("rouge"));
		 this.echiquier[7][6].setPiece(new Cavalier("rouge"));
		 
		//On ajoute les fous
		 this.echiquier[0][2].setPiece(new Fou("bleu"));
		 this.echiquier[0][5].setPiece(new Fou("bleu"));
		 this.echiquier[7][2].setPiece(new Fou("rouge"));
		 this.echiquier[7][5].setPiece(new Fou("rouge"));

		//On ajoute les rois et reine
		 this.echiquier[0][3].setPiece(new Roi("bleu"));
		 this.echiquier[0][4].setPiece(new Reine("bleu"));
		 this.echiquier[7][3].setPiece(new Roi("rouge"));
		 this.echiquier[7][4].setPiece(new Reine("rouge"));

		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Si l'objet source est une case
		if (e.getSource() instanceof Case) {
   			// Caster l'objet source de l'�v�nement en JButton
			
   			Case btnCase = (Case) e.getSource();
   			
   			if(this.depart == null) {
				this.depart = btnCase.getPos();
				String pion = "Pion";
				this.pieceMvt = btnCase.getPiece() ;

			} else if((this.depart != null) & (this.fin ==  null)) {
				this.fin = btnCase.getPos();
				System.out.println(this.pieceMvt.estValide(this.depart, this.fin));
				if(this.pieceMvt.estValide(this.depart, this.fin))
					this.deplacement();	
				this.depart = null;
	   			this.fin = null;
			}
   			
   			System.out.println(btnCase.getPos().getX()+ " "+ btnCase.getPos().getY());
   			System.out.println();

		}
		   			
		
	}
	
	public void deplacement() {
		this.echiquier[this.depart.getX()][this.depart.getY()].setPiece(null);
		this.echiquier[this.fin.getX()][this.fin.getY()].setPiece(this.pieceMvt);

		for(int i = 0; i < NB_CASES_AXE; i++) {
	    	 for(int j = 0; j<NB_CASES_AXE; j++) {
	    		 cases.add( this.echiquier[i][j]);
	    	 }
	    	
	    }
		this.getContentPane().add(cases,BorderLayout.CENTER);
		System.out.println("Pos depart "+this.depart);
		System.out.println("Pos fin "+this.fin);
		
	}
	
}