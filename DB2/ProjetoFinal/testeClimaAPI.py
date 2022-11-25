import json
import requests
import emoji

class Clima():
       
    
    def __init__(self, cidade):
        self.url = f'https://api.openweathermap.org/data/2.5/weather?q={cidade},BR&lang=pt_br&units=metric&appid=37a9c005072920a30e4531b4991ab462'
    
    def buscar(self):
        clima = requests.get(self.url).json()
        return str(f"temperatura: {clima['main']['temp']}ºC\n {clima['weather'][0]['desscription']}")
        	
        


teste = "/clima toledo"
teste = teste.removeprefix("/clima ")
print(teste.strip())

try:
    clima = Clima(teste)
    print(clima.buscar())
except:
    print(emoji.demojize("☀"))
    
 
