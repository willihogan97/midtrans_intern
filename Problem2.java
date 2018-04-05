import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


//input id,email,phone,card
//contoh 1,e1,p1,c1
public class Problem2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		ListCustomer ListCustomer = new ListCustomer();
		
		String perintah;
		while ((perintah = read.readLine()) != null) {
			String[] masukan = perintah.split(",");
			Transaction newTransaction = new Transaction(Integer.parseInt(masukan[0]), masukan[1], masukan[2], masukan[3]);
			ListCustomer.addCustomer(newTransaction);
			ListCustomer.printAll();
		}
	}
}

class ListCustomer {
	ArrayList<Customer> listAllCustomer;
	
	public ListCustomer(){
		listAllCustomer = new ArrayList<Customer>();
	}
	
	public void addCustomer(Transaction newTransaction){
		boolean isExist = false;
		for(int i = 0 ; i < listAllCustomer.size() ; i++) {
			int lengthEmail = listAllCustomer.get(i).emails.size();
			for(int j = 0 ; j < lengthEmail ; j ++) {
				System.out.println("test");
				if(newTransaction.email.equalsIgnoreCase(listAllCustomer.get(i).emails.get(j))) {
					listAllCustomer.get(i).transaction.add(newTransaction.id);
					listAllCustomer.get(i).phones.add(newTransaction.phone);
					listAllCustomer.get(i).cards.add(newTransaction.card);
					isExist = true;
				}
			}
			if(isExist) {
				break;
			}
			int lengthPhone = listAllCustomer.get(i).phones.size();
			for(int j = 0 ; j < lengthPhone ; j ++) {
				if(newTransaction.phone.equalsIgnoreCase((String) listAllCustomer.get(i).phones.get(j))) {
					listAllCustomer.get(i).transaction.add(newTransaction.id);
					listAllCustomer.get(i).emails.add(newTransaction.email);
					listAllCustomer.get(i).cards.add(newTransaction.card);
					isExist = true;
				}
			}
			if(isExist) {
				break;
			}
			int lengthCards = listAllCustomer.get(i).cards.size();
			for(int j = 0 ; j < lengthCards ; j ++) {
				if(newTransaction.card.equalsIgnoreCase((String) listAllCustomer.get(i).cards.get(j))) {
					listAllCustomer.get(i).transaction.add(newTransaction.id);
					listAllCustomer.get(i).getEmails().add(newTransaction.email);
					listAllCustomer.get(i).phones.add(newTransaction.phone);
					isExist = true;
				}
			}
			if(isExist) {
				break;
			}
		}
		if(!isExist) {
			Customer newCustomer = new Customer(newTransaction.id, newTransaction.email, newTransaction.phone, newTransaction.card);
			listAllCustomer.add(newCustomer);
		}
	}
	
	public void printAll() {
		for(int i = 0 ; i < listAllCustomer.size() ; i++) {
			System.out.println("Customer" + (i+1) + ":");
			System.out.print("  transactions: [");
			String output = "";
			for(int j = 0 ; j < listAllCustomer.get(i).transaction.size() ; j++) {
				output += listAllCustomer.get(i).transaction.get(j) + ",";
				
			}
			System.out.println(output.substring(0, output.length()-1) + "],");
			System.out.print("  emails: [");
			output = "";
			for(int j = 0 ; j < listAllCustomer.get(i).emails.size() ; j++) {
				output += listAllCustomer.get(i).emails.get(j) + ",";
			}
			System.out.println(output.substring(0, output.length()-1) + "],");
			System.out.print("  phones: [");
			output = "";
			for(int j = 0 ; j < listAllCustomer.get(i).phones.size() ; j++) {
				output += listAllCustomer.get(i).phones.get(j) + ",";
			}
			System.out.println(output.substring(0, output.length()-1) + "],");
			System.out.print("  cards: [");
			output = "";
			for(int j = 0 ; j < listAllCustomer.get(i).cards.size() ; j++) {
				output += listAllCustomer.get(i).cards.get(j) + ",";
			}
			System.out.println(output.substring(0, output.length()-1) + "]");
			
		}
	}
}

class Customer {
	ArrayList transaction;
	ArrayList<String> emails;
	ArrayList<String> phones;
	ArrayList<String> cards;
	
	public Customer(int id, String email, String phone, String card){
		transaction = new ArrayList<String>();
		transaction.add(id);
		emails = new ArrayList<String>();
		emails.add(email);
		phones = new ArrayList<String>();
		phones.add(phone);
		cards = new ArrayList<String>();
		cards.add(card);
	}
	
	public ArrayList getEmails() {
		return emails;
	}

	public void setEmails(ArrayList emails) {
		this.emails = emails;
	}

	public ArrayList getPhones() {
		return phones;
	}

	public void setPhones(ArrayList phones) {
		this.phones = phones;
	}

	public ArrayList getCards() {
		return cards;
	}

	public void setCards(ArrayList cards) {
		this.cards = cards;
	}

	public void setTransaction(ArrayList transaction) {
		this.transaction = transaction;
	}

	public ArrayList getTransaction() {
		return transaction;
	}
	
}

class Transaction {
	int id;
	String email;
	String phone;
	String card;
	
	public Transaction(int idInput, String emailInput, String phoneInput, String cardInput) {
		id = idInput;
		email = emailInput;
		phone = phoneInput;
		card = cardInput;
	}
}