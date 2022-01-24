package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.EntryData;

public class EntryCreationTests extends TestBase {

    @Test
    public void testEntryCreation() {
        app.getNavigationHelper().gotoAddEntryPage();
        app.getEntryHelper().fillEntryForm(new EntryData("test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "test3", "10", "January", "2022", "12", "January", "2022", "test1", "test3", "test3", "test3")/*, "create"*/);
        app.getEntryHelper().submitEntryCreation();
        app.getEntryHelper().returnToHomePage();
    }

}
