create table memo(
    result varchar2(100)   
);
--찾기
select * from memo;
--저장하기
insert into memo values ('제목/시간/시간2/컬러/메모');
--삭제
delete memo where result like '%시간%';
--되돌리기
rollback;
--저장
commit;


