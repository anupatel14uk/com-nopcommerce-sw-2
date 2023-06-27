package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //Find the Register link
        WebElement RegisterLink = driver.findElement(By.linkText("Register"));
        //click on Register link
        RegisterLink.click();
        //Verify the text ‘Register’
        String expectedText = "Register";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(" redirected to Register page", expectedText, actualText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully() {

            //click on the ‘Register’ link
            WebElement registerLink = driver.findElement(By.linkText("Register"));
            registerLink.click();
            // Select gender radio button
            driver.findElement(By.id("gender-female")).click();
            // Enter First name
            driver.findElement(By.id("FirstName")).sendKeys("yogesh");
            // Enter Last name
            driver.findElement((By.id("LastName"))).sendKeys("patel");
            // Select Day Month and Year
            driver.findElement(By.name("DateOfBirthDay")).sendKeys("24");
            driver.findElement(By.name("DateOfBirthMonth")).sendKeys("September");
            driver.findElement(By.name("DateOfBirthYear")).sendKeys("1990");
            // Enter Email address
            driver.findElement(By.id("Email")).sendKeys("anu@gmail.com");
            // Enter Password
            driver.findElement(By.id("Password")).sendKeys("anu123456");
            // Enter Confirm password
            driver.findElement(By.id("ConfirmPassword")).sendKeys("anu123456");
            // Click on REGISTER button
            driver.findElement(By.id("register-button")).click();
            // Verify the text 'Your registration completed
            String expectedMessage = "Your registration completed";
            String actualMessage = driver.findElement(By.xpath("//div[text() = 'Your registration completed']")).getText();
            Assert.assertEquals("Your registration completed", expectedMessage,actualMessage);

        }
    @After
    public void ternDown() {
        closeBrowser();
    }
    }