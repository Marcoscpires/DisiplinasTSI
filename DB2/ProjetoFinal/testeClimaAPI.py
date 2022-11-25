import json
import requests
import emoji

class Clima():
       
    
    def __init__(self, cidade):
        self.url = f'https://api.openweathermap.org/data/2.5/weather?q={cidade},BR&lang=pt_br&units=metric&appid=37a9c005072920a30e4531b4991ab462'
    
    def buscar(self):
        clima = requests.get(self.url).json()
        temp = clima['main']['temp']
        situacao = clima['weather'][0]['description']
        icon = ""
        match (situacao):
            case 'céu limpo':
                icon = ":sun:"
        
        return emoji.emojize(str(f" :thermometer: {temp}ºC\n {situacao} {icon}"))
        	
        


teste = "/clima londres"
teste = teste.removeprefix("/clima ")
print(teste.strip())

try:
    clima = Clima(teste)
    print(clima.buscar())
except:
    print(emoji.emojize("Erro"))
    
 
