create table memo(
    result varchar2(100)   
);
--ã��
select * from memo;
--�����ϱ�
insert into memo values ('����/�ð�/�ð�2/�÷�/�޸�');
--����
delete memo where result like '%�ð�%';
--�ǵ�����
rollback;
--����
commit;


