import json
import requests

class Clima():
       
    
    def __init__(self, cidade):
        self.url = f'https://api.openweathermap.org/data/2.5/weather?q={cidade}&lang=pt_br&units=metric&appid=37a9c005072920a30e4531b4991ab462'
    
    def buscar(self):
        try: 
            clima = requests.get(self.url).json()
            cidade = clima['name']
            pais = clima['sys']['country']
            temp = round(clima['main']['temp'])
            situacao = clima['weather'][0]['description']
            icon = ""
            match (situacao):
                case 'céu limpo':
                    icon = "\U00002600"
                case 'chuva leve':
                    icon = "\U00001F327"
                case 'neblina':
                    icon = "\U00001F32B"
                case 'algumas nuvens':
                    icon = "\U000026C5"
                case 'nuvens dispersas':
                    icon = "\U00001F324"
                case 'trovoadas':
                    icon = "\U00001F329"
                case 'chuva moderada':  
                    icon = "\U00001F327"
                case 'nublado':
                    icon = "\U00002601"
            vento = clima['wind']['speed']
            umidade = clima['main']['humidity']
            visibilidade = (clima['visibility'])/1000
            return str(f"**{cidade},{pais}** \n \U00001F321 {temp}ºC\n {icon} {situacao}\n \U00001F4A8 {vento}m/s\n \U0001F4A6 {umidade}%\n \U0001F441 {visibilidade}km")
        except:
            return str("Nome da cidade incorreta")
        



 
