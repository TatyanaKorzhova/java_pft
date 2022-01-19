package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class EntryHelper extends HelperBase {
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    public EntryHelper(WebDriver wd) {
        super(wd);
    }

    public void fillEntryForm(EntryData entryData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(entryData.getFirstname());
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(entryData.getMiddlename());
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(entryData.getLastname());
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(entryData.getNickname());
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(entryData.getTitle());
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(entryData.getCompany());
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(entryData.getAddress());
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(entryData.getHome());
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(entryData.getMobile());
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(entryData.getWork());
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(entryData.getFax());
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(entryData.getEmail());
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(entryData.getEmail2());
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(entryData.getEmail3());
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(entryData.getHomepage());
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(entryData.getBday());
        wd.findElement(By.xpath("//option[@value='10']")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(entryData.getBmonth());
        wd.findElement(By.xpath("//option[@value='January']")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(entryData.getByear());
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(entryData.getAday());
        wd.findElement(By.xpath("//div[@id='content']/form/select[3]/option[14]")).click();
        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(entryData.getAmonth());
        wd.findElement(By.xpath("//div[@id='content']/form/select[4]/option[2]")).click();
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(entryData.getAyear());
        wd.findElement(By.name("new_group")).click();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(entryData.getNew_group());
        wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).click();
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(entryData.getAddress2());
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(entryData.getPhone2());
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(entryData.getNotes());

    }

    public void submitEntryCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void submitEntryDeletion() {

        List<WebElement> list = wd.findElements(By.xpath("//input[@type='checkbox']"));
        if (list.size() > 0){
            list.get(0).click();
            wd.findElement(By.xpath("//input[@value='Delete']")).click();
            assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        }
        wd.findElement(By.linkText("Logout")).click();
    }

    public String closeAlertAndGetItsText() {
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

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

}
