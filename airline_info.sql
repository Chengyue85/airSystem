create database airline1;
use airline1;

create table info(
id bigint(20) not null auto_increment,
inum varchar(8) not null, #航班号
icompany varchar(20) not null, #航空公司
ibegin varchar(20) not null, #始发地
iend varchar(20) not null, #目的地
imiddle varchar(20) not null, #经停
ischeduledgo time not null, #计划起飞时间
iactualgo time not null, #实际起飞时间
ischeduledarr time not null, #计划到达时间
iactualarr time not null, #实际到达时间
iterminal varchar(20) not null, #航站楼
igate varchar(20) not null, #登机口
icheck varchar(20) not null, #值机柜台
istatus varchar(20) not null,  #航班状态
primary key(id)
); 
-- inum, icompany, ibegin, iend, imiddle,ischeduledgo,iactualgo,ischeduledarr,iactualarr,iterminal,igate,icheck,istatus
insert into info values("1","MU2832",'中国东方航空公司',"北京","南京","","18:05","","20:10","",'T4','G12','S02',"已取消");
insert into info(inum, icompany, ibegin, iend, imiddle,ischeduledgo,iactualgo,ischeduledarr,iactualarr,iterminal,igate,icheck,istatus) 
values("MF8201",'厦门航空有限公司',"北京","西宁",'',"18:25","","20:45","",'T3','G04','S03',"未出发");
insert into info(inum, icompany, ibegin, iend, imiddle,ischeduledgo,iactualgo,ischeduledarr,iactualarr,iterminal,igate,icheck,istatus)
 values("MU5458",'中国东方航空公司',"北京","杭州",'天津',"18:30","18:24","20:35","20:02",'T2','G09','S01',"已登陆");
insert into info(inum, icompany, ibegin, iend, imiddle,ischeduledgo,iactualgo,ischeduledarr,iactualarr,iterminal,igate,icheck,istatus)
 values("CZ8889",'中国南方航空公司',"北京","上海",'',"18:45","18:43","21:05","20:26",'T1','G18','S04',"在途中");
insert into info(inum, icompany, ibegin, iend, imiddle,ischeduledgo,iactualgo,ischeduledarr,iactualarr,iterminal,igate,icheck,istatus)
 values("CA8681",'中国国际航空公司',"北京","佳木斯",'哈尔滨',"20:00","","21:15","",'T3','G04','S01',"未出发");