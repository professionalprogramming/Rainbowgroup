import java.util.Scanner;


public class ReturnBookUI {
//this code review by kumaran there are no errors in this file
	public static enum UiState { INITIALISED, READY, INSPECTING, COMPLETED };//UI_STATE renamed to UiState

	private ReturnBookControl control;
	private Scanner input;
	private UiState state; //UI_STATE renamed to UiState

	
	public ReturnBookUI(ReturnBookControl control) {
		this.control = control;
		Scanner input = new Scanner(System.in); //change the input to Scanner input
		
		state = UiState.INITIALISED; //UI_STATE renamed to UiState
		control.setUI(this);
	}
 

	public void run() {		
		System.out.print("Return Book Use Case UI\n"); //output rename to system.out.print
		
		while (true) {
			
			switch (state) {
			
			case INITIALISED:
				break;
				
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
						System.out.print("Invalid bookId"); //output rename to system.out.print
						
					}					
				}
				break;				
				
			case INSPECTING:
				String ans = input("Is book damaged? (Y/N): ");
				boolean isDamaged = false;
				if (ans.toUpperCase().equals("Y")) {					
					isDamaged = true;
				}
				control.dischargeLoan(isDamaged);
			
			case COMPLETED:
				System.out.print("Return processing complete"); //output rename to system.out.print
				
				return;
			
			default:
				System.out.print("Unhandled state"); //output rename to system.out.print
				
				throw new RuntimeException("ReturnBookUI : unhandled state :" + state);			
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
	
	public void setState(UiState state) //UI_STATE renamed to UiState 
	{
		this.state = state;
	}

	
}
