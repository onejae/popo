-- // create postitem table
-- Migration SQL that makes the change goes here.
create table postitem (
    id int,
    url varchar(512),
    views int,
    site_id int,
    board_id int,
    primary key(id),
    foreign key(site_id) references site (id),
    foreign key(board_id) references board (id)
);




-- //@UNDO
-- SQL to undo the change goes here.
drop table postitem;

