import java.util.ArrayList;

class Afficheur {
	
	public Afficheur() { }
	
	public void AfficheAll(ArrayList<Film> cinema) {
		System.out.println("----------------------------------");
		int i = 0;
		for(Film f : cinema) {	
			System.out.println("CinéDome > Affichage du film N° : " + i);
			AfficheFilm(f);
			System.out.println("----------------------------------");
			++i;
		}
	}
	
	public void AfficheFilm(Film f) {
		System.out.println("Titre : " + f.getTitre());
		System.out.println("Date de sortie : " + f.getDate());
		System.out.println("Catégorie : " + f.getCategorie());
		System.out.println("Note Critique : " + f.getNoteCrit());
		System.out.println("Note Spectateur : " + f.getNoteSpec());
		System.out.println("Nombre de vue : " + f.getNbvue());
		System.out.print("Acteurs : ");	
		for(String h : f.getActeurs()) {
				System.out.print(h + " ");
	
		}
		System.out.println();
		System.out.print("Horaires : ");	
		for(String h : f.getHoraires()) {
				System.out.print(h + " ");
	
		}
		System.out.println();
	}

}
