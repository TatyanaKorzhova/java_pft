package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class EntryDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().entryPage();
        if (app.entry().all().size() == 0) {
            app.entry().create(new EntryData().withFirstname("firstname2"));
        }
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        //List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/entries.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(EntryData.class);
            List<EntryData> groups = (List<EntryData>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        //List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/entries.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntryData> groups = gson.fromJson(json, new TypeToken<List<EntryData>>(){}.getType()); // равно =List<GroupData>.class
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test
    public void testEntryDeletion() {
        app.goTo().entryPage();
        //int before = app.getEntryHelper().getEntryCount();
        Entries before = app.entry().all();
        EntryData deletedEntry = before.iterator().next(); //next возвращает любой элемент из множества
        app.entry().delete(deletedEntry);
        //int after = app.getEntryHelper().getEntryCount();
        assertThat(app.entry().count(), equalTo(before.size() - 1));
        Entries after = app.entry().all();

        assertThat(after, equalTo(before.without(deletedEntry)));

    }


}
