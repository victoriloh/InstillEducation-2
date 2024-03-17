package login;

import base.BaseTests;
import base.UtilityTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginTests extends BaseTests{


	LoginPage loginPage = new LoginPage();

	@Test
	public void testCustomerLogin() throws FileNotFoundException, IOException, ParseException {
		UtilityTests.testTitle("Login as a customer");
		loginPage.clickCustomerLoginButton();
		loginPage.selectUserName();
		loginPage.clickUserLoginButton();
	}
	

}

