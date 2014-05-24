#!/usr/local/bin/python


import subprocess
SEP = '/'
root = 'RepositorioDadosEleitorais'

process = subprocess.Popen('mkdir '+root, stdout=subprocess.PIPE, stderr=None, shell=True)
output = process.communicate()

years = ['1950','1955','1960','1970','1974','1978','1982','1986','1989','1990','1994','1996','1998','2000','2002','2004','2006','2008','2010','2012']

consultaCandidatoURL = 'http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_cand/consulta_cand_$year$.zip'
consultaCandidatoPath= root + SEP +'Candidatos'+ SEP + '$year$'+ SEP +'Candidatos'


for y in years:
	command = 'wget '+consultaCandidatoURL+' -P prefix --directory-prefix='+consultaCandidatoPath
	process = subprocess.Popen('mkdir -p '+consultaCandidatoPath.replace('$year$',y), stdout=subprocess.PIPE, stderr=None, shell=True)
       	output = process.communicate()
       	process = subprocess.Popen(command.replace('$year$',y), stdout=subprocess.PIPE, stderr=None, shell=True)
       	output = process.communicate()

process = subprocess.Popen('ls -R | grep -E \'^[^d]\' > files', stdout=subprocess.PIPE, stderr=None, shell=True)
output = process.communicate()


#wget http://agencia.tse.jus.br/estatistica/sead/odsele/bem_candidato/bem_candidato_2012.zip

#wget http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_legendas/consulta_legendas_2012.zip

#wget http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_vagas/consulta_vagas_2012.zip
