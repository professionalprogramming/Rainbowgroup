import java.util.Date;
import java.util.concurrent.TimeUnit;
//this file Review by sanjeevan there are no issues.
// File is review by Zohaib Badarpura and There are no errors in this file.
// File is moderator by sai and no conflicts found.
public class HelloWorld{

     public static void main(String []args){
	
	class Calendar { // class defintion with default 
         Calendar self; // varaible define with default
		 java.util.Calendar cal;
	
	
	private Calendar() { // non  static method 
		cal = java.util.Calendar.getInstance();
	}
	
	public  Calendar getInstance() { // non static method
		if (self == null) {
			self = new Calendar();
		}
		return self;
	}
	
	public void incrementDate(int days) { // method with no return 
		cal.add(java.util.Calendar.DATE, days);		
	}
	
	public synchronized void setDate(Date date) {
		try {
			cal.setTime(date);
	        cal.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cal.set(java.util.Calendar.MINUTE, 0);  
	        cal.set(java.util.Calendar.SECOND, 0);  
	        cal.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public synchronized Date Date() {
		try {
	        cal.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cal.set(java.util.Calendar.MINUTE, 0);  
	        cal.set(java.util.Calendar.SECOND, 0);  
	        cal.set(java.util.Calendar.MILLISECOND, 0);
			return cal.getTime();
		}
		catch (Exception e) { // execption handling 
			throw new RuntimeException(e);
		}	
	}

	public synchronized Date getDueDate(int loanPeriod) { // method with return the date 
		Date now = Date();
		cal.add(java.util.Calendar.DATE, loanPeriod);
		Date dueDate = cal.getTime();
		cal.setTime(now);
		return dueDate;
	}
	
	public synchronized long getDaysDifference(Date targetDate) { // method with the return a number 
		long diffMillis = Date().getTime() - targetDate.getTime();
	    long diffDays = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
	    return diffDays;
	}

}
