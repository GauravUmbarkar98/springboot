create table persistent_logins (username varchar(64) not null,series varchar(64), token varchar(64) not null,last_used timestamp not null, primary key(series));

create table users(username varchar(20) not null,password varchar(20) not null,enabled varchar2(10) not null, primary key(username));

create table authorities (username varchar(20) not null,authority varchar(20) not null);

insert into users values('majrul', '123', 'true');
insert into users values('john', '123', 'true');
insert into users values('smith', '123', 'false');

insert into authorities values('majrul', 'ROLE_ADMIN');
insert into authorities values('majrul', 'ROLE_USER');
insert into authorities values('john', 'ROLE_USER');
insert into authorities values('smith', 'ROLE_ADMIN');
