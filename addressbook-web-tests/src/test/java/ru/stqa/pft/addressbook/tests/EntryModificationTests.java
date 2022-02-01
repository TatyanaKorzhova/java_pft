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
        EntryData entry = new EntryData()
                .withId(before.get(index).getId()).withFirstname("test2").withMiddlename("test2").withLastname("test2").withNickname("test2").withTitle("test2").withCompany("test2").withAddress("test2").withHome("test2").withMobile("test2").withWork("test2").withFax("test2").withEmail("test2").withEmail2("test2").withEmail3("test2").withHomepage("test2").withBday(null).withBmonth(null).withByear(null).withAday(null).withAmonth(null).withAyear(null).withAddress2("test2").withPhone2("test2").withNotes("test2");
        app.entry().modify(index, entry);
        // int after = app.getEntryHelper().getEntryCount();
        List<EntryData> after = app.entry().list();
        Assert.assertEquals(after.size(), index);

    }

}
