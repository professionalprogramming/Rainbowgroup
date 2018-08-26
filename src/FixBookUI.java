import java.util.Scanner;

// Moderator of this file is Zohaib Badarpura

public class FixBookUI {


	public static enum UI_STATE { INITIALISED, READY, FIXING, COMPLETED };

	
	public static enum UiState { INITIALISED, READY, FIXING, COMPLETED };


	private FixBookControl control;
	private Scanner input;
	private UI_STATE state;

	
	public FixBookUI(FixBookControl control) { 
		this.control = control;
		input = new Scanner(System.in);

		state = UI_STATE.INITIALISED;
		control.UI_STATE(this);

		state = UI_STATE.INITIALISED;
		control.setUI(this);

	}


	public void setState(UI_STATE state) {
		this.state = state;
	}

	
	public void run() {
		System.out.println("Fix Book Use Case UI\n"); 
		
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
		System.out.println(prompt);//change to println
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
