package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
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
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

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
