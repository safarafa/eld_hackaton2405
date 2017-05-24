-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotels
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotels
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotels` DEFAULT CHARACTER SET utf8 ;
USE `hotels` ;

-- -----------------------------------------------------
-- Table `hotels`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotels`.`customers` (
  `id_customer` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_customer`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotels`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotels`.`rooms` (
  `id_room` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NOT NULL,
  `seats` INT(11) NOT NULL,
  PRIMARY KEY (`id_room`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotels`.`reservations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotels`.`reservations` (
  `id_reservation` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `total_price` DOUBLE NOT NULL,
  `id_customer` BIGINT(20) NULL DEFAULT NULL,
  `id_room` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  INDEX `FKofp1thcwrrp6bvadtj6028dpe` (`id_customer` ASC),
  INDEX `FKigg5lvd5cn7p77h56gwsg0opq` (`id_room` ASC),
  CONSTRAINT `FKigg5lvd5cn7p77h56gwsg0opq`
    FOREIGN KEY (`id_room`)
    REFERENCES `hotels`.`rooms` (`id_room`),
  CONSTRAINT `FKofp1thcwrrp6bvadtj6028dpe`
    FOREIGN KEY (`id_customer`)
    REFERENCES `hotels`.`customers` (`id_customer`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
