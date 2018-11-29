package com.cv.utilizable.taskmanager.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name="iterator")
public class DBIterator extends BaseDomain {

    @Column(name = "iter_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DBListImpl> dblists = new ArrayList<>();

    public static final DBIteratorFinder find = new DBIteratorFinder();

    public DBIterator() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DBListImpl> getDblists() {
        return dblists;
    }

    public void setDblists(List<DBListImpl> dblists) {
        this.dblists = dblists;
    }

    public void add(String code){
        DBListImpl.create(code, this).save();
    }

    public DBListImpl getElement(String code){

        return DBListImpl.find.query().where().eq("code", code).select("code, status").findOne();
    }

    @Override
    public String toString() {
        return "DBIterator{" +
                "name='" + name + '\'' +
                ", dblists=" + dblists +
                ", id=" + id +
                ", version=" + version +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
