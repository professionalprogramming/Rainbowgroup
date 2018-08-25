import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//this code review by kumaran there are no errors in this file
@SuppressWarnings("serial")
public class Member implements Serializable { //class name should be caps

	// name changes
	private String lastName; // LN to lastName
	private String firstName; // FN to firstName
	private String email; //EM to email
	private int phoneNumber; //PN to phoneNumber
	private int id; //ID to id
	private double fines; //FINES to fines
	
	private Map<Integer, Loan> loans; //class name loan to Loan and LNS to loans

	
	//change constructor from member to Member according to class name
	// change parameter phoneNo to phoneNumber
	public member(String lastName, String firstName, String email, int phoneNumber, int id) {
		this.lastName = lastName; //change LN to lastName
		this.firstName = firstName; //change firstName to firstName
		this.email = email; //change EM to email
		this.phoneNumber = phoneNumber; //change PN to phoneNumber
		this.id = id; //change ID to id
		
		this.loans = new HashMap<>(); //change LNS to loans
	}

	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder(); // object changed to sb to stringBuilder
		stringBuilder.append("Member:  ").append(id).append("\n") // reference changed from sb to stringBuilder and from ID to id
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n") //LN and FN changed to lastName and firstName respectively
		  .append("  Email: ").append(email).append("\n") //reference of EM to email
		  .append("  Phone: ").append(phoneNumber)//reference of PN to phoneNumber
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", fines)) //variable name change to FINES to fines
		  .append("\n");
		
		for (Loan loan : loans.values()) { //Class name and variable changed
			stringBuilder.append(loan).append("\n"); //update the StringBuilder  object
		}		  
		return stringBuilder.toString();//update the StringBuilder  object
	}

	
	public int getId() {
		return id;// changed from ID to id
	}

	// changed from LNS to loans
	// change Class loan to Loan
	public List<Loan> getLoans() {
		return new ArrayList<Loan>(loans.values());
	}

	
	public int getNumberOfCurrentLoans() {
		return loans.size();// changed from LNS to loans
	}

	
	public double getFinesOwed() {
		return fines;// changed from FINES to fines
	}

	
	public void takeOutLoan(Loan loan) {//change Class loan to Loan
		// changed from LNS to loans
		if (!loans.containsKey(loan.getId())) {
			loans.put(loan.getId(), loan);
		}
		else {
			throw new RuntimeException("Duplicate loan added to member");
		}		
	}

	
	public String getLastName() {
		return lastName;// changed from LN to lastName
	}

	
	public String getFirstName() {
		return firstName;// changed from FN to firstName
	}


	public void addFine(double fine) {
		fines += fine;// changed from FINES to fines
	}
	
	public double payFine(double amount) {
		if (amount < 0) {
			throw new RuntimeException("Member.payFine: amount must be positive");
		}
		double change = 0;
		if (amount > fines) {// changed from FINES to fines
			change = amount - fines;// changed from FINES to fines
			fines = 0;// changed from FINES to fines
		}
		else {
			fines -= amount;// changed from FINES to fines
		}
		return change;
	}


	public void dischargeLoan(loan loan) {
		if (LNS.containsKey(loan.getId())) {// changed from LNS to loans
			LNS.remove(loan.getId());
		}
		else {
			throw new RuntimeException("No such loan held by member");
		}		
	}
//Moderator	Vamakumaran
//Reviewer	Sanjeev
//Author	Rehman
}
