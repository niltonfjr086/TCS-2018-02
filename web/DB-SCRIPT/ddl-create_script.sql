-- DROP DATABASE IF EXISTS `tcs_seu_valor`
-- DROP SCHEMA IF EXISTS `tcs_seu_valor`

-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
-- Schema tcs_seu_valor
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tcs_seu_valor` DEFAULT CHARACTER SET utf8 ;
USE `tcs_seu_valor`;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_endereco` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT, 
	`cep` VARCHAR(45) NOT NULL,
    `pais` VARCHAR(45) NOT NULL,
    `estado` VARCHAR(45) NOT NULL,
    `municipio` VARCHAR(100) NOT NULL,
    `bairro` VARCHAR(45),
	`logradouro` VARCHAR(100) NOT NULL,
    `numero` INT NOT NULL,
    `complemento` VARCHAR(12)
    
    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_tipo_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_tipo_pessoa` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(100) NOT NULL,
    `chave` VARCHAR(100) NOT NULL,
    `mascara` VARCHAR(100) NOT NULL,
    `limite` INT NOT NULL

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_pessoa` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(100) NOT NULL,
    `documento` VARCHAR(18) UNIQUE NOT NULL,
    `tipo` BIGINT, FOREIGN KEY (`tipo`) REFERENCES `tcs_seu_valor`.`tb_tipo_pessoa` (`id`),
    `endereco` BIGINT, FOREIGN KEY (`endereco`) REFERENCES `tcs_seu_valor`.`tb_endereco` (`id`)

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_tipo_contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_tipo_contato` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(100) NOT NULL,
    `mascara` VARCHAR(100)

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_contato` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `tipo` BIGINT NOT NULL, FOREIGN KEY (`tipo`) REFERENCES `tcs_seu_valor`.`tb_tipo_contato` (`id`),
    `informacao` VARCHAR(30) NOT NULL,
    `pessoa` BIGINT NOT NULL, FOREIGN KEY (`pessoa`) REFERENCES `tcs_seu_valor`.`tb_pessoa` (`id`)

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_tipo_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_tipo_usuario` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(100) NOT NULL

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_usuario` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `tipo` BIGINT NOT NULL, FOREIGN KEY (`tipo`) REFERENCES `tcs_seu_valor`.`tb_tipo_usuario` (`id`),
    `login` VARCHAR(100) NOT NULL,
    `senha` VARCHAR(30) NOT NULL,
    `pessoa` BIGINT NOT NULL, FOREIGN KEY (`pessoa`) REFERENCES `tcs_seu_valor`.`tb_pessoa` (`id`),
    `media_demandada` DOUBLE,
    `quantidade_demandada` INT,
    `media_ofertada` DOUBLE,
    `quantidade_ofertada` INT
    
    ) ENGINE = InnoDB;
    
-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_status_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_status_pedido` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(30) NOT NULL

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_pedido` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `demandante` BIGINT NOT NULL, FOREIGN KEY (`demandante`) REFERENCES `tcs_seu_valor`.`tb_usuario` (`id`),
    `nota_para_demandante` INT,
    `comentario_para_demandante` VARCHAR(100),
    `ofertante` BIGINT, FOREIGN KEY (`ofertante`) REFERENCES `tcs_seu_valor`.`tb_usuario` (`id`),
    `nota_para_ofertante` INT,
    `comentario_para_ofertante` VARCHAR(100),
    `status_pedido` BIGINT DEFAULT 1, FOREIGN KEY (`status_pedido`) REFERENCES `tcs_seu_valor`.`tb_status_pedido` (`id`),
    `dt_abertura` DATETIME DEFAULT NOW(),
    `dt_fechamento` DATETIME

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_tipo_oferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_tipo_oferta` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` UNIQUE VARCHAR(30) NOT NULL

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_ramo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_ramo` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` UNIQUE VARCHAR(30) NOT NULL

    ) ENGINE = InnoDB;
    
-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_nicho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_nicho` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` UNIQUE VARCHAR(30) NOT NULL,
    `ramo` BIGINT NOT NULL, FOREIGN KEY (`ramo`) REFERENCES `tcs_seu_valor`.`tb_ramo` (`id`)

    ) ENGINE = InnoDB;
    
-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_unidade_medida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_unidade_medida` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` UNIQUE VARCHAR(30) NOT NULL

    ) ENGINE = InnoDB;
    
-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_item` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `tipo` BIGINT NOT NULL, FOREIGN KEY (`tipo`) REFERENCES `tcs_seu_valor`.`tb_tipo_oferta` (`id`),
    `nicho` BIGINT NOT NULL, FOREIGN KEY (`nicho`) REFERENCES `tcs_seu_valor`.`tb_nicho` (`id`),
    `nome` VARCHAR(30) NOT NULL,
    `unidade_medida` BIGINT NOT NULL, FOREIGN KEY (`unidade_medida`) REFERENCES `tcs_seu_valor`.`tb_unidade_medida` (`id`),
    `valor` INT NOT NULL

    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_item_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_item_pedido` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `pedido` BIGINT NOT NULL, FOREIGN KEY (`pedido`) REFERENCES `tcs_seu_valor`.`tb_pedido` (`id`),
    `item` BIGINT NOT NULL, FOREIGN KEY (`item`) REFERENCES `tcs_seu_valor`.`tb_item` (`id`),
    `quantidade` INT NOT NULL,
    `subtotal` DOUBLE NOT NULL

    ) ENGINE = InnoDB;
    
-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_competencia` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `competente` BIGINT NOT NULL, FOREIGN KEY (`competente`) REFERENCES `tcs_seu_valor`.`tb_usuario` (`id`),
    `tipo` BIGINT NOT NULL, FOREIGN KEY (`tipo`) REFERENCES `tcs_seu_valor`.`tb_tipo_oferta` (`id`),
    `nicho` BIGINT NOT NULL, FOREIGN KEY (`nicho`) REFERENCES `tcs_seu_valor`.`tb_nicho` (`id`)

    ) ENGINE = InnoDB;
    
-- -----------------------------------------------------
-- Table `tcs_seu_valor`.`tb_acompanhamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_seu_valor`.`tb_acompanhamento` (

	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `pedido` BIGINT NOT NULL, FOREIGN KEY (`pedido`) REFERENCES `tcs_seu_valor`.`tb_pedido` (`id`),
    `mensagem` VARCHAR(100) NOT NULL,
    `emissor` BIGINT NOT NULL, FOREIGN KEY (`emissor`) REFERENCES `tcs_seu_valor`.`tb_usuario` (`id`)

    ) ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;