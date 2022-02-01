package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class EntryDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().entryPage();
        if (app.entry().list().size() == 0) {
            app.entry().create(new EntryData().withFirstname("firstname2"));
        }
    }

    @Test
    public void testEntryDeletion() {
        app.goTo().entryPage();
        //int before = app.getEntryHelper().getEntryCount();
        List<EntryData> before = app.entry().list();
        int index = before.size() - 1;
        app.entry().delete(index);
        //int after = app.getEntryHelper().getEntryCount();
        List<EntryData> after = app.entry().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index); //пемен. before теперь ссылается на старый список в котором удален 1 элемент
        assertEquals(before, after);


    }


}
