import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogIn {

    public static final String TUT_BY = "https://www.tut.by/";
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TUT_BY);
    }

    @Test (enabled = false)
    public void testSeleniumURI() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, TUT_BY);
    }

    @Test
    public void testLoginButtonIsPresentOnSite() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='enter']")).click();

        WebElement loginForm = driver.findElement(By.cssSelector("div[class=b-popup-i]"));
        Assert.assertTrue(loginForm.isDisplayed(), "Login button is not displayed on site");

        WebElement emailField =  driver.findElement(By.xpath("//input[@tabindex='1']"));
        Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed on Login form");
        emailField.sendKeys("a1qatest@tut.by");

        WebElement passwordField =  driver.findElement(By.xpath("//input[@tabindex='2']"));
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed on Login form");
        passwordField.sendKeys("Qwerty123");

        WebElement loginButton =  driver.findElement(By.xpath("//input[@tabindex='4']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed on Login form");
        loginButton.click();

        WebElement userName =  driver.findElement(By.className("uname"));
        Assert.assertTrue(userName.isDisplayed(), "User name is not displayed on site");

        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
