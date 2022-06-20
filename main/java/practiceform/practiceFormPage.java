package practiceform;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class practiceFormPage {
    WebDriver driver;

    public practiceFormPage(WebDriver driver){

        this.driver = driver;

    }


    public void navigation(){
        this.driver.get("https://demoqa.com/automation-practice-form");
    }

    public WebElement navigationCheck(){
        WebElement pageToCheck = this.driver.findElement(By.className("main-header"));
        return pageToCheck;
    }
    public void firstNameField(String input){
        this.driver.findElement(By.id("firstName")).sendKeys(input);
    }

    public void lastNameField(String input){
        this.driver.findElement(By.id("lastName")).sendKeys(input);
    }

    public void emailField(String input){
        this.driver.findElement(By.id("userEmail")).sendKeys(input);
    }

    public void maleGenderRadioSelect(){
        this.driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
    }
    public void femaleGenderRadioSelect(){
        this.driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
    }
    public void otherGenderRadioSelect(){
        this.driver.findElement(By.xpath("//label[@for='gender-radio-3']")).click();
    }

    public void phoneNumberField(String number){
        this.driver.findElement(By.id("userNumber")).sendKeys(number);
    }

    public void subjectField(String input){
        this.driver.findElement(By.id("subjectsInput")).sendKeys(input);
    }

    public void hobbyFieldSelector(String input){
        String inputHobby = String.format("//label[@for='hobbies-checkbox-%s",input);
        this.driver.findElement(By.xpath(inputHobby)).click();
    }

    public void addressField(String input){
        this.driver.findElement(By.id("currentAddress")).sendKeys(input);
    }

    public void dateOfBirthPicker (int inputDay, int inputMonth, Integer inputYear){
        inputMonth -= 1;
        this.driver.findElement(By.id("dateOfBirthInput")).click();
        Select datepickerMonth = new Select(this.driver.findElement(By.className("react-datepicker__month-select")));
        datepickerMonth.selectByIndex(inputMonth);
        Select datepickerYear = new Select(this.driver.findElement(By.className("react-datepicker__year-select")));
        datepickerYear.selectByValue(inputYear.toString());
        String xpathValue = String.format("//div[text()='%s']", inputDay);
        this.driver.findElement(By.xpath(xpathValue)).click();
    }

    public void selectState(String input){
        driver.findElement(By.id("react-select-3-input")).sendKeys(input + Keys.ENTER);
    }

    public void selectCity(String input){
        this.driver.findElement(By.id("react-select-4-input")).sendKeys(input + Keys.ENTER);
    }

    public void submit(){
        this.driver.findElement(By.id("firstName")).submit();
    }


    public void fillInForm(){
        this.firstNameField("TestName");
        this.lastNameField("TestLastName");
        this.emailField("lars.demaere@bignition.com");
        this.femaleGenderRadioSelect();
        this.phoneNumberField("0123456788");
        this.subjectField("Practice QA Form");
        this.addressField("Veldkant 33B Kontich");
        this.dateOfBirthPicker(1,1,1991);
        this.hobbyFieldSelector("2");
        this.selectCity("NCR");
        this.selectCity("Delhi");
        this.submit();
    }
}
