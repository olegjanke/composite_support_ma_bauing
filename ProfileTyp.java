import static java.lang.Math.*;

public class ProfileTyp {
	double height;
	double width;
	double webThickness;
	double flangeThickness;
	double area;

	public ProfileTyp(String type) {
		this.loadProfile(type);
	}

	private void loadProfile(String type) {
		if (type.equals("HEA200")) {
			this.height = 19;
			this.width = 20;
			this.webThickness = 65;
			this.flangeThickness = 1.0;
			this.area = 53.8;

		} else if (type.equals("HEB200")) {
			this.height = 20;
			this.width = 20;
			this.webThickness = 0.9;
			this.flangeThickness = 1.6;
			this.area = 78.1;

		} else if (type.equals("HEB300")) {
			this.height = 30;
			this.width = 30;
			this.webThickness = 1.1;
			this.flangeThickness = 1.9;
			this.area = 149;

		} else {
			System.out.println("Unbekannter Profiltyp: " + type);
			this.height = this.width = this.webThickness = this.flangeThickness = this.area = 0;
		}
	}

	public double getH() {
		return this.height;
	}

	public double getW() {
		return this.width;
	}

	public double getTw() {
		return this.webThickness;
	}

	public double getTf() {
		return this.flangeThickness;
	}

	public double getA() {
		return this.area;
	}
}