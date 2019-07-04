

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
-- mentorTable(멘토테이블)
drop table mentor;
create table mentor(
	userid		varchar2(20 char) constraint mentor_pk primary key,
	job			varchar2(20 char) not null,
	major		varchar2(100 char) not null,
	license		varchar2(100 char),
	plan		varchar2(800 char) not null,
	confirm	varchar2(20) DEFAULT '대기',
	constraint m_userid_fk foreign key(userid) references member(userid) on delete cascade
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
	constraint userid_fk foreign key(userid) references mentor(userid) on delete cascade,
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




------------------------------------------- Table insert ---------------------------------------------------
-- memberTable insert (admin)
insert into member values ('admin','admin1234!','관리자','admin@encore.com','010-1234-5678');

-- memberTable insert
insert into member values ('gubonjin1','123encore!','구본진','gubonjin@gmail.com','010-1743-5678');
insert into member values ('kimyongjin1','123encore!','김용진','kimyongjin@gmail.com','010-1634-5678');
insert into member values ('kimjiwoo1','123encore!','김지우','kimjiwoo@gmail.com','010-1223-4678');
insert into member values ('parkmunha1','123encore!','박문하','parkmunha@gmail.com','010-1126-5678');
insert into member values ('parkjongsu1','123encore!','박종수','parkjongsu@gmail.com','010-1228-7778');
insert into member values ('baekgihyeon1','123encore!','백기현','baekgihyeon@gmail.com','010-1223-5678');


insert into member values ('kimhyunwoo1','123encore!','김현우','kimhyenwoo@gmail.com','010-5344-5678');
insert into member values ('solbi94','solbi94!','고솔비','gosolbi@gmail.com','010-4010-9537');
insert into member values ('simahyoung1','123encore!','심아영','simahyoung@gmail.com','010-1644-5678');
insert into member values ('jaelee1','123encore!','이길재','jaelee@gmail.com','010-1234-5678');
insert into member values ('egoing1','123encore!','이고잉','egoing@gmail.com','010-1234-5678');
insert into member values ('nomardcorder1','123encore!','노마드코더','nomardcorder@gmail.com','010-1234-5678');

-- categoryTable insert
insert into category values (1, 'IT');
insert into category values (2, '디자인');
insert into category values (3, '뷰티');
insert into category values (4, '외국어');
insert into category values (5, '음악');
insert into category values (6, '라이프');

-- classTable insert 	★ 수강인원은 1이상 5이하!!

insert into class values (class_seq.nextval, '자바 강의입니다','jaelee1', 1, 'JAVA','19/07/01','19/07/08',0,5);
insert into class values (class_seq.nextval, 'html 강의입니다','jaelee1', 1, 'html','19/07/01','19/07/10',0,5);
insert into class values (class_seq.nextval, '1:1 알고리즘 강의입니다.','gildong', 1, '알고리즘','19/07/01','19/07/10',0,1);
insert into class values (class_seq.nextval, 'PhotoShop 강의입니다','egoing1', 2, 'PhotoShop','19/07/01','19/07/10',0,5);
insert into class values (class_seq.nextval, '네일아트 강의입니다.','solbi94', 3, 'Nail Art','19/07/01','19/07/10',0,5);
insert into class values (class_seq.nextval, '메이크업 강의입니다','solbi94', 3, '메이크업','19/07/01','19/07/05',0,3);
insert into class values (class_seq.nextval, '중국어 강의입니다','nomardcorder1', 4, '중국어','19/07/01','19/07/12',0,5);
insert into class values (class_seq.nextval, '독일어 강의입니다','nomardcorder1', 4, '독일어','19/07/01','19/07/12',0,5);
insert into class values (class_seq.nextval, '보컬 강의입니다','simahyoung1', 5, '보컬강의','19/07/08','19/07/12',0,2);
insert into class values (class_seq.nextval, '피아노 강의입니다','simahyoung1', 5, '피아노강의','19/07/08','19/07/12',0,1);
insert into class values (class_seq.nextval, '직접 만드는 핸드드립 커피입니다','bangjimin1', 6, '핸드드립 커피','19/07/01','19/07/3',0,5);
insert into class values (class_seq.nextval, '세계자유여행 강좌입니다','kimhyenwoo1', 6, '자유여행 계획 ','19/07/08','19/07/11',0,3);
insert into class values (class_seq.nextval, '명상강의 입니다. (3명)','kimhyenwoo1', 6, 'Meditation','19/07/01','19/07/10',0,3);



-- mentorTable insert
insert into mentor (userid,job,major,license,plan)values('solbi94', '엔코아','컴퓨터공학과','없음','다양한 뷰티 강의 계획입니다');
insert into mentor (userid,job,major,license,plan)values('simahyoung1', '엔코아','작곡과','자격증','강의 계획입니다');
insert into mentor (userid,job,major,license,plan)values('jaelee1', '엔코아','컴퓨터공학과','자격증','걸어다니는 자바');
insert into mentor (userid,job,major,license,plan)values('egoing1', '엔코아','컴퓨터공학과','자격증','생활코딩');
insert into mentor (userid,job,major,license,plan)values('kimhyunwoo1', '엔코아','컴퓨터공학과','자격증','강의 계획입니다');
insert into mentor (userid,job,major,license,plan)values('nomardcorder1', '엔코아','컴퓨터공학과','자격증','강의 계획입니다');


----------------------------------------------------------------------------------------------------------------------------


-- select
select * from member;

select * from category;

select * from class;

select * from register;

select * from mentor;



select classid, avg(rate) rate
from register 
where classid = 1
group by classid;


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


select classid, avg(rate) from register group by classid;

