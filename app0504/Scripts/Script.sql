create table member(
	member_id int primary key auto_increment
	, user_id varchar(20)
	, password varchar(20)
	, name varchar(20)
	, regdate timestamp default now()
) default character set utf8;


insert into member(user_id,password,name) values("ww","1234","이운우");