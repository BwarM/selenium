
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.RETURN;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class idetest {

	static WebDriver driver;

	@BeforeClass
	public static void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.soastastore.com/");


	}

	@Test
	public void number1(){   
		driver.findElement(By.linkText("Store")).click();
		driver.findElement(By.id("product_112_submit_button")).click();
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.cssSelector("form.adjustform.qty > input[name=\"quantity\"]")).clear();
		driver.findElement(By.cssSelector("form.adjustform.qty > input[name=\"quantity\"]")).sendKeys("4");
		driver.findElement(By.name("submit")).click();
	}
}
