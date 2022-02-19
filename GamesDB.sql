create database if not exists games;

use games;

drop table if exists genres;
drop table if exists games;

create table genres(
id int(10) not null auto_increment,
genre vaarchar(50) not null,
primary key(id)
);

create table games(
id int(10) not null auto_increment;
title varchar(50) not null,
year_released int(4) not null,
developer_name varchar(50) not null,
genre_id int(10) not null,
primary key (id),
foreign key (genre_id) references genres(id)
);