package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebTablesModuleTests {
    public static WebTablesModule page;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        page = new WebTablesModule(driver);
    }

    @Test
    public void addNewRecordTest(){
        page.navigation().addNewRecordButton();
        assertEquals("Registration Form",page.addNewRecordButtonCheck());

        String firstName = "Bojana";
        String lastName = "Bozovic";
        String email = "bojanna.boki@gmail.com";
        String age = "36";
        String salary = "5";
        String department = "QA Testing";

        page.addFirstName(firstName)
                .addLastName(lastName)
                .addEmail(email)
                .addAge(age)
                .addSalary(salary)
                .addDepartment(department)
                .submitNewRecord();

        assertEquals(firstName,page.submitRecordCheck(firstName));
        assertEquals(lastName,page.submitRecordCheck(lastName));
        assertEquals(email,page.submitRecordCheck(email));
        assertEquals(age,page.submitRecordCheck(age));
        assertEquals(salary,page.submitRecordCheck(salary));
        assertEquals(department,page.submitRecordCheck(department));


    }
}
