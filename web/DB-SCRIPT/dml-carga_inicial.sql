-- -----------------------------------------------------
-- INSERTS tb_tipo_pessoa
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_tipo_pessoa` (`nome`, `chave`, `mascara`, `limite`)
VALUES('FÍSICA', 'CPF', '###.###.###-##', 14);
INSERT INTO `tcs_seu_valor`.`tb_tipo_pessoa` (`nome`, `chave`, `mascara`, `limite`)
VALUES('JURÍDICA', 'CNPJ', '##.###.###/####-##', 18);

-- -----------------------------------------------------
-- INSERTS tb_tipo_contato
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` VALUES('Email Pessoal');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` VALUES('Email Corporativo');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` VALUES('Telefone Pessoal', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` VALUES('Telefone Corporativo', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` VALUES('Celular Pessoal', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` VALUES('Celular Corporativo', '(##)#########');

-- -----------------------------------------------------
-- INSERTS tb_tipo_usuario
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` VALUES('Admin');
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` VALUES('Demandante');
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` VALUES('Ofertante');

-- -----------------------------------------------------
-- INSERTS tb_status_pedido
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` VALUES('Orçando');
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` VALUES('Definindo');
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` VALUES('Cancelado');
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` VALUES('Executando');
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` VALUES('Finalizado');

-- -----------------------------------------------------
-- INSERTS tb_tipo_oferta
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_tipo_oferta` VALUES('Produto');
INSERT INTO `tcs_seu_valor`.`tb_tipo_oferta` VALUES('Serviço');
INSERT INTO `tcs_seu_valor`.`tb_tipo_oferta` VALUES('Completo');

-- -----------------------------------------------------
-- INSERTS tb_ramo
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Educação');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Alimento');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Esporte');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Saúde');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Lazer');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Automobilismo');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Construção');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Alvenaria');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Mobília');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Eletrodoméstico');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Tecnologia');
INSERT INTO `tcs_seu_valor`.`tb_ramo` VALUES('Eletrônico');


-- -----------------------------------------------------
-- INSERTS tb_nicho
-- -----------------------------------------------------

-- Educação
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('Aula de Inglês', 1);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('Aula de Espanhol', 1);

-- Alimento
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('Japonês', 2);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('Tailandês', 2);

-- Esporte
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('Futebol', 3);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('Basquete', 3);

-- Saúde
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 4);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 4);

-- Lazer
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 5);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 5);

-- Automobilismo
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 6);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 6);

-- Construção
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 7);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 7);

-- Alvenaria
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 8);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 8);

-- Mobília
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 9);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 9);

-- Eletrodoméstico
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 10);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 10);

-- Tecnologia
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 11);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 11);

-- Eletrônico
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 12);
INSERT INTO `tcs_seu_valor`.`tb_nicho` VALUES('', 12);


-- -----------------------------------------------------
-- INSERTS tb_unidade_medida
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` VALUES('Hora');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` VALUES('Dia');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` VALUES('Metro');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` VALUES('Quilograma');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` VALUES('Litro');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` VALUES('Outro');
