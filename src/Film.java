import java.nio.charset.Charset;
import java.util.ArrayList;

//Class Film
//

class Film {
	private String titre;	
	private String date;
	private int Nbvue;
	private Categorie cat;
	private Float noteSpec;
	private Float noteCrit;
	private ArrayList<String> Acteurs;
	private ArrayList<String> Horaires;
	
	public Film() {	}

	public Film(String titre, String date, int Nbvue, Categorie cat, Float noteSpec, Float noteCrit, ArrayList<String> Acteurs, ArrayList<String> Horaires) {
		this.titre = titre;
		this.date = date;
		if(0 <= noteSpec && 5 >=  noteSpec)
			this.noteSpec = new Float(noteSpec);
		else this.noteSpec = new Float(2.5);
		if(0 <= noteCrit && 5 >=  noteCrit)
			this.noteCrit = new Float(noteCrit);
		else this.noteCrit = new Float(2.5);
		this.cat = cat;
		this.Nbvue = Nbvue;
		this.Horaires = new ArrayList<String>();
		for(String s : Horaires) {
			this.Horaires.add(new String(s.getBytes(), Charset.forName("UTF-8")));
		}
		this.Acteurs = new ArrayList<String>();
		for(String s : Acteurs) {
			this.Acteurs.add(new String(s.getBytes(), Charset.forName("UTF-8")));
		}
		
	}	
	
	//GETTERS SETTERS
	public String getTitre() { return this.titre; }
	public String getDate() { return this.date; }
	public int getNbvue() { return this.Nbvue; }
	public Categorie getCategorie() { return this.cat; }
	public Float getNoteSpec() { return this.noteSpec; }
	public Float getNoteCrit() { return this.noteCrit; }
	public ArrayList<String> getHoraires() { return this.Horaires; }
	public ArrayList<String> getActeurs() { return this.Acteurs; }
	
	public void setTitre(String titre) { this.titre = new String(titre.getBytes(), Charset.forName("UTF-8")); }
	public void setDate(String date) { this.date = new String(date.getBytes(), Charset.forName("UTF-8")); }
	public void setNbvue(int Nbvue) { this.Nbvue = Nbvue; }
	public void setCategorie(String cat) { 
		if(cat.equals("Comedie"))
			this.cat = Categorie.Comedie;
		else if(cat.equals("Drame"))
			this.cat = Categorie.Drame;
		else if(cat.equals("Fiction"))
			this.cat = Categorie.Fiction;
		else if(cat.equals("Fantastique"))
			this.cat = Categorie.Fantastique;
		else if(cat.equals("Horreur"))
			this.cat = Categorie.Horreur;
		else if(cat.equals("Biopic"))
			this.cat = Categorie.Biopic;
		else if(cat.equals("Famille"))
			this.cat = Categorie.Famille;
		else if(cat.equals("Aventure"))
			this.cat = Categorie.Aventure;
		else if(cat.equals("Thriller"))
			this.cat = Categorie.Thriller;
		else if(cat.equals("Action"))
			this.cat = Categorie.Action;
		else if(cat.equals("Animation"))
			this.cat = Categorie.Animation;
		else if(cat.equals("Guerre"))
			this.cat = Categorie.Guerre;
		else this.cat = null;
	}
	public void setNoteSpec(Float noteSpec) { 
		if(0 <= noteSpec && 5 >=  noteSpec)
			this.noteSpec = new Float(noteSpec);
		else this.noteSpec = new Float(2.5);
	}
	public void setNoteCrit(Float noteCrit) { 
		if(0 <= noteCrit && 5 >=  noteCrit)
			this.noteCrit = new Float(noteCrit);
		else this.noteCrit = new Float(2.5);
	}
	public void setHoraires(ArrayList<String> Horaires) { 
		if(this.Horaires == null)
			this.Horaires = new ArrayList<String>();
		this.Horaires.addAll(Horaires); 
	}
	public void setActeurs(ArrayList<String> Acteurs) { 
		if(this.Acteurs == null)
			this.Acteurs = new ArrayList<String>();
		this.Acteurs.addAll(Acteurs);	
	}

	
}
