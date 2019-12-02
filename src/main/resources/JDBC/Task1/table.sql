drop table books;
drop table todelete;

create table books(
    book_id serial,
    author text,
    name text,
    genre text,
    volumes int,
    primary key (book_id)
);

create table todelete(
    id serial,
    info text,
    primary key (id)
);

insert into books values (1,'Jon Kleinberg, Eva Tardos','Algorithm Design','Computer Science',1);