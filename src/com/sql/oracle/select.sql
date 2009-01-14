/**
oracle 中取表中5--9条记录，用minus

只能用符号(<、<=、!=)

不能用：>,>=,=,Between...and
*/

select   *  from   tablename   where   …  and   rownum<10     
  minus     
select   *  from   tablename     where   …  and   rownum<５     
order   by   name   




/*返回的是前９条记录。
**/
 select   *   from   tablename   where   rownum != 10;
 select   *   from   tablename   where   rownum < 10;
 
 
 
 
 /**??效率*/
 select   *   from   (  select   rownum   r,a   from   yourtable   where   rownum   <=   20    order   by   name   )    where   r   >   10  
 
 
 /**抽取从N行到M行的记录，如从20行到30行的记录 */
select * from (select rownum id,t.* from table) where id between N and M;






/****************************************************************************************************************************************************/
--创建表空间
　　create tablespace yyspace
　　datafile ’d:\yyspace.dbf’
　　size 10m
　　autoextend on;
　　--创建临时表空间
　　create temporary tablespace yytemp
　　tempfile ’d:\yytemp.dbf’
　　size 10m
　　autoextend on;
　　--创建用户
　　create user yangrs
　　identified by yangrs;
　　alter user yangrs
　　default tablespace yyspace;
　　alter user yangrs
　　temporary tablespace yytemp;
　　--赋权
　　grant connect,resource to yangrs
　　--connect
　　connect yangrs/yangrs;
　　--建表
　　--删表
　　drop table stuInfo
　　create table stuInfo
　　(
　　s_id number(4),
　　s_name varchar2(10),
　　s_sex char(2),
　　s_age number(3),
　　s_birthday date default(sysdate),
　　s_note varchar2(50)
　　);
　　create table stuScore
　　(
　　stuid number(4),
　　scoreid varchar2(10),
　　score number(3)
　　);
　　drop table stuScore;
　　--加约束
　　--主键
　　alter table stuInfo
　　add constraint PK_s_id primary key(s_id);
　　--检查
　　alter table stuInfo
　　add constraint CK_s_sex check(s_sex in (’男’,’女’));
　　alter table stuInfo
　　add constraint CK_s_age check(s_age>0 and s_age<100);
　　--加默认的不行
　　alter table stuInfo
　　add constraint DK_s_birthday default(systimestamp );
　　--外键
　　alter table stuScore
　　add constraint FK_stuid foreign key(stuid) references stuInfo(s_Id);
　　--insert
　　insert into stuInfo(s_id,s_name,s_age,s_Sex,s_Note) values(1000,’刘德华’,20,’男’,’just do it’);
　　insert into stuInfo(s_Id,s_name,s_age,s_sex,s_birthday,s_note) values(1001,’yangrs’,19,’男’,to_date(’1989-01-01’,’yyyy-mm-dd’),’i am what i am’);
　　insert into stuInfo(s_Id,s_name,s_age,s_sex,s_birthday,s_note) values(1002,’yangrs2’,19,’男’,to_date(’1989-01-01’,’yyyy-mm-dd’),’i am what i am’);
　　insert into stuInfo(s_Id,s_name,s_age,s_sex,s_birthday,s_note) values(1003,’yangrs3’,19,’男’,to_date(’1989-01-01’,’yyyy-mm-dd’),’i am what i am’);
　　insert into stuInfo(s_Id,s_name,s_age,s_sex,s_birthday,s_note) values(1004,’yangrs4’,19,’男’,to_date(’1989-01-01’,’yyyy-mm-dd’),’i am what i am’);
　　insert into stuInfo(s_id,s_name,s_age,s_Sex,s_Note) values(1005,’华仔’,20,’男’,’just do it’);　　
　　insert into stuScore(Stuid,scoreid,Score) values(1001,’1’,100);
　　insert into stuScore(Stuid,scoreid,Score) values(1001,’1’,100);
　　insert into stuScore(Stuid,scoreid,Score) values(1000,’1’,100);
　　insert into stuScore(Stuid,scoreid,Score) values(1000,’1’,100); 
　　

--复制表
　　create table stuBak as select * from stuInfo;
--复制表结构
　　create table stuBak2 as select * from stuInfo where 1=2;
--在已有的表结构中插入数据
　　insert into stuBak2 select * from stuBak;
　　update stuBak set s_sex=’男’;
　
　　select rowid,rownum from stuInfo;
--用于分页
　　select * from (select rownum as num,stuInfo.* from stuInfo) where num>5;
　　--sqlserver中是使用top来分页
　　select sysdate from dual;
　　select systimestamp from dual;
　　--对表的修改
　　alter table stuInfo add(s_sal number(3));
　　--is null and is not null
　　select * from stuInfo where s_note is null;
　　select * from stuInfo where s_name like ’y%’; --%代笔任意个字符
　　select * from stuInfo where s_name like ’y_’; --—_代表一个字符
　　select * from stuInfo where s_name like ’y?’;
　　select * from stuInfo order by s_age desc; -- 排序
　　select * from stuInfo order by s_birthday asc;
　　select * from stuInfo order by s_age desc,s_birthday asc;
　　--可以有两个条件
　　--分组
　　select * from stuInfo where s_name<>’yangrs’;
　　select * from stuInfo where s_age=19;
　　select * from stuInfo where s_name<>’yangrs%’; --这样是不行的
　　--调用函数
　　select sum(s_sal) as 奖学金 from stuInfo;
　　select avg(s_age) 平均年龄 from stuInfo;
　　select s_name,s_age from stuInfo group by s_age;
　　select ’hell’||’loworld’ from dual;
　　select 1+1 from dual;
　　--转换大小写
　　update stuInfo set s_name=upper(s_name);
　　update stuInfo set s_name=lower(s_name);
　　--转换ascii码
　　select ascii(’A’) from dual;
　　select ’Hello’||’\t’||’World’ from dual;
　　select ’Hello’||chr(9)||’World’ from dual;
　　select to_char(sysdate,’yyyy/mm/dd hh24:mi:ss’) from dual;
　　select add_months(sysdate,-12) from dual;
　　-- 一年以前的今天
　　select last_day(sysdate) from dual;
　　select to_char(sysdate,’yyyy/mm/dd’) from dual; --改变日期格式
　　select to_char(to_date(’19990214’,’yyyymmdd’),’yyyy"我"mm"月"dd"日"’) from dual;
　　select to_char(to_date(’19990214’,’yyyymmdd’),’yyyy"我"mm"月"dd"日"’) from dual; 



/*****************************************************************************************************************************/

1.SQL语句包括： 

1) 数据查询：select 
2) DML(data manipulation language):insert、update、delete、merge 
3) DDL(data definition language):create、alter、drop、rename、truncate 
4) 事务控制：commit、rollback、savepoint 
5) DCL(数据控制语言)：grant、revoke 

2.基本SELECT语句 
SELECT * | {[DISTINCT] column [alias],...} 
FROM table; 

例：SELECT deptno,loc 
FROM dept; 

3.显示表的结构 
DESC[RIBE] tablename 

4.表说明 
1)雇员信息表（emp） 
名称 是否为空? 类型 
EMPNO NOT NULL NUMBER(4) 
ENAME VARCHAR2(10) 
JOB VARCHAR2(9) 
MGR NUMBER(4) 
HIREDATE DATE 
SAL NUMBER(7,2) 
COMM NUMBER(7,2) 
DEPTNO NUMBER(2) 

2)部门表（dept） 
名称 是否为空? 类型 
DEPTNO NOT NULL NUMBER(2) 
DNAME VARCHAR2(14) 
LOC VARCHAR2(13) 

3) 薪水等级表（salgrade） 
名称 是否为空? 类型 
GRADE NUMBER 
LOSAL NUMBER 
HISAL NUMBER 

5.SELECT语句练习 
例1： 
SELECT * FROM dept; 
结果： 
DEPTNO DNAME LOC 
10 ACCOUNTING NEW YORK 
20 RESEARCH DALLAS 
30 SALES CHICAGO 
40 OPERATIONS BOSTON 
... 

例2： 
SELECT deptno,loc 
FROM dept; 
结果： 
DEPTNO LOC 
10 NEW YORK 
20 DALLAS 
30 CHICAGO 
40 BOSTON 
... 

6.执行SQL语句的工具： 
1)SQL*Plus工具 
2)iSQL*Plus工具 
3)PL/SQL Developer工具 

7.算术表达式 
使用+，-，*，/可创建一个数据型或日期型数据的表达式 

例1： 

SELECT ename,sal,sal+300 
FROM emp; 
结果： 
ENAME SAL SAL+300 
SMITH 2000 2300 
ALLEN 1600 1900 
WARD 1250 1550 
JONES 2975 3275 
... 
例2： 
SELECT ename,sal,12*sal+100 
FROM emp; 
结果： 
ENAME SAL 12*SAL+100 
SMITH 2000 24100 
ALLEN 1600 19300 
WARD 1250 15100 
JONES 2975 35800 
... 
例3： 
SELECT ename,sal,12*(sal+100) 
FROM emp; 
结果： 
ENAME SAL 12*(SAL+100) 
SMITH 2000 25200 
ALLEN 1600 20400 
WARD 1250 16200 
JONES 2975 36900 
... 

8.空值NULL 
-不同于零或者空格 
-是在一种无效的、未赋值、未知的或不可用的值 

例： 
SELECT ename,job,sal,comm 
FROM emp; 
结果： 
ENAME JOB SAL COMM 
MARTIN SALESMAN 1250 1400 
BLAKE MANAGER 2850 
CLARK MANAGER 2450 
TURNER SALESMAN 1500 0 
ADAMS CLERK 1100 
... 
注：任何包含空值的算术表达式运算后的结果都为空值NULL 
例： 
SELECT ename,12*sal,12*sal+comm 
FROM emp 
WHERE ename='BLAKE'; 
结果： 
ENAME 12*SAL 12*SAL+COMM 
BLAKE 34200 

9.列的别名： 
1)紧跟列名或在列名和别名之间加入可选关键字AS 
2)如果别名包含空格或特殊关键字符或区分大小写则需要使用双引号 

例1： 
SELECT ename AS name,sal salary 
FROM emp; 
结果： 
NAME SALARY 
SMITH 2000 
... 

例2： 
SELECT ename "Name",sal*12 "Annual Salary" 
FROM emp; 
结果： 
Name Annual Salary 
SMITH 24000 
ALLEN 19200 

10.连接操作符 
1)用于列与列、列和字符之间的连接 
2)形式上是连个竖杠：|| 
3)用于创建字符表达式的结果列 

例： 
SELECT ename||job AS "Employees" 
FROM emp; 
结果： 
Employees 
SMITHCLERK 
ALLENSALESMAN 
WARDSALESMAN 
JONESMANAGER 
... 

4)原义字符串： 
-是包含在SELECT列表中的字符、数字或日期 
-日期和字符字面值必须
用单引号引起来 
-每个字符串都会在每个数据行输出中出现 

例： 
SELECT ename||' is a '||job AS "Employees" 
FROM emp; 
结果： 
Employees 
SMITH is a CLERK 
ALLEN is a SALESMAN 
WARD is a SALESMAN 
JONES is a MANAGER 
... 

11. 消除重复行 
在SELECT子句中使用关键字DISTINCT可消除重复行 

例： 
SELECT DISTINCT deptno 
FROM emp; 

练习题 

1.显示emp表结构 

DESC emp 

2.显示emp表中所有列的数据 

SELECT * FROM emp; 

3.显示emp表雇员编号、雇员名、薪水信息 

SEELCT empno,ename,sal 
FROM emp; 

4.显示emp表中不重复的工作类别 

SELECT DISTINCT job 
FROM emp; 

5.显示emp表中empno、sal*12、job，它们对应的别名为编号、年薪、工作类别 

SELECT empno "编号",sal*12 "年薪",job "工作类别" 
FROM emp; 

6.显示emp表的ename和sal列，要求显示的格式为：XXXX雇员的薪水为XXX。 

SELECT ename ||'雇员的薪水为 '||sal 
FROM emp; 


 