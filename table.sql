

-- memberTable(회원테이블)
	drop table member;
	create table member(
		userid varchar2(20) constraint member_pk primary key,
		password varchar2(15) not null,
		uname varchar2(15) not null,
		email varchar2(40) not null,
		phone varchar2(17) not null
	);

----------------------------------------------------------------------------------------------------------------------------
-- classID (sequence)	
	drop sequence class_seq;
	create sequence class_seq
	start with 1
	increment by 1
	nocycle
	nocache;

----------------------------------------------------------------------------------------------------------------------------
-- categoryTable(카테고리테이블)
drop   table category;
create table category(
	cateno number constraint category_pk primary key,
	cname varchar2(20) not null
);
	

----------------------------------------------------------------------------------------------------------------------------
-- classTable(강의테이블)
drop table class;
create table class
(
	classid 	number constraint class_pk primary key,
	classinfo 	varchar2(800),
	userid 		varchar2(20),
	cateno	    number 			not null,
	cname 	    varchar2(15)  	not null,
	opendate 	date 			not null,
	closedate 	date 			not null,
	student 	number		    not null,
	limit       number	        not null check (limit between 5 and 20),
	constraint userid_fk foreign key(userid) references member(userid),
	constraint cateno_fk foreign key(cateno) references category(cateno)
);

	
----------------------------------------------------------------------------------------------------------------------------
-- registerTable(수강신청테이블)
drop table register;
create table register(
	classid 	number		 not null,
	userid 		varchar2(20)  not null,
	rate 		number,
	constraint r_userid_fk foreign key(userid) references member(userid),
	constraint class_id_fk foreign key(classid) references class(classid)
);

	
----------------------------------------------------------------------------------------------------------------------------
-- mentorTable(멘토테이블)
drop table mentor;
create table mentor(
	userid		varchar2(20) not null,
	job			varchar2(20) not null,
	major		varchar2(20) not null,
	license		varchar2(20),
	plan		varchar2(100) not null,
	confirm	varchar2(20) DEFAULT '대기',
	constraint m_userid_fk foreign key(userid) references member(userid)
);


	
----------------------------------------------------------------------------------------------------------------------------




------------------------------------------- Table insert ---------------------------------------------------

-- memberTable insert
insert into member values ('solbi94', '1234', '고솔비', 'gosolb0904@gmail.com', '010-4010-9537');
insert into member values ('gildong', '1111', '홍길동', 'gildong@gmail.com', '010-1234-5678');
insert into member values ('lime', '2222', '길라임', 'lime@gmail.com', '010-1111-2222');
insert into member values ('juwon', '3333', '김주원', 'juwon@gmail.com', '010-1245-7890');

-- memberTable insert (admin)
insert into member values ('admin','1234','관리자','admin@encore.com','010-1234-5678');


-- categoryTable insert
insert into category values (1, 'IT');
insert into category values (2, '디자인');
insert into category values (3, '뷰티');
insert into category values (4, '외국어');
insert into category values (5, '음악');
insert into category values (6, '라이프');


-- classTable insert
insert into class 
values (class_seq.nextval, '자바 강의입니다','solbi94', 1, 'JAVA','19/07/01','19/07/08',0,10);
insert into class 
values (class_seq.nextval, 'html 강의입니다','gildong', 1, 'html','19/07/01','19/07/10',0,10);
insert into class 
values (class_seq.nextval, 'CSS 강의입니다','lime', 2, 'html','19/07/01','19/07/10',0,30);
insert into class 
values (class_seq.nextval, 'Script 강의입니다','juwon', 2, 'html','19/07/01','19/07/10',0,5);
insert into class 
values (class_seq.nextval, 'Spring 강의입니다','gildong', 3, 'html','19/07/01','19/07/10',0,10);
insert into class 
values (class_seq.nextval, 'XML 강의입니다','gildong', 3, 'html','19/07/01','19/07/10',0,10);


-- registerTable insert
insert into register values (10,'solbi94', 4);
insert into register values (10,'lime', 5);


-- mentorTable insert
insert into mentor (userid,job,major,license,plan)values('solbi94', '소속','컴퓨터공학','자격증','강의 계획입니다');


----------------------------------------------------------------------------------------------------------------------------


-- select
select * from member;

select * from category;

select * from class;

select * from register;

select * from mentor;





--update, join select

update member set uname = '솔비',email = 'gosolbi@gmail.com'
where userid = 'solbi94';
	
update member set password = '1111'
where userid = 'solbi94' and password = '1234';


select r.userid , c.cname , c.userid, rate
from register r, class c
where r.classid = c.classid;

select c.classid, c.cname, c.userid, r.rate from register r, class c 
where r.classid = c.classid and r.userid = 'solbi94';


select r.classid, c.cname, c.userid, r.rate
from register r, class c
where r.classid = c.classid and r.userid = 'lime';


















--제약조건 수정할 때 사용하세요!!

alter table class
drop constraint userid_fk;

alter table class
drop constraint cateno_fk;

alter table member
drop constraint member_pk;

alter table category
drop constraint category_pk;

-------------------------------------------
alter table member
add constraint member_pk primary key (userid);

alter table category
add constraint category_pk primary key (cateno);

alter table class
add constraint userid_fk foreign key(userid) references member(userid);

alter table class
add constraint cateno_fk foreign key(cateno) references category(cateno);



