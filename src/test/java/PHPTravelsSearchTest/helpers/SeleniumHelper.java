package PHPTravelsSearchTest.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalTime;


public class SeleniumHelper {

    private WebDriver driver;

    /*public SeleniumHelper(WebDriver newDriver) {

        this.driver = newDriver;
    }

     */

    public static void takeScreenshot(WebDriver driver) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("src/main/resources/Screenshots/PHPTravelsTest" + LocalTime.now().getNano() + ".png");
            Files.copy(screenShotFile.toPath(), destinationFile.toPath());
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku.");
        }

    }
}


