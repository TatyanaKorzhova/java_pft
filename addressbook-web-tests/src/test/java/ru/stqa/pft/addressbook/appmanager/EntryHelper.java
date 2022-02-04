package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class EntryHelper extends HelperBase {
    public static boolean acceptNextAlert = true;
    //public StringBuffer verificationErrors = new StringBuffer();
    public EntryHelper(WebDriver wd) {
        super(wd);
    }
    public List<EntryData> list() {
        List<EntryData> entries = new ArrayList<EntryData>();
        WebElement element = wd.findElement(By.xpath("//*[@id='maintable']"));
        int count = (wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr")).size());
        //List<WebElement> elements = new ArrayList<>();
        for (int i = 2; i <= count; i++) {
            String lastname = (wd.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[position() = 2]"))).getText();
            String firstname = (wd.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[position() = 3]"))).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            entries.add(new EntryData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return entries;

    }

    private Entries entryCache = null;

    public Entries all() {
        if (entryCache != null) {
            return new Entries(entryCache);
        }
        entryCache = new Entries();
        WebElement element = wd.findElement(By.xpath("//*[@id='maintable']"));
        int count = (wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr")).size());
        //List<WebElement> elements = new ArrayList<>();
        for (int i = 2; i <= count; i++) {
            String lastname = (wd.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[position() = 2]"))).getText();
            int id = Integer.parseInt((wd.findElement(By.xpath("//table/tbody/tr[" + i + "]/td/input"))).getAttribute("value"));
            String firstname = (wd.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[position() = 3]"))).getText();
           // int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            entryCache.add(new EntryData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return new Entries(entryCache);
    }



//    public Set<EntryData> all() {
//        Set<EntryData> entries = new HashSet<EntryData>();
//        List<WebElement> rows = wd.findElements(By.name("entry"));
//        for (WebElement row : rows) {
//            List<WebElement> cells = row.findElements(By.tagName("td"));
//            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
//            String lastname = cells.get(1).getText();
//            String firstname = cells.get(2).getText();
//            String allPhones = cells.get(5).getText(); //разбиваем строку на фрагменты
//            entries.add(new EntryData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones));
//        }
//        return entries;
//    }

    public void fillEntryForm(EntryData entryData/*, String option*/) {
        type(By.name("firstname"), entryData.getFirstname());
        type(By.name("middlename"), entryData.getMiddlename());
        type(By.name("lastname"), entryData.getLastname());
        type(By.name("nickname"), entryData.getNickname());
        attach(By.name("photo"), entryData.getPhoto());
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
        if (entryData.getBday() != null && entryData.getBmonth() != null && entryData.getByear() != null) {
            wd.findElement(By.name("bday")).click();
            new Select(wd.findElement(By.name("bday"))).selectByVisibleText(entryData.getBday());
            wd.findElement(By.xpath("//option[@value='" + entryData.getBday() + "']")).click();
            wd.findElement(By.name("bmonth")).click();
            new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(entryData.getBmonth());
            wd.findElement(By.xpath("//option[@value='" + entryData.getBmonth() + "']")).click();
            wd.findElement(By.name("byear")).click();
            wd.findElement(By.name("byear")).clear();
            wd.findElement(By.name("byear")).sendKeys(entryData.getByear());
        }
        if (entryData.getAday() != null && entryData.getAmonth() != null && entryData.getAyear() != null) {
            wd.findElement(By.name("aday")).click();
            new Select(wd.findElement(By.name("aday"))).selectByVisibleText(entryData.getAday());
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]/option[14]")).click();
            wd.findElement(By.name("amonth")).click();
            new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(entryData.getAmonth());
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]/option[2]")).click();
            wd.findElement(By.name("ayear")).click();
            wd.findElement(By.name("ayear")).clear();
            wd.findElement(By.name("ayear")).sendKeys(entryData.getAyear());
        }
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
        wd.findElement(By.linkText("home")).click();
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
//    public void selectEntry(int id) {
//
//        List<WebElement> list = wd.findElements(By.xpath("//input[@type='checkbox']"));
//        if (list.size() > 0) {
//            int id = list.get(0).getAttribute("id");
//            wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']/img[@alt='Edit']")).click();
//        }
//
//    }

    public void selectEntryById(int id) {
         wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']/img[@alt='Edit']")).click();
    }

    public void create(EntryData entry) {
        fillEntryForm(entry/*, "create"*/);
        submitEntryCreation();
        entryCache = null;
        returnToHomePage();

    }

    public void delete(int index) {
        selectEntrys(index);
        //app.getEntryHelper().submitEntryDeletion();
        deleteSelectedEntry();
        returnToEntryPage();
    }

    public void delete(EntryData entry) {
        selectEntryById(entry.getId());
        //app.getEntryHelper().submitEntryDeletion();
        deleteSelectedEntry();
        entryCache = null;
        returnToHomePage();
    }

    public void modify(EntryData entry) {
        selectEntryById(entry.getId());
        fillEntryForm(entry);
        submitEntryModification();
        entryCache = null;
        returnToHomePage();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
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


//    public Iterable<Object> all() {
//
//    }

    public EntryData intoFromEditForm(EntryData entry) { //получаем телефоны из формы редактирования
        initEntryModifacationById(entry.getId()); //выбор записи по id
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value"); // извлекаем из полей нужные значения
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        //строим объект EntryData, в кот запо-я атрибуты полученными значениями
        return new EntryData().withId(entry.getId()).withFirstname(firstname).withLastname(lastname).withHome(home).withMobile(mobile).withWork(work);

    }

    private void initEntryModifacationById(int id) { //выбор по заданному идентификатору из множества
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id))); //находим чекбокс
        WebElement row = checkbox.findElement(By.xpath("./../.."));//от чекбокса переходим к ячейке, в которой он находится, а потом к строке где он находится
        // .. - родительский элемент
        List<WebElement> cells = row.findElements(By.tagName("td"));//берем список ячеек ищем внутри вссе элементы с тегом td
        cells.get(7).findElement(By.tagName("a")).click();//среди этих ячеек берем нужную, внутри ячейки находим ссылку <a> и кликаем

        //wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }

    public EntryData intoFromEditFormAddress(EntryData entry) { //получаем адрес из формы редактирования
        initEntryModifacationById(entry.getId()); //выбор записи по id
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value"); // извлекаем из полей нужные значения
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        //строим объект EntryData, в кот запо-я атрибуты полученными значениями
        return new EntryData().withId(entry.getId()).withFirstname(firstname).withLastname(lastname)/*.withAddress(address)*/;

    }

    private void submitEntryDetails(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }
}
