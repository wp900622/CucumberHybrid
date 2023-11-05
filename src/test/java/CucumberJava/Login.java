package CucumberJava;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Login {
//    WebDriver driver = new  ChromeDriver() ;
     WebDriver driver;
    @Before
    public  void beforeScenario(){

        System.out.println("This will run before the Scenario");
//        System.setProperty("webdriver.chrome.whitelistedIps", "");
        //設定程式內chromedriver的路徑,這樣才能執行chromedriver
      
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //刪除瀏覽器所有cookie以確保瀏覽器最佳狀態
      // driver.manage().deleteAllCookies();
        //最大化瀏覽器
       // driver.manage().window().maximize();
        //driver等待10000毫秒後進入網址以方便找尋網頁元素
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        //進入網址內容

        driver.get("https://tutorialsninja.com/demo/");



    }


    @Given("user navigate to the login page")
    public  void userAreOnTheLoginPage() throws InterruptedException {
        //尋找My Account的元素並點擊
       WebElement element = driver.findElement(By.xpath("//a[@title='My Account']"));
       element.click();
       //Thread.sleep(1000);
       //尋找Login的元素並點擊
        WebElement elementlogin = driver.findElement(By.linkText("Login"));
        elementlogin.click();
        //Thread.sleep(1000);
    }

    @When("User enters valid email address {string} into the email field")
    public void userEntersAnd(String email) throws InterruptedException {
        //尋找email的元素並輸入email
        WebElement element = driver.findElement(By.id("input-email"));
        element.sendKeys(email);
        //Thread.sleep(1000);

    }
    @And("User enters valid password {string} into the password field")
    public void userEntersValidPasswordIntoThePasswordField(String password) throws InterruptedException {
        //尋找password的元素並輸入password
        WebElement element = driver.findElement(By.id("input-password"));
        element.sendKeys(password);
        //Thread.sleep(1000);

    }
    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() throws InterruptedException {
        //尋找login的元素並點擊
        WebElement button = driver.findElement(By.xpath("//input[@value='Login']"));
        button.click();
        //Thread.sleep(1000);
    }
    @Then("user should be logged in")
    public void userShouldBeLoggedIn(){
        //確認是否登入成功
        Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());
        driver.quit();
    }


    @And("User enters invalid password {string} into the password field")
    public void userEntersInvalidPasswordIntoThePasswordField(String invalidPassword) throws InterruptedException {
        //尋找password的元素並輸入password
        WebElement element = driver.findElement(By.id("input-password"));
        element.sendKeys(invalidPassword);
       // Thread.sleep(1000);
    }



    @Then("user should get an error message about invalid credentials")
    public void userShouldGetAnErrorMessageAboutInvalidCredentials() throws InterruptedException {
        //確認是否登入失敗
       Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
        driver.quit();
    }
}
