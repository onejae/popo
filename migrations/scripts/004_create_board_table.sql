-- // create board table
-- Migration SQL that makes the change goes here.
create table board (
    id int not null auto_increment primary key,
    object_id  int references object (id),
    site_id int references site (id),
    url varchar(512)
);

insert into object (object_type_id, name) values (1, 'utza');
insert into board (object_id, site_id, url) values (2, 1, "http://web.humoruniv.com/board/humor/list.html?table=pds&pg=0");

-- //@UNDO
-- SQL to undo the change goes here.
drop table board;


