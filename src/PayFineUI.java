package com.stb.tih.batch.writer;
// File is review by Zohaib Badarpura and There are no errors in this file.
// this file moderator by sai

import java.util.Scanner;


public class PayFineUI {

//this file Review by sanjeevan there are no issues.
	public static enum UI_STATE { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };

	private PayFineControl control; //  This class not defined
	private Scanner input;
	private UI_STATE state;

	
	public PayFineUI(PayFineControl control) {
		this.control = control;
		input = new Scanner(System.in);
		state = UI_STATE.INITIALISED;
		control.setUI(this);
	}
	
	
	public void setState(UI_STATE state) {
		this.state = state;
	}


	public void run() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (state) {
			
			case READY:
				String memStr = input("Swipe member card (press <enter> to cancel): ");
				if (memStr.length() == 0) {
					control.cancel();
					break;
				}
				try {
					int memberId = Integer.valueOf(memStr).intValue();
					control.cardSwiped(memberId);
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double amount = 0;
				String amtStr = input("Enter amount (<Enter> cancels) : ");
				if (amtStr.length() == 0) {
					control.cancel();
					break;
				}
				try {
					amount = Double.valueOf(amtStr).doubleValue();
				}
				catch (NumberFormatException e) {} // Inside Catch must give valid output
				if (amount <= 0) {
					output("Amount must be positive");
					break;
				}
				control.payFine(amount);
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state);			
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
	//Rathar tha using Object we can use String as method parameter	
	private void output(Object object) {
		System.out.println(object);
	}	
			
        //Could have one public method to print
	public void display(Object object) {
		output(object);
	}


}
