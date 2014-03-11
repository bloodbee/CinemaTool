//THE CONTROLLER

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


class Controller implements Observer{
	Cinema cinema;
	FirstVue vue;
	int nbFilm = 0;
	int filmDisplay;
	
	String path;
	
	public Controller(Cinema inCine) {
		filmDisplay = 0;
		cinema = new Cinema(inCine.progra);
		nbFilm = cinema.progra.size()-1;
		cinema.addObserver(this);
		vue = new FirstVue(this);
		
		vue.affiche(cinema.progra.get(0));
		vue.statusBar.setText("Cinéma > Film " + filmDisplay + "/" + nbFilm + " affiché !");
		
		vue.buttonPrecedant.setEnabled(false);
	}
	

	@Override
	public void update(Observable o, Object arg) {	
	}
	
	public void onButtonPrecedantClicked() {
		if(filmDisplay > 0) {
			filmDisplay--;
			vue.affiche(cinema.progra.get(filmDisplay));
			vue.statusBar.setText("Cinéma > Film " + filmDisplay + "/" + nbFilm + " affiché !");
			
			if(!vue.buttonSuivant.isEnabled())
				vue.buttonSuivant.setEnabled(true);
			if(filmDisplay == 0)
				vue.buttonPrecedant.setEnabled(false);
		}
	}
	
	public void onButtonSuivantClicked() {
		if(filmDisplay < cinema.progra.size()-1) {
			filmDisplay++;
			vue.affiche(cinema.progra.get(filmDisplay));
			vue.statusBar.setText("Cinéma > Film " + filmDisplay + "/" + nbFilm + " affiché !");
			
			if(!vue.buttonPrecedant.isEnabled())
				vue.buttonPrecedant.setEnabled(true);
			if(filmDisplay == cinema.progra.size()-1)
				vue.buttonSuivant.setEnabled(false);
		}			
	}
	
	public void onButtonRandomClicked() {
				
		filmDisplay = cinema.progra.indexOf(cinema.random());
		
		if(filmDisplay == cinema.progra.size()-1)
		{
			vue.buttonSuivant.setEnabled(false);
			vue.buttonPrecedant.setEnabled(true);
		}
		else if(filmDisplay == 0)
		{
			vue.buttonPrecedant.setEnabled(false);
			vue.buttonSuivant.setEnabled(true);
		}
		else {
			vue.buttonSuivant.setEnabled(true);
			vue.buttonPrecedant.setEnabled(true);
		}
		vue.affiche(cinema.progra.get(filmDisplay));
		vue.statusBar.setText("Cinéma > Film " + filmDisplay + "/" + nbFilm + " affiché !");
	}
	
	public void onItemOuvrirFichierClicked() {		
		vue.fileChooser.setCurrentDirectory(new File("doc"));
		if(vue.fileChooser.showOpenDialog(vue.frame1) == JFileChooser.APPROVE_OPTION) {
			path = vue.fileChooser.getSelectedFile().getAbsolutePath();
				
			try {
				cinema = new Cinema(new FilmCSV(path).createCinema());
			} catch (IOException e) {
				vue.statusBar.setText("Cinéma > Erreur ouverture fichier " + path);
			}
			vue.buttonPrecedant.setEnabled(false);
			filmDisplay = 0;
			vue.affiche(cinema.progra.get(0));
			vue.statusBar.setText("Cinéma > Film " + filmDisplay + "/" + nbFilm + " affiché !");			
		}		
	}
	
	public void onItemOuvrirBDDClicked() {
		vue.bdd.setVisible(true);
	}
	
	public void onButtonDataAnnulClicked() {
		vue.bdd.dispose();
	}
	
	public void onButtonDataOkClicked() {
		try {	
			cinema = new Cinema(new FilmBDD(vue.databaseHebergeur.getText(), vue.databaseName.getText(), vue.databaseId.getText(), vue.databasePassword.getText()).createCinema(vue.databaseTable.getText()));	
			vue.statusBar.setText("Cinéma > Connexion réussie !");
			vue.affiche(cinema.progra.get(0));
			vue.statusBar.setText("Cinéma > Film 0/" + nbFilm + " affiché !");
			vue.buttonPrecedant.setEnabled(false);
		} catch (Exception e) {
			vue.statusBar.setText("Cinéma > Erreur lors de la connexion à la base de donnée");
		}	
		vue.bdd.dispose();		
	}

	
	public void onItemRecherche1Clicked() {
		String rep = JOptionPane.showInputDialog(vue.frame1, "Entrer un N° de film :", "Recherche par N° de film", JOptionPane.QUESTION_MESSAGE);
		
		if(rep != null)
			filmDisplay = Integer.parseInt(rep);

		
		vue.affiche(cinema.progra.get(filmDisplay));
		vue.statusBar.setText("Cinéma > Film " + filmDisplay + "/" + nbFilm + " affiché !");
		
		if(filmDisplay == cinema.progra.size()-1)
		{
			vue.buttonSuivant.setEnabled(false);
			vue.buttonPrecedant.setEnabled(true);
		}
		else if(filmDisplay == 0)
		{
			vue.buttonPrecedant.setEnabled(false);
			vue.buttonSuivant.setEnabled(true);
		}
		else {
			vue.buttonSuivant.setEnabled(true);
			vue.buttonPrecedant.setEnabled(true);
		}	
	}
	
	public void onItemQuitterClicked() {	
		vue.frame1.dispose();		
	}
	
}
