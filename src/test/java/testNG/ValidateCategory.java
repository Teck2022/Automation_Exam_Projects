package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateCategory {

	WebDriver driver;

	@BeforeMethod
	public void initDriver() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://techfios.com/test/102/");
//		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test
	public void test1() throws InterruptedException {

//		Adding (Sept22QATest) on the add category
		driver.findElement(By.name("categorydata")).sendKeys("Sept22QATest");
		Thread.sleep(4000);

//		Selecting the color
		WebElement w = driver.findElement(By.xpath("//*[@id=\"extra\"]/select[5]"));
		Select dropDown = new Select(w);
		dropDown.selectByIndex(1);

		Thread.sleep(4000);

//		Clicking the button to add the category
		driver.findElement(By.xpath("//*[@id=\"extra\"]/input[2]")).click();
		Thread.sleep(4000);

	}

	@Test
	public void test2() {
	
		By TextBar = By.xpath("//*[@id=\"extra\"]/input[1]");
		By ColorDropDown = By.xpath("//*[@id=\"extra\"]/select[5]");
		By AddBar = By.xpath("//*[@id=\"extra\"]/input[2]");
	
		driver.findElement(TextBar).sendKeys("Sept22QATest");
		Select sel = new Select(driver.findElement(ColorDropDown));
		sel.selectByVisibleText("Green");
		driver.findElement(AddBar).click();
		
		Assert.assertEquals(AddBar, "The category you want to add already exists:");

	}

	@Test
	public void test3() {

//		Validate the drop down has all the months
		Select DropDownList = new Select(driver.findElement(By.name("due_month")));
		DropDownList.getOptions();

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
//		driver.quit();
	}

}
