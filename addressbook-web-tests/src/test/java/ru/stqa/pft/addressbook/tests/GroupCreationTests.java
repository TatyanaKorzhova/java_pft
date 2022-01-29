package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test7");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        //app.logoutPage();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        //присваиваем группе id, берем коллекцию с известными id, превращаем ее в поток,
        //mapToInt в качестве параметра принимает описание того, как объект проеобр. в число
        //в map мы должны передать анонимную ф-ю,
        // которая будет послед. применятся ко всем элементов потока и каждый из них будет преобр. в число
        //в результате из потока объектов GroupData мы получаем поток целых чисел.
        //анонимная функция в качестве парамета приимает группу,
        //а в качестве результата выдает id этой группы(преоб. объект в число)
        //когда получили в итоге поток целых чисел, вызываем метод max,
        // и преобразуем результат в обычное целое число
        before.add(group);
        Assert.assertEquals(before, after);

    }

}
