package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxModule {
    WebDriver driver;

    public CheckBoxModule(WebDriver driver){

        this.driver = driver;

    }

    public void navigation(){
        this.driver.get("https://demoqa.com/checkbox");
    }

    public void expandFileStructBtn(){
        this.driver.switchTo().frame("fixedban");
        this.driver.findElement(By.id("cbb")).click();
        this.driver.switchTo().defaultContent();
        this.driver.findElement(By.xpath("//button[@title='Expand All']"));
    }
}
