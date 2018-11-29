alter table iter_list drop constraint if exists fk_iter_list_dbiterator_id;
drop index if exists ix_iter_list_dbiterator_id;

drop table if exists iterator;

drop table if exists iter_list;

