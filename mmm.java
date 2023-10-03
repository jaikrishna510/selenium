package lmn;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class mmm {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10); // Increased the wait time to 10 seconds for stability
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("YouTube");
        searchBox.submit();
        WebElement youtubeLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("YouTube")));
        youtubeLink.click();

        WebElement searchInput = driver.findElement(By.name("search_query"));
        searchInput.sendKeys("sports");
        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();

        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ytd-video-renderer")));
        System.out.println("The number of results is: " + results.size());

        for (WebElement result : results) {
            WebElement title = result.findElement(By.id("video-title"));
            System.out.println(title.getText());
            if (title.getText().toLowerCase().contains("sports") || title.getText().toLowerCase().contains("sport")) {
                System.out.println("The result is relevant");
            } else {
                System.out.println("The result is not relevant");
            }
        }

        WebElement menuButton = driver.findElement(By.id("guide-icon"));
        menuButton.click();

        // Wait for some time to ensure the menu items load (you may need to adjust the wait time)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fetch and print specific menu items (e.g., "Trending" and "Home")
        List<WebElement> menuItems = driver.findElements(By.xpath("//yt-formatted-string"));
        System.out.println("The menu items in YouTube are:");
        for (WebElement menuItem : menuItems) {
            String itemText = menuItem.getText();
            if (itemText.equals("Trending") || itemText.equals("Home")) {
                System.out.println(itemText);
            }
        }
        WebElement trendingLink = driver.findElement(By.linkText("Trending"));
        trendingLink.click();

        // Click the YouTube menu (hamburger) button
        WebElement MenuButton = driver.findElement(By.id("guide-icon"));
        MenuButton.click();

        // Wait for some time to ensure the menu items load (you may need to adjust the wait time)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click the "Gaming" link from the menu
        WebElement gamingLink = driver.findElement(By.xpath("//a[@title='Gaming']"));
        gamingLink.click();

        // Wait for some time to ensure the gaming page loads (you may need to adjust the wait time)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Scroll down to load more games (you may need to adjust the scroll amount)
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.tagName("body")).sendKeys(org.openqa.selenium.Keys.PAGE_DOWN);
            try {
                Thread.sleep(2000); // Sleep for 2 seconds after scrolling
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Fetch and print the titles of the top games
        List<WebElement> topGames = driver.findElements(By.cssSelector(".style-scope ytd-game-card-renderer #title"));
        System.out.println("Top games on YouTube Gaming:");
        for (int i = 0; i < topGames.size(); i++) {
            WebElement gameTitle = topGames.get(i);
            System.out.println(gameTitle.getText());
        }
        // Find and click the menu button
        WebElement ymenuButton = driver.findElement(By.id("guide-icon"));
        ymenuButton.click();

        // Find the "About" link in the menu
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        
       

        // Create an instance of Actions class for performing actions like hovering and clicking
        Actions actions = new Actions(driver);
        


        // Hover over the "About" link to reveal the submenu
        actions.moveToElement(aboutLink).perform();

        // Find and click the "How YouTube works" link in the submenu
        WebElement howYouTubeWorksLink = driver.findElement(By.linkText("How YouTube works"));
        howYouTubeWorksLink.click();

      

        // Find and print the text on the "How YouTube works" page
        WebElement pageContent = driver.findElement(By.id("content"));
        System.out.println("Text on the 'How YouTube works' page:");
        System.out.println(pageContent.getText());
        
        driver.navigate().back();
        driver.navigate().back();
        // Find and click "Policy & Safety"
        WebElement policyAndSafetyLink = driver.findElement(By.linkText("Policy & Safety"));
        policyAndSafetyLink.click();

        // Wait for some time to ensure the page content loads (you may need to adjust the wait time)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the content under "Policy & Safety"
        WebElement policyAndSafetyContent = driver.findElement(By.id("content"));
        System.out.println("Policy & Safety Content:");
        System.out.println(policyAndSafetyContent.getText());

      
        driver.quit();
        

}}
    
