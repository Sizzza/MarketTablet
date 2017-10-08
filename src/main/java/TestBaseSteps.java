import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBaseSteps {
    ChromeDriver wd;

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/ilyasizov/IdeaProjects/chromdriver/chromedriver");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    protected void assertEqualsCssSelector(String modelName, String selector) {
        Assert.assertEquals(wd.findElement(By.cssSelector(selector)).getText(), modelName);
    }

    protected String getTextFromXpathSelector(String xpathExpression) {
        return wd.findElement(By.xpath(xpathExpression)).getText();
    }

    protected void clickElementByXpath(String xpathExpression) {
        wd.findElement(By.xpath(xpathExpression)).click();
    }

    protected void toFieldEnterValue(String fieldId, String value) {
        wd.findElement(By.id(fieldId)).sendKeys(value);
    }

    protected void clickElementById(String id) {
        wd.findElement(By.id(id)).click();
    }

    protected void clickElementByLinkText(String linkText) {
        wd.findElement(By.linkText(linkText)).click();
    }

    protected void goToUrl(String url) {
        wd.get(url);
    }

    @After
    public void tearDown() {
        wd.quit();
    }
}
