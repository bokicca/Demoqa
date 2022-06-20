package alertsframeswindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsModule {
    WebDriver driver;

    public AlertsModule(WebDriver driver){

        this.driver = driver;

    }

    public void navigation(){
        this.driver.get("https://demoqa.com/alerts");
    }

    public void close(){
        this.driver.close();
    }

    public void basicAlertBtn(){
        this.driver.findElement(By.id("alertButton")).click();
    }

    public void delayedAlertBtn(){
        this.driver.findElement(By.id("timerAlertButton")).click();
    }

    public void confirmAlertBtn(){
        this.driver.findElement(By.id("confirmButton")).click();
    }

    public void promptAlertBtn(){

        this.driver.findElement(By.id("confirmButton")).click();

    }

    public void fillInPromptAlert(String input){
        this.driver.switchTo().alert().sendKeys(input);
    }

    public void acceptDelayedAlertBtnPress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        this.driver.switchTo().alert().accept();
    }

    public void acceptAlertBtnPress(){
        this.driver.switchTo().alert().accept();
    }

    public void dismissAlertBtnPress(){
        this.driver.switchTo().alert().dismiss();
    }

    public String returnAlertBtnSelection(){
        return this.driver.findElement(By.id("confirmResult")).getText();
    }

    public String returnPromptAlertBtnValue(){
        return this.driver.findElement(By.id("promptResult")).getText();
    }
}
