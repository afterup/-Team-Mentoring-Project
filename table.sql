

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
	drop sequence class_seq;
	create sequence class_seq
	start with 1
	increment by 1
	nocycle
	nocache;

	
-- categoryTable
drop   table category;
create table category(
	cateno number constraint category_pk primary key,
	cname varchar2(20) not null
);
	
	
-- classTable
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

	

--insert
insert into member values ('solbi94', '1234', '고솔비', 'gosolb0904@gmail.com', 01040109537);
insert into member values ('gildong', '1111', '홍길동', 'gildong@gmail.com', 01012345678);
insert into member values ('lime', '2222', '길라임', 'lime@gmail.com', 01011112222);
insert into member values ('juwon', '3333', '김주원', 'juwon@gmail.com', 01012457890);
select * from member;


--admin insert
insert into member values ('admin','1234','관리자','admin@encore.com',01012345678);

insert into category values (1, 'IT');
insert into category values (2, '디자인');
insert into category values (3, '뷰티');
insert into category values (4, '외국어');
insert into category values (5, '음악');
insert into category values (6, '라이프');
select * from category;


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

select * from class;


--수강신청 테이블
drop table register;
create table register(
	classid 	number,
	userid 		varchar2(20),
	rate 		number,
	constraint r_userid_fk foreign key(userid) references member(userid),
	constraint class_fk foreign key(classid) references class(classid)
	);
insert into register values (2, 'solbi94', 4);
delete from register where userid ='solbi94';
select * from register;



--멘토테이블
drop table mentor;
create table mentor(
	userid		varchar2(20),
	job			varchar2(20),
	major		varchar2(20),
	license		varchar2(20),
	constraint m_userid_fk foreign key(userid) references member(userid)
);
insert into mentor values('solbi94', '소속','컴퓨터공학','자격증');
select * from mentor;
	


--update, join select

update member set uname = '솔비',email = 'gosolbi@gmail.com'
where userid = 'solbi94';
	
update member set password = '1111'
where userid = 'solbi94' and password = '1234';

select userid, job, major, license,phone
from MEMBER natural join mentor;

select r.userid 멘티아이디 , cname 수강강의명 , c.userid 멘토아이디  , rate 점수
from register r, class c
where r.classid = c.classid;





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



