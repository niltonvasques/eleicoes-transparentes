USE eleicao;

SELECT agentes, candidatos, partidos, comites, pessoasfisica, pessoasjuridica, ( candidatos + partidos + comites + pessoasfisica + pessoasjuridica ) as TOTAL 
FROM ( 
	(SELECT COUNT(*) as agentes 		FROM AgenteEleitoral	) a  JOIN 
	(SELECT COUNT(*) as candidatos 		FROM Candidato		) c  JOIN 
	(SELECT COUNT(*) as partidos 		FROM Partido 		) p  JOIN  
	(SELECT COUNT(*) as comites 		FROM Comite		) co JOIN
	(SELECT COUNT(*) as pessoasfisica 	FROM PessoaFisica	) pf JOIN 
	(SELECT COUNT(*) as pessoasjuridica 	FROM PessoaJuridica	) pj  
);

SELECT SUM(valor) as TOTAL_DOADO_PF FROM PessoaFisica c INNER JOIN Transacao t on t.debitado_id = c.agenteEleitoral_id;
SELECT SUM(valor) as TOTAL_DOADO_PJ FROM PessoaJuridica c INNER JOIN Transacao t on t.debitado_id = c.agenteEleitoral_id;
SELECT SUM(valor) as TOTAL_ARRECADADO_CANDIDATO FROM Candidato c INNER JOIN Transacao t on t.creditado_id = c.agenteEleitoral_id;
SELECT SUM(valor) as TOTAL_ARRECADADO_PARTIDO FROM Partido c INNER JOIN Transacao t on t.creditado_id = c.agenteEleitoral_id;
SELECT SUM(valor) as TOTAL_ARRECADADO_COMITE FROM Comite c INNER JOIN Transacao t on t.creditado_id = c.agenteEleitoral_id;

SELECT nome, SUM(valor) as valor FROM PessoaFisica p INNER JOIN Transacao t on t.debitado_id = p.agenteEleitoral_id GROUP BY p.id ORDER BY SUM(t.valor) DESC LIMIT 10;
SELECT nome, SUM(valor) as valor FROM PessoaJuridica p INNER JOIN Transacao t on t.debitado_id = p.agenteEleitoral_id GROUP BY p.id ORDER BY SUM(t.valor) DESC LIMIT 10;

-- CÁLCULAR OS MAIORES CANDIDATOS RECEBEDORES
SELECT c.nome, SUM(valor) as TOTAL_ARRECADADO_CANDIDATO FROM Candidato c INNER JOIN Transacao t on t.creditado_id = c.agenteEleitoral_id group by c.id order by t.valor DESC limit 10
