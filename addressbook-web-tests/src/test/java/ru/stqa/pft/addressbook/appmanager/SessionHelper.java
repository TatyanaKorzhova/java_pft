package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    private String password;

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String property) {
        type(By.name("user"), username);
        type((By.name("pass")), password);
        click(By.xpath("//input[@value='Login']"));
    }
}
