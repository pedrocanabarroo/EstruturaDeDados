//Recursão é um recurso computacional de programação que substitui as instruções de repetição(for-while)
//Toda repetição obedece 3 pontos:
    //A - Inicialização de variável de controle
    //B - Teste de parada com a variável de controle
    //C - Transformação da variável de controle

import java.util.ArrayList;
import java.util.Random;

public class Recursao {
    public static void popular (ArrayList<Integer> lista, int quantidade){
        Random gerador = new Random();
        int numero;
        for (int i = 0; i < quantidade; i++){
            numero = gerador.nextInt(100);
            lista.add(numero);
        }
    }

    public static void exibir (ArrayList<Integer> lista){
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }

    public static void exibirR (ArrayList<Integer> lista, int n){
        if (n > 0){
            //código antes do empilhamento
            exibirR(lista, n - 1);
            //código depois do empilhamento

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int quantidade = 3;
        popular(lista, quantidade);
        //exibir(lista);
        exibirR(lista, lista.size());
    }
}

/*
Exercícios de fixação sobre o código base gerado. Faça metodos recursivos que:
1) receba uma lista, seu tamanho, valor de pesquisa. Caso o valor de pesquisa ocorra na lista, retornar quantas vezes ele aparece

2) receba uma lista, seu tamanho, valor de pesquisa, valor de substituição. Caso o valor ocorra na lisa, substituir o valor de pesquisa pelo valor de substituição.

3) receba uma lista, seu tamanho, e retorne TRUE se a lista ordenada, FALSE se a lista desordenada

4) receba uma lista e seu tamanho. O método deve exibir todos os números múltiplos de 4
*/

