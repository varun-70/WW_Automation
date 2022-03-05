package scripts;

import org.testng.annotations.Test;

import generic.Generic;

public class TicketWalletGestures extends Generic{
	
	@Test
	public void ticketWalletGestures() throws InterruptedException {
		
		// Ticket vertical swiping and tap
		function.swipingLocation(2, 2, 6, 3);
		Thread.sleep(1000);
		function.swipingLocation(2, 2, 3, 6);
		
		Thread.sleep(1000);
		function.tapByLocation(3, 9);
		Thread.sleep(3000);
		function.swipingLocation(3, 0, 3, 3);
		Thread.sleep(1000);
		function.tapByLocation(3, 5);
		
	}
}
