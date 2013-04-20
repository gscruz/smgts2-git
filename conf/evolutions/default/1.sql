# --- First database schema

# --- !Ups

CREATE TABLE IF NOT EXISTS `user_account` (
  `acc_id` int(10) unsigned NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_pass` char(128) NOT NULL,
  `group_id` int(1) unsigned NOT NULL,
  PRIMARY KEY (`acc_id`),
  KEY `group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `user_groups` (
  `group_id` int(1) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(140) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `user_account`
  ADD CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `user_groups` (`group_id`);

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists `user_account`;

drop table if exists `user_groups`;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists `user_account`;

drop sequence if exists `user_groups`;

