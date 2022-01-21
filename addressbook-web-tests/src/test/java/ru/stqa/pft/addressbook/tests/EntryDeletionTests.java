package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class EntryDeletionTests extends TestBase {

    @Test
    public void testEntryDeletion() {
        app.getNavigationHelper().gotoEntryPage();
        app.getEntryHelper().submitEntryDeletion();
    }
}
