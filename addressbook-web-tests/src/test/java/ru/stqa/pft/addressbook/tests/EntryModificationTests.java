package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

public class EntryModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().entryPage();
        if (app.entry().list().size() == 0) {
            app.entry().create(new EntryData("firstname", null, null, null, "title", "company", "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "bday", "bmonth", "byear", "aday", "amonth", "ayear", "new_group", "address2", "phone2", "notes"));
        }
    }

    @Test
    public void testEntryModification() {
        // int before = app.getEntryHelper().getEntryCount();
        List<EntryData> before = app.entry().list();
        int index = before.size() - 1;
        app.goTo().gotoHomePage();
        EntryData entry = new EntryData(before.get(index).getId(),"firstname", null, null, null, "title", "company", "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "bday", "bmonth", "byear", "aday", "amonth", "ayear", "new_group", "address2", "phone2", "notes");
        app.entry().modify(index, entry);
        // int after = app.getEntryHelper().getEntryCount();
        List<EntryData> after = app.entry().list();
        Assert.assertEquals(after.size(), index);

    }


}
