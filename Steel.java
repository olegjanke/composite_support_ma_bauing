import static java.lang.Math.*;

//Konstruktor 

public class Steel {

	double SteelTyp;

	public Steel(String type) {

		this.loadSteel(type);
	}

	private void loadSteel(String type) {
		if (type.equals("S235")) {
			this.SteelTyp = 23.5;
		}

		else if (type.equals("S275")) {
			this.SteelTyp = 27.5;
		}

		else if (type.equals("S355")) {
			this.SteelTyp = 35.5;
		}

		else if (type.equals("S460")) {
			this.SteelTyp = 46.0;
		}

		else {
			System.out.println("Unbekannter Stahl : " + type);
			this.SteelTyp = 0;
		}
	}

	// Wiederstandswert Wiedergeben

	public double getRvS() {
		return this.SteelTyp;
	}
}