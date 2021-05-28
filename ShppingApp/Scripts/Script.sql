drop table shoppingapp.product;

create table shoppingapp.product(
	product_id int primary key auto_increment
	, subcategory_id int
	, product_name varchar(30)
	, price int default 0 
	, brand varchar(30)
	, detail text
	, filename varchar(40)
) default character set utf8;


create table member(
member_id int primary key auto_increment
, m_id varchar(20)
, m_pass varchar(20)
, m_name varchar(20)
) default character set utf8;