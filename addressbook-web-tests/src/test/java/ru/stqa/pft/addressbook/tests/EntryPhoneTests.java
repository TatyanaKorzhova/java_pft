package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    @Test //(enabled = false) //тест проверки адреса
    public void testHomeAddress() {
        app.goTo().gotoHomePage();
        EntryData entry = app.entry().all().iterator().next();//загружаем подмножество контактов и рандомно выбираем контакт
        EntryData entryIntoFromEditForm = app.entry().intoFromEditForm(entry);//проверяем, что введенные данные = отображающимся на гл странице

        assertThat(entry.getAddress(), equalTo(entryIntoFromEditForm.getAddress()));
    }


    @Test //(enabled = false) //тест для проверки кнопки Details
    public void testSubmitDetails() {
        app.goTo().gotoHomePage();
        EntryData entry = app.entry().all().iterator().next();//загружаем подмножество контактов и рандомно выбираем контакт
        EntryData entryIntoFromEditForm = app.entry().intoFromEditForm(entry);//проверяем, что введенные данные = отображающимся на гл странице

        assertThat(entry.getAddress(), equalTo(entryIntoFromEditForm.getAddress()));
    }

}
