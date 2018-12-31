package com.cv.utilizable.taskmanager.dbiterator.beans;

import javax.persistence.*;

@Entity
@Table(name="iter_list")
public class DBListImpl extends BaseDomain {

    @Column(name = "code", nullable=false, unique=true)
    private String code;

    private boolean status = false;

    @ManyToOne
    @JoinColumn(name = "dbiterator_id")
    DBIterator iterator;

    public static final DBListFinder find = new DBListFinder();

    public DBListImpl(String code, DBIterator iterator) {
        super();
        this.code = code;
        this.iterator = iterator;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DBIterator getIterator() {
        return iterator;
    }

    public void setIterator(DBIterator iterator) {
        this.iterator = iterator;
    }

    public static DBListImpl create(String code, DBIterator iterator){

        return new DBListImpl(code, iterator);
    }

    @Override
    public String toString() {
        return "DBListImpl{" +
                "code='" + getCode() + '\'' +
                ", status=" + isStatus() +
                ", iterator=" + getIterator() +
                ", id=" + getId() +
                ", version=" + getVersion() +
                ", createdOn=" + getCreatedOn() +
                ", modifiedOn=" + getModifiedOn() +
                '}';
    }
}
