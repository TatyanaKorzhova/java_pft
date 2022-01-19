package ru.stqa.pft.addressbook.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EntryDeletionTests extends TestBase {
  private WebDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

   @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    //wd = new WebDriver();
    baseUrl = "https://www.google.com/";
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEntryDeletion() {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
   // app.getNavigationHelper().gotoEntryPage();
   // app.getNavigationHelper().gotoEntryPage();

    List<WebElement> list = wd.findElements(By.xpath("//input[@type='checkbox']"));
    if (list.size() > 0){
      list.get(0).click();
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }
    wd.findElement(By.linkText("Logout")).click();
  }

//   //app.getNavigationHelper().gotoEntryPage();
//   // app.getEntryHelper().returnToHomePage();
//    app.getEntryHelper().go;
//    //app.getEntryHelper().returnToHomePage();
//  app.getEntryHelper().submitEntryDeletion();
// // app.getEntryHelper().closeAlertAndGetItsText();
//    app.getEntryHelper().returnToHomePage();


  @AfterMethod
  public void tearDown()  {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
