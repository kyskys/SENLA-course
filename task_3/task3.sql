
CREATE SCHEMA IF NOT EXISTS `auto_servise_db` ;

USE `auto_servise_db` ;

-- -----------------------------------------------------
-- Table `auto_servise_db`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servise_db`.`order` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `added_date` DATE NOT NULL,
  `start_date` DATE NULL,
  `ending_date` DATE NULL,
  `closed` TINYINT NOT NULL,
  `cancelled` TINYINT NOT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`idorder`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servise_db`.`garage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servise_db`.`garage` (
  `idgarage` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idgarage`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servise_db`.`sit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servise_db`.`sit` (
  `idsit` INT NOT NULL,
  `order_id` INT NULL,
  `garage_id` INT NULL,
  PRIMARY KEY (`idsit`),
  INDEX `sit_order_fk_idx` (`order_id` ASC),
  INDEX `sit_garage_fk_idx` (`garage_id` ASC),
  CONSTRAINT `sit_order_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `auto_servise_db`.`order` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sit_garage_fk`
    FOREIGN KEY (`garage_id`)
    REFERENCES `auto_servise_db`.`garage` (`idgarage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servise_db`.`master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servise_db`.`master` (
  `idmaster` INT NOT NULL AUTO_INCREMENT,
  `busy` TINYINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `order_id` INT NULL,
  PRIMARY KEY (`idmaster`),
  INDEX `order_master_fk_idx` (`order_id` ASC),
  CONSTRAINT `order_master_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `auto_servise_db`.`order` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Data for table `auto_servise_db`.`order`
-- -----------------------------------------------------
START TRANSACTION;
USE `auto_servise_db`;
INSERT INTO `auto_servise_db`.`order` (`idorder`, `added_date`, `start_date`, `ending_date`, `closed`, `cancelled`, `price`) VALUES (1, '2017-10-10', '2017-10-10', '2018-10-11', 0, 0, 200);
INSERT INTO `auto_servise_db`.`order` (`idorder`, `added_date`, `start_date`, `ending_date`, `closed`, `cancelled`, `price`) VALUES (2, '2015-11-11', '2016-12-11', '2018-10-12', 0, 0, 300);
INSERT INTO `auto_servise_db`.`order` (`idorder`, `added_date`, `start_date`, `ending_date`, `closed`, `cancelled`, `price`) VALUES (3, '2017-01-12', '2017-02-12', '2017-10-12', 1, 0, 500);
INSERT INTO `auto_servise_db`.`order` (`idorder`, `added_date`, `start_date`, `ending_date`, `closed`, `cancelled`, `price`) VALUES (4, '2017-01-01', '2017-01-05', '2018-10-01', 0, 1, NULL);
INSERT INTO `auto_servise_db`.`order` (`idorder`, `added_date`, `start_date`, `ending_date`, `closed`, `cancelled`, `price`) VALUES (5, '2017-05-05', '2017-05-05', '2018-10-10', 0, 0, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `auto_servise_db`.`garage`
-- -----------------------------------------------------
START TRANSACTION;
USE `auto_servise_db`;
INSERT INTO `auto_servise_db`.`garage` (`idgarage`) VALUES (1);
INSERT INTO `auto_servise_db`.`garage` (`idgarage`) VALUES (2);
INSERT INTO `auto_servise_db`.`garage` (`idgarage`) VALUES (3);
INSERT INTO `auto_servise_db`.`garage` (`idgarage`) VALUES (4);
INSERT INTO `auto_servise_db`.`garage` (`idgarage`) VALUES (5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `auto_servise_db`.`sit`
-- -----------------------------------------------------
START TRANSACTION;
USE `auto_servise_db`;
INSERT INTO `auto_servise_db`.`sit` (`idsit`, `order_id`, `garage_id`) VALUES (1, 1, 1);
INSERT INTO `auto_servise_db`.`sit` (`idsit`, `order_id`, `garage_id`) VALUES (2, 2, 2);
INSERT INTO `auto_servise_db`.`sit` (`idsit`, `order_id`, `garage_id`) VALUES (3, NULL, 3);
INSERT INTO `auto_servise_db`.`sit` (`idsit`, `order_id`, `garage_id`) VALUES (4, NULL, 3);
INSERT INTO `auto_servise_db`.`sit` (`idsit`, `order_id`, `garage_id`) VALUES (5, NULL, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `auto_servise_db`.`master`
-- -----------------------------------------------------
START TRANSACTION;
USE `auto_servise_db`;
INSERT INTO `auto_servise_db`.`master` (`idmaster`, `busy`, `name`, `order_id`) VALUES (1, 0, 'vasya', NULL);
INSERT INTO `auto_servise_db`.`master` (`idmaster`, `busy`, `name`, `order_id`) VALUES (2, 0, 'kolya', NULL);
INSERT INTO `auto_servise_db`.`master` (`idmaster`, `busy`, `name`, `order_id`) VALUES (3, 1, 'nikita', 1);
INSERT INTO `auto_servise_db`.`master` (`idmaster`, `busy`, `name`, `order_id`) VALUES (4, 1, 'jenya', 2);
INSERT INTO `auto_servise_db`.`master` (`idmaster`, `busy`, `name`, `order_id`) VALUES (DEFAULT, 1, 'artem', 2);

COMMIT;

