package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;
import java.util.Set;

public class EntryModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().entryPage();
        if (app.entry().all().size() == 0) {
            app.entry().create(new EntryData().withFirstname("firstname").withLastname("lastname"));
        }
    }

    @Test
    public void testEntryModification() {
        // int before = app.getEntryHelper().getEntryCount();
        Set<EntryData> before = app.entry().all();
        EntryData modifiedEntry = before.iterator().next(); //next возвращает любой элемент из множества
        app.goTo().gotoHomePage();
        EntryData entry = new EntryData()
                .withId(modifiedEntry.getId()).withFirstname("test2").withMiddlename("test2").withLastname("test2").withNickname("test2").withTitle("test2").withCompany("test2").withAddress("test2").withHome("test2").withMobile("test2").withWork("test2").withFax("test2").withEmail("test2").withEmail2("test2").withEmail3("test2").withHomepage("test2").withBday(null).withBmonth(null).withByear(null).withAday(null).withAmonth(null).withAyear(null).withAddress2("test2").withPhone2("test2").withNotes("test2");
        app.entry().modify(entry);
        // int after = app.getEntryHelper().getEntryCount();
        Set<EntryData> after = app.entry().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedEntry);
        before.add(entry);
        Assert.assertEquals(before, after);

    }

}
