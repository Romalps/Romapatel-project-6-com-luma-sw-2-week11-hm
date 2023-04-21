package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
4. Write down the following test into ‘LoginTest’
class
1. userShouldLoginSuccessfullyWithValid
Credentials()
* Click on ‘Sign In’ link
* Enter valid Email
* Enter valid Password
* Click on ‘Sign In’ button
* Verify the ‘Welcome’ text is display
2. verifyTheErrorMessageWithInvalidCredentials
* Click on ‘Sign In’ link
* Enter valid Email
* Enter valid Password
* Click on ‘Sign In’ button
* Verify the error message ‘The account sign-in was
incorrect or your account is disabled temporarily. Please wait and try again
later.’
3. userShouldLogOutSuccessfully
* Click on ‘Sign In’ link
* Enter valid Email
* Enter valid Password
* Click on ‘Sign In’ button
* Verify the ‘Welcome’ text is display
* Click on down aero neare Welcome
* Click on Sign Out link
* Verify the text ‘You are signed out’
 */
public class LoginTest extends BaseTest {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

        // Find Sign In link element and click
        driver.findElement(By.xpath("//div[@class='panel wrapper']//li[@class='authorization-link']")).click();
        // Find Email field element and send email element
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prime543tester123@gmail.com");
        // Find Password field element and send password element
        driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Prime543Tester");
        // Find Sign In button element and click
        driver.findElement(By.xpath("//div[@class='actions-toolbar']//button[@type='submit' and @class='action login primary']")).click();

        String expectedMessage = "Welcome, prime tester!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='panel header']//span[contains(text(),'Welcome')]"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Welcome text displayed", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {

        // Find Sign In link element and click
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']")).click();
        // Find Email field element and send email element
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prime543tester1239@gmail.com");
        // Find Password field element and send password element
        driver.findElement(By.xpath("//input[@type='password' and @title='Password']")).sendKeys("Prime543Tester9");
        // Find Sign In button element and click
        driver.findElement(By.xpath("//div[@class='actions-toolbar']//button[@type='submit' and @class='action login primary']")).click();

        String expectedMessage ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualTextElement= driver.findElement(By.xpath("//div[@class='message-error error message']"));
        String actualMessage= actualTextElement.getText();

        Assert.assertEquals("Error message is displayed",expectedMessage,actualMessage);


    }
    @Test
    public void verifyUserShouldLogoutSuccessfully(){
        // Find Sign In link element and click
        driver.findElement(By.xpath("//div[@class='panel wrapper']//li[@class='authorization-link']")).click();
        // Find Email field element and send email element
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prime543tester123@gmail.com");
        // Find Password field element and send password element
        driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Prime543Tester");
        // Find Sign In button element and click
        driver.findElement(By.xpath("//div[@class='actions-toolbar']//button[@type='submit' and @class='action login primary']")).click();

        String expectedMessage = "Welcome, prime tester!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='panel header']//span[contains(text(),'Welcome')]"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Welcome text displayed", expectedMessage, actualMessage);
        // Find down aero near welcome element and click
        driver.findElement(By.xpath("//div[@class='panel header']//button[@data-action='customer-menu-toggle']")).click();
        //Find Sign out link element and click
        driver.findElement(By.xpath("//div[@class='panel header']//div[@class='customer-menu']//li[@class='authorization-link']")).click();
        String expectedMessage2= "You are signed out";
        WebElement actualTextElement2= driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']"));
        String actualMessage2=actualTextElement2.getText();
        Assert.assertEquals("You are signed out text displayed",expectedMessage2,actualMessage2);

    }


    @After
    public void tearDown(){
        closeBrowser();
    }

}
