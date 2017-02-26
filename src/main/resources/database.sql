CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE test;
CREATE TABLE `USER` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `age` int(11) NOT NULL,
  `isAdmin` bit(1) NOT NULL DEFAULT b'0',
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
INSERT INTO USER (name,age,isAdmin) VALUES ('Алексей',42,1);
INSERT INTO USER (name,age,isAdmin) VALUES ('Петя',16,0);
INSERT INTO USER (name,age,isAdmin) VALUES ('Александр',43,1);
INSERT INTO USER (name,age,isAdmin) VALUES ('Женя',15,1);
INSERT INTO USER (name,age,isAdmin) VALUES ('Глеб',15,0);
INSERT INTO USER (name,age,isAdmin) VALUES ('Вася',33,1);
commit;
