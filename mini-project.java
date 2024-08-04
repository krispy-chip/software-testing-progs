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
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("https://www.ebay.com/");
        System.out.println("Now the website of eBay is opened");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(7000);
        
        // Click on Sign-In button
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gh-ug\"]/a")));
        signInButton.click();
        System.out.println("Clicked on Sign-In button");
        Thread.sleep(7000);
        
        // Enter email and click continue
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userid\"]")));
        emailField.sendKeys("rajiv123@gmail.com");
        System.out.println("Entered email: rajiv123@gmail.com");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signin-continue-btn\"]")));
        continueButton.click();
        System.out.println("Clicked on Continue button");
        
        // Insert a 4-second wait
        Thread.sleep(7000);

        // Clear email field and enter new email
        emailField.clear();
        Thread.sleep(2000);
        emailField.sendKeys("surajtharun123@gmail.com");
        System.out.println("Entered new email: surajtharun123@gmail.com");

        continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signin-continue-btn\"]")));
        continueButton.click();
        System.out.println("Clicked on Continue button");

        // Enter password and sign in
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
        passwordField.click();
        passwordField.sendKeys("Krispy07.");
        WebElement signInSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sgnBt\"]")));
        signInSubmitButton.click();
        System.out.println("Entered password and clicked Sign In button");
        
        Thread.sleep(5000);
        
        // Handle passkeys cancel button if it appears
        try {
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passkeys-cancel-btn\"]")));
            cancelButton.click();
            System.out.println("Clicked on Passkeys cancel button");
        } catch (Exception e) {
            System.out.println("Passkeys cancel button not found or clickable.");
        }
        Thread.sleep(3000);
        
        // Search for "adidas superstar"
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gh-ac\"]")));
        searchBox.sendKeys("adidas superstar");
        System.out.println("Entered 'adidas superstar' into search box");
        
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gh-btn\"]")));
        searchButton.click();
        System.out.println("Clicked on Search button");
        Thread.sleep(5000);
        
        // Click on adidas superstar product
        WebElement adidasSuperstarProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item4062a70ceb\"]/div/div[1]/div/a/div/img")));
        adidasSuperstarProduct.click();
        System.out.println("Clicked on adidas Superstar product");

        // Switch to the new window opened
        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();

        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
        Thread.sleep(5000);
        
        // Select size from dropdown
        WebElement selectSizeDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn__cell")));
        selectSizeDropdown.click();
        System.out.println("Clicked on Select Size dropdown");
        Thread.sleep(5000);
        
        WebElement size9Option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option']//span[contains(text(), '13')]")));
        size9Option.click();
        System.out.println("Selected size 9");

        // Add to cart
        WebElement cartButton1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"atcBtn_btn_1\"]/span/span")));
        cartButton1.click();
        System.out.println("Added item to cart");
        
        driver.close();
        System.out.println("Closed the current tab");
        
        driver.switchTo().window(mainPage);
        Thread.sleep(5000);
        
        // Search for "samsung s21 ultra"
        WebElement searchBox3 = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox3.clear();  
        searchBox3.sendKeys("samsung s21 ultra");
        searchBox3.submit();
        System.out.println("Searched for 'samsung s21 ultra'");
        Thread.sleep(4000);
        
        // Scroll down and click on Samsung product
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js1.executeScript("window.scrollBy(0, 405)");
            Thread.sleep(100);  
        }
        Thread.sleep(2000);
        
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement samsung = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item4056ea708d\"]/div/div[1]/div/a/div/img")));
        samsung.click();
        System.out.println("Clicked on Samsung product");

        // Switch to the new tab opened by the Samsung product click
        allPages = driver.getWindowHandles();
        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
        
        // Add to cart
        Thread.sleep(3000);
        WebElement cartButton3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"atcBtn_btn_1\"]")));
        cartButton3.click();
        System.out.println("Added Samsung product to cart");
        
        driver.close();
        System.out.println("Closed the current tab");
        
        driver.switchTo().window(mainPage);
        Thread.sleep(3000);
        
        // Search for "iphone 11 pro"
        WebElement searchBox4 = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox4.clear();  
        searchBox4.sendKeys("iphone 11 pro");
        searchBox4.submit();
        System.out.println("Searched for 'iphone 11 pro'");
        Thread.sleep(4000);
        
        // Click on iPhone 11 Pro product
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iphone = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item44851fcfb7\"]/div/div[1]/div/a/div/img")));
        iphone.click();
        System.out.println("Clicked on iPhone 11 Pro product");

        // Switch to the new tab opened by the iPhone 11 Pro product click
        allPages = driver.getWindowHandles();
        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
        Thread.sleep(4000);
        
        // Select color and add to cart
        WebElement selectcolor2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn__cell")));
        selectcolor2.click();
        System.out.println("Clicked on Select Color dropdown");
        Thread.sleep(4000);
        
        WebElement goldOption1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option' and @class='listbox__option']//span[contains(text(), 'Green')]")));
        goldOption1.click();
        System.out.println("Selected color Green");
        Thread.sleep(2000);
        
        WebElement cartButton4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"atcBtn_btn_1\"]")));
        cartButton4.click();
        System.out.println("Added iPhone 11 Pro to cart");
        Thread.sleep(4000);
        
        // Remove item from cart
        WebElement removeitem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/div[1]/div[2]/ul/li/div/div/div/div[2]/span[2]/button")));
        removeitem.click();
        System.out.println("Removed item from cart");
        Thread.sleep(4000);
        
        // Proceed to checkout
        driver.findElement(By.xpath("//*[@id=\"gh-p-1\"]/a")).click();
        System.out.println("Clicked on Cart icon");
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//*[@id=\"refit-spf-container\"]/div[2]/div[2]/div[1]/div/div/div[1]/a/div/img")).click();
        System.out.println("Clicked on Checkout button");
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//*[@id=\"atcBtn_btn_1\"]/span")).click();
        System.out.println("Clicked on Add to Cart button");
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//button[@data-test-id='cta-top']")).click();
        System.out.println("Clicked on Proceed to Checkout button");
        Thread.sleep(4000);

        // Enter payment details
        driver.findElement(By.id("selectable-render-summary4")).click();
        System.out.println("Selected payment method");
        Thread.sleep(4000);
        
        driver.findElement(By.id("cardNumber")).sendKeys("4678940072509102");
        System.out.println("Entered card number");
        
        driver.findElement(By.id("cardExpiryDate")).sendKeys("7/26");
        System.out.println("Entered expiration date");
        
        driver.findElement(By.id("securityCode")).sendKeys("293");
        System.out.println("Entered security code");
        
        driver.findElement(By.xpath("//button[@data-test-id='ADD_CARD']")).click();
        System.out.println("Clicked on Add Card button");

        driver.quit();
        System.out.println("Browser closed and test completed");
    }
}
