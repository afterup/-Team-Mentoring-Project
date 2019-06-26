

-- memberTable
	drop table member;
	create table member(
		userid varchar2(20) constraint member_pk primary key,
		password varchar2(15) not null,
		uname varchar2(15) not null,
		email varchar2(40) not null,
		phone varchar2(17) not null
	);


-- classID (sequence)	
	drop sequence person_seq;
	create sequence person_seq
	start with 1
	increment by 1
	nocycle
	nocache;

	
-- categoryTable
	drop table category;
	create table category(
		
	);
	
	
-- classTable
	drop table class;
	create table class(
	
	);
	
	