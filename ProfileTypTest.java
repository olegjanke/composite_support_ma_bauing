public class ProfileTypTest {
	public static void main(String[] args) {
		ProfileTyp HEA200 = new ProfileTyp("HEA200");

		System.out.println("H�he(mm): " + HEA200.getH());
		System.out.println("Weite(mm): " + HEA200.getW());
		System.out.println("Stegbreite(mm): " + HEA200.getTw());
		System.out.println("Flanschdicke(mm): " + HEA200.getTf());
		System.out.println("QS-Fl�che(cm�): " + HEA200.getA());

		/*
		 * ProfileType HEB200 = new ProfileType("HEB200");
		 * 
		 * System.out.println("H�he(mm): " + HEB200.getH());
		 * System.out.println("Weite(mm): " + HEB200.getW());
		 * System.out.println("Stegbreite(mm): " + HEB200.getTw());
		 * System.out.println("Flanschdicke(mm): " + HEB200.getTf());
		 * System.out.println("QS-Fl�che(cm�): " + HEB200.getA());
		 */}
}