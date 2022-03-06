-- // create site table
-- Migration SQL that makes the change goes here.
create table site (
    id int not null auto_increment primary key,
    name varchar(64)
);

insert into site (name) values ('huv');

-- //@UNDO
-- SQL to undo the change goes here.
drop table site;

