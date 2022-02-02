package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test7");
        app.group().create(group);
        Groups after = app.group().all();
        //app.logoutPage();

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

    @Test
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
