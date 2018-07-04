create DATABASE if not exists todo;

CREATE TABLE `todo`.`todo_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NOT NULL,
  `completed` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)) charset utf8 collate utf8_general_ci engine=INNODB;