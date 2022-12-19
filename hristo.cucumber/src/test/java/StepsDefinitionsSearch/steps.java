package StepsDefinitionsSearch;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
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
	
	@Given("User navigate home page")
	public void User_navigate_home_page() {
		driver.get("https://demo.nopcommerce.com/");
	    
	}

	@When("^User search for (.*)")
	public void User_search_for(String item) {
		
		driver.findElement(By.id("small-searchterms")).sendKeys(item);
			
		
	}

	@And("Click on search button")
	public void Click_on_search_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("verify the successfuly of the search")
	public void verify_the_successfuly_of_the_search() throws InterruptedException {
		Thread.sleep(5000);
		String ActualMessage = driver.findElement(By.xpath("//h2[@class='product-title']//child::a")).getText();
		String ExpectedText = "Adobe Photoshop CS4";
		Assert.assertEquals(ActualMessage,ExpectedText);
		}
	
	@Then("verify the unsuccessful of the search")
	public void verify_the_unsuccessful_of_the_search() throws InterruptedException {
		Thread.sleep(5000);
		String ActualMessage = driver.findElement(By.xpath("//div[@class='no-result']")).getText();
		String ExpectedText = "No products were found that matched your criteria.";
		Assert.assertEquals(ActualMessage,ExpectedText);
				
	}
	@Then("verify the successful of the search")
	public void verify_the_successful_of_the_search() throws InterruptedException {
		Thread.sleep(5000);
		String ActualMessage = driver.findElement(By.xpath("//h2[@class='product-title']//child::a")).getText();
		String ExpectedText = "Levi's 511 Jeans";
		Assert.assertEquals(ActualMessage,ExpectedText);
		}
}
