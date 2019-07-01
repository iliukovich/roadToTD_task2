package tutby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogIn {

    private static final String TUT_BY_URI = "https://www.tut.by/";
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TUT_BY_URI);
    }

    @Test(dataProvider = "userData", dataProviderClass = DataDrivenLogIn.class)
    public void testLoginButtonIsPresentOnSite(String email, String password, String username) {
        driver.findElement(By.xpath("//a[@class='enter']")).click();

        WebElement emailField =  driver.findElement(By.xpath("//form[@class='auth-form']//input[@name='login']"));
        emailField.sendKeys(email);

        WebElement passwordField =  driver.findElement(By.xpath("//form[@class='auth-form']//input[@name='password']"));
        passwordField.sendKeys(password);

        driver.findElement(By.xpath("//form[@class='auth-form']//input[contains(@class, 'auth')]")).click();

        WebElement userName =  driver.findElement(By.className("uname"));
        Assert.assertEquals(userName.getText(), username,"User name is not correct");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
