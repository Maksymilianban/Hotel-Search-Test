package PHPTravelsSearchTest.Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClassTest  {

    protected  WebDriver driver;

    @BeforeClass
    public void setUp() {
        String driverPack = ("C:\\Users\\Maks\\IdeaProjects\\PHPTravelsTest\\src\\main\\resources\\Drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driverPack);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

