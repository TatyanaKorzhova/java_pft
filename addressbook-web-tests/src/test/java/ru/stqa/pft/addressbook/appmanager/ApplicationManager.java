package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");

        navigationHelper = new NavigationHelper(wd);
        navigationHelper.groupHelper = new GroupHelper(wd);
        navigationHelper.entryHelper = new EntryHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void logoutPage() {
        wd.findElement(By.linkText("Logout")).click();
    }



    public GroupHelper getGroupHelper() {
        return navigationHelper.groupHelper;
    }

    public EntryHelper getEntryHelper() {
        return navigationHelper.entryHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void stop() {
        wd.quit();
    }
}
