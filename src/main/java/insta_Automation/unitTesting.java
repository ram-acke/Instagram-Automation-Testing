package insta_Automation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class unitTesting {
    TestMethods testMethod = new TestMethods();

    @Test
    public void LoginMethod(){

        testMethod.checkLogin();
        WebElement CheckElement = null;
        try {
            CheckElement =  testMethod.driver.findElement(By.cssSelector("._aacp._aacw"));
        }
        catch (Exception e){
            System.out.println("Exception Result :- "+e);
        }
        testMethod.logout();

        if (CheckElement.isDisplayed()){
            assertTrue("Test Passed",true);
        }else{
            assertTrue("Test Failed",false);
        }
        testMethod.driver.quit();
    }

    @Test
    public void userProfileTest(){

        testMethod.checkLogin();
        WebElement checkElement = null;
        testMethod.openUserProfile();
        try {
            checkElement = testMethod.driver.findElement(By.xpath("/html/body[@class='_a3wf system-fonts--body']/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/section/main[@role='main']//section//h2[@class='_aacl _aacs _aact _aacx _aada']"));
        }
        catch (Exception e){
            System.out.println("Exception Result :- "+e);
        }
        testMethod.logout();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (checkElement.isDisplayed()){
            assertTrue("Test Passed",true);
        }else{
            assertTrue("Test Failed",false);
        }
        testMethod.driver.quit();
    }

    @Test
    public void searchingTest(){

        testMethod.checkLogin();
        WebElement checkElement = null;
        testMethod.searching();
        try {
            checkElement = testMethod.driver.findElement(By.cssSelector("a[role='link'] > ._aacl._aacs._aact._aacx._aada"));
            System.out.println("Element found :- "+checkElement);
        }
        catch (Exception e){
            System.out.println("Exception Result :- "+e);
        }

        testMethod.logout();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (checkElement.isDisplayed()){
            assertTrue("Test Passed",true);
        }else{
            assertTrue("Test Failed",false);
        }
        testMethod.driver.quit();
    }

}
