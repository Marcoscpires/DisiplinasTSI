import testeClimaAPI

teste = input()
print(teste.strip())


clima = testeClimaAPI.Clima(teste)
print(clima.buscar())
