drop table if exists public.users;
drop sequence if exists public.user_id_seq;

create table public.users
(
    id            bigint       not null,
    birthday_date timestamp    not null,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    primary key (id)
);

create sequence user_id_seq start with 1 increment by 1;
