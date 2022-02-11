package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntryModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().entries().size() == 0) {
            app.goTo().entryPage();
            app.entry().create(new EntryData().withFirstname("firstname").withLastname("lastname"));
        }
    }

//    @DataProvider
//    public Iterator<Object[]> validGroupsFromXml() throws IOException {
//        //List<Object[]> list = new ArrayList<Object[]>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/entries.xml")))) {
//            String xml = "";
//            String line = reader.readLine();
//            while (line != null) {
//                xml += line;
//                line = reader.readLine();
//            }
//            XStream xstream = new XStream();
//            xstream.processAnnotations(EntryData.class);
//            List<EntryData> groups = (List<EntryData>) xstream.fromXML(xml);
//            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
//        }
//    }
//
//    @DataProvider
//    public Iterator<Object[]> validGroupsFromJson() throws IOException {
//        //List<Object[]> list = new ArrayList<Object[]>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/entries.json")))) {
//            String json = "";
//            String line = reader.readLine();
//            while (line != null) {
//                json += line;
//                line = reader.readLine();
//            }
//            Gson gson = new Gson();
//            List<EntryData> groups = gson.fromJson(json, new TypeToken<List<EntryData>>(){}.getType()); // равно =List<GroupData>.class
//            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
//        }
//    }

    @Test //(enabled = false)
    public void testEntryModification() {
        int beforeCount = app.entry().count();
        Entries before = app.db().entries();
        app.goTo().gotoHomePage();
        EntryData modifiedEntry = before.iterator().next(); //next возвращает любой элемент из множества
        EntryData entry = new EntryData()
                .withId(modifiedEntry.getId()).withFirstname("modified").withMiddlename("modified").withLastname("modified").withNickname("modified").withTitle("modified").withCompany("modified").withAddress("modified").withHome("modified").withPhoto(modifiedEntry.getPhoto());
        app.goTo().gotoHomePage();
        app.entry().modify(entry);
        // int after = app.getEntryHelper().getEntryCount();
       // int beforeCount = app.entry().count();
        assertThat(app.entry().count(), equalTo(before.size()));
        Entries after = app.db().entries();

        assertThat(after, equalTo(before.without(modifiedEntry).withAdded(entry)));
        verifyEntryListInUI();
    }

}
