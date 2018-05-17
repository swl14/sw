
create table Worker(
worker_seq varchar2(300) primary key
, name varchar2(300)
, id varchar2(300)
, password varchar2(300)
, phone_number varchar2(300)
, email varchar2(300)
, room_seq varchar2(300)
, leader varchar2(300)
)

create sequence worker_seq

create table Room(
room_seq varchar2(300) primary key
, room_name varchar2(300)
, first_day varchar2(300)
, last_day varchar2(300)
, room_password varchar2(300)
, leader varchar2(300)
, room_creater varchar2(30)
)

create sequence room_seq

create table Work(
work_seq varchar2(300) primary key
, work_name varchar2(300)
, start_day varchar2(300)
, period varchar2(300)
, people varchar2(300)
, detail varchar2(900)
, progress varchar2(300)
, room_seq varchar2(300)
)

create sequence work_seq

create table JoinWork(
joinwork_seq varchar2(300) primary key
, user_num varchar2(300)
, room_num varchar2(300)
)

create sequence joinwork_seq

select * from room
select * from work
select * from worker
drop table worker