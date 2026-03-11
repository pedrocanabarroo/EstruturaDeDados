from Glicemia import Glicemia

lista = []

linha = "120, 11/03/2026, 09:00"

vetor_linha = linha.split(",")

obj = Glicemia(int(vetor_linha[0]), vetor_linha[1], vetor_linha[2])

if obj not in lista:
    lista.append(obj)
