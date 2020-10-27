import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {

    public static Sort sort;
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Config.getProperty("driver"));
        driver = new ChromeDriver();
        sort = new Sort(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getProperty("page"));
    }

    @Test
    public void sortByPopularTest() {
        sort.setSort(sort.getSortByPopular());
        String currentUrl = driver.getCurrentUrl();
        String[] sorting = currentUrl.split("=");
        String popular = "popular";
        assertEquals(popular, sorting[1]);
    }

    @Test
    public void sortByRateTest() {
        sort.setSort(sort.getSortByRate());
        String currentUrl = driver.getCurrentUrl();
        String[] sorting = currentUrl.split("=");
        String rate = "rate";
        assertEquals(rate, sorting[1]);
    }

    @Test
    public void sortByPriceUpTest() {
        sort.setSort(sort.getSortByPrice());
        String currentUrlUp = driver.getCurrentUrl();
        String[] sortingUp = currentUrlUp.split("=");
        String priceUp = "priceup";
        assertEquals(priceUp, sortingUp[1]);
    }

    @Test
    public void sortByPriceDownTest() {
        driver.get("https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki?sort=priceup");
        sort.setSort(sort.getSortByPrice());
        String currentUrlUp = driver.getCurrentUrl();
        String[] sortingDown = currentUrlUp.split("=");
        String priceDown = "pricedown";
        assertEquals(priceDown, sortingDown[1]);
    }

    @Test
    public void sortBySaleTest() {
        sort.setSort(sort.getSortBySale());
        String currentUrl = driver.getCurrentUrl();
        String[] sorting = currentUrl.split("=");
        String popular = "sale";
        assertEquals(popular, sorting[1]);
    }

    @Test
    public void sortByNewlyTest() {
        sort.setSort(sort.getSortByNewly());
        String currentUrl = driver.getCurrentUrl();
        String[] sorting = currentUrl.split("=");
        String popular = "newly";
        assertEquals(popular, sorting[1]);
    }

    @After
    public void close() {
        driver.quit();
    }
}

