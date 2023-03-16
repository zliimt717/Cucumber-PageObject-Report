package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
  WebDriver driver;

  public PageObject(WebDriver webDriver){
      driver=webDriver;
      PageFactory.initElements(driver,this);
  }
  @FindBy(xpath = "//input[@name='uid']")
  @CacheLookup
  WebElement txtUserName;

  @FindBy(xpath = "//input[@name='password']")
  @CacheLookup
 WebElement txtPassWord;

  @FindBy(xpath = "//input[@name='btnLogin']")
  @CacheLookup
  WebElement btnLogin;

  public void setUsername(String userName){
      txtUserName.sendKeys(userName);
  }

  public void setPassWord(String passWord){
      txtPassWord.sendKeys(passWord);
  }

  public void clickLogin(){
      btnLogin.click();
  }

}
