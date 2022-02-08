package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.EntryData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class EntryDataGenerator {
    @Parameter(names = "-c", description = "Entry count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        EntryDataGenerator generator = new EntryDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<EntryData> entries = generateEntries(count);
        if (format.equals("csv")) {
            saveAsCsv(entries, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(entries, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(entries, new File(file));
        } else {
            System.out.println("Unrecognixed format" + format);
        }
    }

    private void saveAsJson(List<EntryData> entries, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(entries);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);//close не надо - закроется автоматически, после блока try
        }
    }

    private void saveAsXml(List<EntryData> entries, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class);
        String xml = xstream.toXML(entries);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<EntryData> entries, File file) throws IOException { //каждая запись сохр в виде строки, разделенной ';'
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)) {
            for (EntryData entry : entries) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", entry.getFirstname(), entry.getMiddlename(), entry.getLastname(), entry.getNickname(), entry.getTitle(), entry.getCompany(), entry.getAddress(), entry.getHome(), entry.getMobile(), entry.getWork(), entry.getFax(),entry.getEmail(), entry.getEmail2(), entry.getEmail2(), entry.getHomepage(), entry.getBday(), entry.getBmonth(), entry.getByear(), entry.getAday(), entry.getAmonth(), entry.getAyear(), entry.getNew_group(), entry.getAddress2(), entry.getPhone2(), entry.getNotes(), entry.getAllPhones()));
            }
        }
    }

    private List<EntryData> generateEntries(int count) { //генерируем список объектов типа GroupData тестовых данных
        List<EntryData> entries = new ArrayList<EntryData>();
        for (int i = 0; i < count; i++) {
          //  entries.add(new EntryData().getFirstname(String.format("test %s", i)).withMiddlename(String.format("middlename\n%s", i)).withLastname(String.format("lastname\n%s", i)).withNickname(String.format("nickname\n%s", i)).withTitle(String.format("title\n%s", i)).withCompany(String.format("company\n%s", i)).withAddress(String.format("address\n%s", i)).withHome(String.format("home\n%s", i)).withMobile(String.format("mobile\n%s", i)).withWork(String.format("work\n%s", i)).withFax(String.format("fax\n%s", i)).withEmail(String.format("email\n%s", i)).withEmail2(String.format("email2\n%s", i)).withEmail3(String.format("email3\n%s", i)).withHomepage(String.format("homepage\n%s", i)).withBday(String.format("bday\n%s", i)).withBmonth(String.format("bmonth\n%s", i)).withByear(String.format("byear\n%s", i)).withAday(String.format("aday\n%s", i)).withAmonth(String.format("amonth\n%s", i)).withAyear(String.format("ayear\n%s", i)).withNew_group(String.format("new_group\n%s", i)).withAddress2(String.format("Address2\n%s", i)).withPhone2(String.format("phone2\n%s", i)).withgetNotes(String.format("notes\n%s", i)).withAllPhones(String.format("allPhones\n%s", i)));
        }
        return entries;
    }
}
