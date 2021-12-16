package gmt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://difc.globaltradingnetwork.com/web/login");
        driver.manage().window().maximize();
        Thread.sleep(7000);
    }

    @Test
    public void emptyFields() throws InterruptedException {
        driver.findElement(By.id("LoginButton")).click();
        String msg = driver.findElement(By.xpath("//div[@class='login_error_msg']")).getText();
        Thread.sleep(1000);
        System.out.println("Error msg: " + msg);
    }

    @Test
    public void validUser() throws InterruptedException {
        driver.findElement(By.id("form-input-live-u")).sendKeys("ValidUser");
        driver.findElement(By.id("form-input-live-p")).sendKeys("Passwprd");
        driver.findElement(By.id("LoginButton")).click();
        String msg = driver.findElement(By.xpath("//div[@class='login_error_msg'][1]")).getText();
        Thread.sleep(3000);
        System.out.println("Error msg 1: " + msg);
        Thread.sleep(8000);
        String msg2 = driver.findElement(By.xpath("//div[@class='login_error_msg'][1]")).getText();
        System.out.println("Error msg 2: " + msg2);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterAll(){
        driver.close();
    }

}
