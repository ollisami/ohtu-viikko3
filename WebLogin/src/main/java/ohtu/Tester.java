package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver"); 
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaarasalasana");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("vaarakayttaja");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        
        driver.get("http://localhost:4567");
        sleep(2);
        
        element = driver.findElement(By.linkText("user"));
        element.click();
        
        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("test1234");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("test1234");
        
        sleep(2);
        element.submit();
        sleep(2);
        element = driver.findElement(By.linkText("user"));
        element.click();
        
        sleep(2);
        element = driver.findElement(By.linkText("/"));
        element.click();
        
        
        sleep(3);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
