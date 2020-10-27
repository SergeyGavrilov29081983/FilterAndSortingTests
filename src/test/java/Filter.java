import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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


    @FindBy(css = ".list_left_fbrand")
    List<WebElement> checkboxes = new ArrayList<WebElement>();


    public Filter(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    public void activateCheckBox(WebElement element) {

    }
}
