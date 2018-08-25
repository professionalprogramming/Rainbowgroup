import java.util.Scanner;


public class FixBookUI {

	//Need revision UiState should be UI_STATE
	public static enum UiState { INITIALISED, READY, FIXING, COMPLETED };// Reaname enum UI_STATE to UiState.

	private FixBookControl control;
	private Scanner input;
	private UiState state;//Need revision UiState should be UI_STATE

	//this is review by kumaran there a no errors in this code any more
	public FixBookUI(FixBookControl control) { //Need revision method name should be fixBookUI
		this.control = control;
		input = new Scanner(System.in);
		state = UiState.INITIALISED;//Need revision UiState should be UI_STATE
		control.setUI(this);
	}


	public void setState(UiState state) {
		this.state = state;
	}

	
	public void run() {
		System.out.println("Fix Book Use Case UI\n"); //Change the Output to System.out.println
		
		while (true) {
			
			switch (state) {
			
			case READY:
				String bookStr = input("Scan Book (<enter> completes): ");
				if (bookStr.length() == 0) {
					control.scanningComplete();
				}
				else {
					try {
						int bookId = Integer.valueOf(bookStr).intValue();
						control.bookScanned(bookId);
					}
					catch (NumberFormatException e) {
						System.out.println("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String ans = input("Fix Book? (Y/N) : ");
				boolean fix = false;
				if (ans.toUpperCase().equals("Y")) {
					fix = true;
				}
				control.fixBook(fix);
				break;
								
			case COMPLETED:
				System.out.println("Fixing process complete");
				return;
			
			default:
				System.out.println("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state);			
			
			}		
		}
		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}
	

	public void display(Object object) {
		output(object);
	}
	
	
//Moderator	Zohaib
//Reviewer	Rehman
//Author	Sanjeev

}
