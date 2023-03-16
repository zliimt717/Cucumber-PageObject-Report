package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Steps {

   public WebDriver stepDriver= Hook.driver;
    public PageObject pageObject;
    @Given("Launch the browser and open the URL:{string}")
    public void launch_the_browser_and_open_the_url(String url) {

        pageObject =new PageObject(stepDriver);
        stepDriver.get(url);
    }
    @When("Check the title at the login page")
    public void check_the_title_at_the_login_page() {
        if(stepDriver.getPageSource().contains("Guru99 Bank")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
            stepDriver.close();
        }
    }
    @Then("Enter the username as {string} and password as {string}")
    public void enter_the_username_as_and_password_as(String userName, String passWord) {
        pageObject.setUsername(userName);
        pageObject.setPassWord(passWord);
    }
    @Then("click the login button")
    public void click_the_login_button() throws InterruptedException {
        Thread.sleep(2000);
        if(stepDriver.findElements(By.id("gdpr-consent-notice")).size()>0){
            stepDriver.switchTo().frame("gdpr-consent-notice");
            stepDriver.findElement(By.id("save")).click();
            stepDriver.switchTo().defaultContent();
        }

        Thread.sleep(3000);
        pageObject.clickLogin();
    }
    @When("Check the manage id at the home page")
    public void check_the_manage_id_at_the_home_page() {
        if(stepDriver.getPageSource().contains("Manger Id")){
            Assert.assertTrue(true);
            stepDriver.quit();
        }else {
            Assert.assertTrue(false);
            stepDriver.close();
        }
    }


}
