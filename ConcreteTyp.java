import static java.lang.Math.*;

//Konstruktor
public class ConcreteTyp {

	double fck;
	double gammaC;
	double fcd;

	public ConcreteTyp(String type) {
		this.loadConcrete(type);
	}

	private void loadConcrete(String type) {
		if (type.equals("C25/30")) {
			this.fck = 2.5; // kN/cm²
			this.gammaC = 1.5;
			this.fcd = 0.85 * this.fck / this.gammaC;

		} else if (type.equals("C30/37")) {
			this.fck = 3; // kN/cm²
			this.gammaC = 1.5;
			this.fcd = 0.85 * this.fck / this.gammaC;

		} else {
			System.out.println("Unbekannter Beton : " + type);
			this.fck = this.gammaC = this.fcd = 0;
		}

	}

	// Wiederstandswert design zurück geben
	public double getRv() {
		return this.fcd;
	}
}
