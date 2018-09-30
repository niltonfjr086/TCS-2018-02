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
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`) VALUES('Email Pessoal');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`) VALUES('Email Corporativo');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Telefone Pessoal', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Telefone Corporativo', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Celular Pessoal', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Celular Corporativo', '(##)#########');

-- -----------------------------------------------------
-- INSERTS tb_tipo_usuario
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` (`nome`) VALUES('Admin');
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` (`nome`) VALUES('Demandante');
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` (`nome`) VALUES('Ofertante');

-- -----------------------------------------------------
-- INSERTS tb_status_pedido
-- -----------------------------------------------------
-- COR AMARELA
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Aguardando');
-- COR VERDE
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Negociando');
-- COR VERMELHO
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Cancelado');

-- COR 
-- STATUS ONDE OS OUTROS SÃO CANCELADOS
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Executando');

-- COR AZUL
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Concluído');

-- -----------------------------------------------------
-- INSERTS tb_tipo_oferta
-- -----------------------------------------------------
-- INSERT INTO `tcs_seu_valor`.`tb_tipo_oferta` (`nome`) VALUES('Produto');
INSERT INTO `tcs_seu_valor`.`tb_tipo_oferta` (`nome`) VALUES('Somente Serviço');
INSERT INTO `tcs_seu_valor`.`tb_tipo_oferta` (`nome`) VALUES('Completo');

-- -----------------------------------------------------
-- INSERTS tb_unidade_medida
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` (`nome`) VALUES('Hora');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` (`nome`) VALUES('Dia');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` (`nome`) VALUES('Metro');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` (`nome`) VALUES('Quilograma');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` (`nome`) VALUES('Litro');
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` (`nome`) VALUES('Outro');

-- -----------------------------------------------------
-- INSERTS tb_ramo
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Educação');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Alimento');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Esporte');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Saúde');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Lazer');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Automobilismo');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Construção');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Alvenaria');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Mobília');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Eletrodoméstico');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Tecnologia');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Eletrônico');


-- -----------------------------------------------------
-- INSERTS tb_nicho
-- -----------------------------------------------------

-- Educação
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Aula de Inglês', 1);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Aula de Espanhol', 1);

-- Alimento
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Japonês', 2);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Tailandês', 2);

-- Esporte
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Futebol', 3);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Basquete', 3);

-- Saúde
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 4);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 4);

-- Lazer
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 5);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 5);

-- Automobilismo
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 6);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 6);

-- Construção
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 7);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 7);

-- Alvenaria
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 8);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 8);

-- Mobília
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 9);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 9);

-- Eletrodoméstico
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 10);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 10);

-- Tecnologia
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 11);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 11);

-- Eletrônico
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 12);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('', 12);
