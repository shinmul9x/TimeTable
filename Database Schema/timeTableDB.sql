-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TimeTable
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TimeTable
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `TimeTable` DEFAULT CHARACTER SET utf8 ;
USE `TimeTable` ;

-- -----------------------------------------------------
-- Table `TimeTable`.`semester`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TimeTable`.`semester` (
  `semester_id` INT NOT NULL AUTO_INCREMENT,
  `semester_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`semester_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TimeTable`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TimeTable`.`subject` (
  `subject_id` INT NOT NULL AUTO_INCREMENT,
  `subject_name` VARCHAR(45) NOT NULL,
  `room` VARCHAR(10) NOT NULL,
  `day` TINYINT(4) NOT NULL,
  `lession` TINYINT(4) NOT NULL,
  `isExercise` BOOLEAN NOT NULL,
  `semester_id` INT NOT NULL,
  PRIMARY KEY (`subject_id`, `semester_id`),
  INDEX `fk_subject_semester_idx` (`semester_id` ASC),
  CONSTRAINT `fk_subject_semester`
    FOREIGN KEY (`semester_id`)
    REFERENCES `TimeTable`.`semester` (`semester_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
