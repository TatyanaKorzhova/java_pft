package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EntryPhoneTests extends TestBase {

    @Test //(enabled = false)
    public void testEntryPhones() {
        app.goTo().gotoHomePage();
        EntryData entry = app.entry().all().iterator().next();
        EntryData entryIntoFromEditForm = app.entry().intoFromEditForm(entry);
    }

    private String mergePhones(EntryData entry) { //метод обратных проверок
        return Arrays.asList(entry.getHome(), entry.getMobile(), entry.getWork())
                .stream().filter((s) -> !s.equals(""))
                .map(EntryPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", ""); //рег выражение
    }

}
