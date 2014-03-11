import java.io.IOException;


public class Main {

	//Main1
	public static void main(String[] param) {
		
		
		
		//create model
		//FilmBuilder build1 = new FilmCSV("doc/cinedome_20140128.csv");
		FilmBuilder build2 = new FilmBDD();
		Cinema cinema = new Cinema();
		try {
			cinema = new Cinema(build2.createCinema());
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		//create controller
		Controller controller = new Controller(cinema);
		

		
	}
}
