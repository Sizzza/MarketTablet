
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckNameTest {
    ChromeDriver wd;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/ilyasizov/IdeaProjects/chromdriver/chromedriver");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @Test
    public void Tablet() {
        String modelName;
        wd.manage().window().maximize();
        wd.get("https://yandex.ru/");
        wd.findElement(By.linkText("Маркет")).click();
        wd.findElement(By.linkText("Компьютеры")).click();
        wd.findElement(By.linkText("Планшеты")).click();
        wd.findElement(By.linkText("Перейти ко всем фильтрам")).click();
        wd.findElement(By.id("glf-pricefrom-var")).click();
        wd.findElement(By.xpath("//input[@id='glf-pricefrom-var']")).sendKeys("20000");
        wd.findElement(By.id("glf-priceto-var")).click();
        wd.findElement(By.id("glf-priceto-var")).sendKeys("25000");
        wd.findElement(By.xpath("//span[contains(text(),'Производитель')]")).click();
        wd.findElement(By.xpath("//label[contains(text(),'Acer')]")).click();
        wd.findElement(By.linkText("Показать подходящие")).click();
        modelName = wd.findElement(By.xpath("(//div[@class='n-snippet-card2__title']/a)[2]")).getText();
        wd.findElement(By.id("header-search")).click();
        wd.findElement(By.id("header-search")).sendKeys(modelName);
        wd.findElement(By.xpath("//span[@class='search2__button']//button[.='Найти']")).click();
        Assert.assertEquals(wd.findElement(By.cssSelector(".n-title__text")).getText(), modelName);

    }

    @After
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
