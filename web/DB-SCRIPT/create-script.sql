-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`table1` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`login` (
  `idlogin` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idlogin`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`endereco` (
  `idendereco` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(100) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(12) NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(100) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idendereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orcamento` (
  `idorcamento` INT NOT NULL,
  `dt_orcamento` DATE NOT NULL,
  `dt_vl_orcamento` DATE NOT NULL,
  PRIMARY KEY (`idorcamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `telefone` INT(20) NULL,
  `celular` INT(20) NOT NULL,
  `login_idlogin` INT NOT NULL,
  `endereco_idendereco1` INT NOT NULL,
  `orcamento_idorcamento` INT NOT NULL,
  PRIMARY KEY (`idusuario`, `login_idlogin`, `endereco_idendereco1`, `orcamento_idorcamento`),
  INDEX `fk_usuario_login_idx` (`login_idlogin` ASC),
  INDEX `fk_usuario_endereco1_idx` (`endereco_idendereco1` ASC),
  INDEX `fk_usuario_orcamento1_idx` (`orcamento_idorcamento` ASC),
  CONSTRAINT `fk_usuario_login`
    FOREIGN KEY (`login_idlogin`)
    REFERENCES `mydb`.`login` (`idlogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_endereco1`
    FOREIGN KEY (`endereco_idendereco1`)
    REFERENCES `mydb`.`endereco` (`idendereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_orcamento1`
    FOREIGN KEY (`orcamento_idorcamento`)
    REFERENCES `mydb`.`orcamento` (`idorcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pessoa_fisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pessoa_fisica` (
  `idpessoa_fisica` INT NOT NULL AUTO_INCREMENT,
  `cpf` INT(11) NOT NULL,
  PRIMARY KEY (`idpessoa_fisica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pessoa_juridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pessoa_juridica` (
  `idpessoa_juridica` INT NOT NULL AUTO_INCREMENT,
  `cnpj` INT(14) NOT NULL,
  PRIMARY KEY (`idpessoa_juridica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cadastroPessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cadastroPessoaFisica` (
  `usuario_idusuario` INT NOT NULL,
  `usuario_login_idlogin` INT NOT NULL,
  `usuario_endereco_idendereco` INT NOT NULL,
  `pessoa_fisica_idpessoa_fisica` INT NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `usuario_login_idlogin`, `usuario_endereco_idendereco`, `pessoa_fisica_idpessoa_fisica`),
  INDEX `fk_usuario_has_pessoa_fisica_pessoa_fisica1_idx` (`pessoa_fisica_idpessoa_fisica` ASC),
  CONSTRAINT `fk_usuario_has_pessoa_fisica_usuario1`
    FOREIGN KEY (`usuario_idusuario` , `usuario_login_idlogin` , `usuario_endereco_idendereco`)
    REFERENCES `mydb`.`usuario` (`idusuario` , `login_idlogin` , `endereco_idendereco1`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_pessoa_fisica_pessoa_fisica1`
    FOREIGN KEY (`pessoa_fisica_idpessoa_fisica`)
    REFERENCES `mydb`.`pessoa_fisica` (`idpessoa_fisica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cadastroPessoaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cadastroPessoaJuridica` (
  `usuario_idusuario` INT NOT NULL,
  `usuario_login_idlogin` INT NOT NULL,
  `usuario_endereco_idendereco` INT NOT NULL,
  `pessoa_juridica_idpessoa_juridica` INT NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `usuario_login_idlogin`, `usuario_endereco_idendereco`, `pessoa_juridica_idpessoa_juridica`),
  INDEX `fk_usuario_has_pessoa_juridica_pessoa_juridica1_idx` (`pessoa_juridica_idpessoa_juridica` ASC),
  CONSTRAINT `fk_usuario_has_pessoa_juridica_usuario1`
    FOREIGN KEY (`usuario_idusuario` , `usuario_login_idlogin` , `usuario_endereco_idendereco`)
    REFERENCES `mydb`.`usuario` (`idusuario` , `login_idlogin` , `endereco_idendereco1`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_pessoa_juridica_pessoa_juridica1`
    FOREIGN KEY (`pessoa_juridica_idpessoa_juridica`)
    REFERENCES `mydb`.`pessoa_juridica` (`idpessoa_juridica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atividade` (
  `idatividade` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idatividade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipo` (
  `idtipo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idtipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`setor` (
  `idsetor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idsetor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto` (
  `idproduto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` MEDIUMTEXT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` FLOAT NOT NULL,
  `atividade_idatividade` INT NOT NULL,
  `tipo_idtipo` INT NOT NULL,
  `setor_idsetor` INT NOT NULL,
  PRIMARY KEY (`idproduto`, `atividade_idatividade`, `tipo_idtipo`, `setor_idsetor`),
  INDEX `fk_produto_atividade1_idx` (`atividade_idatividade` ASC),
  INDEX `fk_produto_tipo1_idx` (`tipo_idtipo` ASC),
  INDEX `fk_produto_setor1_idx` (`setor_idsetor` ASC),
  CONSTRAINT `fk_produto_atividade1`
    FOREIGN KEY (`atividade_idatividade`)
    REFERENCES `mydb`.`atividade` (`idatividade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_tipo1`
    FOREIGN KEY (`tipo_idtipo`)
    REFERENCES `mydb`.`tipo` (`idtipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_setor1`
    FOREIGN KEY (`setor_idsetor`)
    REFERENCES `mydb`.`setor` (`idsetor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`itens_orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`itens_orcamento` (
  `orcamento_idorcamento` INT NOT NULL,
  `produto_idproduto` INT NOT NULL,
  `produto_atividade_idatividade` INT NOT NULL,
  `produto_tipo_idtipo` INT NOT NULL,
  `produto_setor_idsetor` INT NOT NULL,
  PRIMARY KEY (`orcamento_idorcamento`, `produto_idproduto`, `produto_atividade_idatividade`, `produto_tipo_idtipo`, `produto_setor_idsetor`),
  INDEX `fk_itens_orcamento_orcamento1_idx` (`orcamento_idorcamento` ASC),
  INDEX `fk_itens_orcamento_produto1_idx` (`produto_idproduto` ASC, `produto_atividade_idatividade` ASC, `produto_tipo_idtipo` ASC, `produto_setor_idsetor` ASC),
  CONSTRAINT `fk_itens_orcamento_orcamento1`
    FOREIGN KEY (`orcamento_idorcamento`)
    REFERENCES `mydb`.`orcamento` (`idorcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_orcamento_produto1`
    FOREIGN KEY (`produto_idproduto` , `produto_atividade_idatividade` , `produto_tipo_idtipo` , `produto_setor_idsetor`)
    REFERENCES `mydb`.`produto` (`idproduto` , `atividade_idatividade` , `tipo_idtipo` , `setor_idsetor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;