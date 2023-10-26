package CucumberJava;
import io.cucumber.java.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Register {

    WebDriver driver ;
    @Before
    public  void beforeScenario(){

        System.out.println("This will run before the Scenario");
//        System.setProperty("webdriver.chrome.whitelistedIps", "");
        //設定程式內chromedriver的路徑,這樣才能執行chromedriver
        System.setProperty("webdriver.chrome.driver","D:\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver等待10000毫秒後進入網址以方便找尋網頁元素
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        //進入網址內容
        driver.get("https://tutorialsninja.com/demo/");
    }
    @Given("user navigate to the register page")
    public void userNavigateToTheRegisterPage() throws InterruptedException {
        //尋找My Account的元素並點擊
        WebElement element = driver.findElement(By.xpath("//a[@title='My Account']"));
        element.click();
        //Thread.sleep(1000);
        WebElement elementlogin = driver.findElement(By.linkText("Register"));
        elementlogin.click();
        //Thread.sleep(1000);
    }

    @When("user enters {string} into the first name field")
    public void userEntersIntoTheFirstNameField(String FirstName) throws InterruptedException {
        //尋找First name的元素並輸入First name
        WebElement element = driver.findElement(By.id("input-firstname"));
        element.sendKeys(FirstName);
        //Thread.sleep(1000);
    }

    @And("user enters {string} into the last name field")
    public void userEntersIntoTheLastNameField(String LastName) throws InterruptedException {
        //尋找Last name的元素並輸入Last name
        WebElement element = driver.findElement(By.id("input-lastname"));
        element.sendKeys(LastName);
        //Thread.sleep(1000);
    }
<<<<<<< HEAD
=======



>>>>>>> 634daf8 (first commit)
    @And("user enters {string} into the email field")
    public void userEntersIntoTheEmailField(String email) throws InterruptedException {
        //尋找email的元素並輸入email
        WebElement element = driver.findElement(By.id("input-email"));
        element.sendKeys(email);
        //Thread.sleep(1000);
    }
<<<<<<< HEAD
=======



>>>>>>> 634daf8 (first commit)
    @And("user enters {string} into the telephone field")
    public void userEntersIntoTheTelephoneField(String telephone) throws InterruptedException {
        //尋找telephone的元素並輸入telephone
        WebElement element = driver.findElement(By.id("input-telephone"));
        element.sendKeys(telephone);
        //Thread.sleep(1000);
    }
<<<<<<< HEAD
=======


>>>>>>> 634daf8 (first commit)
    @And("user enters {string}  into the password field")
    public void userEntersIntoThePasswordField(String password) throws InterruptedException {
        //尋找password的元素並輸入password
        WebElement element = driver.findElement(By.id("input-password"));
        element.sendKeys(password);
        //Thread.sleep(1000);
    }

    @And("user enters {string} into the password confirm field")
    public void userEntersIntoThePasswordConfirmField(String passwordconfirm) throws InterruptedException {
        //尋找password confirm的元素並輸入password confirm
        WebElement element = driver.findElement(By.id("input-confirm"));
        element.sendKeys(passwordconfirm);
        //Thread.sleep(1000);
    }

    @And("user clicks on the privacy policy checkbox")
    public void userClicksOnThePrivacyPolicyCheckbox() throws InterruptedException {
        //尋找privacy policy的元素並點擊
        WebElement element = driver.findElement(By.name("agree"));
        element.click();
        //Thread.sleep(1000);
    }

    @And("user clicks on the continue button")
    public void userClicksOnTheContinueButton() throws InterruptedException {
        //尋找continue的元素並點擊
        WebElement button = driver.findElement(By.xpath("//input[@value='Continue']"));
        button.click();
        //Thread.sleep(1000);
    }

    @Then("user should be registered successfully")
    public void userShouldBeRegisteredSuccessfully() {
        //確認是否註冊失敗
        Assert.assertTrue(driver.findElement(By.xpath(
                "//div[contains(@class,'alert-dismissible')]")).getText().
                contains("Warning: E-Mail Address is already registered!"));
    }
}
