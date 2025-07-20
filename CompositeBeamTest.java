public class CompositeBeamTest {

	public static void main(String[] args) {
		// Verbundst�tze mit Profil HEB200
		CompositeBeam beam = new CompositeBeam("HEB300", "S235", "C30/37");

		// Betonfl�che berechnen und ausgeben
		/*
		 * double concreteArea = beam.getConcreteArea();
		 * System.out.printf("Betonfl�che (cm�): %.2f%n", concreteArea);
		 */

		// Normalkraft A infolge Stahl & Beton
		double NormalA = beam.getPointA();
		System.out.printf("NormalkraftA (kN): %.2f%n", NormalA);

		// Methode MomentB Ausrechnen
		double ProfileMRdB = beam.getPointB();
		System.out.printf("MomentkraftB (kNm): %.2f%n", ProfileMRdB);

		// Methode MomentC Ausrechnen
		double ProfileMRdC = beam.getPointB();
		System.out.printf("MomentkraftC (kNm): %.2f%n", ProfileMRdC);

		// Methode NormalkraftC Ausrechnen
		double ProfileNRdC = beam.getPointNormalC();
		System.out.printf("NormalkraftC (kN): %.2f%n", ProfileNRdC);

		// Methode NormalkraftD Ausrechnen
		double ProfileNRdD = beam.getPointNormalD();
		System.out.printf("NormalkraftD (kN): %.2f%n", ProfileNRdD);

		// Methode MomentD Ausrechnen
		double ProfileMRdD = beam.getPointMomentD();
		System.out.printf("MomentkraftD (kNm): %.2f%n", ProfileMRdD);

	}
}