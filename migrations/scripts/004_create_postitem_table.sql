-- // create postitem table
-- Migration SQL that makes the change goes here.
create table postitem (
    id int,
    url varchar(512),
    views int,
    site_id int,
    primary key(id),
    foreign key(site_id) references site (id)
);




-- //@UNDO
-- SQL to undo the change goes here.
drop table postitem;

