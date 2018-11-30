package com.cv.utilizable.taskmanager.beans;

import io.ebean.Finder;

public class DBIteratorFinder extends Finder<Long, DBIterator> {
    /**
     * Create with the type of the entity bean.
     * <pre>{@code
     *
     * public class CustomerFinder extends Finder<Customer> {
     *
     *   public CustomerFinder() {
     *     super(Customer.class);
     *   }
     *
     *   // ... add extra customer specific finder methods
     * }
     *
     * @Entity
     * public class Customer extends BaseModel {
     *
     *   public static final CustomerFinder find = new CustomerFinder();
     *   ...
     *
     * }</pre>
     *
     * @param type
     */
    public DBIteratorFinder() {
        super(DBIterator.class);
    }

    public DBIterator byName(String name) {

        return  db().find(DBIterator.class)
                .where().eq("name", name)
                .findOne();
    }
}
