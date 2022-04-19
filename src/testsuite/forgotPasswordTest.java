package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class forgotPasswordTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/ ";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        WebElement forgotYourPassword = driver.findElement(By.linkText("Forgot your password?"));
        forgotYourPassword.click();
        //requirement from customer
        String expectedMessage="Forgot Your Password?";
        //find the forgot your password? text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualMessage= actualMessageElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void close(){
        closeBrowser();
    }

}
