-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PGAPlayerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PGAPlayerdb` ;

-- -----------------------------------------------------
-- Schema PGAPlayerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PGAPlayerdb` DEFAULT CHARACTER SET utf8 ;
USE `PGAPlayerdb` ;

-- -----------------------------------------------------
-- Table `junk`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `junk` ;

CREATE TABLE IF NOT EXISTS `junk` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Golfer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Golfer` ;

CREATE TABLE IF NOT EXISTS `Golfer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `pga_wins` INT NULL,
  `college_attended` VARCHAR(45) NULL,
  `total_earnings` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS PGA@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'PGA'@'localhost' IDENTIFIED BY 'PGA';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'PGA'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `junk`
-- -----------------------------------------------------
START TRANSACTION;
USE `PGAPlayerdb`;
INSERT INTO `junk` (`id`, `data`) VALUES (1, 'data is working');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Golfer`
-- -----------------------------------------------------
START TRANSACTION;
USE `PGAPlayerdb`;
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (1, 'Jack', 'Nicklaus', 73, 'The Ohio State University', 5700000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (2, 'Tiger', 'Woods', 85, 'Stanford University', 118309570);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (3, 'Phil', 'Mickelson', 44, 'Arizona State University', 88254000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (4, 'Arnold', 'Palmer', 62, 'Wake Forest', 3600000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (5, 'Ricki', 'Fowler', 5, 'Oklahoma State University', 37000000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (6, 'Ben', 'Hogan', 64, NULL, 332516);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (7, 'Gary', 'Player', 24, NULL, 14000000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (8, 'Dustin', 'Johnson', 20, 'Coastal Carolina University', 56500000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (9, 'Fred', 'Couples', 15, 'University of Houston', 22800000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (10, 'Adam', 'Scott', 13, 'University Nevada Las Vegas', 52000000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (11, 'Jason', 'Day', 12, NULL, 45000000);
INSERT INTO `Golfer` (`id`, `first_name`, `last_name`, `pga_wins`, `college_attended`, `total_earnings`) VALUES (12, 'Bubba', 'Watson', 12, 'University of Georgia', 42000000);

COMMIT;

