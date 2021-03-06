/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.57 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(10) DEFAULT NULL,
  `bname` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `state` int(5) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bid`,`cid`,`bname`,`author`,`price`,`description`,`pic`,`state`,`create_time`) values (1,1,'算法导论（原书第3版）','[美]Thomas H.Cormen',128,'以英语和伪代码的形式描述','s25648004.jpg',0,'2012-12-01 00:00:00'),(2,1,'计算机科学导论','[美]贝赫鲁兹·佛罗赞',69,'讲解计算机科学的基础知识','s28418968.jpg',0,'2015-08-01 00:00:00'),(3,1,'C程序设计语言','[美]Brian W. Kernighan',30,'一本介绍C语言的权威经典著作','s1106934.jpg',0,'2004-01-01 00:00:00'),(4,1,'深入理解计算机系统（原书第2版）','[美]Randal E.Bryant',99,'详细阐述计算机系统的本质概念','s4510534.jpg',0,'2011-01-01 00:00:00'),(5,1,'设计模式','[美]Erich Gamma ',35,'从面向对象的设计中精选出23个设计模式','s1074361.jpg',0,'2000-09-01 00:00:00'),(6,1,'数据结构与算法分析','[美]Mark Allen Weiss',35,'数据结构介绍','s28015501.jpg',0,'2004-01-01 00:00:00'),(7,1,'编译原理','[美]Alfred V. Aho',89,'探讨编译器设计方面的重要主题','s3392161.jpg',0,'2008-12-01 00:00:00'),(8,1,'离散数学及其应用（原书第5版）','[美]Kenneth H·Rosen',79,'全面而系统地介绍了离散数学的理论和方法','s10355117.jpg',0,'2007-06-01 00:00:00'),(9,2,'微积分学教程（第1卷）','[俄]Г.М.菲赫金哥尔茨',45,'俄罗斯数学教材-微积分','s1525451.jpg',0,'2006-01-01 00:00:00'),(10,2,'数学分析（第一卷）','[俄]B.A.卓里奇',59,'俄罗斯数学教材-数分','s2574948.jpg',0,'2006-06-01 00:00:00'),(11,2,'函数论与泛函分析初步','[俄]А. Н. 柯尔莫戈洛夫 ',56,'俄罗斯数学教材-函数','s3010916.jpg',0,'2006-01-01 00:00:00'),(12,2,'复变函数论方法（第六版）','[俄]拉夫连季耶夫',68,'俄罗斯数学教材-复变','s9223830.jpg',0,'2006-01-01 00:00:00'),(13,2,'大学物理(第3版)','朱峰',48,'大学物理教材','25337331-1_b_3.jpg',0,'2014-11-01 00:00:00'),(14,4,'全唐诗','中华书局编辑部',430,'唐五代诗四万八千九百多首','s3069351.jpg',0,'2008-02-01 00:00:00'),(15,4,'二十四史','中华书局编辑部',1480,'纪传体裁，完整地记录清以前各个朝代的历史','s9449338.jpg',0,'2000-01-01 00:00:00'),(16,4,'资治通鉴','司马光',136,'共1362年的历史的编年体史书','s27466811.jpg',0,'2009-01-01 00:00:00'),(17,4,'史记','司马迁',28,'司马迁所著的史学巨著，列“二十四史”之首','s9077296.jpg',0,'2006-06-01 00:00:00'),(18,4,'三国志','陈寿 / 裴松之',36,'平行地叙述东汉末年魏、蜀、吴三国鼎峙的史实','s9086187.jpg',0,'2006-09-01 00:00:00'),(19,3,'毛泽东思想和中国特色社会主义理论体系概论','本书编写组',23,'毛概','s27251261.jpg',0,'2013-01-01 00:00:00'),(20,3,'马克思主义基本原理概论','《马克思主义基本原理概论》编写组',13,'马原','s3480063.jpg',0,'2008-02-01 00:00:00'),(21,3,'中国近现代史纲要','《中国近现代史纲要》编写组',14.8,'近代史','s4196972.jpg',0,'2008-02-01 00:00:00'),(22,5,'骆驼祥子','老舍',12,'二十年代的北京，底层社会小人物的故事','s1146040.jpg',0,'2000-03-01 00:00:00'),(23,5,'鲁迅全集','鲁迅',990,'鲁迅全集','s1513604.jpg',0,'2005-11-11 00:00:00'),(24,5,'俗世奇人全本','冯骥才',36,'清末民初天津卫的地域风貌、风土人情、生活风尚','s33571357.jpg',0,'2020-01-01 00:00:00'),(25,5,'汪曾祺全集','汪曾祺 ',1280,'以汪先生的手稿作为第一位组稿来源','s29962218.jpg',0,'2019-01-10 00:00:00'),(26,5,'呼兰河传','萧红',38,'描写上个世纪三、四十年代东北小镇呼兰的风土人情','s1934734.jpg',0,'2003-01-01 00:00:00'),(27,5,'活着','余华',20,'讲述农村人福贵悲惨的人生遭遇','s29053580.jpg',0,'2012-08-01 00:00:00'),(28,5,'一只特立独行的猪','王小波',18,'不管什么书，我都不希望它太严肃，这一本也不例外。————王小波','s1670642.jpg',0,'2006-04-01 00:00:00'),(29,5,'边城','沈从文',12,'描摹湘女翠翠阴差阳错的生活悲剧','s1595557.jpg',0,'2002-04-01 00:00:00'),(30,5,'沿着塞纳河到翡冷翠','黄永玉',38,'黄永玉在国外小住时所写的艺术游记散文集','s1940795.jpg',0,'2006-11-01 00:00:00'),(31,5,'狼图腾','姜戎',32,'由几十个有机连贯的“狼故事”组成，情节紧张激烈而又新奇神秘。','s1466042.jpg',0,'2004-04-01 00:00:00'),(32,6,'只有你聽到 Calling You','[日]乙一',91.88,'透過三個不同題材的短篇故事，勾勒被社會忽略遺忘的一群，以及他們被人捨棄踐踏的內心世界。','s29822466.jpg',0,'2000-01-01 00:00:00'),(33,6,'百年孤独','[哥伦比亚]加西亚·马尔克斯',39.5,'描写布恩迪亚家族七代人的传奇故事','s6384944.jpg',0,'2011-06-01 00:00:00'),(34,6,'人间失格---太宰治文学精选集','[日]太宰治',29.9,'太宰治文选','s26368496.jpg',0,'2013-03-01 00:00:00'),(35,6,'挪威的森林','[日]村上春树',23,'一部动人心弦的、平缓舒雅的、略带感伤的恋爱小说。','s27312538.jpg',0,'2007-07-01 00:00:00'),(36,6,'罗生门','[日]芥川龙之介',31,'按创作时间顺序，收录芥川龙之介代表小说、散文共26篇','s33633732.jpg',0,'2017-12-01 00:00:00'),(37,6,'春雪','[日]三岛由纪夫',32,'描写清显与聪子的爱情纠葛','s4418737.jpg',0,'2010-08-01 00:00:00'),(38,6,'麦田里的守望者','[美]J·D·塞林格',28,'通过第一人称以青少年的说话口吻叙述全书','s2380159.jpg',0,'2007-03-01 00:00:00'),(39,6,'鬼','[俄]陀思妥耶夫斯基',72,'19世纪俄国大文豪陀思妥耶夫斯基的长篇小说','s28527613.jpg',0,'2015-01-01 00:00:00'),(40,5,'鬼狗','格日勒其木格·黑鹤',19,'因为雪域高原与莱茵河畔血缘的巧妙结合，蕴育出鬼这样一头绝无仅有的纯白色獒犬','s6831454.jpg',0,'2010-04-01 00:00:00'),(41,7,'曾国藩传','张宏杰',68,'曾国藩传','s33678368.jpg',0,'2018-12-01 00:00:00'),(42,7,'他改变了中国','[美]罗伯特·劳伦斯·库恩',38,'江泽民传','s27074014.jpg',0,'2005-01-01 00:00:00'),(43,7,'王阳明传：知行合一的心学圣人','燕山刀客',40.8,'王阳明传','2020-07-12 141857.jpg',0,'2019-02-01 00:00:00'),(44,7,'人类群星闪耀时','[奥地利]斯蒂芬·茨威格',69,'14个改变人类命运的天才','s32299368.jpg',0,'2019-04-01 00:00:00'),(45,7,'周恩来传','[英]迪克·威尔逊',60.9,'周恩来传','s6886397.jpg',0,'2011-07-01 00:00:00'),(46,8,'人类简史','[以色列]尤瓦尔·赫拉利',68,'希伯来大学最受欢迎课程 Coursera最受欢迎课程','s27814883.jpg',0,'2014-11-01 00:00:00'),(47,8,'时间简史','[英]史蒂芬·霍金',45,'讲述探索时间和空间核心秘密的故事','s1914861.jpg',0,'2010-04-01 00:00:00'),(48,8,'万物简史','[美]比尔·布莱森',36.8,'一部有关现代科学发展史的既通俗易懂又引人入胜的书','s1171582.jpg',0,'2005-02-01 00:00:00'),(49,8,'时间的秩序','[意]卡洛·罗韦利',56,'我们对时间流逝的感知，取决于我们的视角','s32332471.jpg',0,'2019-06-01 00:00:00'),(50,8,'枪炮、病菌与钢铁','[美]贾雷德·戴蒙德',45,'揭示了事实上有助于形成历史最广泛模式的环境因素','s1738643.jpg',0,'2006-04-01 00:00:00'),(51,9,'中村佑介的插画世界','[日]中村佑介',199.8,'中村佑介，十年创作精选','s33497793.jpg',0,'2020-07-12 14:29:34'),(52,9,'莫奈','[法]莫奈',172.2,'莫奈作品集','s3978320.jpg',0,'2005-08-01 14:32:08'),(53,9,'艺术的慰藉','[英]阿兰·德波顿',98,'解答艺术之所以重要的问题','s33500556.jpg',0,'2019-07-01 00:00:00'),(54,10,'美国陷阱','[法]弗雷德里克·皮耶鲁齐',68,'以身陷囹圄的亲身经历披露了阿尔斯通被美国企业“强制”收购内幕','s32305312.jpg',0,'2019-05-01 00:00:00'),(55,10,'价值投资实战手册','唐朝',59.8,'作者对20多年投资实践中形成的投资体系的回顾与总结','s29962571.jpg',0,'2019-01-01 00:00:00'),(56,10,'战胜一切市场的人','[美]爱德华·O·索普',98,'用清晰简单的语言分享了自己在赌场和市场这两大领域的激动人心的冒险之旅','s32289558.jpg',0,'2019-04-01 00:00:00'),(57,10,'周期','[美]霍华德·马克斯',88,'人的决策对经济周期、企业周期、市场周期产生了巨大影响','s29988314.jpg',0,'2019-02-01 00:00:00'),(58,10,'债务危机','[美]瑞·达利欧',98,'通过三部分内容阐述了债务危机及其应对原则','s30245856.jpg',0,'2019-03-01 00:00:00');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) DEFAULT NULL,
  `state` int(1) DEFAULT '1',
  `order_number` int(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`cid`,`cname`,`state`,`order_number`,`create_time`) values (1,'CS经典教材',1,1,'2020-07-12 13:37:15'),(2,'理学基础教材',1,2,'2020-07-12 13:37:18'),(3,'马哲教材',1,3,'2020-07-12 13:37:19'),(4,'中华古典文学',1,5,'2020-07-12 13:37:21'),(5,'中国现当代文学',1,4,'2020-07-12 13:56:59'),(6,'外国文学',1,6,'2020-07-12 13:56:56'),(7,'人物传记',1,10,'2020-07-12 14:13:18'),(8,'科学读物',1,7,'2020-07-12 14:22:52'),(9,'艺术设计',1,9,'2020-07-12 14:29:06'),(10,'商业书籍',1,8,'2020-07-12 14:35:01');

/*Table structure for table `order_detial` */

DROP TABLE IF EXISTS `order_detial`;

CREATE TABLE `order_detial` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `bids` varchar(100) DEFAULT NULL,
  `numbers` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `order_detial` */

insert  into `order_detial`(`oid`,`bids`,`numbers`) values (11,'1,','13,'),(12,'','');

/*Table structure for table `order_list` */

DROP TABLE IF EXISTS `order_list`;

CREATE TABLE `order_list` (
  `uid` int(11) DEFAULT NULL,
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `sum_price` double DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `order_list` */

insert  into `order_list`(`uid`,`oid`,`sum_price`,`state`,`create_time`) values (3,3,NULL,0,'2020-07-22 15:59:19'),(3,4,NULL,0,'2020-07-16 15:59:21'),(1,5,1,0,'2020-07-14 17:24:49'),(1,6,1,0,'2020-07-14 17:28:07'),(1,7,1,0,'2020-07-14 17:28:15'),(1,8,1,0,'2020-07-14 17:41:57'),(1,9,1,0,'2020-07-14 17:46:06'),(1,10,1,0,'2020-07-14 19:09:20'),(1,11,1300,0,'2020-07-14 20:25:00'),(1,12,0,0,'2020-07-14 21:59:37');

/*Table structure for table `trolley` */

DROP TABLE IF EXISTS `trolley`;

CREATE TABLE `trolley` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT '1',
  `price` double DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `trolley` */

insert  into `trolley`(`tid`,`uid`,`bid`,`number`,`price`) values (1,1,1,1,1),(2,1,2,1,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `uphone` varchar(20) DEFAULT NULL,
  `upwd` varchar(20) DEFAULT NULL,
  `manager` int(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `upic` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`email`,`uphone`,`upwd`,`manager`,`create_time`,`upic`) values (1,'admin','1285483975@qq.com','17694805812','admin',0,'2020-07-12 00:00:00','R&M.jpg'),(2,'张三','2222222222@qq.com','13419849483','zhangsan',1,'2020-07-12 14:43:34','2.jpg'),(3,'李四','3333333333@qq.com','14593950385','lisi',1,'2020-07-12 14:44:07','r.jpg'),(4,'王二','4444444444@qq.com','17290483959','wanger',1,'2020-07-12 14:44:49','face1.jpg'),(5,'Neptuni','5555555555@qq.com','18579375933','123',1,'2020-07-12 14:45:35','face2.jpg'),(6,'Pluto','6666666666@qq.com','17395395028','321',1,'2020-07-12 14:46:41','face3.jpg'),(7,'Mars','7777777777@qq.com','17495068305','666',1,'2020-07-12 14:47:06','face4.jpg'),(8,'The Old','8888888888@qq.com','19385038586','oldman',1,'1934-07-12 14:47:47','face5.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
