import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sort {

    public WebDriver driver;

    @FindBy(id = "popular")
    private WebElement sortByPopular;
    @FindBy(id = "rate")
    private WebElement sortByRate;
    @FindBy(id = "price")
    private WebElement sortByPrice;
    @FindBy(id = "sale")
    private WebElement sortBySale;
    @FindBy(id = "newly")
    private WebElement sortByNewly;

    public Sort(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setSort(WebElement element) {
        element.click();
    }

    public WebElement getSortByPopular() {
        return sortByPopular;
    }

    public WebElement getSortByRate() {
        return sortByRate;
    }

    public WebElement getSortByPrice() {
        return sortByPrice;
    }

    public WebElement getSortBySale() {
        return sortBySale;
    }

    public WebElement getSortByNewly() {
        return sortByNewly;
    }
}
