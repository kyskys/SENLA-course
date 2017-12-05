-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema senla_course_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema senla_course_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `senla_course_db` ;
USE `senla_course_db` ;

-- -----------------------------------------------------
-- Table `senla_course_db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `senla_course_db`.`product` (
  `model` VARCHAR(50) NOT NULL,
  `maker` VARCHAR(10) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`model`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `senla_course_db`.`pc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `senla_course_db`.`pc` (
  `code` INT NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `speed` SMALLINT NOT NULL,
  `ram` SMALLINT NOT NULL,
  `hd` REAL NOT NULL,
  `cd` VARCHAR(10) NOT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_modelPC_ModelProduct_idx` (`model` ASC),
  CONSTRAINT `fk_modelPC_ModelProduct`
    FOREIGN KEY (`model`)
    REFERENCES `senla_course_db`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `senla_course_db`.`laptop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `senla_course_db`.`laptop` (
  `code` INT NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `speed` SMALLINT NOT NULL,
  `ram` SMALLINT NOT NULL,
  `hd` REAL NOT NULL,
  `screen` TINYINT NOT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_modelLaptop_ModelProduct_idx` (`model` ASC),
  CONSTRAINT `fk_modelLaptop_ModelProduct`
    FOREIGN KEY (`model`)
    REFERENCES `senla_course_db`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `senla_course_db`.`printer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `senla_course_db`.`printer` (
  `code` INT NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `color` CHAR(1) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_modelPrinter_ModelProduct_idx` (`model` ASC),
  CONSTRAINT `fk_modelPrinter_ModelProduct`
    FOREIGN KEY (`model`)
    REFERENCES `senla_course_db`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;