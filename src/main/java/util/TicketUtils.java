package util;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import pages.ConfirmScreenPage;
import pages.PlayWorldWinnersPage;

public class TicketUtils {
	
	AndroidDriver<WebElement> driver;
	static HashMap<String, ArrayList<Integer>> listOfTicketNo;
	static boolean ticketNumbers = false;
	
	public TicketUtils(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	/**
	 * addTicket is used to add the ticket and store the values of ticket numbers
	 * 
	 * @param n is the number of tickets to add
	 * @throws InterruptedException 
	 */
	public void addTicket(int n) throws InterruptedException {
		PlayWorldWinnersPage ticket = new PlayWorldWinnersPage(driver);
		int noOfTickets = Integer.parseInt(ticket.getNoOfTicketAdded().getText()); 
		System.out.println(noOfTickets);
		
		listOfTicketNo = new HashMap<>();
		String alphabeticalOrder;
		char loop = 'A';
		char loop1 = 'A';
		int j = 0;
		
		for(int i=0; i<n; i++) {
			int currentTickets = Integer.parseInt(ticket.getNoOfTicketAdded().getText()); 
			
			while(currentTickets!=i+noOfTickets || noOfTickets==0 && currentTickets==0) {
				currentTickets = Integer.parseInt(ticket.getNoOfTicketAdded().getText()); 
				Thread.sleep(500);
			}

			if(j>=26) {
				loop = 'A';
				alphabeticalOrder = ("" + loop+loop1);
				loop1++;
				j++;
			}
			else {
				alphabeticalOrder = Character.toString(loop);
				j++;
			}
			
			if(currentTickets==1) {
				listOfTicketNo.put(alphabeticalOrder, new ArrayList<Integer>());
				int[] arr4= getTicketNumbers();
				for(int k : arr4) {
					listOfTicketNo.get(alphabeticalOrder).add(k);
				}
				loop++;
			}
			
			ticket.getPlusButton().click();
			
			while(currentTickets==i+1+noOfTickets || noOfTickets==0 && currentTickets==0) {
				currentTickets = Integer.parseInt(ticket.getNoOfTicketAdded().getText()); 
				Thread.sleep(500);
			}

			alphabeticalOrder = Character.toString(loop);
			listOfTicketNo.put(alphabeticalOrder, new ArrayList<Integer>());
			int[] arr4= getTicketNumbers();
			for(int k : arr4) {
				listOfTicketNo.get(alphabeticalOrder).add(k);
			}
			loop++;
			
		}

		ticketNumbers = true;
		System.out.println(listOfTicketNo);
	}
	
	/**
	 * deleteTicket is used to add the ticket and store the values of ticket numbers
	 * @param n is the number of tickets to delete
	 * @throws InterruptedException 
	 */
	public void deleteTicket(int n) throws InterruptedException {
		PlayWorldWinnersPage ticket = new PlayWorldWinnersPage(driver);
		int noOfTickets = Integer.parseInt(ticket.getNoOfTicketAdded().getText());
		
		for(int i=0; i<n; i++) {
			int currentTickets = Integer.parseInt(ticket.getNoOfTicketAdded().getText()); 
			
			while(currentTickets+i!=noOfTickets || noOfTickets==0 && currentTickets==0) {
				currentTickets = Integer.parseInt(ticket.getNoOfTicketAdded().getText()); 
				Thread.sleep(500);
			}
			
			if(listOfTicketNo!=null) {
				listOfTicketNo.remove(getKey(currentTickets));
			}
					
			ticket.getDeleteButton().click();
		}
		System.out.println(listOfTicketNo);
	}
	
	/**
	 * To get the key in string for Alphabetical order
	 * @param alphabetsNumber is the Alphabet in number
	 * @return
	 */
	public String getKey(int alphabetsNumber) {
		char loop = 'A';
		char loop1 = 'A';
		int j=0;
		String alphabeticalOrder="";
		
		for(int i=0; i<alphabetsNumber; i++) {
			if(j>=26) {
				loop = 'A';
				alphabeticalOrder = ("" + loop+loop1);
				loop1++;
				j++;
			}
			else {
				alphabeticalOrder = Character.toString(loop);
				loop++;
				j++;
			}
		}
		
		return alphabeticalOrder;
	}
	
	/**
	 * To get the alphabet number by in int
	 * @param alphabetsNumber is the Alphabet in number
	 * @return
	 */
	public int getAplhabetNumber(String alphabet) {
		char loop = 'A';
		char loop1 = 'A';
		int j=0;
		String alphabeticalOrder="";
		
		for(int i=0; i<=50; i++) {
			if(j>=26) {
				loop = 'A';
				alphabeticalOrder = ("" + loop+loop1);
				loop1++;
				j++;
			}
			else {
				alphabeticalOrder = Character.toString(loop);
				loop++;
				j++;
			}
			if(alphabet==Character.toString(loop)) {
				break;
			}
		}
		
		return j+1;
	}
	
	/**
	 * Gets the no. element text, click on "Continue with n Button" element dynamically
	 * 
	 * @return the continueWithnButton Web Element
	 * POM (Page Object Model) should have static data and doesn't support dynamic data in the element.
	 * @throws InterruptedException 
	 */
	public WebElement getContinueWithnButton() throws InterruptedException {
		PlayWorldWinnersPage tickets = new PlayWorldWinnersPage(driver);
		Thread.sleep(2000);
		String ticketsAdded=tickets.getNoOfTicketAdded().getText();
		System.out.println(ticketsAdded);
		WebElement continueWithnButton;
		if(ticketsAdded.equals(1)) {
			continueWithnButton=driver.findElementByXPath("//android.widget.TextView[@text='Continue with "+ticketsAdded+" Ticket']");
			Reporter.log("Continue with "+ticketsAdded+" ticket", true);
		}
		else {
			continueWithnButton=driver.findElementByXPath("//android.widget.TextView[@text='Continue with "+ticketsAdded+" Tickets']");
			Reporter.log("Continue with "+ticketsAdded+" tickets", true);
		}
		return continueWithnButton;
	}
	
	/**
	 * To get the ticket numbers or the last visible ticket
	 * 
	 * Takes all the text within scrollable area of the tickets and removes the characters other than the ticket numbers 
	 * and converts the ticket numbers from String[] to the int[]
	 * 
	 * @return ticketNumbers returns the ticket numbers
	 * @throws InterruptedException 
	 */
	public int[] getTicketNumbers() throws InterruptedException {
		PlayWorldWinnersPage tickets = new PlayWorldWinnersPage(driver);
		Thread.sleep(500);
		int size=tickets.getTicketNo().size();
		String allText = "";
		for(int i=0; i<size; i++) {
			allText = allText + tickets.getTicketNo().get(i).getText() + " ";
		}
		System.out.println(allText);
		String[] seperateText = allText.split(" ");
		
		String[] ticketNumberInString = new String[7];
		int j = 0;
		for(int i=seperateText.length-8; i<seperateText.length-1; i++){
			ticketNumberInString[j]=seperateText[i];
			j++;
		}
		
		int[] ticketNumbers = new int[ticketNumberInString.length];
		for(int i=0; i<ticketNumberInString.length; i++){
			ticketNumbers[i] = Integer.valueOf(ticketNumberInString[i]);
		}
		
		return ticketNumbers;
	}
	
	/**
	 * Used to verify the ticket numbers on the confirm or successful screen for both Regular and AutoPlay flow
	 * 
	 * @param noOfTickets
	 */
	public void verifyTicketNo(int noOfTickets) {
		PlayWorldWinnersPage ticket = new PlayWorldWinnersPage(driver);
		ConfirmScreenPage confirm = new ConfirmScreenPage(driver);
		ScrollUtils scroll = new ScrollUtils(driver);
		SwipeUtils swipe = new SwipeUtils(driver);
		
		HashMap<String, ArrayList<Integer>> confirmTicketNo = new HashMap<>();
		char loop = 'A';
		char loop1 = 'A';
		String alphabeticalOrder;
		int num=0;
		int num2 = 0;
		int num3 = 0;
		Boolean scrolled = false;
		int tickets = Integer.parseInt(confirm.getTickets().getText());
		
		
		while(num>=0) {
			int size=confirm.getTicketsScrollable().size();
			if(size>40) {
				size = size-8;
			}
			String allText = "";
			int num1 = 0;
			
			if(num3>0) {
				try {
					swipe.swipeByElementToElement(confirm.getTicketsScrollable().get(35), confirm.getTicketsScrollable().get(3));
					scrolled = true;
				}
				catch(Exception e) {
					break;
				}
			}
			
			for(int i=0; i<size; i++) {
				allText = allText + ticket.getTicketNo().get(i).getText() + " ";
			}
			
			if(scrolled) {
				allText = allText.substring(allText.indexOf("" + loop) + 1);
				allText.trim();
			}
			
			String[] arr = allText.split(" ");
			String[] arr1 = new String[arr.length];
			
			for(int j=0; j<arr.length; j++){
				arr1[j]=arr[j];
			}
			
			//arr2 is ticket numbers in int
			int[]arr2 = new int[arr1.length];
			for(int k=0; k<arr1.length; k++) {
				try{
					arr2[num2]=Integer.valueOf(arr1[k]);
					num2++;
				}
				catch(Exception e) {
					
				}
			}
			
			System.out.println(arr2.length);
			
			for(int l=0; l<arr2.length/7; l++) {
				if(num>=26) {
					loop = 'A';
					alphabeticalOrder = ("" + loop+loop1);
					loop1++;
				}
			
				else {
					alphabeticalOrder = Character.toString(loop);
					loop++;
				}

				confirmTicketNo.put(alphabeticalOrder, new ArrayList<Integer>());
				for(int m=0; m<7; m++) {
					confirmTicketNo.get(alphabeticalOrder).add(arr2[num1]);
					num1++;
				}

				System.out.println(confirmTicketNo);
			}
			num3++;
			
			if(tickets==getAplhabetNumber(Character.toString(loop))) {
				break;
			}
		}

		char loop2 = 'A';
		char loop3 = 'A';
		for(int i=0; i<listOfTicketNo.size(); i++) {
			if(i>=26) {
				loop2 = 'A';
				alphabeticalOrder = ("" + loop2+loop3);
				loop3++;
			}
		
			else {
				alphabeticalOrder = Character.toString(loop2);
				loop2++;
			}
			
			if(listOfTicketNo.get(alphabeticalOrder).equals(confirmTicketNo.get(alphabeticalOrder)) == true) {
				System.out.println(listOfTicketNo.get(alphabeticalOrder) + "==" + confirmTicketNo.get(alphabeticalOrder));
				System.out.println(alphabeticalOrder + "- matching");	
			}
			
			else {
				System.out.println(listOfTicketNo.get(alphabeticalOrder) + "==" + confirmTicketNo.get(alphabeticalOrder));
				System.out.println(alphabeticalOrder + "- Not matching");
			}
		}
		
	}
	

}
