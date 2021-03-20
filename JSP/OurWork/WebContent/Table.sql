CREATE TABLE accounts(
	id varchar(100) not null,
	name varchar(100) not null,
	passwd varchar(100) not null,
	email varchar(100) not null,
	introduce varchar(1000),
	PRIMARY KEY (id)
	);

	
	

SELECT * FROM projects;

CREATE TABLE projects(
	userid varchar(100) not null,
	proj_name varchar(200) not null,
	number int not null,
	PRIMARY KEY (proj_name)
	);

CREATE TABLE to_do_list(
	listname varchar(500) not null,
	number int not null,
	proj_name varchar(200) not null,
	PRIMARY KEY (listname)
	);

CREATE TABLE to_do(
	todoname varchar(500) not null,
	listname varchar(500),
	sequence int,
	PRIMARY KEY (todoname)
	);
	
	
	CREATE TABLE projects(
    user_id varchar(100) not null,
    project_no int not null,
    project_name varchar(200) not null,
    PRIMARY KEY (project_no)
    );

CREATE TABLE todolist(
    todolist_no int not null,
    project_no int not null,
    PRIMARY KEY (todolist_no)
    );

CREATE TABLE todo(
    todo_no int,
    todolist_no int not null,
    todo varchar(300),
    rownum int,
    PRIMARY KEY (todo_no)
    );

    insert into projects values('2016156007', 1, '첫번째 프로젝트');
    insert into projects values('2016156007', 2, '두번째 프로젝트');
    insert into projects values('2016156007', 3, '세번째 프로젝트');
    insert into projects values('2016156007', 4, '네번째 프로젝트');
    insert into projects values('2016156007', 5, '다섯번째 프로젝트');

    insert into todolist values(1, 1);
    insert into todolist values(2, 1);
    insert into todolist values(3, 1);
    insert into todolist values(4, 2);
    insert into todolist values(5, 2);

    insert into todo values(1, 1);
    insert into todo values(2, 1);
    insert into todo values(3, 1);
    insert into todo values(4, 2);
    insert into todo values(5, 2);
    insert into todo values(6, 3);
    insert into todo values(7, 3);
    insert into todo values(8, 4);
    insert into todo values(9, 5);

    commit;
	
drop table projects;
drop table to_do_list;
drop table to_do;

SELECT COUNT(userid) FROM projects WHERE userid = "id";
select * from projects;
INSERT INTO projects VALUES ("id","프로젝트1",1);
SELECT proj_name FROM projects WHERE userid ="id" AND number = 1