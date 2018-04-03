CREATE TABLE `users`.`user` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL DEFAULT '',
  `email` VARCHAR(100) NOT NULL DEFAULT '',
  `password` VARCHAR(100) NOT NULL DEFAULT '',
  `active` BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

CREATE TABLE `users`.`roles` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL DEFAULT '',
  PRIMARY KEY(`id`)
)
ENGINE = InnoDB;

ALTER TABLE `users`.`user` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL,
 ADD COLUMN `role_id` INTEGER UNSIGNED NOT NULL DEFAULT 2 AFTER `password`;