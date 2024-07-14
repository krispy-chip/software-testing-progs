package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class FirstTestClass {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox.sendKeys("adidas Superstar");
        searchBox.submit();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shoeLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item4062a70ceb\"]/div/div[1]/div/a/div/img")));
        shoeLink.click();

        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();

        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }

        WebElement selectSizeDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"x-msku__select-box-1000\"]")));
        selectSizeDropdown.click();

        WebElement selectSizeOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"x-msku__option-box-4\"]")));
        selectSizeOption.click();

        WebElement buyButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"binBtn_btn_1\"]/span/span")));
        buyButton.click();

        // Optionally, you can add driver.quit() at the end to close the browser
        // driver.quit();
    }
}
