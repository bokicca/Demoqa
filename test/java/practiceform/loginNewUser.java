package practiceform;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginNewUser {
    @Test
    public void createUserAndLogin(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/register");

        driver.findElement(By.id("firstname")).sendKeys("Bojana");
        driver.findElement(By.id("lastname")).sendKeys("Bozovic");
        driver.findElement(By.id("userName")).sendKeys("BoBo");
        driver.findElement(By.id("password")).sendKeys("seleniumDrivenPassword123!");


        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border"))).click();

        driver.switchTo().defaultContent();
        driver.findElement(By.id("firstname")).submit();


    }
}
