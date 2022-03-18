-- // create site table
-- Migration SQL that makes the change goes here.
create table object_type (
    id int not null primary key,
    name varchar(64)
);

insert into object_type values (1, 'Board'), (2, 'Site');

create table object (
    id int not null auto_increment primary key,
    object_type_id int not null references object_type (id),
    name varchar(64)
);

create table site (
    id int not null auto_increment primary key,
    object_id int not null references object (id)
);

insert into object (object_type_id, name) values (2, 'huv');
insert into site (object_id) values (1);

-- //@UNDO
-- SQL to undo the change goes here.
drop table site;
drop table object;
drop table object_type;

