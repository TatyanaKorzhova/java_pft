package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class GroupHelper extends HelperBase{

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
      click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());

    }

    public void initGroupCreation() {
      click(By.name("new"));
    }

    public void deleteSelectedGroups() {
      click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
      //click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
       initGroupCreation();
       fillGroupForm(group);
       submitGroupCreation();
       returnToGroupPage();
       // logoutPage();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
         return wd.findElements(By.name("selected[]")).size();
    }
//
//    public void submitGrouppDeletion() {
//
//        List<WebElement> list = wd.findElements(By.xpath("//input[@type='checkbox']"));
//        if (list.size() > 0) {
//            list.get(0).click();
//            wd.findElement(By.xpath("//input[@value='Delete']")).click();
//            //assertTrue(EntryHelper.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
//        }
//        wd.findElement(By.linkText("Logout")).click();
//
//    }
}
