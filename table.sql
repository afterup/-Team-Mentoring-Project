

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
drop   table category;
create table category(
	cateno number primary key,
	cname char(20) not null
);
	
	
-- classTable
	                
drop   table class;
create table class
(
	classid	 	number primary key,
	classinfo 	varchar2(800),
	userid 		char(10),
	cateno 		number			not null,
	cname 		varchar2(15) 	not null,
	opendate	date			not null,
	closedate 	date			not null,
	student		integer			not null,
	foreign key(userid) references member(userid),
	foreign key(cateno) references category(cateno)
);
	



--insert

insert into member values ('solbi94', '1234', '고솔비', 'gosolb0904@gmail.com', 01040109537);
insert into member values ('gildong', '1111', '홍길동', 'gildong@gmail.com', 01012345678);
insert into member values ('lime', '2222', '길라임', 'lime@gmail.com', 01011112222);
insert into member values ('juwon', '3333', '김주원', 'juwon@gmail.com', 01012457890);
select * from member;

insert into category values (1, '컴퓨터/IT');
insert into category values (2, '예술/대중문화');
insert into category values (3, '역사/문화');
insert into category values (4, '정치/사회');
insert into category values (5, '종교');
insert into category values (6, '기술/공학');
insert into category values (7, '인문');
insert into category values (8, '과학');
select * from category;


insert into class 
values (class_seq.nextval, '자바 강의입니다','solbi94', 1, 'JAVA','19/07/01','19/07/08',0);
insert into class 
values (class_seq.nextval, 'html 강의입니다','gildong', 1, 'html','19/07/01','19/07/10',0);

select * from class;


--강의 승인여부, 수강신청 테이블
	