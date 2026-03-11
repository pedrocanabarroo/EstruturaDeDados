import random

def popular_lista_aleatoria(lista_numeros,quantidade_numeros,faixa_inicial,faixa_final):
    """método que popula uma lista com números interiors e aleatórios 

    Args:
        lista_numeros (int): armazena números inteiros e aleatórios
        quantidade_numeros (int): total de números interios a serem inseridos
        faixa_inicial (int): número inicial da faixa
        faixa_final (int): número final da faixa
    """
    for _ in range(quantidade_numeros):
        lista_numeros.append(random.randint(faixa_inicial, faixa_final))
    

def exibir_lista(lista_numeros):
    """método que recebe uma lista e a exibe, elementos um abaixo do outro
    Args:
        lista_numeros (int): lista contendo números inteiros
    """
    for numero in lista_numeros:
        print(numero)

    print("------------------------")
    print("Total de números armazenados:", len(lista_numeros))

def copiar_lista_sem_repetidos(lista_numeros, lista_resultado):
    """método que recebe uma lista de origem e copia os elementos para uma lista de destino, sem repetir os elementos

    Args:
        lista_numeros (int): lista contendo números inteiros
        lista_resultado (int): lista que receberá os números inteiros da lista de origem, sem repetição
    """
    for numero in lista_numeros:
        if numero not in lista_resultado:
            lista_resultado.append(numero)
    