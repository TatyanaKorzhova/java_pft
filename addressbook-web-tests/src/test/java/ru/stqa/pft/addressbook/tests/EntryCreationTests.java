package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EntryCreationTests extends TestBase {

    @Test
    public void testEntryCreation() {
        //int before = app.getEntryHelper().getEntryCount();
        app.goTo().entryPage();
        Set<EntryData> before = app.entry().all();
        app.goTo().gotoAddEntryPage();
        EntryData entry = new EntryData().withFirstname("firstname1");
        app.entry().create(entry);
        Set<EntryData> after = app.entry().all();
        // int after = app.getEntryHelper().getEntryCount();
        Assert.assertEquals(after.size(), before.size() + 1);

        entry.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(entry);
        Assert.assertEquals(before, after);

    }

}
