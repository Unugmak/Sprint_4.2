package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    //Кнопка "Заказать" в хедере
    private final By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Кнопка "Заказать" внутри страницы
    private final By inPageOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка принятия куки
    private final By cookieAcceptButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Блок "Вопросы о важном"
    private final By accordionHead = By.xpath("//div[text()='Вопросы о важном']");

    // Конструктор класса
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод клика в кнопку "Заказать" в хедере
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    //Метод скрола и клика в кнопку "Заказать" внутри страницы
    public void clickInPageOrderButton() {
        WebElement button = driver.findElement(inPageOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }

    //Метод скрола и клика в кнопку принятия куки
    public void clickCookieAcceptButton() {
        WebElement button = driver.findElement(cookieAcceptButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }

    //Метод скрола до блока "Вопросы о важном"
    public void scrollAccordion() {
        WebElement element = driver.findElement(accordionHead);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    // Метод кликает в вопрос и возвращает ответ
    public String clickAccordion(int accordionIdNumber) {
        driver.findElement(By.id("accordion__heading-" + (accordionIdNumber))).click();
        new WebDriverWait(driver, 3);
        return driver.findElement(By.id("accordion__panel-" + (accordionIdNumber))).getText();
    }

}


