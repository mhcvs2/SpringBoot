create DATABASE if not exists springboot;

CREATE TABLE `springboot`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `age` TINYINT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)) charset utf8 collate utf8_general_ci;