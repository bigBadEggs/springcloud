drop database if exists ithm8001;
create database ithm8001 character set utf8;
use ithm8001;
create table dept(
	deptno bigint auto_increment,
	dname varchar(50),
	dbname varchar(50),
	constraint pk_deptno primary key(deptno)
);
insert into dept(dname, dbname) values ('开发部', database());
insert into dept(dname, dbname) values ('财务部', database());
insert into dept(dname, dbname) values ('市场部', database());
insert into dept(dname, dbname) values ('技术部', database());
insert into dept(dname, dbname) values ('公关部', database());