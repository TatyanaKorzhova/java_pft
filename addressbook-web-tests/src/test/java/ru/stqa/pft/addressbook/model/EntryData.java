package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("entry")
@Entity
@Table(name = "addressbook")
@Where(clause = "deprecated='0000-00-00'")
public class EntryData {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "title")
    private String title;
    @Column(name = "company")
    private String company;
    @Column(name = "address")
    private String address;
    @Column(name = "home", columnDefinition="TEXT")
   // @Type(type = "text")
    private String home;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "work")
    private String work;
    @Column(name = "fax")
    private String fax;
    @Column(name = "email")
    private String email;
    @Column(name = "email2")
    private String email2;
    @Column(name = "email3")
    private String email3;
    @Column(name = "homepage")
    private String homepage;
    @Column(name = "bday", columnDefinition = "tinyint")
    private String bday;
    @Column(name = "bmonth")
    private String bmonth;
    @Column(name = "byear")
    private String byear;
    @Column(name = "aday")
    private int aday;
    @Column(name = "amonth")
    private String amonth;
    @Column(name = "ayear")
    private String ayear;
//    @Column(name = "new_group")   //для связи many to many нужно убрать new_group
//    private String new_group;
    @Column(name = "address2")
    private String address2;
    @Column(name = "phone2")
    private String phone2;
    @Column(name = "notes")
    private String notes;

    @Transient
    private String allPhones;

    @Column(name = "photo", columnDefinition = "mediumtext")
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)//чтобы из БД извлекалось как можно больше информ. за одно соединение
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public Groups getGroups() {
        return new Groups(groups);
    }

    public String getPhoto() {
        return photo;
    }

    public EntryData withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public EntryData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

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

    public String getFirstname() {
        return firstname;
    }
    public EntryData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getMiddlename() {
        return middlename;
    }
    public EntryData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastname() {
        return lastname;
    }
    public EntryData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getNickname() {
        return nickname;
    }
    public EntryData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getTitle() {
        return title;
    }
    public EntryData withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCompany() {
        return company;
    }
    public EntryData withCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAddress() {
        return address;
    }
    public EntryData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHome() {
    return home;
}
    public EntryData withHome(String home) {
        this.home = home;
        return this;
    }

    public String getMobile() {
    return mobile;
}
    public EntryData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getWork() {
    return work;
}
    public EntryData withWork(String work) {
        this.work = work;
        return this;
    }

    public String getFax() {
        return fax;
    }
    public EntryData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public EntryData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail2() {
        return email2;
    }
    public EntryData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }
    public EntryData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }
    public EntryData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getBday() {
        return bday;
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

    public EntryData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public String getBmonth() {
        return bmonth;
    }
    public EntryData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public String getByear() {
        return byear;
    }
    public EntryData withByear(String byear) {
        this.byear = byear;
        return this;
    }

//    public Int getAday() {
//        return aday;
//    }
//    public EntryData withAday(Int aday) {
//        this.aday = aday;
//        return this;
//    }

    public EntryData withAday(int aday) {
        this.aday = aday;
        return this;
    }

    public int getAday() {
        return aday;
    }

    public String getAmonth() {
        return amonth;
    }
    public EntryData withAmonth(String amonth) {
        this.amonth = amonth;
        return this;
    }

    public String getAyear() {
        return ayear;
    }
    public EntryData withAyear(String ayear) {
        this.ayear = ayear;
        return this;
    }

//    public String getNew_group() {
//        return new_group;
//    }
//    public EntryData withNew_group(String new_group) {
//        this.new_group = new_group;
//        return this;
//    }

    public String getAddress2() {
        return address2;
    }
    public EntryData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getPhone2() {
        return phone2;
    }
    public EntryData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public String getNotes() {
        return notes;
    }
    public EntryData withNotes(String notes) {
        this.notes = notes;
        return this;
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

    public EntryData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
