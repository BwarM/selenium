
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

public class playGround {

	static WebDriver driver;

	@BeforeClass
	public static void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://timvroom.com/selenium/playground/");


	}

	@Test
	public void number1(){
		String input1 = driver.getTitle();
		driver.findElement(By.id("answer1")).sendKeys(input1);
		driver.findElement(By.id("name")).sendKeys("Kilgore Trout");
		driver.findElement(By.name("occupation")).sendKeys("Science Fiction Author");
		List<WebElement> antal = driver.findElements(By.className("bluebox"));
		driver.findElement(By.id("answer4")).sendKeys(Integer.toString(antal.size()));
		driver.findElement(By.linkText("click me")).click();
		String txt = driver.findElement(By.id("redbox")).getAttribute("class");
		driver.findElement(By.id("answer6")).sendKeys(txt);	
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("ran_this_js_function()");
		Long uppgift8=(Long) executor.executeScript("return got_return_from_js_function()");
		driver.findElement(By.id("answer8")).sendKeys(Long.toString(uppgift8));
		driver.findElement(By.name("wrotebook")).click();
		String text10 = driver.findElement(By.id("redbox")).getText();
		driver.findElement(By.id("answer10")).sendKeys(text10);
		Point locationOrange = driver.findElement(By.id("orangebox")).getLocation();
		Point locationgreen = driver.findElement(By.id("greenbox")).getLocation();
		
		if(locationOrange.y>locationgreen.y){
			driver.findElement(By.id("answer11")).sendKeys("green");
		} else {
			driver.findElement(By.id("answer11")).sendKeys("orange");
		}
		
		Dimension d = new Dimension(850,650);
		driver.manage().window().setSize(d);
		
		List<WebElement> elementsHere = driver.findElements(By.id("ishere"));
		if (elementsHere.size()==0){
			driver.findElement(By.id("answer13")).sendKeys("no");
		} else {
			driver.findElement(By.id("answer13")).sendKeys("yes");
		}
		
		Boolean isElementVisble = driver.findElement(By.id("purplebox")).isDisplayed();
		if (isElementVisble){
			driver.findElement(By.id("answer14")).sendKeys("yes");
		} else {
			driver.findElement(By.id("answer14")).sendKeys("no");
		}
		
		driver.findElement(By.linkText("click then wait")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("click after wait")));
		wait.pollingEvery(5, TimeUnit.MILLISECONDS);
		driver.findElement(By.linkText("click after wait")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("submitbutton")).click();
	}
}
