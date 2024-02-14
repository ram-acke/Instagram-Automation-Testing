package org.example.testcases;

import org.example.objects.login_logout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class basicFlow {

    WebDriver driver;
    login_logout login;

    @BeforeTest
    public void setupUrl(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Facebook\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login = new login_logout(driver);
        driver.get("https://www.instagram.com/");
    }

    @AfterTest
    public void exiting() throws InterruptedException {
        Thread.sleep(5000);
        login.logout();
        Thread.sleep(2000);
        driver.quit();

    }

    @Test(priority = 0)
    public void login() throws InterruptedException {
        login.initialLogin();
        Assert.assertEquals(driver.getTitle(),"Instagram");
    }

    @Test(priority = 1)
    public void searchingId() throws InterruptedException {
        String searchId = "instagramforbusiness";
        login.search(searchId);
        Assert.assertEquals(login.getSearchId(),searchId);
    }

    @Test(priority = 2)
    public void scrollingReels(){
        login.clickReelBtn();
        login.startScrollReels();
    }




}
