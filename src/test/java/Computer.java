//import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

//import org.junit.Test;


public class Computer {

    public static WebDriver driver;

    @Test // (priority=1)
    public void AddNewComputer () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Tools\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://computer-database.gatling.io/computers");
        // <!-- Add new computer -->
        driver.findElement(By.xpath("//a[@id='add']")).click();
        Thread.sleep(1000);
        // <!- Fill the lines -->
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Acer Aspire F15");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("2010-09-21");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("2020-09-21");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='company']")).sendKeys( "Hewlett-Packard");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='btn primary']")).click();
        Thread.sleep(1000);

        //<!- Done ! Computer Acer F15 has been created -->
    }

    @Test // (priority=2)
    public void CheckComputer () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Tools\\chromedriver\\chromedriver.exe");
        // <!- Searcjing the computer>
        driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("Acer Aspire F15");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
        //<!- Check if computer is present>
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]")).getText().contains("Acer Aspire F15"));
        //<!- If the statement will be false Test fails>
    }
}
