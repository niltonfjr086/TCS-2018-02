-- CONSULTAS BÁSICAS INICIAIS DE TESTE

SELECT * FROM tb_tipo_pessoa;


SELECT * FROM tb_pessoa WHERE tipo=1;
SELECT COUNT(*) FROM tb_pessoa WHERE tipo=2;


SELECT * FROM tb_endereco;


SELECT tb_tipo_pessoa.chave, tb_pessoa.documento, tb_pessoa.nome -- *
FROM tb_pessoa INNER JOIN tb_tipo_pessoa
ON tb_pessoa.tipo = tb_tipo_pessoa.id
-- WHERE tb_pessoa.tipo = 1
ORDER BY tb_tipo_pessoa.id;