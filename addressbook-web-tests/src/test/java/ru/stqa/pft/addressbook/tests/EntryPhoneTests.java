package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EntryData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntryPhoneTests extends TestBase {

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
