import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class FirstTest {
    @Test
    public void testGoogleSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Apple");
        searchBox.submit();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String title = driver.getTitle();
        assertTrue(title.contains("Apple"));
        List<WebElement> images = driver.findElements(By.className("hide-focus-ring"));
        WebElement image = images.get(1);
        image.click();
        System.out.println(image.getCssValue("left"));
      //  assertTrue(images.get(1).getAttribute("border-bottom").contains("solid"));

    }
}
