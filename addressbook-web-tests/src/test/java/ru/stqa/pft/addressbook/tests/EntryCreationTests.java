package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class EntryCreationTests extends TestBase {

    @Test
    public void testEntryCreation() {
        //int before = app.getEntryHelper().getEntryCount();
        app.goTo().entryPage();
        List<EntryData> before = app.entry().List();
        app.goTo().gotoAddEntryPage();
        EntryData entry = new EntryData("test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "10", "January", "2022", "12", "January", "2022", "test1", "test3", "test3", "test3")/*, "create"*/;
        app.entry().fillEntryForm(entry);
        app.entry().submitEntryCreation();
        app.entry().returnToHomePage();
        List<EntryData> after = app.entry().List();
        // int after = app.getEntryHelper().getEntryCount();
        Assert.assertEquals(after.size(), before.size() + 1);

        entry.setId((after.stream().max((Comparator<EntryData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()));
        before.add(entry);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//
    }
}
