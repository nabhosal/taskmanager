package com.cv.utilizable.taskmanager.beans;

import io.ebean.Finder;

public class DBListFinder extends Finder<Long, DBListImpl> {
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
    public DBListFinder() {
        super(DBListImpl.class);
    }

    public DBListImpl byCode(String code) {

        return  db().find(DBListImpl.class)
                .where().eq("code", code)
                .findOne();
    }
}
