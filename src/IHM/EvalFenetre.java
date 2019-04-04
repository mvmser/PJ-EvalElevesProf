package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;




public class EvalFenetre extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel labelTitre;
	private JPanel panel, panelMenu, panelBody;
	private JButton buttonProfesseur, buttonEleve, buttonClassement;
	
	
	public EvalFenetre() {
		super();
		build(); //On initialise notre fenetre
	}

	public void build() {
		this.setTitle("Evaluation Eleve / Professeur"); 
		this.setSize(1500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //regarder c quoi
		this.setResizable(true); 
		
		setContentPane(buildContentPane());
	}


	private JPanel buildContentPane(){
		/** 
		 * CREATION DU PANEL MENU EN WEST
		 */
		panelMenu = new JPanel();
		
		GridLayout gl = new GridLayout(3,1);
		gl.setVgap(150);
		panelMenu.setLayout(gl);
		
		
		/** Creation des 3 boutons du menu */
		buttonProfesseur = new JButton("Professeur");
		buttonProfesseur.addActionListener(this);
		buttonProfesseur.setPreferredSize(new Dimension(200, 150));
		panelMenu.add(buttonProfesseur);
		
		buttonEleve = new JButton("Eleve");
		buttonEleve.addActionListener(this);
		buttonEleve.setPreferredSize(new Dimension(300, 150));
		panelMenu.add(buttonEleve);
		
		buttonClassement = new JButton("Classement des eleves");
		buttonClassement.addActionListener(this);
		buttonClassement.setPreferredSize(new Dimension(300, 150));
		panelMenu.add(buttonClassement);
		
		
		
		
		/** 
		 * CREATION DU PANEL BODY EN EAST
		 */
		panelBody = new JPanel();
		panelBody.setLayout(new BorderLayout());
		
		/** Creation du JLabel pour le titre */
		labelTitre = new JLabel("Accueil");
		Font f = new Font("Lato", Font.PLAIN, 45);
		labelTitre.setFont(f);
		labelTitre.setHorizontalAlignment(JLabel.CENTER);
		labelTitre.setVerticalAlignment(JLabel.CENTER);
		panelBody.add(labelTitre, BorderLayout.CENTER);
		
		
		
		/** set colors*/
		panelMenu.setBackground(Color.red);
		panelBody.setBackground(Color.green);

		
		/**
		 * CREATION DU PANEL TOTAL
		 */
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(panelMenu, BorderLayout.WEST); /** a gauche */
		panel.add(panelBody, BorderLayout.CENTER); /** au centre */
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}