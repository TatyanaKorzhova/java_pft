package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class EntryDeletionTests extends TestBase {

    @Test
    public void testEntryDeletion() {
        app.goTo().entryPage();
        //int before = app.getEntryHelper().getEntryCount();
        List<EntryData> before = app.entry().List();
        app.entry().selectEntrys(before.size() - 1);
        //app.getEntryHelper().submitEntryDeletion();
        app.entry().deleteSelectedEntry();
        app.goTo().entryPage();
        //int after = app.getEntryHelper().getEntryCount();
        List<EntryData> after = app.entry().List();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1); //пемен. before теперь ссылается на старый список в котором удален 1 элемент
        assertEquals(before, after);


    }
}
