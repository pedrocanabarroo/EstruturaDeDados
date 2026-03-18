class Clima:

    def __init__(self, ano, mes, temperatura, precipitacao):
        self.ano = ano
        self.mes = mes
        self.temperatura = temperatura
        self.precipitacao = precipitacao
    
    def __str__(self):
        return f"Dados climáticos (Ano: {self.ano}. Mes: {self.mes}. Temperatura: {self.temperatura}. Precipitação: {self.precipitacao}."

    