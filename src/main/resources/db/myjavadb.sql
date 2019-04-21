CREATE TABLE `classinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `parentId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


CREATE TABLE `newsinfo` (
  `id` varchar(36) NOT NULL,
  `title` varchar(100) NOT NULL,
  `classId` int(11) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `comeFrom` varchar(50) NOT NULL,
  `addDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isDel` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `systemconfig` (
  `key` varchar(50) DEFAULT NULL,
  `value` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

