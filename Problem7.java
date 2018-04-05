import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


//input pertama adalah angka berapa banyak input
//kemudian dilanjutkan dengan input add dan find
public class Problem7 {
	public static void main(String[] args) throws IOException {

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Cus listCustomer = new Cus();
		int inputAmount = Integer.parseInt(read.readLine());
		
		for(int i = 0 ; i < inputAmount ; i++) {
			String[] input = read.readLine().split(" ");
			if(input[0].equalsIgnoreCase("add")) {
				listCustomer.addCustomer(input[1]);
			} else if (input[0].equalsIgnoreCase("find")){
				System.out.println(listCustomer.findCustomer(input[1]));
			}
		}
	}
}

class Cus {
	 ArrayList<String> listCustomer;
	
	public Cus() {
		this.listCustomer = new ArrayList<String>();
	}

	public ArrayList<String> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(ArrayList<String> listCustomer) {
		this.listCustomer = listCustomer;
	}
	
	public void addCustomer(String customer) {
		listCustomer.add(customer);
	}
	
	public int findCustomer(String prefix) {
		int lengthOfPrefix = prefix.length();
		int count = 0;
		for(int i = 0 ; i < listCustomer.size() ; i++) {
			if(listCustomer.get(i).length() >= lengthOfPrefix && listCustomer.get(i).substring(0, lengthOfPrefix).equalsIgnoreCase(prefix)) {
				count++;
			}
		}
		return count;
	}
}
