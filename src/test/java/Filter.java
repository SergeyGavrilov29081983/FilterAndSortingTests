import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    /*   -бренд
   -цена
   -скидка
   -цвет
   -назначение
   -диагональ
   -тип матрицы
   -разрешение экрана
   -поверхность экрана
   -операционная система
   -линейка процессоров
   -количество ядер процессора
   -объем оперативной памяти
   -производитель видеопроцессора
   -видеоадаптер
   -объем памяти видеоадаптера
   -оптический привод
   -тип накопителя
   -объем накопителя HDD
   -объем накопителя SSD
   -доп. опции ноутбука
   -процессор*/

    public WebDriver driver;
    @FindBys({
            @FindBy(css = "#catalog-content > div.your-choice.i-your-choice > ul > li")
    })
    private List<WebElement> filter;


    @FindBy(id = "tBrandSearch")
    private WebElement tBrandSearch;


    @FindBys({
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_6.fbrand.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content.scroll-scrolly_visible > fieldset > label"),
    })
    private List<WebElement> brandBoxes = new ArrayList<>();

    @FindBy(name = "startN")
    private WebElement startN;

    @FindBy(name = "endN")
    private WebElement endN;

    @FindBy(css = "label.c-radio-withText-md:nth-child(1)")
    private WebElement stock;

    @FindAll({
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_2.fcolor.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content.scroll-scrollx_visible > fieldset > label:nth-child(2) > span"),
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_2.fcolor.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content.scroll-scrollx_visible > fieldset > label:nth-child(4) > span")
    })
    private List<WebElement> colours = new ArrayList<>();

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div[1]/div[5]/div[2]/div/div[1]/fieldset")
    private List<WebElement> appointment = new ArrayList<>();

    @FindBy(css = ".list_left_f4474")
    private List<WebElement> screenDiagonal = new ArrayList<>();

    @FindBy(css = ".list_left_f4346 > label:nth-child(4)")
    private List<WebElement> operatingSystem = new ArrayList<>();
    @FindAll({
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_1.f143560.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content > fieldset > label:nth-child(1)"),
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_1.f143560.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content > fieldset > label:nth-child(2)")

    })
    private List<WebElement> processorsType = new ArrayList<>();

    @FindAll({
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_1.f4710.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content > fieldset >label:nth-child(1)"),
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_1.f4710.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content > fieldset >label:nth-child(2)")
    })
    private List<WebElement> ram = new ArrayList<>();

    @FindAll({
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_1.f202872.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content > fieldset > label:nth-child(1)"),
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_1.f202872.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content > fieldset > label:nth-child(2)"),
            @FindBy(css = "#filterPanelLeft > div.filterblock.render_type_1.f202872.show.filter-active > div.i-scrollbar-in-filter > div > div.selectorsblock.custom-scroll.scrollbar-inner.scroll-content > fieldset > label:nth-child(3)")
    })
    private List<WebElement> ssd = new ArrayList<>();

    public Filter(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setBranText(String text) {
        tBrandSearch.sendKeys(text);
    }

    public List<WebElement> getBrandCheckboxes() {
        return brandBoxes;
    }

    public void activateCheckBox(WebElement elements) {
        elements.click();
    }

    public void ActivateStock() {
        stock.click();
    }

    public List<WebElement> getColours() {
        return colours;
    }

    public void setColour(WebElement colour) {
        colour.click();
    }

    public List<WebElement> getAppointment() {
        return appointment;
    }

    public void setAppointment(WebElement appointment) {
        appointment.click();
    }

    public List<WebElement> getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(WebElement screenDiagonal) {
        screenDiagonal.click();
    }

    public List<WebElement> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperationSystem(WebElement element) {
        element.click();
    }

    public List<WebElement> getProcessors() {
        return processorsType;
    }

    public void setProcessor(WebElement element) {
        element.click();
    }

    public List<WebElement> getRam() {
        return ram;
    }

    public void setRam(WebElement element) {
        element.click();
    }

    public List<WebElement> getSsd() {
        return ssd;
    }

    public void setSsdDisk(WebElement element) {
        element.click();
    }

    public List<WebElement> getFilter() {
        return filter;
    }
}
