package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntryCreationTests extends TestBase {

    @Test
    public void testEntryCreation() {
        //int before = app.getEntryHelper().getEntryCount();
        app.goTo().entryPage();
        int beforeCount = app.entry().count();
        Entries before = app.entry().all();
        app.goTo().gotoAddEntryPage();
        EntryData entry = new EntryData().withFirstname("firstname1").withLastname("").withBday("10").withBmonth("May").withByear("2022");
        app.entry().create(entry);
        Entries after = app.entry().all();
        // int after = app.getEntryHelper().getEntryCount();
        assertThat(app.entry().count(), equalTo(beforeCount + 1));

        assertThat(after, equalTo(
                before.withAdded(entry.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
