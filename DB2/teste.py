import itertools
import requests
import json
paises = requests.get("https://servicodados.ibge.gov.br/api/v1/paises/BR%7CRU%7CCN%7CIN%7CZA/indicadores/77850").json()
paises = paises[0]['series']
dict_taxa = {"":1}
for pais in paises:
    nome_pais = pais['pais']['nome']
    for taxas in pais['serie']:
        value = str(list(taxas.values())[0])
        key = str(list(taxas.keys()))
        if value != "None":
            valor = float(value)
            chave = str(nome_pais + key)
            dict_taxa[chave] = valor
    tx_ord = {k: v for k, v in sorted(dict_taxa.items(), key=lambda item: item[1], reverse=True)}    
    tx_ord_10 = dict(itertools.islice(tx_ord.items(),10))          
print(tx_ord_10)