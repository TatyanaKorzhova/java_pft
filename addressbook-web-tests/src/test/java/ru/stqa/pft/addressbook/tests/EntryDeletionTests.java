package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class EntryDeletionTests extends TestBase {

    @Test
    public void testEntryDeletion() {
        app.getNavigationHelper().gotoEntryPage();
        //int before = app.getEntryHelper().getEntryCount();
        List<EntryData> before = app.getEntryHelper().getEntryList();
        app.getEntryHelper().selectEntrys(before.size() - 1);
        //app.getEntryHelper().submitEntryDeletion();
        app.getEntryHelper().deleteSelectedEntry();
        app.getNavigationHelper().gotoEntryPage();
        //int after = app.getEntryHelper().getEntryCount();
        List<EntryData> after = app.getEntryHelper().getEntryList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1); //пемен. before теперь ссылается на старый список в котором удален 1 элемент
        assertEquals(before, after);


    }
}
