package PHPTravelsSearchTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {



    @FindBy (xpath = "//span[text() = 'Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy (xpath = "//div[@id = 'select2-drop']//input")
    private WebElement inputCityName;

    @FindBy (xpath = "//div//span[@class = 'select2-match']")
    private WebElement resultLabel;

    @FindBy (xpath = "//div[@id = 'dpd1']//input")
    private WebElement CheckInDate;

    @FindBy (xpath = "//div[@id = 'dpd2']//input")
    private WebElement CheckOutDate;

    @FindBy (id = "travellersInput")
    private WebElement travellersInput;

    @FindBy (id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy (id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy (xpath = "//button[text() = ' Search']")
    private WebElement searchButton;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setCityName(String cityName)  {
        searchSpan.click();
        inputCityName.sendKeys(cityName);
        resultLabel.click();
    }

    public void setCheckInDate(String arrivalDAte){
        CheckInDate.click();
        CheckInDate.sendKeys(arrivalDAte);
    }

    public void setCheckOutDate(String departureDate) {
        CheckOutDate.click();
        CheckOutDate.sendKeys(departureDate);
    }

    public void setNumbersOfTravellers() {
        travellersInput.click();
        adultPlusBtn.click();
        childPlusBtn.click();
    }

    public void hitSearchButton(){
        searchButton.click();
    }
}
