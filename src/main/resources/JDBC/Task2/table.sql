drop table homelibrary;

create table homelibrary(
    book_id serial,
    author text,
    name text,
    genre text,
    volumes int,
    primary key (book_id)
);

