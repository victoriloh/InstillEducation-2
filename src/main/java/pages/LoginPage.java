package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.BaseTests.driver;

public class LoginPage {

	 By customerLoginButton = By.cssSelector("button[ng-click='customer()']");
	 By userSelect = By.id("userSelect");
	 By userLoginButton = By.cssSelector("button[type='submit']");



	public void clickCustomerLoginButton() {
	    driver.findElement(customerLoginButton).click();
	}

	public  void selectUserName() {

		Select select = new Select(driver.findElement(userSelect));
		select.selectByValue("1");
	}

	public void clickUserLoginButton() {
		 driver.findElement(userLoginButton).click();

	}


	
}
