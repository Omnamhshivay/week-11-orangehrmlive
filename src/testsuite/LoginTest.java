package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/ ";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //find email field element
        WebElement emailField=driver.findElement(By.id("txtUsername"));
        //sending email to email field element
        emailField.sendKeys("Admin");
        //finding password field element
        WebElement passwordField =driver.findElement(By.id("txtPassword"));
        //sending password to password field
        passwordField.sendKeys("admin123");
        // click on login button
        WebElement loginField=driver.findElement(By.id("btnLogin"));
        loginField.click();
        //requirement
        String expectedMessage="Welcome";
        //find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.partialLinkText("Welcome"));
        String actualMessage= actualMessageElement.getText();
        Assert.assertNotSame(expectedMessage,actualMessage);
    }
    @After
    public void close(){
        closeBrowser();
    }

}
