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
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`) VALUES('Email');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`) VALUES('Email Compartilhado');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Telefone Fixo', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Tele. Fixo Compartilhado', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Telefone Móvel', '(##)#########');
INSERT INTO `tcs_seu_valor`.`tb_tipo_contato` (`nome`, `mascara`) VALUES('Tele. Móvel Compartilhado', '(##)#########');

-- -----------------------------------------------------
-- INSERTS tb_tipo_usuario
-- -----------------------------------------------------
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` (`nome`) VALUES('Admin');
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` (`nome`) VALUES('Demandante');
INSERT INTO `tcs_seu_valor`.`tb_tipo_usuario` (`nome`) VALUES('Ofertante');

-- -----------------------------------------------------
-- INSERTS tb_status_pedido
-- -----------------------------------------------------
-- COR BRANCA
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Aguardando');
-- COR AMARELA
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Negociando');

-- COR VERDE - STATUS ONDE UM É SELECIONADO E OS OUTROS SÃO DESCARTADOS AUTOMATICAMENTE PARA COR PRETA
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Executando');

-- COR PRETA
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Descartado');

-- COR VERMELHA - ESTE STATUS CORRESPONDE AO CANCELAMENTO DE UM PEDIDO DURANTE SUA EXECUÇÃO
INSERT INTO `tcs_seu_valor`.`tb_status_pedido` (`nome`) VALUES('Cancelado interrompido');

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
INSERT INTO `tcs_seu_valor`.`tb_unidade_medida` (`nome`) VALUES('Pessoa');
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
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Informática');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Imobiliário');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Mobiliário');
INSERT INTO `tcs_seu_valor`.`tb_ramo` (`nome`) VALUES('Eletrodoméstico');



-- -----------------------------------------------------
-- INSERTS tb_nicho
-- -----------------------------------------------------

-- Educação
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Aula de Inglês', 1);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Aula de Espanhol', 1);

-- Alimento
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Buffet Japonês', 2);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Buffet Tailandês', 2);

-- Esporte
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Aula de Futebol', 3);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Aula de Basquete', 3);

-- Saúde
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Medicamento Tele-entrega', 4);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Consulta Nutricionista', 4);

-- Lazer
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Bebida tele-entrega', 5);

-- Automobilismo
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Reparo mecânico', 6);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Reparo interno', 6);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Reparo externo', 6);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Customização', 6);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Limpeza', 6);

-- Informática
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Desenvolvimento software mobile', 7);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Desenvolvimento software web', 7);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Manutenção smartphone', 7);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Manutenção smartwatch', 7);

-- Imobiliário
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Construção manutenção', 8);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Pintua', 8);

-- Mobiliário
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Montagem móveis', 9);
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Frete', 9);

-- Eletroeletrônico
INSERT INTO `tcs_seu_valor`.`tb_nicho` (`nome`, `ramo`) VALUES('Manutenção peças', 10);
