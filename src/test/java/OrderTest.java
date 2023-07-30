import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;
import pages.OrderPage;
import pages.RentalPeriodPage;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentPeriod;
    private final String color;
    private final String comment;
    public OrderTest(String name, String surname, String address, String metro, String phoneNumber, String deliveryDate, String rentPeriod, String color, String comment){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentPeriod = rentPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] orderData(){
        return new Object[][]{
                {"Михаил","Казаков","ул.Малинина, дом 30", "Лубянка","+77777777777", "05.08.2023", "трое суток", "black", "123"},
                {"Петр","Сергеевич","ул. Академика Байкова, дом 4", "Черкизовская","98765432101", "25.08.2023", "сутки", "grey", "Жду!"},
        };
    }
    @Test
    public void createOrderHeader(){

        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        RentalPeriodPage rentalPeriodPage = new RentalPeriodPage(driver);

        homePage.clickCookieAcceptButton();
        homePage.clickHeaderOrderButton();
        orderPage.enterOrderData(name, surname, address, metro, phoneNumber);
        rentalPeriodPage.enterRentalData(deliveryDate, rentPeriod, color, comment);
    }

    @Test
    public void createOrderInPage(){

        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        RentalPeriodPage rentalPeriodPage = new RentalPeriodPage(driver);

        homePage.clickCookieAcceptButton();
        homePage.clickInPageOrderButton();
        orderPage.enterOrderData(name, surname, address, metro, phoneNumber);
        rentalPeriodPage.enterRentalData(deliveryDate, rentPeriod, color, comment);
    }

}