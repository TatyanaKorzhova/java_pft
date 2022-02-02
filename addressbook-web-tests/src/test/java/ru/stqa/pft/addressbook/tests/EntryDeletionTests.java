package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;
import java.util.Set;

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
        Set<EntryData> before = app.entry().all();
        EntryData deletedEntry = before.iterator().next(); //next возвращает любой элемент из множества
        app.entry().delete(deletedEntry);
        //int after = app.getEntryHelper().getEntryCount();
        Set<EntryData> after = app.entry().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedEntry); //пемен. before теперь ссылается на старый список в котором удален 1 элемент
        assertEquals(before, after);


    }


}
