package scripts;

import org.testng.annotations.Test;

import generic.Generic;

public class LogOut extends Generic{
	
	@Test
	public void test() {
		// Side menu
		elements.getHamburgerMenu().click();   // Hamburger menu on the home screen
		elements.getAboutWorldWinnersSidemenu().click(); // Side menu
		elements.getLogoutAboutWorldWinners().click();  // logout button on the About WorldWinners
		elements.getlogoutOnPopUp().click();  // logout on the logout pop-up
	}
}
