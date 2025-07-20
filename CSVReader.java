
public class CSVReader {

	public static void main(String[] args) {
		   try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {       String line;while ((line = br.readLine()) != null) {           String[] values = line.split(",");           String name = values[0];           int age = Integer.parseInt(values[1]);           String city = values[2];// Verarbeiten der Daten hier}} catch (IOException e) {       e.printStackTrace();}
		   
		

	}

}
