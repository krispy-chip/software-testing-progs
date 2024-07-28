package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class FirstTestClass {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Click on the sign-in link
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gh-ug\"]/a")));
        signInButton.click();
        
        // Enter initial email
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userid\"]")));
        emailField.sendKeys("rajiv123@gmail.com");

        // Click on the continue button
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signin-continue-btn\"]")));
        continueButton.click();
        
        // Insert a 4-second wait
        Thread.sleep(2000);

        emailField.clear();
        // Clear the email field and enter new email
        emailField.clear(); // Clear the previous email
        Thread.sleep(2000);
        emailField.sendKeys("surajtharun123@gmail.com");

        // Click on the continue button again
        continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signin-continue-btn\"]")));
        continueButton.click();

        // Wait for the password field to be clickable and enter the password
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
        passwordField.click(); // Click on the password field
        passwordField.sendKeys("Krispy07."); // Enter the password
        
        // Click on the sign-in button
        WebElement signInSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sgnBt\"]")));
        signInSubmitButton.click();
        
        // Handle passkeys cancel button if it appears
        try {
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passkeys-cancel-btn\"]")));
            cancelButton.click();
        } catch (Exception e) {
            System.out.println("Passkeys cancel button not found or clickable.");
        }
        
        // Perform search for "adidas superstar"
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gh-ac\"]")));
        searchBox.sendKeys("adidas superstar");
        
        // Click on the search button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gh-btn\"]")));
        searchButton.click();
        
        // Click on the adidas superstar product
        WebElement adidasSuperstarProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item4062a70ceb\"]/div/div[1]/div/a/div/img")));
        adidasSuperstarProduct.click();
        
        // Switch to the new window opened
        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();

        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
        
        // Select size from dropdown
        WebElement selectSizeDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn__cell")));
        selectSizeDropdown.click();

        // Add this code to select size 9
        WebElement size9Option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option']//span[contains(text(), '9')]")));
        size9Option.click();

        // Add to cart
        WebElement cartButton1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"atcBtn_btn_1\"]/span/span")));
        cartButton1.click();
        
        driver.close();
        
        driver.switchTo().window(mainPage);
        
        WebElement searchBox3 = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox3.clear();  // Clear the search box
        searchBox3.sendKeys("samsung s21 ultra");
        searchBox3.submit();
        
        // Wait for search results and click on apple ipad pro link
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement samsung = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item3b6063c307\"]/div/div[1]/div/a/div/img")));
        samsung.click();

        // Switch to the new tab opened by the apple link click
        allPages = driver.getWindowHandles();
        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
       
        WebElement selectcolor1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn__cell")));
        selectcolor1.click();

        // Add this code to select color
        WebElement phantomBlackOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option' and contains(@class, 'listbox__option')]//span[contains(text(), 'Phantom Black')]")));
        phantomBlackOption.click();

        // Add apple ipad pro to cart
        WebElement cartButton3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"atcBtn_btn_1\"]")));
        cartButton3.click();
        
        driver.close();
        
        driver.switchTo().window(mainPage);
        
        WebElement searchBox4 = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox4.clear();  // Clear the search box
        searchBox4.sendKeys("iphone 11 pro");
        searchBox4.submit();
        
        // Wait for search results and click on apple ipad pro link
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iphone = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item44851fcfb7\"]/div/div[1]/div/a/div/img")));
        iphone.click();

        // Switch to the new tab opened by the apple link click
        allPages = driver.getWindowHandles();
        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
        
        WebElement selectcolor2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn__cell")));
        selectcolor2.click();

        // Add this code to select color
        WebElement goldOption1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option' and @class='listbox__option']//span[contains(text(), 'Gold')]")));
        goldOption1.click();

        // Add apple ipad pro to cart
        WebElement cartButton4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"atcBtn_btn_1\"]")));
        cartButton4.click();
        
        // Perform auto-scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)");
        
        WebElement removeitem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div[1]/div[2]/ul/li/div/div/div/div[2]/span[2]/button")));
        removeitem.click();
       
        
        WebElement quant = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dropdown-648896175-927bbc49-1763-4b10-b630-047e565b3c98")));
        quant.click();

        WebElement quantityOption2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='dropdown-648896175-94b3d4c0-a4f2-4f25-b254-8cf5c9c0cd28']/option[@value='2']")));
        quantityOption2.click();

    }
}
