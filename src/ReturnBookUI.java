import java.util.Scanner;
// Moderator of this file is Zohaib Badarpura


public class ReturnBookUI {

	//Remove duplication of code

	public static enum UiState { INITIALISED, READY, INSPECTING, COMPLETED };

	private ReturnBookControl control;
	private Scanner input;
	//Need revision -  UiState to UI_STATE
	private UiState state; // UI_STATE renamed to UiState 


	public static enum UiState  (INITIALISED, READY, INSPECTING, COMPLETED) ; //Reaname UT_STAE to UiState and change the { to (

	private ReturnBookControl control;
	private static Scanner scanner = new Scanner( System.in ); // change the scanner input.
	private UiState state; // Reaname UT_STAE to UiState

	public static enum UiState { INITIALISED, READY, INSPECTING, COMPLETED };//UI_STATE renamed to UiState

	private ReturnBookControl control;
	private Scanner input;
	private UiState state; //UI_STATE renamed to UiState



	
	public ReturnBookUI(ReturnBookControl control)
	{ 							// Change the place {
		this.control = control;

		input = new Scanner(System.in);
		state = UiState.INITIALISED;


		Scanner scanner = new Scanner( System.in ); // Change the scanner input..
		
		//need review - UiState to UI_State
		state = UiState.INITIALISED;                // Reaname UT_STAE to UiState
		Scanner input = new Scanner(System.in); //change the input to Scanner input
		

		state = UiState.INITIALISED; 

		//need review - UiState to UI_State
		state = UiState.INITIALISED; //UI_STATE renamed to UiState
 

		control.setUI(this);
	}
 


	public void run() {		
		System.out.print("Return Book Use Case UI\n"); //output rename to system.out.print

		
		while (true) 
		{
			
			switch (state) 
			{
			
			case INITIALISED:
			break;
				
			case READY:
				String bookStr = input("Scan Book (<enter> completes): ");
				if (bookStr.length() == 0) 
				{
					control.scanningComplete();
				}
				else {
					try 
					{
						int bookId = Integer.valueOf(bookStr).intValue();
						control.bookScanned(bookId);
					}

					catch (NumberFormatException e) 
					{
						System.out.println("Invalid bookId"); // Change the output to  System.out.println.

					catch (NumberFormatException e) {

						System.out.print("Invalid bookId"); //output rename to system.out.print
						

					}					
				}
				break;				
				
			case INSPECTING:
				String ans = input("Is book damaged? (Y/N): ");
				boolean isDamaged = false;
				if (ans.toUpperCase().equals("Y")) 
				{					
					isDamaged = true;
				}
				control.dischargeLoan(isDamaged);
			
			case COMPLETED:

				System.out.println("Return processing complete"); // Change the output to  System.out.println.
				return;
			
			default:
			System.out.println("Unhandled state");

				System.out.print("Return processing complete"); //output rename to system.out.print
				
				return;
			
			default:
				System.out.print("Unhandled state"); //output rename to system.out.print
				

				throw new RuntimeException("ReturnBookUI : unhandled state :" + state);			
			}
		}
	}

	
	private String input(String prompt)
	{
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) 
	{
		System.out.println(object);
	}
	
			
	public void display(Object object) 
	{
		output(object);
	}
	

	public void setState(UiState state) {


		//need review - UiState to UI_State
	public void setState(UiState state) // Reaname UT_STAE to UiState

		//need review - UiState to UI_State
	public void setState(UiState state) //UI_STATE renamed to UiState 

	{
		this.state = state;
	}
//Moderator	Zohaib
//Reviewer	Rehman
//Author	Sanjeev
	
}
