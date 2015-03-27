-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema DB_GEKE_TCC
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DB_GEKE_TCC
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DB_GEKE_TCC` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `DB_GEKE_TCC` ;

-- -----------------------------------------------------
-- Table `DB_GEKE_TCC`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_GEKE_TCC`.`Pessoa` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `ativo` TINYINT(1) NOT NULL,
  `tipo` INT NOT NULL COMMENT 'Os tipos de Pessoa são:\n0 = Aluno\n1 = Professor\n2 = Técnico Administrativo\n3 = Membro Externo',
  `nome` VARCHAR(60) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `emailAlternativo` VARCHAR(100) NULL,
  `matricula` VARCHAR(15) NULL,
  `curso` VARCHAR(60) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_GEKE_TCC`.`Matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_GEKE_TCC`.`Matricula` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `tema` VARCHAR(100) NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `tcc` INT(1) NOT NULL COMMENT '0 - TCC 1\n1 - TCC 2',
  `status` INT(1) NOT NULL COMMENT '0 - pendente\n1 - aceita\n2 - rejeitado\n3 - aprovado\n4 - reprovado',
  `aluno` INT NOT NULL,
  `orientador` INT NOT NULL,
  `coorientador` INT NULL,
  `motivoReprovacao` VARCHAR(200) NULL,
  `notaFinal` FLOAT NULL,
  `avaliado` TINYINT(1) NULL,
  PRIMARY KEY (`codigo`),
  INDEX `FK_ALUNO_idx` (`aluno` ASC),
  INDEX `FK_ORIENTADOR_idx` (`orientador` ASC),
  INDEX `FK_COORIENTADOR_idx` (`coorientador` ASC),
  CONSTRAINT `FK_ALUNO`
    FOREIGN KEY (`aluno`)
    REFERENCES `DB_GEKE_TCC`.`Pessoa` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `FK_ORIENTADOR`
    FOREIGN KEY (`orientador`)
    REFERENCES `DB_GEKE_TCC`.`Pessoa` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `FK_COORIENTADOR`
    FOREIGN KEY (`coorientador`)
    REFERENCES `DB_GEKE_TCC`.`Pessoa` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_GEKE_TCC`.`MatriculaArquivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_GEKE_TCC`.`MatriculaArquivo` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `arquivo` LONGBLOB NOT NULL,
  `matricula` INT NOT NULL,
  `status` INT(1) NOT NULL COMMENT '0 - pendente\n1 - aceito\n2 - rejeitado',
  PRIMARY KEY (`codigo`),
  INDEX `fk_matricula_idx` (`matricula` ASC),
  CONSTRAINT `fk_matricula`
    FOREIGN KEY (`matricula`)
    REFERENCES `DB_GEKE_TCC`.`Matricula` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_GEKE_TCC`.`Defesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_GEKE_TCC`.`Defesa` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `matricula` INT NOT NULL,
  `data` DATE NULL,
  `hora` TIME NULL,
  `local` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`),
  INDEX `bancaMatricula_idx` (`matricula` ASC),
  CONSTRAINT `bancaMatricula`
    FOREIGN KEY (`matricula`)
    REFERENCES `DB_GEKE_TCC`.`Matricula` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_GEKE_TCC`.`MembroBanca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_GEKE_TCC`.`MembroBanca` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `matricula` INT NOT NULL,
  `membro` INT NOT NULL,
  `presenca` TINYINT(1) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `matricula_idx` (`matricula` ASC),
  INDEX `membro_idx` (`membro` ASC),
  CONSTRAINT `matricula`
    FOREIGN KEY (`matricula`)
    REFERENCES `DB_GEKE_TCC`.`Matricula` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `membro`
    FOREIGN KEY (`membro`)
    REFERENCES `DB_GEKE_TCC`.`Pessoa` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_GEKE_TCC`.`Nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_GEKE_TCC`.`Nota` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `membroBanca` INT NOT NULL,
  `relevancia` FLOAT NOT NULL,
  `estadoArte` FLOAT NOT NULL,
  `clarezaApresentacao` FLOAT NOT NULL,
  `corretudeTecnica` FLOAT NOT NULL,
  `abrangencia` FLOAT NOT NULL,
  `conhecimento` FLOAT NOT NULL,
  `planejamento` FLOAT NOT NULL,
  `clarezaTexto` FLOAT NOT NULL,
  `gramaticaOrtografia` FLOAT NOT NULL,
  `estruturaOrg` FLOAT NOT NULL,
  `notaFinalAvaliacao` FLOAT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `membroBanca_idx` (`membroBanca` ASC),
  CONSTRAINT `membroBanca`
    FOREIGN KEY (`membroBanca`)
    REFERENCES `DB_GEKE_TCC`.`MembroBanca` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
