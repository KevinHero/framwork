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
 