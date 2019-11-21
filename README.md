# Title
Hotel Search Test
# Introduction
The goal of this project is to execute test, which find hotels in given city on the website: [http://www.kurs-selenium.pl/demo/ ](http://www.kurs-selenium.pl/demo/) 
Test founds and send keys to applicable fields, then download results and compare them to expected ones. 
Project was created to perpetuate learning material from online course
# Technologies
Project is created with:
1. Java version 13.0.1
2. Apache Maven version 3.6.2
3. Selenium version 3.141.59
# Features
1. Waits for webelements
2. Uses asserts
3. Takes screenshot after the test 
# State of project
Project is compatible with basic principles. 
Opportunities for development:
Reading information from file
making screenshots only after test failures.
# Sources
This project is inspired by Udemy: "Kurs Selenium Java od podstaw"
[https://www.udemy.com/course/kurs-selenium-java](https://www.udemy.com/course/kurs-selenium-java)
# Details
### BaseClassTest
It Contains annotation @BeforeClass and @AfterClass, and initiates driver.
```
protected  WebDriver driver;

```
1. @BeforeClass contains method seUp, which set Chromedriver in project and opening, next maximizes browser window.
2. @AfterClass contains method tearDown which close the browser after the test.
### HomePage
Using annotation FindBy to find web elements and assigns them to variables in program. For example field to input city name 
```
@FindBy (xpath = "//span[text() = 'Search by Hotel or City Name']")
private WebElement searchSpan;
```
It contains methods using to send information in the right input. For example finds and completes check in date.
```
public void setCheckInDate(String arrivalDAte){
        CheckInDate.click();
        CheckInDate.sendKeys(arrivalDAte);
    }
```

### ResultPage
This class contains methods using to return names of the found hotels and their prices.
```
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
```
### HotelSearchTest
This class extends "BaseClassTest" and creates object of classes "HomePage" and "ResultPage". Moreover this is the class with @Test annotation. 
Using object driver mapped in BaseClassTest to get URL.
```
driver.get("http://www.kurs-selenium.pl/demo/");
```
Using object homePage to invoke methods.
```
homePage.setCityName("Dubai");
homePage.setCheckInDate("28/12/2019");
homePage.setCheckOutDate("30/12/2019");
homePage.setNumbersOfTravellers();
homePage.hitSearchButton();
```
Using asserts, this class equals:
1. Title of the result page
2. Names of hotels with prices, and compare them to expected data.

### SeleniumHelper
This class contains static method "TakeScreenshot" which are able to make screenshots. 
```
public static void takeScreenshot(WebDriver driver) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("src/main/resources/Screenshots/PHPTravelsTest" + LocalTime.now().getNano() + ".png");
            Files.copy(screenShotFile.toPath(), destinationFile.toPath());
        } catch (IOException e) {
            System.out.println("File not found.");
        }

    }
```
