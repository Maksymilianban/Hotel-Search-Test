package PHPTravelsSearchTest.Tests;

import PHPTravelsSearchTest.Pages.HomePage;
import PHPTravelsSearchTest.Pages.ResultPage;
import PHPTravelsSearchTest.helpers.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;


public class hotelSearchTest extends BaseClassTest {

    protected String expectedTitle = "Search Results";

    @Test
    public void hotelSearchTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = new ResultPage(driver);
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

        homePage.setCityName("Dubai");
        homePage.setCheckInDate("28/12/2019");
        homePage.setCheckOutDate("30/12/2019");
        homePage.setNumbersOfTravellers();
        homePage.hitSearchButton();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(), expectedTitle);

        List<String> hotelNames = resultPage.getHotelNames();
        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");

        List<String> hotelPrices = resultPage.getHotelPrices();
        Assert.assertEquals(hotelPrices.get(0), "€20.24");
        Assert.assertEquals(hotelPrices.get(1), "€46");
        Assert.assertEquals(hotelPrices.get(2), "€73.60");
        Assert.assertEquals(hotelPrices.get(3), "€138");

        SeleniumHelper.takeScreenshot(driver);
    }
}
