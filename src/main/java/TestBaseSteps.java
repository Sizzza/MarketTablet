import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Step;

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
    @Step("Открыть хром на весь экран")
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/ilyasizov/IdeaProjects/chromdriver/chromedriver");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Step("Выбрать элемент по css")
    protected void assertEqualsCssSelector(String modelName, String selector) {
        Assert.assertEquals(wd.findElement(By.cssSelector(selector)).getText(), modelName);
    }

    @Step("Скопировать текст")
    protected String getTextFromXpathSelector(String xpathExpression) {
        return wd.findElement(By.xpath(xpathExpression)).getText();
    }

    @Step("Выбрать элемент по xpath")
    protected void clickElementByXpath(String xpathExpression) {
        wd.findElement(By.xpath(xpathExpression)).click();
    }

    @Step("Ввести значение")
    protected void toFieldEnterValue(String fieldId, String value) {
        wd.findElement(By.id(fieldId)).sendKeys(value);
    }

    @Step("Найти элемент по id")
    protected void clickElementById(String id) {
        wd.findElement(By.id(id)).click();
    }

    @Step("Найти элемент по тексту")
    protected void clickElementByLinkText(String linkText) {
        wd.findElement(By.linkText(linkText)).click();
    }

    @Step("Перейти по url")
    protected void goToUrl(String url) {
        wd.get(url);
    }

    @After
    public void tearDown() {
        wd.quit();
    }
}
