package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class EntryData {
//    private int id;
//    private String firstname;
//    private String lastname;
//    private String group;
//    private String homePhone;
//    private String mobilePhone;
//    private String workPhone;

    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String title;
    private String company;
    private String address;
    private String home;
    private String mobile;
    private String work;
    private String fax;
    private String email;
    private String email2;
    private String email3;
    private String homepage;
    private String bday;
    private String bmonth;
    private String byear;
    private String aday;
    private String amonth;
    private String ayear;
    private String new_group;
    private String address2;
    private String phone2;
    private String notes;

//    public String getWorkPhone() {
//        return workPhone;
//    }
//
//    public EntryData withWorkPhone(String workPhone){
//        this.workPhone() = workPhone;
//        return this;
//    }
//
//    public String getMobilePhone() {
//        return mobilePhone;
//    }
//
//    public EntryData withMobilePhone(String mobilePhone){
//        this.mobilePhone() = mobilePhone;
//        return this;
//    }
//
//    public String getHomePhone() {
//        return homePhone;
//    }
//
//    public EntryData withHomePhone(String homePhone){
//        this.homePhone() = homePhone;
//        return this;
//    }

    public int getId() {
        return id;
    }
    public EntryData withId(int id) {
        this.id = id;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EntryData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public EntryData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public EntryData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public EntryData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public EntryData withTitle(String title) {
        this.title = title;
        return this;
    }

    public EntryData withCompany(String company) {
        this.company = company;
        return this;
    }

    public EntryData withAddress(String address) {
        this.address = address;
        return this;
    }
//    public String getHome() {
//       return home;
//    }
    public EntryData withHome(String home) {
        this.home = home;
        return this;
    }
//    public String getMobile() {
//        return mobile;
//    }

    public EntryData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
//    public String getWork() {
//        return work;
//    }

    public EntryData withWork(String work) {
        this.work = work;
        return this;
    }

    public EntryData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public EntryData withEmail(String email) {
        this.email = email;
        return this;
    }

    public EntryData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public EntryData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public EntryData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public EntryData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public EntryData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public EntryData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public EntryData withAday(String aday) {
        this.aday = aday;
        return this;
    }

    public EntryData withAmonth(String amonth) {
        this.amonth = amonth;
        return this;
    }

    public EntryData withAyear(String ayear) {
        this.ayear = ayear;
        return this;
    }

    public EntryData withNew_group(String new_group) {
        this.new_group = new_group;
        return this;
    }

    public EntryData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public EntryData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public EntryData withNotes(String notes) {
        this.notes = notes;
        return this;
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
//
//    ////
//    public String getNotes() {
//        return notes;
//    }
//    public String getNotes() {
//        return notes;
//    }
//    public String getNotes() {
//        return notes;
//    }
//    public String getNotes() {
//        return notes;
//    }

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


    //    public EntryData withLastname(String lastname) {
//        this.lastname = lastname;
//        return this;
//    }
//    public EntryData withHomePhone(String home) {
//        this.home = home;
//        return this;
//    }
//    public EntryData withMobilePhone(String mobile) {
//        this.mobile = mobile;
//        return this;
//    }
//    public EntryData withWorkPhone(String work) {
//        this.work = work;
//        return this;
//    }

}
