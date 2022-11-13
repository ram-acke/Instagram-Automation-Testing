package insta_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Scanner;

public class TestMethods {
    WebDriver driver;

    public void checkLogin(){
        String userName = "";
        String password = "";
        Scanner sc = new Scanner(System.in);
        if (userName.isEmpty() && password.isEmpty()){
            System.out.println("Enter UserName :-");
            userName = sc.nextLine();

            System.out.println("Enter Password :-");
            password = sc.nextLine();
        }

        System.setProperty("webdriver.chrome.driver","/home/ravan/Desktop/insta_selenium/chromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("._acan._acap._acas > ._ab8w._ab94._ab99._ab9f._ab9m._ab9p._abcm")).click();
        driver.findElement(By.cssSelector("._ac8f [type]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Not Now'])[1]")).click();
    }

    public void openUserProfile(){
        driver.findElement(By.xpath("/html/body[@class='_a3wf system-fonts--body']/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div//div[@class='x1vjfegm xvb8j5']/div/div[@class='x1iyjqo2 xh8yej3']/div[7]/div[@class='x1n2onr6']/div[@class='x1n2onr6']/a[@role='link']/div")).click();
    }

    public void logout(){

        driver.findElement(By.cssSelector(".xhuyl8g.xl5mz7h > div > .x1n2onr6 > a[role='link']  .x1s85apg.x1swvt13.x6ikm8r.x6s0dn4.x9f619.xeq5yr9.xxk0z11.xzzcqpx  ._aacl._aacp._aacu._aacx._aada")).click();
        //Click on More
        driver.findElement(By.xpath("//div[contains(text(),'Log out')]")).click();
        //Click on Logout
    }

    public void searching(){
        // Click on Search Button
        driver.findElement(By.xpath("/html/body[@class='_a3wf system-fonts--body']/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div//div[@class='x1vjfegm xvb8j5']/div/div[@class='x1iyjqo2 xh8yej3']/div[2]/div[@class='x1n2onr6']/a[@role='link']/div")).click();

        // Type on search Bar
        driver.findElement(By.cssSelector("._aauy")).sendKeys("Marvel");

        // Click on MarvelId
        driver.findElement(By.cssSelector(".x18d9i69.x1odjw0f.x4uap5.x5yr21d.x6ikm8r.x78zum5.x9f619.xdt5ytf.xh8yej3.xkhd6sd.xocp1fn > div:nth-of-type(1)  a[role='link'] > ._ab8w._ab94._ab97._ab9f._ab9k._ab9p._aba0._aba8._abcm")).click();


    }
}
