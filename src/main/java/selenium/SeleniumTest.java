package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Pablo.Rodriguez on 22-09-2017.
 */
public class SeleniumTest {
    private static HashMap<String, String> soDrivers = new HashMap<>();
    private static String phrase = "iphone";

    public static void main(String[] args) {
        soDrivers.put("Windows", "src/main/resources/chromedriver_win.exe");
        soDrivers.put("Linux", "src/main/resources/chromedriver_linux");
        soDrivers.put("MacOS", "src/main/resources/chromedriver_mac");
        // Set the proper driver for a OS
        // download the proper chrome driver https://sites.google.com/a/chromium.org/chromedriver/downloads
        System.setProperty("webdriver.chrome.driver", soDrivers.get(System.getProperty("os.name")));
        // use browser chrome for testing
        ChromeDriver driver=new ChromeDriver();
        //Visit the page
        driver.get("https://www.mercadolibre.cl/");
        //Send text to a text box
        driver.findElement(By.xpath("//html/body/header/div/form/input")).sendKeys("iphone");
        // click in the search button
        driver.findElement(By.xpath("//html/body/header/div/form/button[3]")).click();
        // Get all the phones in the results
        List<WebElement> phones = driver.findElements(By.xpath("//li[contains(@class, 'results-item')]"));
        System.out.println("Total results for searching " + phrase + " " + phones.size());
        // Get the first phone
        WebElement firstPhone = phones.get(0);
        // Click in the first result
        firstPhone.findElement(By.xpath("//div/h2/a")).click();

        driver.close();
    }
}
