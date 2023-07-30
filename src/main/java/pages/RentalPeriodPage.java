package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RentalPeriodPage {
    private WebDriver driver;

    //Поле ввода даты когда привезти самокат
    private final By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле c названием страници 'Про аренду'. Использую для того чтобы убрать окно с выбором даты
    private final By dropDatePiker = By.xpath(".//div[text() = 'Про аренду']");
    //Пикер срока аренды самоката
    private final By rentalPeriodDropDownField = By.xpath(".//div[text() = '* Срок аренды']");
    //Поле выбора цвета самоката
    private final By fieldColor = By.xpath(".//div[text() = 'Цвет самоката']");
    //Поле ввода комментария для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private final By orderConfirmationButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Заказать')]");
    //Кнопка подтверждения заказа
    private final By yesConfirmationButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g') and contains(text(), 'Да')]");

    //Заголовок всплывающего окна Заказ оформлен
    private final By orderPlaced = By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");

    //Конструктор класса
    public RentalPeriodPage(WebDriver driver){
        this.driver = driver;
    }

    // Выбор даты доставки
    public RentalPeriodPage writeDeliveryDate (String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        driver.findElement(dropDatePiker).click();
        return this;
    }

    //Выбор срока аренды
    public RentalPeriodPage selectRentalPeriod (String rentPeriod){
        driver.findElement(rentalPeriodDropDownField).click();
        driver.findElement(By.xpath(".//div[(@class='Dropdown-option' and text()='" + rentPeriod + "')]")).click();
        return this;
    }

    //Выбор цвета самоката
    public RentalPeriodPage selectColor(String color){
        driver.findElement(fieldColor).click();
        driver.findElement(By.xpath(".//label[@for='" + color + "']")).click();
        return this;
    }

    // Ввод коментария
    public RentalPeriodPage writeComment (String comment){
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }

    //Клик в кнопку "Заказать"
    public void clickOrderConfirmationButton(){
        driver.findElement(orderConfirmationButton).click();
    }

    //Клик в кнопку "Да"
    public void clickYesConfirmationButton(){
        driver.findElement(yesConfirmationButton).click();
    }

    // Ожидание заголовка Заказ оформлен
    public void waitOrderPlaced() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlaced));
    }

        //Метод ввода необходимых данных
    public void enterRentalData(String deliveryDate, String rentPeriod, String color, String comment){
        writeDeliveryDate(deliveryDate)
            .selectRentalPeriod(rentPeriod)
            .selectColor(color)
            .writeComment(comment)
            .clickOrderConfirmationButton();
            clickYesConfirmationButton();
            waitOrderPlaced();
        }

}