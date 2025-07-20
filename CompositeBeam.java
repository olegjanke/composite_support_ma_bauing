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
		double fcd = this.concrete.getRv(); // z.B. 1.7 für C30/37
		double fyd = this.steel.getRvS(); // z.B. 23.5 für S235

		double tw = this.profile.getTw(); // 1.1
		double tf = this.profile.getTf(); // 1.9
		double h = this.profile.getH(); // 30.0
		double b = this.profile.getW(); // 30.0

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;
		// return xB;

		double momentResistanceB = fcd * ((b - tw) * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (2 * b * tf * (h / 2 - tf / 2)) + fyd * (tw * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (tw * (h - xB - tf) * (h / 2 - (h - xB - tf) / 2 - tf));

		return momentResistanceB / 100;

	}

	public double getPointMomentC() {

		double fcd = this.concrete.getRv(); // z.B. 1.7 für C30/37
		double fyd = this.steel.getRvS(); // z.B. 23.5 für S235

		double tw = this.profile.getTw(); // 1.1
		double tf = this.profile.getTf(); // 1.9
		double h = this.profile.getH(); // 30.0
		double b = this.profile.getW(); // 30.0

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;
		// return xB;

		double momentResistanceC = fcd * ((b - tw) * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (2 * b * tf * (h / 2 - tf / 2)) + fyd * (tw * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (tw * (h - xB - tf) * (h / 2 - (h - xB - tf) / 2 - tf));

		return momentResistanceC / 100;
	}

	double getPointNormalC() {
		double fcd = this.concrete.getRv(); // z.B. 1.7 für C30/37
		double fyd = this.steel.getRvS(); // z.B. 23.5 für S235

		double tw = this.profile.getTw(); // 1.1
		double tf = this.profile.getTf(); // 1.9
		double h = this.profile.getH(); // 30.0
		double b = this.profile.getW(); // 30.0

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;
		double normalResistanceC = (b - tw) * (h - 2 * xB) * fcd + 2 * (h - 2 * xB) * tw * fyd;

		return normalResistanceC;

	}

	double getPointNormalD() {
		double fcd = this.concrete.getRv(); // z.B. 1.7 für C30/37
		double fyd = this.steel.getRvS(); // z.B. 23.5 für S235

		double tw = this.profile.getTw(); // 1.1
		double tf = this.profile.getTf(); // 1.9
		double h = this.profile.getH(); // 30.0
		double b = this.profile.getW(); // 30.0

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;
		double normalResistanceD = 0.5 * ((b - tw) * (h - 2 * xB) * fcd + 2 * (h - 2 * xB) * tw * fyd);

		return normalResistanceD;
	}

	public double getPointMomentD() {

		double fcd = this.concrete.getRv(); // z.B. 1.7 für C30/37
		double fyd = this.steel.getRvS(); // z.B. 23.5 für S235

		double tw = this.profile.getTw(); // 1.1
		double tf = this.profile.getTf(); // 1.9
		double h = this.profile.getH(); // 30.0
		double b = this.profile.getW(); // 30.0

		double numerator = fyd * tw * h + fcd * b * tf - fcd * tw * tf;
		double denominator = fcd * b - fcd * tw + 2 * fyd * tw;

		double xB = numerator / denominator;
		// return xB;

		double momentResistanceD = fcd * ((b - tw) * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (2 * b * tf * (h / 2 - tf / 2)) + fyd * (tw * (xB - tf) * (h / 2 - tf - (xB - tf) / 2))
				+ fyd * (tw * (h - xB - tf) * (h / 2 - (h - xB - tf) / 2 - tf))

				+ 0.5 * ((b - tw) * (h - 2 * xB) * fcd + 2 * (h - 2 * xB) * tw * fyd) * ((h / 2 - xB) / 2);

		return momentResistanceD / 100;
	}

}