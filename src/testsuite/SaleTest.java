package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage() {
        // Find Sale element and click
        driver.findElement(By.xpath("//span[contains(text(),'Sale')]")).click();
        // Find Jackets link on left side under Women's Deal category element and click
        driver.findElement(By.xpath("//div[@class='categories-menu']//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']")).click();

        String expectedMessage = "Jackets";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[text()='Jackets' and @class='base']"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Jackets text displayed", expectedMessage, actualMessage);

        //count total items displayed on page
        List<WebElement> totalItems = driver.findElements(By.xpath("//div[@class='products wrapper grid products-grid']//li/div/div[@class='product details product-item-details']//a[@class='product-item-link']"));
        System.out.println("Total items displayed on page : " + totalItems.size());
        // print all items on the console
        for(WebElement items:totalItems){
            System.out.println("Name of the items: "+ items.getText());
        }
        String expectedMessage2="12 Items";
        WebElement actualTextElement2= driver.findElement(By.id("toolbar-amount"));
        String actualMessage2=actualTextElement2.getText();
         Assert.assertEquals("Total 12 items displayed",expectedMessage2,actualMessage2);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
