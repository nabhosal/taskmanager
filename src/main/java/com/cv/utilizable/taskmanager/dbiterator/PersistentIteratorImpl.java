package com.cv.utilizable.taskmanager.dbiterator;

import com.cv.utilizable.taskmanager.dbiterator.beans.DBIterator;
import com.cv.utilizable.taskmanager.dbiterator.beans.DBListImpl;

import java.util.Iterator;
import java.util.List;

public class PersistentIteratorImpl implements PersistentIterator {

    private DBIterator dbIterator;

    protected PersistentIteratorImpl(){
    }

    protected PersistentIteratorImpl(DBIterator dbIterator){
        this.dbIterator = dbIterator;
    }

    public PersistentIteratorImpl(String name){
        dbIterator = new DBIterator();
        dbIterator.setName(name);
        dbIterator.save();
    }

    @Override
    public void add(String code) {
        dbIterator.add(code);
    }

    @Override
    public DBListImpl get(String code) {

        return DBListImpl.find.byCode(code);
    }

    @Override
    public DBListImpl get(String code, Object def) {
        DBListImpl element = get(code);
        return element != null ? element : (DBListImpl)def;
    }

    @Override
    public void completed(String code) {
        DBListImpl element = dbIterator.getElement(code);
        if(element != null){
            element.setStatus(true);
            element.save();
        }
    }

    @Override
    public Boolean getStatus(String code) {
        DBListImpl element = dbIterator.getElement(code);
        if(element != null)
            return element.isStatus();

        return null;
    }

    @Override
    public boolean remove(String code) {

        return DBListImpl.find.byCode(code).delete();
    }

    @Override
    public boolean clearAll() {

        return dbIterator.deletePermanent();
    }

    @Override
    public List<DBListImpl> getAllIncompletedElements() {

        return DBListImpl.find.query()
                        .where()
                        .eq("status", false)
                        .and()
                        .eq("dbiterator_id", dbIterator.getId())
                        .findList();
    }

    @Override
    public List<DBListImpl> getAllCompletedElements() {

        return DBListImpl.find.query()
                .where()
                .eq("status", true)
                .and()
                .eq("dbiterator_id", dbIterator.getId())
                .findList();
    }

    @Override
    public PersistentIterator loadFromDBInternal(String iteratorName) {

        DBIterator iterator = DBIterator.find.byName(iteratorName);
        if(iterator == null){
            iterator = new DBIterator();
            iterator.setName(iteratorName);
            iterator.save();
        }
        return new PersistentIteratorImpl(iterator);
    }

    public static PersistentIterator loadFromDB(String iteratorName) {

        return new PersistentIteratorImpl().loadFromDBInternal(iteratorName);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<DBListImpl> iterator() {
        return dbIterator.getDblists().iterator();
    }

    @Override
    public String toString() {
        return "PersistentIteratorImpl{" +
                "dbIterator=" + dbIterator +
                '}';
    }
}
