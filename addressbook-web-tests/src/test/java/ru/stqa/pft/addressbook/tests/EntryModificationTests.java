package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class EntryModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().entryPage();
        if (app.entry().all().size() == 0) {
            app.entry().create(new EntryData().withFirstname("firstname").withLastname("lastname"));
        }
    }

    @Test //(enabled = false)
    public void testEntryModification() {
        int beforeCount = app.entry().count();
        Entries before = app.entry().all();
        app.goTo().gotoHomePage();
        EntryData modifiedEntry = before.iterator().next(); //next возвращает любой элемент из множества

        EntryData entry = new EntryData()
                .withId(modifiedEntry.getId()).withFirstname("modif").withMiddlename("m").withLastname("m").withNickname("test2").withTitle("test2").withCompany("test2").withAddress("test2").withHome("test2");
        app.entry().modify(entry);
        // int after = app.getEntryHelper().getEntryCount();
       // int beforeCount = app.entry().count();
        assertThat(app.entry().count(), equalTo(before.size()));
        Entries after = app.entry().all();

        assertThat(after, equalTo(before.without(modifiedEntry).withAdded(entry)));
    }

}
