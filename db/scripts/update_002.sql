create table items (
   id serial primary key not null,
   name varchar(2000),
   create timestamp
);
insert into items (name, create) values ('n', now());

create table car (
                       id serial primary key not null,
                       name varchar(2000),
                       created timestamp
);
alter table car rename TO cars;
alter table cars rename column name to model;