create table iterator (
  id                            bigint auto_increment not null,
  iter_name                     varchar(255),
  version                       bigint not null,
  created_on                    timestamp not null,
  modified_on                   timestamp not null,
  constraint pk_iterator primary key (id)
);

create table iter_list (
  id                            bigint auto_increment not null,
  code                          varchar(255) not null,
  status                        boolean default false not null,
  dbiterator_id                 bigint,
  version                       bigint not null,
  created_on                    timestamp not null,
  modified_on                   timestamp not null,
  constraint pk_iter_list primary key (id)
);

create index ix_iter_list_dbiterator_id on iter_list (dbiterator_id);
alter table iter_list add constraint fk_iter_list_dbiterator_id foreign key (dbiterator_id) references iterator (id) on delete restrict on update restrict;

