package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EntryData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntryPhoneTests extends TestBase {

    @Test //(enabled = false)
    public void testEntryPhones(){
        app.goTo().gotoHomePage();
        EntryData entry = app.entry().all().iterator().next();
        EntryData entryIntoFromEditForm = app.entry().intoFromEditForm(entry);

        assertThat(entry.getHome(), equalTo(entryIntoFromEditForm.getHome()));
        assertThat(entry.getMobile(), equalTo(entryIntoFromEditForm.getMobile()));
        assertThat(entry.getWork(), equalTo(entryIntoFromEditForm.getWork()));

    }
}
