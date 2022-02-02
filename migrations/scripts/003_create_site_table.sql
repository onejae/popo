-- // create site table
-- Migration SQL that makes the change goes here.
create table site (
    id int,
    name varchar(64),
    primary key (id)
);




-- //@UNDO
-- SQL to undo the change goes here.
drop table site;

