import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//input berupa nomor telepon yang mau dinormalisasi
//Contoh langsung masukkan (021) 61275712
public class Problem3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String perintah;
		while ((perintah = read.readLine()) != null) {
			String regex = "(.)*(\\d+)(.)*";
			if(perintah.matches(regex)) {
				String str = perintah.replaceAll("\\D+","");
				if(str.substring(0, 1).equals("0") && str.length() != 1) {
					System.out.println("6" + str.substring(1, str.length()));
				} else {
					System.out.println(str);
				}
			} else {
				System.out.println(perintah);
			}
		}
	}
	
}
