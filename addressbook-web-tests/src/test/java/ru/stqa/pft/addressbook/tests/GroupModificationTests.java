package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

//    @DataProvider
//    public Iterator<Object[]> validGroupsFromXml() throws IOException {
//        //List<Object[]> list = new ArrayList<Object[]>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
//            String xml = "";
//            String line = reader.readLine();
//            while (line != null) {
//                xml += line;
//                line = reader.readLine();
//            }
//            XStream xstream = new XStream();
//            xstream.processAnnotations(GroupData.class);
//            List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
//            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
//        }
//    }
//
//    @DataProvider
//    public Iterator<Object[]> validGroupsFromJson() throws IOException {
//        //List<Object[]> list = new ArrayList<Object[]>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
//            String json = "";
//            String line = reader.readLine();
//            while (line != null) {
//                json += line;
//                line = reader.readLine();
//            }
//            Gson gson = new Gson();
//            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); // равно =List<GroupData>.class
//            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
//        }
//    }


    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("modified").withHeader("test2").withFooter("test3");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat(app.group().сount(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }

}
