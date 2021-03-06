CREATE DATABASE `library_users`;
CREATE TABLE `library_users`.`user` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL DEFAULT '',
  `email` VARCHAR(100) NOT NULL DEFAULT '',
  `password` VARCHAR(100) NOT NULL DEFAULT '',
  `active` BOOLEAN NOT NULL DEFAULT 1,
  `role_id` INTEGER NOT NULL,
  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

CREATE TABLE `library_users`.`roles` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL DEFAULT '',
  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

INSERT INTO `library_users`.`roles` (`id`, `role`) VALUES ('1', 'User');
INSERT INTO `library_users`.`roles` (`id`, `role`) VALUES ('2', 'Admin');