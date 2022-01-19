package ru.stqa.pft.addressbook.tests;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;

public class GroupCreationTestSelenium {
  private WebDriver wd;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    wd = new FirefoxDriver();
    js = (JavascriptExecutor) wd;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    wd.quit();
  }
  @Test
  public void groupCreationTestSelenium() {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.cssSelector("input:nth-child(7)")).click();
    wd.findElement(By.name("MainForm")).click();
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.name("new")).click();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).sendKeys("test2");
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).sendKeys("test2");
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).sendKeys("test2");
    wd.findElement(By.name("submit")).click();
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

}
