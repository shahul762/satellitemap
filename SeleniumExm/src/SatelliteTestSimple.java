import java.io.File;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class SatelliteTestSimple {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

        try {
            driver.manage().window().maximize();
            driver.get("https://satellitemap.space/");
            Thread.sleep(4000); 

            WebElement canvas = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("canvas")));

            actions.moveToElement(canvas).clickAndHold().moveByOffset(-150, 0).pause(Duration.ofSeconds(1)).release().perform();
            Thread.sleep(2000);
            takeScreenshot(driver, "rotate_globe");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 19; i++) {
                js.executeScript("document.querySelector('canvas').dispatchEvent(new WheelEvent('wheel', {deltaY: -100}));");
                Thread.sleep(500);
            }
            takeScreenshot(driver, "zoom_in");


            actions.moveToElement(canvas, 100, 50).click().perform();
            Thread.sleep(3000);
            takeScreenshot(driver, "satellite_info_orbit");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Users\\HP\\eclipse-workspace\\SeleniumExm\\Screenshots", fileName + ".png");
            Files.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
