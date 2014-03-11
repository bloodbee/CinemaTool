//THE VUE

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


class FirstVue implements ActionListener{
	//controller
	public Controller controller;
	//frame
	public JFrame frame1;
	public JDialog bdd;
	//panels
	public JPanel pane1;
	public JPanel pane2;
	public JPanel pane3;
	//file chooser
	public JFileChooser fileChooser;
	//menu
	public JMenuBar menuBar;
	public JMenu menu;
	public JMenu menu2;
	public JMenuItem itemRecherche1;
	public JMenuItem itemOuvrirFichier;
	public JMenuItem itemOuvrirBDD;
	public JMenuItem itemQuitter;
	//buttons
	public JButton buttonRandom;
	public JButton buttonPrecedant;
	public JButton buttonSuivant;
	
	public JButton buttonDataOk;
	public JButton buttonDataAnnul;
	//label
	public JLabel labelTitre;
	public JLabel labelDate;
	public JLabel labelVue;
	public JLabel labelCategorie;
	public JLabel labelSpectateur;
	public JLabel labelCritique;
	public JLabel labelActeurs;
	public JLabel labelHoraires;
	
	public JLabel dataName;
	public JLabel dataId;
	public JLabel dataPassword;
	public JLabel dataHebergeur;
	public JLabel dataTable;
	//textfield 
	public JTextField statusBar;
	public JTextField databaseName;
	public JTextField databaseId;
	public JTextField databasePassword;
	public JTextField databaseHebergeur;
	public JTextField databaseTable;

	private void initialiserElements() {
		//Frame
		frame1 = new JFrame("Cinéma");
		frame1.setSize(500, 400);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		
		bdd = new JDialog(frame1, "Connexion à une base de donnée");
		bdd.setSize(300, 200);
		bdd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
		//Panes
		pane1 = new JPanel(new GridLayout(8,1));
		pane2 = new JPanel(new BorderLayout());
		pane3 = new JPanel(new GridLayout(6,2));
		
		
		//Menu
		menuBar = new JMenuBar();
		menu = new JMenu("Fichier");
		menu2 = new JMenu("Recherche");
		
		menuBar.add(menu);
		menuBar.add(menu2);
		itemOuvrirFichier = new JMenuItem("Ouvrir fichier");
		itemOuvrirBDD = new JMenuItem("Ouvrir connexion");
		itemQuitter = new JMenuItem("Quitter");
		itemRecherche1 = new JMenuItem("Recherche par N°");
		
		menu.add(itemOuvrirFichier);
		menu.add(itemOuvrirBDD);
		menu.addSeparator();
		menu.add(itemQuitter);
		
		menu2.add(itemRecherche1);
		
		frame1.setJMenuBar(menuBar);
		
		//File
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("tableur csv", "csv"));
		
		//Buttons
		buttonRandom = new JButton("Film au hasard");
		buttonSuivant = new JButton("Film suivant");	
		buttonPrecedant = new JButton("Film précédant");
		
		buttonDataAnnul = new JButton("Annuler");
		buttonDataOk = new JButton("Connexion");
			
		//Label
		labelTitre = new JLabel("Titre du film : ");
		labelDate = new JLabel("Date de sortie : ");
		labelVue = new JLabel("Nombre de vue : ");
		labelCategorie = new JLabel("Catégorie : ");
		labelSpectateur = new JLabel("Note spectateur : ");
		labelCritique = new JLabel("Note critique : ");
		labelActeurs = new JLabel("Acteurs : ");
		labelHoraires = new JLabel("Horaires : ");
		
		dataName = new JLabel("Nom de la base :");
		dataId = new JLabel("Id :");
		dataPassword = new JLabel("Mot de passe :");
		dataHebergeur = new JLabel("Hebergeur : ");
		dataTable = new JLabel("Table :");
		
		//TextField
		statusBar = new JTextField("Cinéma > ");
		statusBar.setEditable(false);
		
		databaseName = new JTextField();
		databaseId = new JTextField();
		databasePassword = new JTextField();
		databaseHebergeur = new JTextField();
		databaseTable = new JTextField();
	}
	
	public void placeContents() {
		frame1.add(statusBar, BorderLayout.NORTH);
		frame1.add(pane1, BorderLayout.CENTER);
		frame1.add(pane2, BorderLayout.SOUTH);
	
		pane1.add(labelTitre);
		pane1.add(labelDate);
		pane1.add(labelVue);
		pane1.add(labelCategorie);
		pane1.add(labelSpectateur);
		pane1.add(labelCritique);
		pane1.add(labelActeurs);
		pane1.add(labelHoraires);
				
		pane2.add(buttonPrecedant, BorderLayout.WEST);
		pane2.add(buttonSuivant, BorderLayout.EAST);
		pane2.add(buttonRandom, BorderLayout.CENTER);
		
		pane3.add(dataHebergeur);
		pane3.add(databaseHebergeur);
		databaseHebergeur.setText("localhost");
		pane3.add(dataName);
		pane3.add(databaseName);
		databaseName.setText("filmbdd");
		pane3.add(dataTable);
		pane3.add(databaseTable);
		databaseTable.setText("film");
		pane3.add(dataId);
		pane3.add(databaseId);
		databaseId.setText("root");	
		pane3.add(dataPassword);
		pane3.add(databasePassword);	
		pane3.add(buttonDataAnnul);
		pane3.add(buttonDataOk);
		bdd.setContentPane(pane3);
		bdd.setVisible(false);	
		
		
	}
	
	public void createActions() {
		buttonRandom.addActionListener(this);
		buttonSuivant.addActionListener(this);
		buttonPrecedant.addActionListener(this);
		
		buttonDataAnnul.addActionListener(this);
		buttonDataOk.addActionListener(this);
		
		itemOuvrirFichier.addActionListener(this);
		itemOuvrirBDD.addActionListener(this);
		itemQuitter.addActionListener(this);
		
		itemRecherche1.addActionListener(this);
	}
	
	
	public FirstVue(Controller controller) {
		
		this.controller = controller;

		//Elements of the view
		initialiserElements();
			
		//Disposition of the panels
		placeContents();
		
		//Create actionlistener on elements
		createActions();		
	}

	public void affiche(Film f) {
		labelTitre.setText("Titre du film : " + f.getTitre());
		labelDate.setText("Date de sortie : " + f.getDate());
		labelVue.setText("Nombre de vue : " + f.getNbvue());
		labelCategorie.setText("Catégorie : " + f.getCategorie());
		labelSpectateur.setText("Note spectateur : " + f.getNoteSpec().floatValue());
		labelCritique.setText("Note critique : " + f.getNoteCrit().floatValue());
		labelActeurs.setText("Acteurs : " + f.getActeurs().toString());
		labelHoraires.setText("Horaires : " + f.getHoraires().toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonPrecedant)
			controller.onButtonPrecedantClicked();
		else if(e.getSource() == buttonRandom)
			controller.onButtonRandomClicked();
		else if(e.getSource() == buttonSuivant)
			controller.onButtonSuivantClicked();
		else if(e.getSource() == itemOuvrirFichier)
			controller.onItemOuvrirFichierClicked();
		else if(e.getSource() == itemOuvrirBDD)
			controller.onItemOuvrirBDDClicked();
		else if(e.getSource() == itemQuitter)
			controller.onItemQuitterClicked();
		else if(e.getSource() == itemRecherche1)
			controller.onItemRecherche1Clicked();
		else if(e.getSource() == buttonDataAnnul)
			controller.onButtonDataAnnulClicked();
		else if(e.getSource() == buttonDataOk)
			controller.onButtonDataOkClicked();
	}
}
