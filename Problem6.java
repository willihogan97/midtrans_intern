import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//input berupa string pertama kemudian dienter untuk memasukkan string kedua
public class Problem6 {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String firstString = read.readLine();
		String secondString = read.readLine();
		
		ArrayList arrRemove = new ArrayList();
		String removedString = "";
		
		for(int i = 0 ; i < firstString.length() ; i++) {
			if(!secondString.contains(firstString.substring(i, i+1))) {
				arrRemove.add(firstString.substring(i, i+1));
			}
		}
		
		for(int i = 0 ; i < secondString.length() ; i++) {
			if(!firstString.contains(secondString.substring(i, i+1))) {
				arrRemove.add(secondString.substring(i, i+1));
			}
		}
		
		
		for(int i = 0 ; i < arrRemove.size() ; i++) {
			removedString += arrRemove.get(i) + ",";
		}
		
		System.out.println("Output " + arrRemove.size());
		if(arrRemove.size() == 0) {
			System.out.println("Not removing any string ");
		} else {
			System.out.println("Removing " + removedString.substring(0, removedString.length() - 1));
		}
		
		
	}
}
