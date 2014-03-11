//THE MODEL

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;


class Cinema extends Observable{
	public ArrayList<Film> progra;
	
	public Cinema() { 
		this.progra = new ArrayList<Film>();
	}
	public Cinema(ArrayList<Film> list) {
		this.progra = new ArrayList<Film>(list);
	}
	
	public void ajouteFilm(Film f) {
		this.progra.add(f);
		setChanged();
		notifyObservers();
	}
	
	public Film random() {
		Random random = new Random();
		return this.progra.get(random.nextInt(this.progra.size()));
	}
	
	
	public void notifyObserver(Film f) {	
	}
	
}
