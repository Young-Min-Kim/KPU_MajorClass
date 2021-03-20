CREATE TABLE accounts(
	id varchar(100) not null,
	name varchar(100) not null,
	passwd varchar(100) not null,
	email varchar(100) not null,
	introduce varchar(1000),
	PRIMARY KEY (id)
	);

CREATE TABLE projects(
	userid varchar(100) not null,
	proj_name varchar(200) not null,
	number int not null,
	PRIMARY KEY (proj_name)
	);