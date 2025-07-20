public class CompositeBeam {

	private ProfileTyp profile;
	private Steel steel;
	private ConcreteTyp concrete;

	public CompositeBeam(String profileName, String steelType, String concreteType) {
		this.profile = new ProfileTyp(profileName);
		this.steel = new Steel(steelType);
		this.concrete = new ConcreteTyp(concreteType);
	}

	/*
	 * public double getConcreteArea() { double cArea = (this.profile.getH() *
	 * this.profile.getW()) - this.profile.getA(); return cArea; }
	 */

	public double getPointA() {
		double steelForce = this.profile.getA() * this.steel.getRvS();
		double concreteArea = (this.profile.getH() * this.profile.getW()) - this.profile.getA();
		double concreteForce = concreteArea * this.concrete.getRv();
		double normalResistanceA = steelForce + concreteForce;

		return normalResistanceA;

	}

	public double getPointB() {
		double fcd = this.concrete.getRv();
		double fyd = this.steel.getRvS();

		double tw = this.profile.getTw();
		double tf = this.profile.getTf();
		double h = this.profile.getH();
		double b = this.profile.getW();

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;

		// Variabel erzeugen für Moment B/C
		double momentResistanceB = fcd * ((b - tw) * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (2 * b * tf * (h / 2 - tf / 2)) + fyd * (tw * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (tw * (h - xB - tf) * (h / 2 - (h - xB - tf) / 2 - tf));

		return momentResistanceB / 100;

	}

	double getPointNormalC() {
		double fcd = this.concrete.getRv();
		double fyd = this.steel.getRvS();

		double tw = this.profile.getTw();
		double tf = this.profile.getTf();
		double h = this.profile.getH();
		double b = this.profile.getW();

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;
		double normalResistanceC = (b - tw) * (h - 2 * xB) * fcd + 2 * (h - 2 * xB) * tw * fyd;

		return normalResistanceC;

	}

	double getPointNormalD() {
		double fcd = this.concrete.getRv();
		double fyd = this.steel.getRvS();

		double tw = this.profile.getTw();
		double tf = this.profile.getTf();
		double h = this.profile.getH();
		double b = this.profile.getW();

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;
		double normalResistanceD = 0.5 * ((b - tw) * (h - 2 * xB) * fcd + 2 * (h - 2 * xB) * tw * fyd);

		return normalResistanceD;
	}

	public double getPointMomentD() {

		double fcd = this.concrete.getRv();
		double fyd = this.steel.getRvS();

		double tw = this.profile.getTw();
		double tf = this.profile.getTf();
		double h = this.profile.getH();
		double b = this.profile.getW();

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;

		double momentResistanceD = fcd * ((b - tw) * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (2 * b * tf * (h / 2 - tf / 2)) + fyd * (tw * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (tw * (h - xB - tf) * (h / 2 - (h - xB - tf) / 2 - tf))

				+ 0.5 * ((b - tw) * (h - 2 * xB) * fcd + 2 * (h - 2 * xB) * tw * fyd) * ((h / 2 - xB) / 2);

		return momentResistanceD / 100;
	}

}