package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps {
	
	WebDriver driver=null;
	
	@Before
	public void openChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void closeChrome() {
		driver.quit();
	}
	
	@Given("user navigate home page")
	public void user_navigate_home_page() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	    
	}

	@When("^user enters (.*),(.*),(.*),(.*)and(.*)")
	public void user_enters_firstName_lastName_email_password_and_confirmPassword(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(confirmPassword); 
	}

	@And("click on register button")
	public void click_on_register_button() {
		driver.findElement(By.xpath("//button[@id=\"register-button\"]")).click();
	}

	@Then("the user will successfully register on the webpage")
	public void the_user_will_successfully_register_on_the_webpage() throws InterruptedException {
		Thread.sleep(9000);
		String sucess = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
		Assert.assertEquals(sucess, "Your registration completed");
		
	   
	}
	
	@Then("the user will unsuccessfully register on the webpage")
	public void the_user_will_unsuccessfully_register_on_the_webpage() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals("https://demo.nopcommerce.com/register?returnUrl=%2F", driver.getCurrentUrl());
		
	}
	
	



}
