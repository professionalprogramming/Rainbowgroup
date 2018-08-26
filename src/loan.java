import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

// File is review by Zohaib Badarpura and There are 4 errors in this file. Details are on wiki
// file is moderator by sai

@SuppressWarnings("serial")
public class Loan implements Serializable {
	// Class name Starting with capital letter is conventional
	
	
	public static enum LOAN_STATE { CURRENT, OVER_DUE, DISCHARGED };
	
	private int ID;

	private book b;// Class name Starting with capital letter and varibale name in starting with small letter is good for programming conventionall
	
	private member ;// Class name Starting with capital letter and varibale name in starting with small letter is good for programming conventionall
	
	private Date D;

	private book B;
	private member M;

	private LOAN_STATE state;

	
	public loan(int loanId, book book, member member, Date dueDate) {
		this.ID = loanId;
		this.B = book;
		this.M = member;
		this.D = dueDate;
		this.state = LOAN_STATE.CURRENT;
	}

	
	public void checkOverDue() {
		if (state == LOAN_STATE.CURRENT &&
			Calendar.getInstance().Date().after(D)) {
			this.state = LOAN_STATE.OVER_DUE;			
		}
	}

	
	public boolean isOverDue() {
		return state == LOAN_STATE.OVER_DUE;
	}

	
	public Integer getId() {
		return ID;
	}


	public Date getDueDate() {
		return D;
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		//Surround this code with try catch clause because ParseException can be thrown

		


		StringBuilder sb = new StringBuilder();
		sb.append("Loan:  ").append(ID).append("\n")
		  .append("  Borrower ").append(M.getId()).append(" : ")
		  .append(M.getLastName()).append(", ").append(M.getFirstName()).append("\n")
		  .append("  Book ").append(B.ID()).append(" : " )
		  .append(B.Title()).append("\n")
		  .append("  DueDate: ").append(sdf.format(D)).append("\n")
		  .append("  State: ").append(state);		
		return sb.toString();
	}


	public member member() {// Method name Starting with small letters is goof for programming convention
		return M;
	
	}



	public book book() { // Method name Starting with small letters is goof for programming convention

	
	public book Book() {

		return B;
	}


	public void Loan() {
		state = LOAN_STATE.DISCHARGED;		
	}

}
