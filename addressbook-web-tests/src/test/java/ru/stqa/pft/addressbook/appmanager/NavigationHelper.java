package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{
    public EntryHelper gotoHomePage;
    //protected Homepage returnToHomePage;
    protected GroupHelper groupHelper;
    protected EntryHelper entryHelper;

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
       click(By.linkText("groups"));
    }

    public void gotoEntryPage() {
        click(By.linkText("add new"));
    }
    public void gotoHomePage() {
        click(By.linkText("home"));
    }
}
