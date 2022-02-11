package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntryCreationTests extends TestBase {

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
    public void testEntryCreation(/*dataProvider = "validEntriesFromJson"*/) {
        app.goTo().entryPage();
        int beforeCount = app.entry().count();
        Entries before = app.db().entries();
        app.goTo().gotoAddEntryPage();
        File photo = new File("src/test/resources/stru.png");
        EntryData entry = new EntryData().withFirstname("firstname1").withLastname("");
        app.entry().create(entry);
        Entries after = app.db().entries();
        // int after = app.getEntryHelper().getEntryCount();
        assertThat(app.entry().count(), equalTo(beforeCount + 1));

        assertThat(after, equalTo(
                before.withAdded(entry.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        verifyEntryListInUI();
    }

//    @Test
//    public void testEntryCreation() {
//        Groups groups = app.db().groups();
//        File photo = new File("src/test/resources/stru.png");
//        EntryData newEntry = new EntryData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo).inGroup(groups.iterator().next());
//        app.goTo().gotoHomePage();
//        app.entry().initEntryCreation();
//        app.entry().fillEntryForm(newEntry, true);
//        app.entry().submitEntryCreation();
//        app.entry().returnToHomePage();
//    }


    @Test (enabled = false)
    public void testCerrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsoluteFile());
        File photo = new File("src/test/resources/stru.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());

    }
}
