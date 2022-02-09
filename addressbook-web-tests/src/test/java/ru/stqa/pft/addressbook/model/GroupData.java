package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")

public class GroupData {
    @XStreamOmitField //пропускать поле Id при записи в файл
    @Id
    @Column(name = "group_id")
    private int id = Integer.MAX_VALUE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);
    }

    @Expose //аннотация помечает какие поля должны быть реализованы
    @Column(name = "group_name")
    //@Type(type = "text")
    private String name;

    @Expose
    @Column(name = "group_header")
   // @Type(type = "text")
    private String header;

    @Expose
    @Column(name = "group_footer")
    //@Type(type = "text")
    private String footer;

    @ManyToMany(mappedBy = "groups")
    private Set<EntryData> entries = new HashSet<EntryData>();
    public int getId() {
        return id;
    }

    public Set<EntryData> getEntries() {
        return entries;   //сделать преобразование new entries и вернуть преобразовавшееся значение
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

}