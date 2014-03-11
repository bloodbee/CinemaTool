import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class FilmBDD extends FilmBuilder {
	Connection con;

	public FilmBDD() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/filmbdd", "root", "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public FilmBDD(String heberg, String data, String id, String mdp) {
		super();
		try {		
			
			String url = "jdbc:mysql://" + heberg + "/" + data;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, id, mdp);
		}
		catch(Exception e) {
			System.out.println("Erreur connexion à la base.");
		}
	}
	
	
	@Override
	public ArrayList<Film> createCinema() throws IOException {
		ArrayList<Film> cinema = new ArrayList<Film>();

		ResultSet resultat = null;
		
		try {
			Statement st = con.createStatement();
			resultat = st.executeQuery("SELECT * FROM film");
			
			while(resultat.next()) {
				cinema.add(createFilm(resultat));
			}
			
			resultat.close();
			st.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				
		return cinema;
	}
	
	public ArrayList<Film> createCinema(String table) throws IOException {
		ArrayList<Film> cinema = new ArrayList<Film>();

		ResultSet resultat = null;
		
		try {
			Statement st = con.createStatement();
			resultat = st.executeQuery("SELECT * FROM " + table);
			
			while(resultat.next()) {
				cinema.add(createFilm(resultat));
			}
			
			resultat.close();
			st.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				
		return cinema;
	}
	
	public Film createFilm(ResultSet ligne) {
		//Creation of object Film
		Film f = new Film();
	
		try {
			//titre
			f.setTitre(new String(ligne.getString(1).getBytes()));
			//date
			f.setDate(ligne.getString(2));
			//nombre de vue
			f.setNbvue(ligne.getInt(3));
			//categorie
			f.setCategorie(ligne.getString(5));
			//note spectateur
			f.setNoteSpec(new Float(ligne.getFloat(6)));
			//note critique
			f.setNoteCrit(new Float(ligne.getFloat(7)));
			//acteurs
			String a = ligne.getString(8);
			String [] act = a.split(",");
			ArrayList<String> acteurs = new ArrayList<String>();
			for(String acteur : act) {
				acteurs.add(new String(acteur.getBytes()));
			}
			f.setActeurs(acteurs);
			//horaires
			String h = ligne.getString(9);
			String [] hor = h.split(",");
			ArrayList<String> horaires = new ArrayList<String>();
			for(String horaire : hor) {
				horaires.add(new String(horaire.getBytes()));
			}
			f.setHoraires(horaires);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return f;
		
	}

}
