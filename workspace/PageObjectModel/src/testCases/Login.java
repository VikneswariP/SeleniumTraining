package testCases;



import org.junit.Assert;
import org.junit.Test;

import pageClasses.LoginPage;



public class Login {
	
	LoginPage loginpage = new LoginPage();
	
	/*@Test
	public void correctLogin() {
		loginpage.setTextUsername("Vikneswari");
		loginpage.setTextPassword("vikneswari");
		loginpage.setBtnlogin();
	}
	*/
	@Test
	public void inCorrectLogin() {
		loginpage.setTextUsername("Vikneswari");
		loginpage.setTextPassword("vik");
		loginpage.setBtnlogin();
		//loginpage.getTextInvalidLogin();
		
		Assert.assertEquals("Invalid Login Details", loginpage.getTextInvalidLogin());
		System.out.println(loginpage.getTextInvalidLogin());
		
	}
	
	@Test
	public void BookingHotel() {
		
	}

	@Test
	public void Logout() {
		
	}
}
