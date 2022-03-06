-- // create board table
-- Migration SQL that makes the change goes here.
create table board (
    id int not null auto_increment primary key,
    site_id int,
    name varchar(64),
    url varchar(512),
    foreign key(site_id) references site (id)
);

insert into board (site_id, name, url) values (1, "utza", "http://web.humoruniv.com/board/humor/list.html?table=pds&pg=0");

-- //@UNDO
-- SQL to undo the change goes here.
drop table board;


