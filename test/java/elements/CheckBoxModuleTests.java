package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBoxModuleTests {
    @Test
    public void checkBoxExpand(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        CheckBoxModule page = new CheckBoxModule(driver);

        page.navigation();




        page.expandFileStructBtn();


        driver.quit();
    }
}
