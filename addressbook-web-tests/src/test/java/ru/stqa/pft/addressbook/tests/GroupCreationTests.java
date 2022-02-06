package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        //List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(GroupData.class);
            List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        //List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); // равно =List<GroupData>.class
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }


    @Test(dataProvider = "validGroupsFromJson") //указываем какой провайдер будет использовать тест
    public void testGroupCreation(GroupData group) {
       // String[] names = new String[]{"test1", "test2", "test3"};
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        Groups after = app.group().all();
        //присваиваем группе id, берем коллекцию с известными id, превращаем ее в поток,
        //mapToInt в качестве параметра принимает описание того, как объект проеобр. в число
        //в map мы должны передать анонимную ф-ю,
        // которая будет послед. применятся ко всем элементов потока и каждый из них будет преобр. в число
        //в результате из потока объектов GroupData мы получаем поток целых чисел.
        //анонимная функция в качестве парамета приимает группу,
        //а в качестве результата выдает id этой группы(преоб. объект в число)
        //когда получили в итоге поток целых чисел, вызываем метод max,
        // и преобразуем результат в обычное целое число
//        assertThat(after, equalTo(
//                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    @Test(enabled = false)
    public void testBadGroupCreation() { //Группа с ' не должна создаваться
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test7'");
        app.group().create(group);
        assertThat(app.group().сount(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
