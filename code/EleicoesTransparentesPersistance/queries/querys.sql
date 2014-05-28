
--CONSULTA RECEITAS CANDIDATOS 

select p.nome, p.numero, sum(valor), t.tipo, count(*) as numero_transacoes  
from Transacao t inner join Candidato p on p.id = t.creditado_id  
where t.tipoCreditado = 'Candidato' and p.numero = 13 and p.UF like '%AC%' 
group by p.id  order by sum(valor) desc;

--CONSULTA RECEITA DE UM CANDIDATO

select c.nome, sum(valor) 
from Transacao t inner join Candidato c on c.id = t.debitado_id 
where t.tipoDebitado = 'Candidato' and c.sequencialCandidato like '%10000000443%';

--CONSULTA DESPESAS PARTIDO

select p.nome, sum(valor), t.tipo, count(*) as numero_transacoes 
from Transacao t inner join Partido p on p.id = t.debitado_id and t.tipoDebitado = 'Partido'  
where  p.numero = 13 and t.UF like '%AC%'
group by p.id 
order by sum(valor) desc;

--CONSULTA TRANSACOES DE UM DETERMINADO PARTIDO

select * 
from Transacao 
where debitado_id = (select id from Partido where numero = 13) and tipoDebitado = 'Partido';



--TODAS AS TRANSACOES DE UM DETERMINADO CANDIDATO

select id, valor, tipoDebitado, debitado_id, tipoCreditado, creditado_id, SUBSTRING(descricao,1,50) 
from Transacao 
where (creditado_id = 2262 and tipoCreditado = 'Candidato') OR (debitado_id = 2262 and tipoDebitado = 'Candidato');

select t.id, t.valor, t.tipo, t.tipoDebitado, t.debitado_id, t.tipoCreditado, t.creditado_id, SUBSTRING(t.descricao,1,50) from Transacao t inner join Candidato c where ((c.id = t.creditado_id and t.tipoCreditado = 'Candidato') OR (c.id = t.debitado_id and t.tipoDebitado = 'Candidato')) and c.sequencialCandidato like '%10000000443%';


--RANKING DOADORES PESSOA JURIDICA

select pj.nome, pj.cnpj, t.tipoDebitado, sum(t.valor) as valor from Transacao t inner join PessoaJuridica pj on pj.id = t.debitado_id  where t.tipo = 'R' and t.tipoDebitado = 'PessoaJuridica' and t.UF like '%AC%' group by t.debitado_id order by sum(t.valor) desc LIMIT 20;

--RANKING DOADORES PESSOA FISICA

select pj.nome, pj.cpf, t.tipoDebitado, sum(t.valor) as valor from Transacao t inner join PessoaFisica pj on pj.id = t.debitado_id  where t.tipo = 'R' and t.tipoDebitado = 'PessoaFisica' group by t.debitado_id order by sum(t.valor) desc LIMIT 20;

--LISTA DE TRANSACOES DE UMA EMPRESA POR NOME
select p.nome as Doador, c.nome as Candidato, c.cargo, c.uf, pt.sigla, t.valor, p.cnpj, SUBSTRING(t.descricao,1,50) from Transacao t join PessoaJuridica p on p.id = t.debitado_id join Candidato c on c.id = t.creditado_id join Partido pt on pt.id = c.partido_id where t.tipoDebitado = 'PessoaJuridica' and p.nome like 'ITAU%' and t.tipoCreditado = 'Candidato';
