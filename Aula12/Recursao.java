import java.util.ArrayList;

public class Recursao{
    static void mostrarSequenciaCrescente(int numero){
        //variável de controle => i
        for (int i = 0; i <= numero; i++){
            System.out.println(i);
        }
    }

    static void mostrarSequenciaDecrescente(int numero){
        //variável de controle => número
        for(; numero >= 0; numero --){
            System.out.println(numero);
        }
    }

    static void mostrarSequenciaDecrescenteR(int numero){
        if (numero >= 0){
            System.out.println(numero);
            mostrarSequenciaDecrescenteR(numero - 1); //ponto de recursão
        }
    }

    static void mostrarSequenciaCrescenteR(int numero){
        if (numero >= 0){
            mostrarSequenciaCrescenteR(numero - 1);
            System.out.println(numero);
        }
    }

    static void mostrarIntervalo(int ini, int fim){
        for (; ini <= fim; ini++){
            System.out.println(ini);
        }
    }

    static void mostrarIntervaloR(int ini, int fim){
        if (ini <= fim){
            System.out.println(ini);
            mostrarIntervalo(ini + 1, fim);
        }
    }

    static void mostrarLista(ArrayList<Integer> lista){
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }

        // for (Integer i : lista){
        //     System.out.println(i);
        // }
    }

    static void mostrarListaR(ArrayList<Integer> lista, int n){
        if (n > 0){
            mostrarListaR(lista, n - 1);  
            System.out.println(lista.get(n - 1));
        }
    }

    static void mostrarParesListaR(ArrayList<Integer> lista, int n){
        if (n > 0){
            mostrarParesListaR(lista, n - 1);
            if (lista.get(n - 1) % 2 == 0){
                System.out.println(lista.get(n - 1));
            }
        }
    }

    static void substituirR(ArrayList<Integer> lista, int n, int velho, int novo){
        if (n > 0){
            substituirR(lista, n - 1, velho, novo);
            if (lista.get(n - 1) == velho){
                lista.set(n - 1, novo);
            }
            System.out.println(lista.get(n - 1));
        }
    }

    public static void main (String[] args){
        int numero = 3;
        //mostrarSequenciaCrescente(numero); //mostra a sequencia de 0 até numero
        //mostrarSequenciaDecrescente(numero); //mostra a sequencia de numero até 0
        //mostrarSequenciaCrescenteR(numero);
        //mostrarSequenciaDecrescenteR(numero);

        //mostrarIntervalo(3, 6);
        //mostrarIntervaloR(3, 6);

        ArrayList<Integer> lista = new ArrayList<>();
        //lista = [20, 30, 40]
        lista.add(21);
        lista.add(32);
        lista.add(40);

        //mostrarLista(lista);
        //mostrarListaR(lista, lista.size());
        //mostrarParesListaR(lista, lista.size());
        substituirR(lista, lista.size(), 32, 100);
    }
}
