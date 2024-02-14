package org.example.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class login_logout {

    WebDriver driver;

    public login_logout(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.cssSelector("input[aria-label=\"Phone number, username, or email\"]");
    By password = By.cssSelector("input[type=\"password\"]");
    By loginBtn = By.cssSelector("button[type=\"submit\"]");
    By notNowbtn = By.cssSelector("div[role=\"button\"]");

    By notificationOff = By.xpath("//*[contains(text(),'Not Now')]");

    By moreBtn = By.cssSelector("svg[aria-label=\"Settings\"][height=\"24\"]");
    By logoutBtn = By.xpath("//*[text()=\"Log out\"]");

    By openSearch = By.cssSelector("svg[aria-label=\"Search\"]");
    By inputSearchText = By.cssSelector("input[aria-label=\"Search input\"]");
    By reelBtn = By.cssSelector("svg[aria-label=\"Reels\"]");
    By reelWH = By.cssSelector("div[style*=\"height\"][class=\"x78zum5 xedcshv\"]");

    String searchId ="";


    public void initialLogin() throws InterruptedException {
        driver.findElement(username).sendKeys("username");
        driver.findElement(password).sendKeys("password");
        driver.findElement(loginBtn).click();
        Thread.sleep(5000);
        driver.findElement(notNowbtn).click();
        driver.findElement(notificationOff).click();
    }

    public void search(String text) throws InterruptedException {
        driver.findElement(openSearch).click();
        driver.findElement(inputSearchText).sendKeys(text);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='"+text+"']//parent::div")).click();
        searchId = String.valueOf(driver.findElement(By.xpath("//h2[text()='"+text+"']")).getText());
    }

    public String getSearchId(){
        return searchId;
    }

    public void logout(){
        driver.findElement(moreBtn).click();
        driver.findElement(logoutBtn).click();
    }

    public void clickReelBtn(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(reelBtn).click();

    }

    public void startScrollReels(){
        java.util.List<WebElement> elements = driver.findElements(reelWH);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        for (WebElement element : elements) {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            try {
                Thread.sleep(5000);
                System.out.println("First");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
