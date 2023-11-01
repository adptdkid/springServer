create sequence character_class_seq start with 1 increment by 50;
create sequence character_seq start with 1 increment by 50;
create sequence race_seq start with 1 increment by 50;

CREATE TABLE IF NOT EXISTS race (
    race_id serial primary key,
    race_name varchar(255)
);

CREATE TABLE IF NOT EXISTS character_class (
    class_id serial primary key,
    character_class_name varchar(255)
);

CREATE TABLE IF NOT EXISTS character (
    class_id integer,
    id bigint not null,
    race_id integer not null,
    character_name varchar(255) not null,
    primary key (id)
);

alter table if exists character add constraint FKrwfs56b1gaw10brfwqa4jvmke foreign key (class_id) references character_class;
alter table if exists character add constraint FKk86v4v54vguydmsgp15f3dvbu foreign key (race_id) references race;