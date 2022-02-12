package assignment1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	static WebDriver driver;

	@Before
	public void lunchBrowser() {

		// step 1 Lunching Chrome browser
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void loginAndAddInfo() throws InterruptedException {

		// store elements by class & Locate web Element

		By usernameLocator = By.xpath("//*[@id=\"username\"]");
		By passwordLocator = By.xpath("//*[@id=\"password\"]");
		By signinLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");

		By customerMenuLocator = By.xpath("//span[(text()='Customers')]");
		By addCustomerMenuLocator = By.xpath("//a[contains(text(),'Add Customer')]");
		By listCustomersLocator = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a");

		By fullNameLocator = By.xpath("//*[@id=\"account\"]");
		By eamilLocator = By.xpath("//*[@id=\"email\"]");
		By phoneNumberLocator = By.xpath("//*[@id=\"phone\"]");
		By addressLocator = By.xpath("//*[@id=\"address\"]");
		By cityLocator = By.xpath("//*[@id=\"city\"]");
		By stateLocator = By.xpath("//*[@id=\"state\"]");
		By zipCodeLocator = By.xpath("//*[@id=\"zip\"]");
		By countryLocator = By.xpath("//*[@id=\"select2-country-container\"]");
		By saveButtonLocator = By.xpath("//*[@id=\"submit\"]");

		// Step 2 Login to the website with the provided Username and Password
		driver.findElement(usernameLocator).sendKeys("demo@techfios.com");
		driver.findElement(passwordLocator).sendKeys("abc123");
		driver.findElement(signinLocator).click();

		// click on the Customer menu and chose from the drop down add customer
		driver.findElement(customerMenuLocator).click();
		driver.findElement(addCustomerMenuLocator).click();

		// here we select the company from the drop down menu

		Select sel = new Select(driver.findElement(By.xpath("//*[@id='cid']")));
		sel.selectByVisibleText("Google");

		// filling up the Rest of the page

		driver.findElement(fullNameLocator).sendKeys("Mustafa Muhana abdul");
		driver.findElement(eamilLocator).sendKeys("test2@mustafamuhana.com");
		driver.findElement(phoneNumberLocator).sendKeys("407-461-0001");
		driver.findElement(addressLocator).sendKeys("1234 lake spring rd");
		driver.findElement(cityLocator).sendKeys("San Antonio");
		driver.findElement(stateLocator).sendKeys("TX");
		driver.findElement(zipCodeLocator).sendKeys("78250");
		// how to select the country from the dropdown

		//Select sel2 = new Select(driver.findElement(By.xpath("//span[text()='United States')]")));
		//sel2.selectByVisibleText("United States");
		
		
		driver.findElement(saveButtonLocator).click();
		driver.findElement(listCustomersLocator).click();
		
		
		
	}

	@after
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
