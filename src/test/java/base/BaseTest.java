package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public abstract class BaseTest {

    protected  WebDriver driver;
    protected WebDriverWait wait;

    protected BaseTest (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BaseTest() {

    }



    @BeforeMethod
    public void setUp() {
        startDriver();
        openHomePage();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

    /* ================= helpers ================= */

    private void startDriver() {
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().window().maximize();
    }

    private void openHomePage() {
        driver.get(TestConfig.get("automationStore.url"));
    }

}
