package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class EntryCreationTests extends TestBase {

    @Test
    public void testEntryCreation() {

        List<EntryData> before = app.getEntryHelper().getEntryList();
        // int before = app.getEntryHelper().getEntryCount();
        app.getNavigationHelper().gotoAddEntryPage();
        app.getEntryHelper().fillEntryForm(new EntryData("test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "10", "January", "2022", "12", "January", "2022", "test1", "test3", "test3", "test3")/*, "create"*/);
        app.getEntryHelper().submitEntryCreation();
        app.getEntryHelper().returnToHomePage();
        List<EntryData> after = app.getEntryHelper().getEntryList();
        // int after = app.getEntryHelper().getEntryCount();
        Assert.assertEquals(after.size(), before.size() + 1);
        // List<EntryData> after = app.getEntryHelper().getEntryList();
        // Assert.assertEquals(after.size(),before.size() + 1);

//        entry.setId(after.stream().max((Comparator<EntryData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//        before.add(entry);
//        Comparator<? super EntryData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);

        int max = 0;
        for (EntryData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }

        /*entry.setId(max);
        before.add(entry);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<>(Object)(after));*/

    }
}
