package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
2. Create the package ‘testsuite’ and create the
following classes inside the ‘testsuite’ package.
1. RegisterTest
2. LoginTest
3. SaleTest
3. Write down the following test into ‘RegisterTest’
class
1. verifyThatSignInPageDisplay
* click on the ‘Create an Account’ link
* Verify the text ‘Create New Customer Account’
2. userShouldRegisterAccountSuccessfully
* click on the ‘Create an Account’ link
* Enter First name
* Enter Last name
* Click on checkbox Sign Up for Newsletter
* Enter Email
* Enter Password
* Enter Confirm Password
* Click on Create an Account button
* Verify the text 'Thank you for registering with Main Website Store.’
* Click on down aero near Welcome
* Click on Sign Out link
* Verify the text ‘You are signed out’
 */
public class RegisterTest extends BaseTest {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSignInPageDisplay() {

        // Find Create an Account field element and click
        driver.findElement(By.linkText("Create an Account")).click();
        // Verify text 'Create New Customer Account is displayed
        String expectedMessage = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[contains(@class,'base') or starts-with(@id,'page')]"));
        String actualMessage = actualTextElement.getText();

        //Compare two messages
        Assert.assertEquals("Create New Customer Account text displayed", expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldRegisterAccountSuccessfully(){
        //Find Create an Account link element and click
        driver.findElement(By.xpath("//div[@class='panel header']//a[text()='Create an Account']")).click();
        //Find Enter First name field element and send first name element
        driver.findElement(By.xpath("//input[starts-with(@id,'firstname') and @class='input-text required-entry']")).sendKeys("prime543");
        //Find Last name field element and send last name element
        driver.findElement(By.xpath("//input[contains(@name,'lastname') and contains(@id,'lastname')]")).sendKeys("tester");
        //Find checkbox sign up for Newsletter element and click
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        //Find Email field element and send email element
        driver.findElement(By.xpath("//input[contains(@name,'email') and @id='email_address']")).sendKeys("prime765tester234@gmail.com");
        // Find Password field element and send password element
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Prime543Tester");
        //Find Confirm Password field element and send confirm password element
        driver.findElement(By.xpath("//input[starts-with(@title,'Confirm Password') and @id='password-confirmation']")).sendKeys("Prime543Tester");
        // Find  Create an Account button element and click
        driver.findElement(By.xpath("//button[@type='submit' and @title='Create an Account']")).click();
        String expectedMessage= "Thank you for registering with Main Website Store.";
        WebElement actualTextElement= driver.findElement(By.xpath("//div[@class='message-success success message']"));
        String actualMessage= actualTextElement.getText();
        // Compare two messages
        Assert.assertEquals("Thank you for registering with Main website store text displayed",expectedMessage,actualMessage);
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
    public void tearDown() {
        closeBrowser();
    }

}
