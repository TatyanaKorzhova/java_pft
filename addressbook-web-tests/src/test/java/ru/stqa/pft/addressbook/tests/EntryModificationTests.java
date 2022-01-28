package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

public class EntryModificationTests extends TestBase {
    @Test
    public void testEntryModification() {
        // int before = app.getEntryHelper().getEntryCount();
        List<EntryData> before = app.getEntryHelper().getEntryList();
        app.getNavigationHelper().gotoEditEntryPage();
        if (!app.getEntryHelper().isThereAEntry()) {
            app.getEntryHelper().createEntry(new EntryData("firstname", null, null, null, "title", "company", "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "bday", "bmonth", "byear", "aday", "amonth", "ayear", "new_group", "address2", "phone2", "notes"));
        }
        app.getNavigationHelper().gotoHomePage();
        app.getEntryHelper().selectEntry(/*before.size()-1*/);
        app.getEntryHelper().fillEntryForm(new EntryData(before.get(before.size() - 1).getId(), "test355", "test35", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "10", "May", "2022", "12", "January", "2022", "test1", "test3", "test3", "test3")/*, "edit"*/);
        app.getEntryHelper().submitEntryModification();
        app.getEntryHelper().returnToHomePage();
        // int after = app.getEntryHelper().getEntryCount();
        List<EntryData> after = app.getEntryHelper().getEntryList();
        Assert.assertEquals(after.size(), before.size());

    }
}
