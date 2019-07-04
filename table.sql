

-- memberTable(회원테이블)
	drop table member;
	create table member(
		userid varchar2(20 char) constraint member_pk primary key,
		password varchar2(13 char) not null,
		uname varchar2(10 char) not null,
		email varchar2(30 char) not null,
		phone varchar2(15 char) not null
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
	cname varchar2(20 char) not null
);
	

----------------------------------------------------------------------------------------------------------------------------
-- classTable(강의테이블)
drop table class;
create table class
(
	classid 	number constraint class_pk primary key,
	classinfo 	varchar2(400 char),
	userid 		varchar2(20 char),
	cateno	    number 			not null,
	cname 	    varchar2(20 char)  	not null,
	opendate 	date 			not null,
	closedate 	date 			not null,
	student 	number		    not null,
	limit       number	        not null check (limit between 1 and 5),
	constraint userid_fk foreign key(userid) references member(userid) on delete cascade,
	constraint cateno_fk foreign key(cateno) references category(cateno) on delete cascade
);

	
----------------------------------------------------------------------------------------------------------------------------
-- registerTable(수강신청테이블)
drop table register;
create table register(
	classid 	number		 not null,
	userid 		varchar2(20 char)  not null,
	rate 		number,
	constraint r_userid_fk foreign key(userid) references member(userid)  ON DELETE CASCADE,
	constraint class_id_fk foreign key(classid) references class(classid)  ON DELETE CASCADE
);

-- 제약 추가
alter table register
add primary key (classid, userid);
	
----------------------------------------------------------------------------------------------------------------------------
-- mentorTable(멘토테이블)
drop table mentor;
create table mentor(
	userid		varchar2(20 char) not null,
	job			varchar2(20 char) not null,
	major		varchar2(100 char) not null,
	license		varchar2(100 char),
	plan		varchar2(800 char) not null,
	confirm	varchar2(20) DEFAULT '대기',
	constraint m_userid_fk foreign key(userid) references member(userid) on delete cascade
);


	
----------------------------------------------------------------------------------------------------------------------------




------------------------------------------- Table insert ---------------------------------------------------

-- memberTable insert
insert into member values ('gosolbi','123encore!','고솔비','gosolbi@gmail.com','01015345678');
insert into member values ('gubonjin','123encore!','구본진','gubonjin@gmail.com','01017435678');
insert into member values ('kimyongjin','123encore!','김용진','kimyongjin@gmail.com','01016345678');
insert into member values ('kimjiwoo','123encore!','김지우','kimjiwoo@gmail.com','01012234678');
insert into member values ('kimhyenwoo','123encore!','김현우','kimhyenwoo@gmail.com','01053445678');
insert into member values ('kangsejin','123encore!','강세진','kangsejin@gmail.com','01012341478');
insert into member values ('parkmunha','123encore!','박문하','parkmunha@gmail.com','01011265678');
insert into member values ('parkjongsu','123encore!','박종수','parkjongsu@gmail.com','01012287778');
insert into member values ('bangjimin','123encore!','방지민','bangjimin@gmail.com','01016445678');
insert into member values ('baekgihyeon','123encore!','백기현','baekgihyeon@gmail.com','01012235678');
insert into member values ('simahyoung','123encore!','심아영','simahyoung@gmail.com','01016445678');
insert into member values ('jaelee','123encore!','이길재','jaelee@gmail.com','01012345678');
insert into member values ('egoing','123encore!','이고잉','egoing@gmail.com','01012345678');
insert into member values ('nomardcorder','123encore!','노마드코더','nomardcorder@gmail.com','01012345678');
insert into member values ('eboakgi','123encore!','이복기','eboakgi@gmail.com','01012345678');


-- memberTable insert (admin)
insert into member values ('admin','1234','관리자','admin@encore.com','010-1234-5678');


-- categoryTable insert
insert into category values (1, 'IT');
insert into category values (2, '디자인');
insert into category values (3, '뷰티');
insert into category values (4, '외국어');
insert into category values (5, '음악');
insert into category values (6, '라이프');


-- classTable insert 	★ 수강인원은 1이상 5이하!!
insert into class 
values (class_seq.nextval, '자바 강의입니다','solbi94', 1, 'JAVA','19/07/01','19/07/08',0,5);
insert into class 
values (class_seq.nextval, 'html 강의입니다','gildong', 1, 'html','19/07/01','19/07/10',0,5);
insert into class 
values (class_seq.nextval, 'PhotoShop 강의입니다','lime', 2, 'PhotoShop','19/07/01','19/07/10',0,5);
insert into class 
values (class_seq.nextval, '네일아트 강의입니다.','juwon', 2, 'Nail Art','19/07/01','19/07/10',0,5);
insert into class 
values (class_seq.nextval, '1:1 알고리즘 강의입니다.','gildong', 1, '알고리즘','19/07/01','19/07/10',0,1);
insert into class 
values (class_seq.nextval, '명상강의 입니다. (3명)','juwon', 6, 'Meditation','19/07/01','19/07/10',0,3);


-- registerTable insert 	★ insert할때 classid와 userid가 일치하는지 확인!!
insert into register values (3,'solbi94', 4);
insert into register values (4,'lime', 5);


-- mentorTable insert

insert into mentor (userid,job,major,license,plan)values('lime', '소속','전공','자격증','강의 계획입니다');


----------------------------------------------------------------------------------------------------------------------------


-- select
select * from member;

select * from category;

select * from class;

select * from register;

select * from mentor;






----------------------------------------------------------------------------------------------------------------------------



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



