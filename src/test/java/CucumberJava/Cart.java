package CucumberJava;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Cart {
    WebDriver driver;
    @Before
    public  void beforeScenario(){
        System.out.println("This will run before the Scenario");
        //設定程式內chromedriver的路徑,這樣才能執行chromedriver
        System.setProperty("webdriver.chrome.driver","D:\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //設定chromedriver的參數
        ChromeOptions options = new ChromeOptions();
        //增加參數--remote-allow-origins=*,以防止跨域問題
        options.addArguments("--remote-allow-origins=*");
        //增加參數--headless,以防止跑測試時跳出瀏覽器
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver等待15000毫秒後進入網址以方便找尋網頁元素
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        //進入網址內容
        driver.get("https://tutorialsninja.com/demo/");

    }
    @Given("User navigate to the Phones&PDAs page")
    public void userNavigateToThePhonesPDAsPage() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//a[text()='Phones & PDAs']"));
        element.click();
       // Thread.sleep(1000);
    }

    @When("I click on the iPhone link")
    public void iClickOnTheIPhoneLink() throws InterruptedException {
        //尋找iPhone的元素並點擊
        WebElement element = driver.findElement(By.xpath("//a[text()='iPhone']"));
        element.click();
        //Thread.sleep(1000);
    }

    @And("I enter {int} in the quantity field")
    public void iEnterInTheQuantityField(int quantity) throws InterruptedException {
        //尋找Quantity的元素並輸入Quantity
        WebElement element = driver.findElement(By.id("input-quantity"));
        element.clear();
        element.sendKeys(String.valueOf(quantity));
        //Thread.sleep(1000);
    }

    @And("I click on the Add to cart button")
    public void iClickOnTheAddToCartButton() throws InterruptedException {
        //尋找Add to cart的元素並點擊
        WebElement element = driver.findElement(By.id("button-cart"));
        element.click();
        //Thread.sleep(1000);
    }

    @Then("I should see the Item added to cart message")
    public void iShouldSeeTheItemAddedToCartMessage() {
        //確認是否有出現Success: You have added iPhone to your shopping cart!
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class= 'alert alert-success" +
                        " alert-dismissible']")).
                getText().contains("Success: You have added iPhone to your shopping cart!"));
    }

    @And("I click cart button")
    public void iClickCartButton() {
            WebElement element = driver.findElement(By.xpath("//button[@class='btn " +
                    "btn-inverse btn-block btn-lg dropdown-toggle']"));
            element.click();
    }

    @Then("I should see the item in the cart")
    public void iShouldSeeTheItemInTheCart() {
        //確認是否有出現iPhone
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='iPhone']")).
                getText().contains("iPhone"));

    }
}
