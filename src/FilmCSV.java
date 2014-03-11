import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


class FilmCSV extends FilmBuilder {
	
	FileInputStream csv;
	BufferedReader reader;

	public FilmCSV(String file) {
		super();
		try {
			if(file.matches(".*\\.csv")) {
				csv = new FileInputStream(file);
				reader = new BufferedReader(new InputStreamReader(csv));
			}
			else {
				csv = new FileInputStream("doc/cinedome_20140128.csv");
				reader = new BufferedReader(new InputStreamReader(csv));
			}
		} catch (FileNotFoundException e) {
			System.exit(0);
		}
	}

	
	@Override
	public ArrayList<Film> createCinema() throws IOException {
		ArrayList<Film> cinema = new ArrayList<Film>();
		String line;
		while((line = reader.readLine()) != null) {
			cinema.add(createFilm(line));	
		}
		
		return cinema;
	}
	
	public Film createFilm(String line) {
		//Creation of object Film
		Film f = new Film();
		//Recuperation of different elements in the line
		String[] tab = line.split(";");
		//Set the title
		if(!tab[0].isEmpty())
			f.setTitre(tab[0]);
		else f.setTitre("UNKNOW");
		//Set the date
		if(!tab[1].isEmpty())
			f.setDate(tab[1]);
		else f.setDate("UNKNOW");
		//Set the number of views
		if(!tab[2].isEmpty())
			f.setNbvue(Integer.parseInt(tab[2]));
		else f.setNbvue(0);
		//Set the category
		f.setCategorie(tab[4]);
		//Set the critical's rate
		if(!tab[5].isEmpty())
			f.setNoteCrit(Float.parseFloat(tab[5]));
		else f.setNoteCrit(new Float(2.5));
		//Set the spectator's rate
		if(!tab[6].isEmpty())
			f.setNoteSpec(Float.parseFloat(tab[6]));
		else f.setNoteSpec(new Float(2.5));
		//Recuperation of all actors, insertion of each actor in a list, set our object's list
		String[] tabAct = tab[7].split(",");
		ArrayList<String> Acteurs = new ArrayList<String>();
		for(int i = 0; i < tabAct.length; ++i)
			Acteurs.add(new String(tabAct[i].getBytes(), Charset.forName("UTF-8")));
		f.setActeurs(Acteurs);
		//Recuperation of all hours, insertion of each hours in a list, set our object's list
		String[] tabHor = tab[8].split(",");
		ArrayList<String> Horaires = new ArrayList<String>();
		for(int i = 0; i < tabHor.length; ++i)
			Horaires.add(new String(tabHor[i].getBytes(), Charset.forName("UTF-8")));
		f.setHoraires(Horaires);
		
		return f;
		
	}

}
