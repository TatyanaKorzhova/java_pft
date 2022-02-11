package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.Entries;
import ru.stqa.pft.addressbook.model.EntryData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));//взять значение системного свойства
    //  protected WebDriver wd;

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test" + m.getName() + " with parameters" + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test" + m.getName());
    }

    public void verifyGroupListInUI() { //сравниваем 2 множества
        if (Boolean.getBoolean("verifyUI")){ //получаем сист. св. с заданным именем и преобразуем его в boolean
            Groups dbGroups = app.db().groups(); //список групп из БД
            Groups uiGroups = app.group().all(); //список групп из интерфейса
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
            //сравниваем 2 множества объектов, состоящих из id и name, из UI и из БД
        }
    }

    public void verifyEntryListInUI() { //сравниваем 2 множества
        if (Boolean.getBoolean("verifyUI")){ //получаем сист. св. с заданным именем и преобразуем его в boolean
            Entries dbEntry = app.db().entries(); //список контактов из БД
            Entries uiEntries = app.entry().all(); //список контактов из интерфейса
            assertThat(uiEntries, equalTo(dbEntry.stream()
                    .map((g) -> new EntryData().withId(g.getId()).withFirstname(g.getFirstname())).collect(Collectors.toSet())));
            //сравниваем 2 множества объектов, состоящих из id и name, из UI и из БД
        }
    }
}
