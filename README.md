## PROJETO ELEIÇÕES TRANSPARENTES

[![Join the chat at https://gitter.im/niltonvasques/eleicoes-transparentes](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/niltonvasques/eleicoes-transparentes?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


- [Introdução](#introdução)
- [Instalação](#instalação)
- [Checklist do projeto](#checklist-do-projeto)

### Introdução
Sistema para mineração dos dados financeiros/eleitorais presentes no TSE

Descrição do cenário
O sistema irá extrair dos dados brutos presentes no TSE [1], as seguintes informações
relevantes para o eleitor:

1. Prestação de contas por partido/candidato
2. Custos das campanhas por ano: qual partido gasta mais por campanha
3. Dinheiro gasto X partido/candidato eleito
4. Comparativo de doações: pessoas físicas X jurídicas X fundo partidário
5. Tratamento de informações: gráfico, tabelas, etc
6. Parsing: dados brutos -> informações


### Instalação

    git clone https://github.com/niltonvasques/eleicoes-transparentes
    cd eleicoes-transparentes
  
##### Importar projetos

Importar os seguintes projetos no eclipse:

  - code/EleicoesTransparentesPersistance
  - code/ParserTSE
  - code/RadarEleitoral

##### Download dos dados

Efetuar o download dos dados das eleições de 2012, no TSE ou no snapshot que já foi testado e está armazenado no mega.

[https://mega.nz/#!aIdx3BSL!xc50O2nrlapLLfZk21d-_IvbrUZb_gFEDcHMWjqXqBo](https://mega.nz/#!aIdx3BSL!xc50O2nrlapLLfZk21d-_IvbrUZb_gFEDcHMWjqXqBo)

Caso deseje baixar direto do TSE, siga para o endereço:

[www.tse.jus.br/eleicoes/estatisticas/repositorio-de-dados-eleitorais](www.tse.jus.br/eleicoes/estatisticas/repositorio-de-dados-eleitorais)

##### Organização dos dados

Todos Os dados devem estar em uma pasta, organizados da seguinte maneira:

  - eleicoes-2012
    - bem_candidato_2012
    - consulta_cand_2012
    - perfil_eleitoral_2012
    - prestacao_final_2012

##### Arquivo de configuração

Crie um arquivo de configurações em `code/eleicoes.properties`, com o seguinte conteúdo:
```properties
database_url = jdbc:mysql://<MYSQL-URL>/<DBNAME>?user=<USER>&password=<SECRET-PASS>
path_root = <PATH-DADOS>
start_uf = AC
```

##### Execução

Executar o main do projeto RadarEleitoral, e usar opção 8 para preparar o banco de dados para receber os dados do parser, em seguida usar a opção 2 para iniciar o parser.

---
### Checklist do projeto
- [ ] Parser dos dados
  - [ ] 2014
  - [x] 2012
  - [ ] 2010
  - [ ] 2008
  - [ ] 2006
- [x] API
  - [x] [REST API](https://github.com/niltonvasques/eleicoes-transparentes-api)
  - [x] Facade
- [ ] Apps
  - [ ] Web App
  - [ ] Android App
  - [x] Sample App
- [ ] Testes
  


