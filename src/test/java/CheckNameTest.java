
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class CheckNameTest extends TestBaseSteps{


    @Test
    @DisplayName("Поиск планшета Aser")
    public void Tablet() {
        String modelName;
        goToUrl("https://yandex.ru/");
        clickElementByLinkText("Маркет");
        clickElementByLinkText("Компьютеры");
        clickElementByLinkText("Планшеты");
        clickElementByLinkText("Перейти ко всем фильтрам");
        toFieldEnterValue("glf-pricefrom-var", "20000");
        toFieldEnterValue("glf-priceto-var", "25000");
        clickElementByXpath("//span[contains(text(),'Производитель')]");
        clickElementByXpath("//label[contains(text(),'Acer')]");
        clickElementByLinkText("Показать подходящие");
        modelName = getTextFromXpathSelector("(//div[@class='n-snippet-card2__title']/a)[2]");
        clickElementById("header-search");
        toFieldEnterValue("header-search", modelName);
        clickElementByXpath("//span[@class='search2__button']//button[.='Найти']");
        assertEqualsCssSelector(modelName, ".n-title__text");

    }


}
