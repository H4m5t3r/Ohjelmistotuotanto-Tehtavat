package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

//        HtmlUnitDriver driver = new HtmlUnitDriver();
//        driver.setJavascriptEnabled(true);

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        // Jos ohjelma ei löydä pekkaa, niin ota käyttöön kommentoitu koodi
//        element.click();

//        sleep(2);
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("passwordConfirmation"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("signup"));
//        
//        sleep(2);
//        element.submit();
//        
//        sleep(2);
//        
//        element = driver.findElement(By.linkText("continue to application main page"));
//        sleep(1);
//        element.click();
//        element = driver.findElement(By.linkText("logout"));
//        sleep(1);
//        element.click();
//
//        sleep(2);
        
        element = driver.findElement(By.linkText("login"));
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
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(1);
        
        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        sleep(1);
        
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        
        sleep(1);
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));

        element = driver.findElement(By.name("password"));
        element.sendKeys("user");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("user");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        sleep(2);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(1);
        element.click();
        element = driver.findElement(By.linkText("logout"));
        sleep(1);
        element.click();

        sleep(1);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
