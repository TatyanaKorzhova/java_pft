package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class EntryDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().entryPage();
        if (app.entry().all().size() == 0) {
            app.entry().create(new EntryData().withFirstname("firstname2"));
        }
    }

    @Test
    public void testEntryDeletion() {
        app.goTo().entryPage();
        //int before = app.getEntryHelper().getEntryCount();
        Entries before = app.entry().all();
        EntryData deletedEntry = before.iterator().next(); //next возвращает любой элемент из множества
        app.entry().delete(deletedEntry);
        //int after = app.getEntryHelper().getEntryCount();
        assertThat(app.entry().count(), equalTo(before.size() - 1));
        Entries after = app.entry().all();

        assertThat(after, equalTo(before.without(deletedEntry)));

    }


}
