create table user(
	userid int(11) PRIMARY KEY AUTO_INCREMENT,
	username char(100) not NULL,
	userpw char(100) not null
);

create table subject(
	subjectid int(11) PRIMARY KEY AUTO_INCREMENT,
	subjectname char(100) not NULL,
	starttime int(11) not NULL,
	endtime int not null,
	wday int(3) not null,
	color char(100) not null
);

create table schedule(
	userid int(11),
	subjectid int(11),
	FOREIGN key (userid) REFERENCES user(userid),
	FOREIGN key (subjectid) REFERENCES subject(subjectid)
);

drop table schedule;
drop table subject;


#유저 조회
select * from user;

#전체 과목 조회 쿼리
select * from subject order by wday, starttime;

#시간표 조회
select * from schedule;

#유저에게 보내주는 시간표 조회
select sc.subjectid, sb.subjectname, sb.starttime, sb.endtime, sb.wday, sb.color from schedule as sc join subject as sb on sc.subjectid = sb.subjectid where sc.userid = 1 order by sb.wday, sb.starttime;

#유저 시간표 개수
select count(*) from schedule;

TRUNCATE table schedule;

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table user; 
SET FOREIGN_KEY_CHECKS = 1;
