-- -----------------------------------------------------
-- INSERTS tb_endereco
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_endereco` (`cep`, `pais`, `estado`, `municipio`, `bairro`, `logradouro`, `numero`, `complemento`) 
VALUES('88085-150', 'Brasil', 'SC', 'Florianópolis', 'Capoeiras', 'Avenida Patrício Caldeira de Andrade', 1010, 'apto');
INSERT INTO `tcs_seu_valor`.`tb_endereco` (`cep`, `pais`, `estado`, `municipio`, `bairro`, `logradouro`, `numero`, `complemento`) 
VALUES('88080-200', 'Brasil', 'SC', 'Florianópolis', 'Coqueiros', 'Rua Marques de Carvalho', 1010, 'apto');
INSERT INTO `tcs_seu_valor`.`tb_endereco` (`cep`, `pais`, `estado`, `municipio`, `bairro`, `logradouro`, `numero`, `complemento`) 
VALUES('13484-015', 'Brasil', 'SP', 'Limeira', 'Vila da Glória', 'Rua do Rosário', 1010, 'apto');
INSERT INTO `tcs_seu_valor`.`tb_endereco` (`cep`, `pais`, `estado`, `municipio`, `bairro`, `logradouro`, `numero`, `complemento`) 
VALUES('88070-250', 'Brasil', 'SC', 'Florianópolis', 'Estreito', 'Rua Álvaro Cardoso', 1010, 'apto');


-- -----------------------------------------------------
-- INSERTS tb_pessoa
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_pessoa` (`nome`, `documento`, `tipo`, `endereco`) VALUES('João Silva', '123.321.644-20', 1, 1);
INSERT INTO `tcs_seu_valor`.`tb_pessoa` (`nome`, `documento`, `tipo`, `endereco`) VALUES('Maria Silva', '030.321.644-31', 1, 2);
INSERT INTO `tcs_seu_valor`.`tb_pessoa` (`nome`, `documento`, `tipo`, `endereco`) VALUES('José Silva', '977.321.644-44', 1, 3);
INSERT INTO `tcs_seu_valor`.`tb_pessoa` (`nome`, `documento`, `tipo`, `endereco`) VALUES('Mário Silva', '888.321.644-55', 1, 4);

-- -----------------------------------------------------
-- INSERTS tb_usuario
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_usuario` (`tipo`, `login`, `senha`, `pessoa`) VALUES(2, 'joao', '1010', 1);
INSERT INTO `tcs_seu_valor`.`tb_usuario` (`tipo`, `login`, `senha`, `pessoa`) VALUES(2, 'maria', '1010', 2);
INSERT INTO `tcs_seu_valor`.`tb_usuario` (`tipo`, `login`, `senha`, `pessoa`) VALUES(3, 'jose', '1010', 3);
INSERT INTO `tcs_seu_valor`.`tb_usuario` (`tipo`, `login`, `senha`, `pessoa`) VALUES(3, 'mario', '1010', 4);

-- -----------------------------------------------------
-- INSERTS tb_filtro_oferta
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_filtro_oferta` (`ofertante`, `tipo`, `nicho`) VALUES(3,2,3); -- Buffet Japonês - COMPLETO
INSERT INTO `tcs_seu_valor`.`tb_filtro_oferta` (`ofertante`, `tipo`, `nicho`) VALUES(4,2,3); -- Buffet Japonês - COMPLETO