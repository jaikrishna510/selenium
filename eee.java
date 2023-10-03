package lmn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class eee {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Initialize the WebDriver (in this case, Chrome)
        WebDriver driver = new ChromeDriver();

        // Scenario: Navigate to YouTube menu, About, How YouTube works, and print text
        driver.get("https://www.youtube.com");
        
        
        WebElement trendingLink = driver.findElement(By.linkText("Trending"));
        trendingLink.click();

     
    
        
 // Fetch and print the titles of the top 3 trending videos
       List<WebElement> trendingVideos = driver.findElements(By.cssSelector(".style-scope ytd-video-renderer #video-title"));
       System.out.println("The top 3 trending videos are:");
      for (int i = 0; i < 3 && i < trendingVideos.size(); i++) {
         WebElement tvideoTitle = trendingVideos.get(i);
         System.out.println(tvideoTitle.getAttribute("title"));}
    

        // Find and click the menu button
        WebElement menuButton = driver.findElement(By.id("guide-icon"));
        menuButton.click();

        // Find the "About" link in the menu
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        
       

        // Create an instance of Actions class for performing actions like hovering and clicking
        Actions actions = new Actions(driver);
        


        // Hover over the "About" link to reveal the submenu
        actions.moveToElement(aboutLink).perform();

        // Find and click the "How YouTube works" link in the submenu
        WebElement howYouTubeWorksLink = driver.findElement(By.linkText("How YouTube works"));
        howYouTubeWorksLink.click();

        // Wait for some time to ensure the page content loads (you may need to adjust the wait time)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find and print the text on the "How YouTube works" page
        WebElement pageContent = driver.findElement(By.id("content"));
        System.out.println("Text on the 'How YouTube works' page:");
        System.out.println(pageContent.getText());

        // Close the WebDriver
        driver.quit();
    }
}
