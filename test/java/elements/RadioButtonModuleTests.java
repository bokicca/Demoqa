package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class RadioButtonModuleTests {
    public ChromeDriver setup() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        return driver;

    }

    @Test
    public void yesRadioButtonCheck() {

        ChromeDriver testDriver = setup();
        RadioButtonModule page = new RadioButtonModule(testDriver);

        page.navigation();
        page.yesRadioBtn();
        assertEquals("Yes",page.returnRadioValue());
        testDriver.quit();
    }

    @Test
    public void impressiveRadioButtonCheck() {

        ChromeDriver testDriver = setup();
        RadioButtonModule page = new RadioButtonModule(testDriver);

        page.navigation();
        page.impressiveRadioBtn();
        assertEquals("Impressive", page.returnRadioValue());
        testDriver.quit();
    }

    @Test
    public void noRadioButtonCheck() {

        ChromeDriver testDriver = setup();
        RadioButtonModule page = new RadioButtonModule(testDriver);

        page.navigation();
        page.noRadioBtn();
        assertFalse(Boolean.parseBoolean(page.returnRadioValue()));
        testDriver.quit();
    }

}
