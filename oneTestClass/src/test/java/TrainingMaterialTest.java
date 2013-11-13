import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertTrue;

public class TrainingMaterialTest {

    WebDriver driver;
    private By searchTextBox = By.id("gbqfq");
    private By firstReturnedResult = By.className("g");

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }

    @Test
    public void verifySearch(){
        if ( driver.findElement(searchTextBox).isDisplayed()){
            driver.findElement(searchTextBox).sendKeys("London");
            driver.findElement(searchTextBox).submit();
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(firstReturnedResult));
        assertTrue("the first returned result does not contain London text", driver.findElement(firstReturnedResult).getText().contains("London"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
