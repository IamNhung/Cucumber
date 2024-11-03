package stepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Map;
import io.cucumber.datatable.DataTable;
public class Test_Steps {
    public static WebDriver driver;
    @Given("User is on Register Page")
    public void user_is_on_Register_Page() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/");
        driver.manage().window().maximize();
    }
    @When("User enters Email")
    public void user_enters_Email() throws Throwable {
        driver.findElement(By.name("emailid")).sendKeys("usedtokeep@rom.vn");
    }

    @And("User click on Submit button")
    public void user_click_Submit_button() throws Throwable {
        driver.findElement(By.name("btnLogin")).click();
    }

    @Then("Access details is displayed")
    public void Accessdetails_displayed_Successfully() throws Throwable {
        boolean status = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/h2")).isDisplayed();
        if(status){
            System.out.println("Access details is displayed successfully");
        }
        else
            System.out.println("Access details is displayed unsuccessfully");
    }

    @Given("User is on Login Page")
    public void user_is_on_Login_Page() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/login.html");
        driver.manage().window().maximize();
    }
//    DDT in Cucumber
    @When("User enters {string} and {string}")
    public void user_enters_email_and_password(String username, String password) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

/*    @When("User enters credentials to Login")
    public void user_enters_credentials_to_Login(DataTable credentials) throws Throwable {
        for (Map<String, String> data : credentials.asMaps(String.class, String.class)){
            driver.findElement(By.id("email")).sendKeys(data.get("username"));
            driver.findElement(By.id("passwd")).sendKeys(data.get("password"));
            driver.findElement(By.id("SubmitLogin")).submit();
        }
    }*/

    @And("User click on Sign in button")
    public void user_click_Signin_button() throws Throwable {
        driver.findElement(By.id("SubmitLogin")).submit();
    }
    @Then("Home page is displayed successfully")
    public void homepage_displayed_successfully() throws Throwable{
        boolean status1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).isDisplayed();
        if(status1){
            System.out.println("Login successfully");
        }
        else
            System.out.println("Login unsuccessfully");
    }
}
