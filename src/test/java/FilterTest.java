import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterTest {

    public static Filter filter;
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Config.getProperty("driver"));
        driver = new ChromeDriver();
        filter = new Filter(driver);
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getProperty("page"));
    }

    @Test
    public void brandTextTest() {
        filter.setBranText("Asus");
        List<WebElement> elements = filter.getBrandCheckboxes();
        String[] text = elements.get(0).getText().split(" ");
        Assertions.assertEquals(10, elements.size());
        Assertions.assertEquals("Acer", text[0]);
    }

    @Test
    public void activateCheckBoxTest() {
        List<WebElement> checkBoxes = filter.getBrandCheckboxes();
        filter.activateCheckBox(checkBoxes.get(0));
        String currentUrl = driver.getCurrentUrl();
        String[] cols = currentUrl.split("=");
        String col = "3859";
        String[] name = checkBoxes.get(0).getText().split("\\(");
        assertEquals(col, cols[1]);
        assertEquals("Acer", name[0].trim());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement el = driver.findElement(By.cssSelector("#catalog-content > div.catalog_main_table.j-products-container > div:nth-child(1) > div.dtList-inner > a > div.dtlist-inner-brand > div.dtlist-inner-brand-name > strong"));
        String[] elName = el.getText().split(" ");
        assertEquals("Acer", elName[0].trim());
        asFilters("Acer");
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("Acer", filters.get(0).getText());
    }

    @Test
    public void activateSomeCheckBoxTest() {
        List<WebElement> checkBoxes = filter.getBrandCheckboxes();
        filter.activateCheckBox(checkBoxes.get(0));
        filter.activateCheckBox(checkBoxes.get(1));
        String currentUrl = driver.getCurrentUrl();
        String[] cols = currentUrl.split("//?");
        Assertions.assertEquals("fbrand=3859;40305", driver.getCurrentUrl().split("\\?")[1]);
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("Acer", filters.get(0).getText());
        Assertions.assertEquals("Alienware", filters.get(1).getText());
    }

    @Test
    public void ActivateStockTest() {
        filter.ActivateStock();
        String currentUrl = driver.getCurrentUrl();
        String[] discounts = currentUrl.split("\\?");
        String discount = "discount=10";
        assertEquals(discount, discounts[1]);
    }

    @Test
    public void setColourTest() {
        List<WebElement> colours = filter.getColours();
        filter.setColour(colours.get(0));
        String currentUrl = driver.getCurrentUrl();
        String[] cols = currentUrl.split("=");
        String col = "16777215";
        assertEquals(col, cols[1]);
        WebElement button = driver.findElement(By.cssSelector("#c13253208"));
        button.click();
        driver.navigate().to("https://www.wildberries.ru/catalog/13253208/detail.aspx?targetUrl=GP");
        WebElement element2 = driver.findElement(By.cssSelector("#container > div.product-content-v1 > div:nth-child(6) > div.card-right > div.color.j-color-name-container > span"));
        Assertions.assertEquals("белый", element2.getText().trim());
    }

    @Test
    public void appointmentTest() {
        WebElement label = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[1]/div[5]/div[2]/div/div[1]/fieldset/label[2]"));
        List<WebElement> appointment = filter.getAppointment();
        filter.setAppointment(appointment.get(0));
        String[] split = label.getText().split("\\(");
        Assertions.assertEquals(1, appointment.size());
        Assertions.assertEquals("для дома", split[0].trim());
        String currentUrl = driver.getCurrentUrl();
        String[] category = currentUrl.split("=");
        String url = "207428";
        Assertions.assertEquals(url, category[1]);

    }

    @Test
    public void screenDiagonalTest() {
        List<WebElement> screenDiagonal = filter.getScreenDiagonal();
        filter.setScreenDiagonal(screenDiagonal.get(0));
        Assertions.assertEquals(1, screenDiagonal.size());
        String currentUrl = driver.getCurrentUrl();
        String[] category = currentUrl.split("=");
        String url = "239349";
        Assertions.assertEquals(url, category[1]);
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("13.5\"", filters.get(0).getText());

    }

    @Test
    public void operationSystemTest() {
        List<WebElement> operationSystems = filter.getOperatingSystem();
        filter.setOperationSystem(operationSystems.get(0));
        Assertions.assertEquals(1, operationSystems.size());
        String currentUrl = driver.getCurrentUrl();
        String[] category = currentUrl.split("=");
        String url = "98636";
        Assertions.assertEquals(url, category[1]);
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("macOS", filters.get(0).getText());
    }

    @Test
    public void processorTest() {
        List<WebElement> processors = filter.getProcessors();
        filter.setProcessor(processors.get(0));
        Assertions.assertEquals(2, processors.size());
        String currentUrl = driver.getCurrentUrl();
        String[] category = currentUrl.split("=");
        String url = "143566";
        Assertions.assertEquals(url, category[1]);
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("AMD Athlon", filters.get(0).getText());
    }

    @Test
    public void ramTest() {
        List<WebElement> rams = filter.getRam();
        filter.setRam(rams.get(0));
        Assertions.assertEquals(2, rams.size());
        String currentUrl = driver.getCurrentUrl();
        String[] category = currentUrl.split("=");
        String url = "14213";
        Assertions.assertEquals(url, category[1]);
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("4 ГБ", filters.get(0).getText());
    }

    @Test
    public void ssdTest() {
        List<WebElement> disks = filter.getSsd();
        filter.setSsdDisk(disks.get(1));
        Assertions.assertEquals(3, disks.size());
        String currentUrl = driver.getCurrentUrl();
        String[] category = currentUrl.split("=");
        String url = "202880";
        Assertions.assertEquals(url, category[1]);
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("16 Гб", filters.get(0).getText());
    }

    @Test
    public void multipleFilter() {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        List<WebElement> checkBoxes = filter.getBrandCheckboxes();
        filter.activateCheckBox(checkBoxes.get(0));
        List<WebElement> disks = filter.getSsd();
        filter.setSsdDisk(disks.get(2));
        String currentUrl = driver.getCurrentUrl();
        String[] text = currentUrl.split("\\?");
        Assertions.assertEquals("fbrand=3859&f202872=202879", text[1].trim());
        List<WebElement> filters = filter.getFilter();
        Assertions.assertEquals("Acer", filters.get(0).getText());
        Assertions.assertEquals("128 Гб", filters.get(1).getText());
    }

    @Test
    public void rejectFilter() {
        List<WebElement> colours = filter.getColours();
        filter.setColour(colours.get(0));
        String currentUrl = driver.getCurrentUrl();
        String[] cols = currentUrl.split("=");
        String col = "16777215";
        assertEquals(col, cols[1]);
        WebElement reject = driver.findElement(By.cssSelector("#filterPanelLeft > div.filterblock.render_type_2.fcolor.show.filter-active > div.filter-title > span.reset.show"));
        reject.click();
        Assertions.assertEquals(Config.getProperty("page"), driver.getCurrentUrl());
    }

    private void asFilters(String actual){
        List<WebElement> filters = filter.getFilter();
        if (filters != null && !filters.isEmpty()) {
            for (WebElement element : filters) {
                Assertions.assertEquals(actual, element.getText());
            }
        }
    }

    @After
    public void close() {
        driver.quit();
    }

}
