package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RadioButtonModule {
    WebDriver driver;

    public RadioButtonModule(WebDriver driver){

        this.driver = driver;

    }

    public void navigation(){
        this.driver.get("https://demoqa.com/radio-button");
    }

    public void yesRadioBtn(){
        this.driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

    }

    public void impressiveRadioBtn(){
        this.driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();

    }

    public void noRadioBtn(){

        try {
            this.driver.findElement(By.xpath("//label[@for='noRadio']")).click();
        } catch (NoSuchElementException e) {
        }
    }

    public String returnRadioValue(){
        String textValue = "";
        try {
            textValue = this.driver.findElement(By.className("text-success")).getText();
        } catch (NoSuchElementException e) {
            return "false";
        }
        return textValue;
    }
}
