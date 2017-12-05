-- -----------------------------------------------------
-- Data for table `senla_course_db`.`product`
-- -----------------------------------------------------
START TRANSACTION;
USE `senla_course_db`;
INSERT INTO `senla_course_db`.`product` (`model`, `maker`, `type`) VALUES ('1', 'Lenovo', 'Laptop');
INSERT INTO `senla_course_db`.`product` (`model`, `maker`, `type`) VALUES ('2', 'Samsung', 'PC');
INSERT INTO `senla_course_db`.`product` (`model`, `maker`, `type`) VALUES ('3', 'Canon', 'Printer');
INSERT INTO `senla_course_db`.`product` (`model`, `maker`, `type`) VALUES ('4', 'Lenovo', 'PC');
INSERT INTO `senla_course_db`.`product` (`model`, `maker`, `type`) VALUES ('5', 'Samsung', 'Laptop');
INSERT INTO `senla_course_db`.`product` (`model`, `maker`, `type`) VALUES ('6', 'HP', 'Printer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `senla_course_db`.`pc`
-- -----------------------------------------------------
START TRANSACTION;
USE `senla_course_db`;
INSERT INTO `senla_course_db`.`pc` (`code`, `model`, `speed`, `ram`, `hd`, `cd`, `price`) VALUES (12, '2', 4000, 10000, 750, '12', 1000);
INSERT INTO `senla_course_db`.`pc` (`code`, `model`, `speed`, `ram`, `hd`, `cd`, `price`) VALUES (13, '4', 5000, 10000, 400, '12', 1000);
INSERT INTO `senla_course_db`.`pc` (`code`, `model`, `speed`, `ram`, `hd`, `cd`, `price`) VALUES (14, '2', 10000, 5000, 750, '24', NULL);
INSERT INTO `senla_course_db`.`pc` (`code`, `model`, `speed`, `ram`, `hd`, `cd`, `price`) VALUES (15, '4', 7200, 6000, 1500, '36', 2400);
INSERT INTO `senla_course_db`.`pc` (`code`, `model`, `speed`, `ram`, `hd`, `cd`, `price`) VALUES (16, '2', 7200, 7000, 500, '36', 1500);

COMMIT;


-- -----------------------------------------------------
-- Data for table `senla_course_db`.`laptop`
-- -----------------------------------------------------
START TRANSACTION;
USE `senla_course_db`;
INSERT INTO `senla_course_db`.`laptop` (`code`, `model`, `speed`, `ram`, `hd`, `screen`, `price`) VALUES (7, '1', 1000, 4000, 500, 400, 1000);
INSERT INTO `senla_course_db`.`laptop` (`code`, `model`, `speed`, `ram`, `hd`, `screen`, `price`) VALUES (8, '5', 2000, 8000, 500, 200, 2000);
INSERT INTO `senla_course_db`.`laptop` (`code`, `model`, `speed`, `ram`, `hd`, `screen`, `price`) VALUES (9, '5', 5000, 10000, 1000, 100, 5000);
INSERT INTO `senla_course_db`.`laptop` (`code`, `model`, `speed`, `ram`, `hd`, `screen`, `price`) VALUES (10, '1', 500, 4000, 750, 300, );
INSERT INTO `senla_course_db`.`laptop` (`code`, `model`, `speed`, `ram`, `hd`, `screen`, `price`) VALUES (11, '5', 1000, 4200, 300, 350, 750);

COMMIT;


-- -----------------------------------------------------
-- Data for table `senla_course_db`.`printer`
-- -----------------------------------------------------
START TRANSACTION;
USE `senla_course_db`;
INSERT INTO `senla_course_db`.`printer` (`code`, `model`, `color`, `type`, `price`) VALUES (17, '3', 'y', 'Laser', 100);
INSERT INTO `senla_course_db`.`printer` (`code`, `model`, `color`, `type`, `price`) VALUES (18, '3', 'n', 'Jet', 200);
INSERT INTO `senla_course_db`.`printer` (`code`, `model`, `color`, `type`, `price`) VALUES (19, '6', 'y', 'Jet', NULL);
INSERT INTO `senla_course_db`.`printer` (`code`, `model`, `color`, `type`, `price`) VALUES (20, '6', 'y', 'Matrix', 100);
INSERT INTO `senla_course_db`.`printer` (`code`, `model`, `color`, `type`, `price`) VALUES (21, '6', 'n', 'Laser', NULL);

COMMIT;

