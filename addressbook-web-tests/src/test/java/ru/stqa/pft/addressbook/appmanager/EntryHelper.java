package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.EntryData;
import ru.stqa.pft.addressbook.model.GroupData;

import javax.lang.model.element.Name;
import java.security.KeyStore;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class EntryHelper extends HelperBase {
    public static boolean acceptNextAlert = true;
    //public StringBuffer verificationErrors = new StringBuffer();

    public List<EntryData> getEntryList() {
        List<EntryData> entries = new ArrayList<EntryData>();
        WebElement element = wd.findElement(By.xpath("//*[@id='maintable']"));
        int count = (wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr")).size());
        //List<WebElement> elements = new ArrayList<>();
        for (int i = 2; i <= count; i++) {
            String lastname = (wd.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[position() = 2]"))).getText();
            String firstname = (wd.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[position() = 3]"))).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            EntryData entry = new EntryData(id, firstname, null, lastname, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            entries.add(entry);
        }
        return entries;
    }

    public EntryHelper(WebDriver wd) {
        super(wd);
    }

    public void fillEntryForm(EntryData entryData/*, String option*/) {
        type(By.name("firstname"), entryData.getFirstname());
        type(By.name("middlename"), entryData.getMiddlename());
        type(By.name("lastname"), entryData.getLastname());
        type(By.name("nickname"), entryData.getNickname());
        type(By.name("title"), entryData.getTitle());
        type(By.name("company"), entryData.getCompany());
        type(By.name("address"), entryData.getAddress());
        type(By.name("home"), entryData.getHome());
        type(By.name("mobile"), entryData.getMobile());
        type(By.name("work"), entryData.getWork());
        type(By.name("fax"), entryData.getFax());
        type(By.name("email"), entryData.getEmail());
        type(By.name("email2"), entryData.getEmail2());
        type(By.name("email3"), entryData.getEmail3());
        type(By.name("homepage"), entryData.getHomepage());
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(entryData.getBday());
        wd.findElement(By.xpath("//option[@value='" + entryData.getBday() + "']")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(entryData.getBmonth());
        wd.findElement(By.xpath("//option[@value='" + entryData.getBmonth() + "']")).click();
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

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        if (wd.findElements(By.name("//select[@name=new_group]")).size() > 0) {
            wd.findElement(By.name("new_group")).click();
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(entryData.getNew_group());
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).click();
        }


//        if (option.equals("create")) {
//            wd.findElement(By.name("new_group")).click();
//            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(entryData.getNew_group());
//            wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).click();
//        }
        type(By.name("address2"), entryData.getAddress2());
        type(By.name("phone2"), entryData.getPhone2());
        type(By.name("notes"), entryData.getNotes());

    }

    public void submitEntryModification() {
        click(By.name("update"));
    }

    public void submitEntryCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void submitEntryDeletion() {

        List<WebElement> list = wd.findElements(By.xpath("//input[@type='checkbox']"));
        if (list.size() > 0) {
            list.get(0).click();
            wd.findElement(By.xpath("//input[@value='Delete']")).click();
            assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        }
        wd.findElement(By.linkText("Logout")).click();
    }

    public static String closeAlertAndGetItsText() {
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

    public void returnToEntryPage() {
        wd.findElement(By.linkText("entry page")).click();
    }

    public void initEntryCreation() {
        click(By.name("add new"));
    }

    public void deleteSelectedEntry() {
        //click(By.name("//input[@value='Delete']"));
        //click(By.name("delete"));
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void selectEntry() {

        List<WebElement> list = wd.findElements(By.xpath("//input[@type='checkbox']"));
        if (list.size() > 0) {
            String id = list.get(0).getAttribute("id");
            wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']/img[@alt='Edit']")).click();
        }

    }

    public void createEntry(EntryData entry) {
        fillEntryForm(entry/*, "create"*/);
        submitEntryCreation();
        returnToEntryPage();

    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isThereAEntry() {
        return isElementPresent(By.name("selected[]"));
    }


    public int getEntryCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectEntrys(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

}
