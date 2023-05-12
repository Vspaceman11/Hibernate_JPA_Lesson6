CREATE DATABASE library2
use library2;

drop table author;
drop table book;
drop table author_book;

create table author(
id int not null auto_increment primary key,
name varchar(45),
last_name varchar(45));

create table book(
id int not null auto_increment primary key,
name varchar(45),
);

create table author_book
(
    author_id int not null,
    book_id int not null,
    foreign key (author_id) references author(id),
    foreign key (book_id) references book(id)
);

