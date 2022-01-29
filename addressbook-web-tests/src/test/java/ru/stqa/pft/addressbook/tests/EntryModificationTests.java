package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

public class EntryModificationTests extends TestBase {
    @Test
    public void testEntryModification() {
        // int before = app.getEntryHelper().getEntryCount();
        List<EntryData> before = app.entry().List();
        app.goTo().gotoEditEntryPage();
        if (!app.entry().isThereAEntry()) {
            app.entry().createEntry(new EntryData("firstname", null, null, null, "title", "company", "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "bday", "bmonth", "byear", "aday", "amonth", "ayear", "new_group", "address2", "phone2", "notes"));
        }
        app.goTo().gotoHomePage();
        app.entry().selectEntry(/*before.size()-1*/);
        app.entry().fillEntryForm(new EntryData(before.get(before.size() - 1).getId(), "test355", "test35", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "10", "May", "2022", "12", "January", "2022", "test1", "test3", "test3", "test3")/*, "edit"*/);
        app.entry().submitEntryModification();
        app.entry().returnToHomePage();
        // int after = app.getEntryHelper().getEntryCount();
        List<EntryData> after = app.entry().List();
        Assert.assertEquals(after.size(), before.size());

    }
}
