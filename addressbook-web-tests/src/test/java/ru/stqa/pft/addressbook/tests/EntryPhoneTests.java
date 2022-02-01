package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EntryData;

public class EntryPhoneTests extends TestBase {

    @Test (enabled = true)
    public void testEntryPhones(){
        app.goTo().gotoHomePage();
       // EntryData entry = app.entry().all().iterator().next();
        //EntryData entryIntoFromEditForm = app.entry().intoFromEditForm(entry);
    }
}
