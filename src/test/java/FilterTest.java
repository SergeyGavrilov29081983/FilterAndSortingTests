import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FilterTest {

    public static Filter filter;
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Config.getProperty("driver"));
        driver = new ChromeDriver();
        filter = new Filter(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getProperty("page"));
    }

    @Test
    public void activateCheckBox() {
       filter.activateCheckBox(filter.getAcerNotebooks());
    }

    @Test
    public void activateCheckBox1() {
        filter.activateCheckBox(filter.getCheckBox1());
    }
}
