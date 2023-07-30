package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    //Поле ввода имени
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода адреса куда везти
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Пикер выбора станции
    private final By metroField = By.xpath(".//div[@class='select-search']");
    //Поле ввода телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextPageButton = By.xpath(".//button[text()='Далее']");


    //Конструктор класса
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод значения в поле "Имя"
    public OrderPage writeName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    //Ввод значения в поле "Фамилия"
    public OrderPage writeSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }
    //Ввод значения в поле "Адрес"
    public OrderPage writeAddress(String address){
        driver.findElement(addressField).sendKeys(address);
        return this;
    }
    //Ввод значения в поле "Станция метро"
    public OrderPage selectMetro(String metro){
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//ul[@class='select-search__options']/li//div[text()='" + metro + "']/parent::button")).click();
        return this;
    }
    //Ввод значения в поле "Номер телефона"
    public OrderPage writePhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }
    //Клик в кнопку "Далее"
    public void clickNextPageButton(){
        driver.findElement(nextPageButton).click();
    }

    //Метод ввода данных необходимых для заказа
    public void enterOrderData(String name, String surname, String address, String metro, String phoneNumber){
        writeName(name)
        .writeSurname(surname)
        .writeAddress(address)
        .selectMetro(metro)
        .writePhoneNumber(phoneNumber)
        .clickNextPageButton();
    }

}