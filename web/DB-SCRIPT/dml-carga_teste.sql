-- -----------------------------------------------------
-- INSERTS tb_endereco
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_endereco` (`cep`, `pais`, `estado`, `municipio`, `bairro`, `logradouro`, `numero`, `complemento`) 
VALUES('88085-150', 'Brasil', 'SC', 'Florianópolis', 'Capoeiras', 'Avenida Patrício Caldeira de Andrade', 1010, 'apto');
INSERT INTO `tcs_seu_valor`.`tb_endereco` (`cep`, `pais`, `estado`, `municipio`, `bairro`, `logradouro`, `numero`, `complemento`) 
VALUES('88085-150', 'Brasil', 'SC', 'Florianópolis', 'Capoeiras', 'Avenida Patrício Caldeira de Andrade', 1010, 'apto');
INSERT INTO `tcs_seu_valor`.`tb_endereco` (`cep`, `pais`, `estado`, `municipio`, `bairro`, `logradouro`, `numero`, `complemento`) 
VALUES('88085-150', 'Brasil', 'SC', 'Florianópolis', 'Capoeiras', 'Avenida Patrício Caldeira de Andrade', 1010, 'apto');


-- -----------------------------------------------------
-- INSERTS tb_pessoa
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_pessoa` (`nome`, `documento`, `tipo`, `endereco`) VALUES('James Silva', '123.321.644-20', 1, 1);
INSERT INTO `tcs_seu_valor`.`tb_pessoa` (`nome`, `documento`, `tipo`, `endereco`) VALUES('Doodle1', '24.527.942/4182-12', 2, 2);
INSERT INTO `tcs_seu_valor`.`tb_pessoa` (`nome`, `documento`, `tipo`, `endereco`) VALUES('Doodle2', '25.527.942/4182-14', 2, 3);

-- -----------------------------------------------------
-- INSERTS tb_usuario
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_usuario` (`tipo`, `login`, `senha`, `pessoa`) VALUES(2, 'james', '1010', 1);
INSERT INTO `tcs_seu_valor`.`tb_usuario` (`tipo`, `login`, `senha`, `pessoa`) VALUES(3, 'doogle1', '1010', 2);
INSERT INTO `tcs_seu_valor`.`tb_usuario` (`tipo`, `login`, `senha`, `pessoa`) VALUES(3, 'doogle2', '1010', 3);

-- -----------------------------------------------------
-- INSERTS tb_filtro_oferta
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_filtro_oferta` (`ofertante`, `tipo`, `nicho`) VALUES(2,2,3); -- Buffet Japonês - COMPLETO
INSERT INTO `tcs_seu_valor`.`tb_filtro_oferta` (`ofertante`, `tipo`, `nicho`) VALUES(3,2,3); -- Buffet Japonês - COMPLETO