package DemoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Interview {

	// @Test
	public void ValidLogin() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Form Authentication")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		// driver.findElement(By.id("username")).clear();
		// driver.findElement(By.id("username")).sendKeys("tomsmith");
		// driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Boolean flag = driver.findElement(By.xpath("//div[@class='flash error']")).isDisplayed();
		Assert.assertTrue(flag);
		// Assert.assertEquals("Your username is invalid!", text);
		System.out.println(flag);
		driver.close();

	}

	// @Test

	public void DropDown() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Dropdown")).click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option 2");
		String text = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).getAttribute("selected");
		System.out.println(text);
	}

	@Test
	public void Tables() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		Thread.sleep(2000);
		String row = driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[3]/td[6]/a[1]")).getText();
		System.out.println(row);
		driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[3]/td[6]/a[1]")).click();
		String Actualtitle = driver.getCurrentUrl();
		String ExpectedTitle = "https://the-internet.herokuapp.com/tables#edit";
		Assert.assertEquals(Actualtitle, ExpectedTitle);

	}

}
