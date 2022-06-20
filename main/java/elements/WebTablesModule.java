package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WebTablesModule {
    WebDriver driver;
    List<String> valuesArray = new ArrayList<>();
    public WebTablesModule(WebDriver driver){
        this.driver = driver;
        valuesArray.clear();
    }
    public WebTablesModule navigation(){
        this.driver.get("https://demoqa.com/webtables");
        return this;
    }

    public String addNewRecordButtonCheck(){
        return this.driver.findElement(By.id("registration-form-modal")).getText();
    }

    public WebTablesModule addNewRecordButton(){
        this.driver.findElement(By.id("addNewRecordButton")).click();
        return this;
    }
    public WebTablesModule addAge(String input){
        this.driver.findElement(By.id("age")).sendKeys(input);
        valuesArray.add(input);
        return this;
    }

    public WebTablesModule addFirstName(String input){
        this.driver.findElement(By.id("firstName")).sendKeys(input);
        valuesArray.add(input);
        return this;
    }

    public WebTablesModule addLastName(String input){
        this.driver.findElement(By.id("lastName")).sendKeys(input);
        valuesArray.add(input);
        return this;
    }
    //userEmail

    public WebTablesModule addEmail(String input){
        this.driver.findElement(By.id("userEmail")).sendKeys(input);
        valuesArray.add(input);
        return this;
    }

    //salary
    public WebTablesModule addSalary(String input){
        this.driver.findElement(By.id("salary")).sendKeys(input);
        valuesArray.add(input);
        return this;
    }

    public WebTablesModule addDepartment(String input){
        this.driver.findElement(By.id("department")).sendKeys(input);
        valuesArray.add(input);
        return this;
    }

    public void submitNewRecord(){
        this.driver.findElement(By.id("submit")).click();
    }

    public String submitRecordCheck(String input){
        System.out.printf("//*[contains(text()='%s')]%n", input);

        return this.driver.findElement(By.xpath(String.format("//div[text()='%s']", input))).getText();


    }

    public void quit(){
        this.driver.quit();
    }
}
