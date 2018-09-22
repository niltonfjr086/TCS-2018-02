-- CONSULTAS BÁSICAS INICIAIS DE TESTE
USE tcs_seu_valor;

SELECT * FROM tcs_seu_valor.tb_tipo_pessoa;


SELECT * FROM tcs_seu_valor.tb_pessoa WHERE tipo=2;
SELECT COUNT(*) FROM tcs_seu_valor.tb_pessoa WHERE tipo=2;


SELECT * FROM tcs_seu_valor.tb_endereco;


SELECT tcs_seu_valor.tb_tipo_pessoa.chave, tcs_seu_valor.tb_pessoa.documento, tcs_seu_valor.tb_pessoa.nome -- *
FROM tcs_seu_valor.tb_pessoa INNER JOIN tcs_seu_valor.tb_tipo_pessoa
ON tcs_seu_valor.tb_pessoa.tipo = tcs_seu_valor.tb_tipo_pessoa.id
-- WHERE tcs_seu_valor.tb_pessoa.tipo = 1
ORDER BY tcs_seu_valor.tb_tipo_pessoa.id;


SELECT * FROM tcs_seu_valor.tb_tipo_usuario;

SELECT * FROM tcs_seu_valor.tb_ramo;