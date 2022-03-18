-- // create job table
-- Migration SQL that makes the change goes here.
create table job_type (
    id int primary key,
    name varchar(64)
);

insert into job_type values (1, 'Board'), (2, 'Site');

create table job (
    id int not null auto_increment primary key,
    job_object_id int not null references object (id),
    enabled boolean not null,
    created_at datetime not null default current_timestamp,
    modified_at datetime not null default current_timestamp on update current_timestamp
);

insert into job (job_object_id, enabled) values (2, true);

create table schedule (
    id int primary key references job (id),
    note varchar(512),
    interval_in_seconds int not null,
    enabled boolean,
    created_at datetime not null,
    modified_at datetime
);


-- //@UNDO
-- SQL to undo the change goes here.
drop table schedule;
drop table job;
drop table job_type;


