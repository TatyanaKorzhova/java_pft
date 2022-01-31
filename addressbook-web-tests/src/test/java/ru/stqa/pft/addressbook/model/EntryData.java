package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class EntryData {
    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String fax;
    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String amonth;
    private final String ayear;
    private final String new_group;
    private final String address2;
    private final String phone2;
    private final String notes;

    public EntryData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group, String address2, String phone2, String notes) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.new_group = new_group;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public EntryData(int id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group, String address2, String phone2, String notes) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.new_group = new_group;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

//     public EntryData(String firstname, String lastname, String home, String mobile, String work) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.home = home;
//        this.mobile = mobile;
//        this.work = work;
//    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAday() {
        return aday;
    }

    public String getAmonth() {
        return amonth;
    }

    public String getAyear() {
        return ayear;
    }

    public String getNew_group() {
        return new_group;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }


////
    public String getWorkPhone() {
        return workPhone;
    }
    public EntryData withWorkPhone(String workPhone){
        this.workPhone() = workPhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public EntryData withMobilePhone(String mobilePhone){
        this.mobilePhone() = mobilePhone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public EntryData withHomePhone(String homePhone){
        this.homePhone() = homePhone;
        return this;
    }
    ////
    public String getNotes() {
        return notes;
    }
    public String getNotes() {
        return notes;
    }
    public String getNotes() {
        return notes;
    }
    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "EntryData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryData entryData = (EntryData) o;
        return id == entryData.id && Objects.equals(firstname, entryData.firstname) && Objects.equals(lastname, entryData.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public EntryData withLastname(String lastname) {
//        this.lastname = lastname;
//        return this;
//    }
    public EntryData withHomePhone(String home) {
        this.home = home;
        return this;
    }
    public EntryData withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }
    public EntryData withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public int withId(int id) {
        return id;
    }
}
