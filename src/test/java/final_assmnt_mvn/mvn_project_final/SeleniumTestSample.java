package final_assmnt_mvn.mvn_project_final;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SeleniumTestSample {
	private WebDriver driver;
    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    }
    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        // Wait for search results to load
        try {
            Thread.sleep(2000); // Wait for 2 seconds (for demonstration purposes)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the page title contains the search query
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Selenium"), "Search results page title does not contain 'Selenium'");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
