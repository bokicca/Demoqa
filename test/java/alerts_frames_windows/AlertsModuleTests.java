package alerts_frames_windows;

import alertsframeswindows.AlertsModule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsModuleTests {
    public static AlertsModule page;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        page = new AlertsModule(driver);
    }

    @Test
    public void testBasicAlertBtn()  {

        page.navigation();
        page.basicAlertBtn();
        page.acceptAlertBtnPress();
        page.close();

    }
    @Test
    public void testDelayedAlertBtn() {
        page.navigation();
        page.delayedAlertBtn();
        page.acceptDelayedAlertBtnPress();
        page.close();
    }
    @Test
    public void testConfirmAlertBtn_Accept()  {

        page.navigation();
        page.confirmAlertBtn();
        page.acceptAlertBtnPress();
        assertEquals("You selected Ok",page.returnAlertBtnSelection());
        page.close();

    }

    @Test
    public void testConfirmAlertBtn_Dismiss()  {

        page.navigation();
        page.confirmAlertBtn();
        page.dismissAlertBtnPress();
        assertEquals("You selected Cancel",page.returnAlertBtnSelection());
        page.close();

    }

    public void testPromptAlertBtn(){
        page.navigation();
        page.promptAlertBtn();
        page.fillInPromptAlert("Text");
        assertEquals("You entered Text", page.returnPromptAlertBtnValue());
        page.close();
    }
}
