
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


