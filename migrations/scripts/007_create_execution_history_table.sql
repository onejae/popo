-- // create execution history table
-- Migration SQL that makes the change goes here.
create table execution_history (
    id int not null auto_increment primary key,
    job_id int references job (id),
    status tinyint,
    created_at datetime not null
);


-- //@UNDO
-- SQL to undo the change goes here.
drop table execution_history;

