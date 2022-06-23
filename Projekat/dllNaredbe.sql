-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema isproj
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema isproj
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `isproj` DEFAULT CHARACTER SET utf8 ;
USE `isproj` ;

-- -----------------------------------------------------
-- Table `isproj`.`id_gen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isproj`.`id_gen` (
  `tab_gen` VARCHAR(64) NOT NULL,
  `id_p` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tab_gen`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `isproj`.`stranka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isproj`.`stranka` (
  `brojlicne` VARCHAR(20) NOT NULL,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `adresa` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`brojlicne`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `isproj`.`sud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isproj`.`sud` (
  `idsud` INT(11) NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `grad` VARCHAR(45) NULL DEFAULT NULL,
  `adresa` VARCHAR(45) NULL DEFAULT NULL,
  `nivo` VARCHAR(45) NULL DEFAULT NULL,
  `websajt` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsud`),
  UNIQUE INDEX `websajt_UNIQUE` (`websajt` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `isproj`.`sudija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isproj`.`sudija` (
  `idsudija` INT(11) NOT NULL,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `idsuda` INT(11) NOT NULL,
  PRIMARY KEY (`idsudija`),
  INDEX `fk_sud_idx` (`idsuda` ASC),
  CONSTRAINT `fk_sud`
    FOREIGN KEY (`idsuda`)
    REFERENCES `isproj`.`sud` (`idsud`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `isproj`.`tuzba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isproj`.`tuzba` (
  `idtuzba` INT(11) NOT NULL,
  `idsuda` INT(11) NOT NULL,
  `idsudije` INT(11) NULL DEFAULT NULL,
  `idtuzioc` VARCHAR(20) NOT NULL,
  `idoptuzen` VARCHAR(20) NULL DEFAULT NULL,
  `sadrzaj` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtuzba`),
  INDEX `fk_sudt_idx` (`idsuda` ASC),
  INDEX `fk_sudac_idx` (`idsudije` ASC),
  INDEX `fk_opt_idx` (`idoptuzen` ASC),
  INDEX `fk_tuz_idx` (`idtuzioc` ASC),
  CONSTRAINT `fk_opt`
    FOREIGN KEY (`idoptuzen`)
    REFERENCES `isproj`.`stranka` (`brojlicne`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sudac`
    FOREIGN KEY (`idsudije`)
    REFERENCES `isproj`.`sudija` (`idsudija`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sudt`
    FOREIGN KEY (`idsuda`)
    REFERENCES `isproj`.`sud` (`idsud`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tuz`
    FOREIGN KEY (`idtuzioc`)
    REFERENCES `isproj`.`stranka` (`brojlicne`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
