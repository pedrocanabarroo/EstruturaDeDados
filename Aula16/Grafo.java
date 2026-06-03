import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grafo {
    int matrizADJ[][];
    int qtdVertices;
    ArrayList<String> vertices;

    /**
     * Construtor
     * @param qtdVertices para indicar a quantidade de linhas e colunas da Matriz 
    */
    public Grafo(ArrayList<String> vertices){
        this.vertices = new ArrayList<>();
        this.vertices.addAll(vertices);
        this.qtdVertices = vertices.size();
        this.matrizADJ = new int [this.qtdVertices][this.qtdVertices];

        //inicializar com 0 a matriz que representa o grafo
        for(int i = 0; i < qtdVertices; i++){
            for(int j = 0; j < qtdVertices; j++){
                this.matrizADJ[i][j] = 0;
            }
        }
    }

    /**
     * Exibe a matrizADJ do grafo em formato de matriz
     */
    void mostrarMatriz(){
        for(String v : this.vertices){
            System.out.print("    " + v);
        }
        System.out.println();

        for(int i = 0; i < qtdVertices; i++){   
            System.out.print(this.vertices.get(i) + "   ");
            for(int j = 0; j< qtdVertices; j++){
                System.out.print(matrizADJ[i][j] + "    ");
            }
            System.out.println();
        }
    }

    void mostrarGrafo(){
        for(int i = 0; i < qtdVertices; i++){
            System.out.print(this.vertices.get(i) + " -> ");
            for(int j = 0; j < qtdVertices; j++){
                if(this.matrizADJ[i][j] == 1){
                    System.out.print(this.vertices.get(j) + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Insere uma aresta entre os vértices v1 e v2
     * @param v1 índice do vértice de origem
     * @param v2 índice do vértice de destino
     */

    void inserirAresta(int v1, int v2){
        if(this.matrizADJ[v1][v2] == 0){
            this.matrizADJ[v1][v2] = 1;
        }
    }

    //retorna o índice do vértice na lista de vértices
    //@param vertice o nome do vértice
    //@return o índice do vértice ou -1 se não encontrado
    int pegarIndice(String vertice){
        return this.vertices.indexOf(vertice);
    }
}
