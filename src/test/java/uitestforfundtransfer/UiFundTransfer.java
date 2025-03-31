package uitestforfundtransfer;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import java.time.Duration;

	public class UiFundTransfer {
	    WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://banking-app.com"); // Replace with actual banking URL
	    }

	    @Test(priority = 1)
	    public void loginToBank() {
	        driver.findElement(By.id("username")).sendKeys("testUser");
	        driver.findElement(By.id("password")).sendKeys("testPass123");
	        driver.findElement(By.id("loginBtn")).click();

	        WebElement dashboard = driver.findElement(By.id("dashboard"));
	        Assert.assertTrue(dashboard.isDisplayed(), "Login Failed!");
	    }

	    @Test(priority = 2)
	    public void transferFunds() {
	        driver.findElement(By.id("fundTransfer")).click();
	        driver.findElement(By.id("beneficiary")).sendKeys("John Doe");
	        driver.findElement(By.id("accountNumber")).sendKeys("123456789");
	        driver.findElement(By.id("amount")).sendKeys("500");
	        driver.findElement(By.id("transferBtn")).click();

	        WebElement successMsg = driver.findElement(By.id("successMessage"));
	        Assert.assertTrue(successMsg.isDisplayed(), "Transfer Failed!");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}


