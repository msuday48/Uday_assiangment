package webdriver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AmazonAutomation {
    public static void main(String[] args) throws InterruptedException {
        
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser window to full screen
        driver.manage().window().maximize();

        // Navigate to Amazon India
        driver.get("https://www.amazon.in/");

        // --- Step 1: Search for "Wrist Watches" ---
        
        // Locate the search box using XPath and input the search term
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Wrist Watches");  // Type the search term into the search box
        searchBox.submit();  // Submit the search

        // Wait until the page is loaded and the search results are displayed (Leather filter option appears)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Leather']")));

        // --- Step 2: Apply Filters (Leather and Fastrack brand) ---

        // Create an instance of JavascriptExecutor to scroll the page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the page until the Leather filter option is visible
        WebElement Leatherfilter = driver.findElement(By.xpath("//li[@id='p_n_material_browse/1480907031']//label"));
        js.executeScript("arguments[0].scrollIntoView();", Leatherfilter);  // Scroll to Leather filter element
        Leatherfilter.click();  // Click the Leather filter

        // Scroll the page until the Fastrack filter option is visible
        WebElement Fastrackfilter = driver.findElement(By.xpath("//li[@id='p_123/230542']//i[@class='a-icon a-icon-checkbox']"));
        js.executeScript("arguments[0].scrollIntoView();", Fastrackfilter);  // Scroll to Fastrack filter element
        Fastrackfilter.click();  // Click the Fastrack filter

        // Wait until the page loads and the Fastrack filter is applied
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='a-size-base a-color-base a-text-bold'][normalize-space()='Fastrack'])[1]")));

     // Scroll the page until the next page  option is visible
        WebElement nextpage = driver.findElement(By.xpath("//a[@aria-label='Go to next page, page 2']"));
        js.executeScript("arguments[0].scrollIntoView();", nextpage);  // 
        
        Thread.sleep(3000);        // --- Step 3: Select a Product ---
        
        nextpage.click();
      
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

     // Wait until the product image is clickable and then click it
     WebElement Product_selections = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_49']//span[@class='a-size-base-plus a-color-base a-text-normal']")));
     Product_selections.click();
         
        // --- Step 4: Handle Multiple Windows (Switch to new tab) ---

        // Store the current window handle (main window)
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();  // Get all window handles

        // Switch to the new window (if different from the main window)
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);  // Switch to the new tab
            }
        }

        // --- Step 5: Add the Product to Cart ---

        // Wait until the "Add to Cart" button becomes visible
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));

        // Locate the "Add to Cart" button and click it
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // --- Step 6: Handle the Protection Plan Popup (if appears) ---

        try {
            // Wait for the protection plan popup to appear
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='attachSiAddCoverage']//input[@type='submit']")));

            // Click the "Skip" button to dismiss the protection plan popup
            WebElement skipButton = driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']"));
            skipButton.click();
        } catch (Exception e) {
            // If no popup appears, continue without interruption
            System.out.println("No protection plan popup appeared.");
        }

        // --- Step 7: Verify that the Product is Added to Cart ---

        try {
            // Wait until the "Added to Cart" confirmation message appears
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Added to Cart')]")));
            
            // Locate the "Added to Cart" confirmation message
            WebElement confirmationMessage = driver.findElement(By.xpath("//h1[contains(text(),'Added to Cart')]"));
            String confirmationText = confirmationMessage.getText();

            // Validate the confirmation text
            if (confirmationText.equals("Added to Cart")) {
                System.out.println("Test Passed: Fastrack watch successfully added to the cart.");
            } else {
                System.out.println("Test Failed: Fastrack watch was not added to the cart.");
            }
        } catch (Exception e) {
            // Handle cases where the confirmation message is not found
            System.out.println("Test : 'Added to Cart' message  found.");
        }

        // --- Step 8: Close the Browser ---
         // Close all browser windows and end the session
    }
}
