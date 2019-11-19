package PHPTravelsSearchTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@class = 'bgwhite table table-striped']")
    private WebElement table;

    public List<String> getHotelNames(){
        List<String> hotelNames = new ArrayList<>();
        List<WebElement> hotelNameWebElements = table.findElements(By.xpath("//h4//b"));
        for(WebElement hotelNameWebElement : hotelNameWebElements){
            System.out.println(hotelNameWebElement.getText());
            hotelNames.add(hotelNameWebElement.getText());
        }
        return hotelNames;
    }

    public List<String> getHotelPrices(){
        List<String> hotelPrices = new ArrayList<>();
        List<WebElement> hotelPriceWebElements = table.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        for(WebElement hotelPriceWebElement : hotelPriceWebElements) {
            System.out.println(hotelPriceWebElement.getText());
            hotelPrices.add(hotelPriceWebElement.getText());
        }
        return hotelPrices;
    }
}
