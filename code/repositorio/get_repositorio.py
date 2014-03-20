#!/usr/local/bin/python

import os

SEP = '/'
root = SEP+'home'+SEP+'flavio'+SEP+'RepositorioDadosEleitorais'

os.popen('mkdir '+root,"r")

years = ['1950','1955','1960','1970','1974','1978','1982','1986','1989','1990','1994','1996','1998','2000','2002','2004','2006','2008','2010','2012']

consultaCandidatoURL = 'http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_cand/consulta_cand_$year$.zip'
consultaCandidatoPath= root + SEP +'Candidatos'+ SEP + '$year$'+ SEP +'Candidatos'


for y in years:
	command = 'wget '+consultaCandidatoURL+' -P prefix --directory-prefix='+consultaCandidatoPath
	os.popen('mkdir -p '+consultaCandidatoPath.replace('year',y),'r')
	os.popen(command.replace('$year$',y),"r")

#wget http://agencia.tse.jus.br/estatistica/sead/odsele/bem_candidato/bem_candidato_2012.zip

#wget http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_legendas/consulta_legendas_2012.zip

#wget http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_vagas/consulta_vagas_2012.zip
