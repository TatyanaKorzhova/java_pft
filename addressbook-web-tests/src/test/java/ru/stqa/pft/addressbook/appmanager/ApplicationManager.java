package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   // private final Properties properties;
    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private String browser;

    public ApplicationManager(String browser)  {
        this.browser = browser;
//        String target = System.getProperty("target", "local");
//        properties = new Properties();
//        properties.load(new FileReader(new File(String.format("src/test/test/resources/%s.properties", target))));
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");

        navigationHelper = new NavigationHelper(wd);
        navigationHelper.groupHelper = new GroupHelper(wd);
        navigationHelper.entryHelper = new EntryHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void logoutPage() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public GroupHelper group() {
        return navigationHelper.groupHelper;
    }

    public EntryHelper entry() {
        return navigationHelper.entryHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public void stop() {
        wd.quit();
    }
}
