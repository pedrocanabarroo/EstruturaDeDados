## Estrutura de Dados - Unidade 1
 - Físicas: as próprias varipaveis - fortamente dependentes da linguagem de programação
 - Abstratas: algoritmos de gestão de memória (COLEÇÕES)
   
   - Lista: conjunto de dados ordenados (não obrigatoriamente) 
     - todas as operações - inserir, remover, buscar, atualizar (Create, Retrieve, Update, Delete)
     - foco no amazenamento, busca e relatórios
     - contains, size, add, remove, isEmpty
       
   - Pilha: dados organizados pelo topo - LIFO: Last In, First Out
     - há duas operações: inserir no topo e o remover do topo
     - foco no dado que está no topo
     - peek, push, pop
       
   - Fila: dados organizados pela chegada - FIFO: First In, First Out
     - há dois ponteiros: o início/cabeça para o remover e o fim/cauda para o inserir
     - foco na prioridade de chegada, ou seja, o dado mais importante é o que está no início/cabeça
     - offers, poll
  
 - No processo de herança: LISTA -> PILHA -> FILA

- COLEÇÕES de objetos
  - Na classe, há os métodos que devem ser sobreescritos:
    - toString()
    - equals()
      
 OBS:. o arquivo serve para o programador, mas na compilação todas as classes serão geradas.
 ### Exemplo - Main
```
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Aluno {
    String cpf;
    String nome;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Aluno(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aluno [cpf=" + cpf + ", nome=" + nome + "]";
    }
}

public class ExemploMaria {  
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String cpf, nome;
        Aluno alunoTMP;
        boolean flagSair;

        do {
            do {
                System.out.print("Digite o cpf: ");
                cpf = teclado.nextLine().toUpperCase();
                if (cpf.equals("FIM")) {
                    alunos.sort((a1, a2) -> a1.getNome().compareTo(a2.getNome()));
                    System.out.println("Alunos cadastrados....");
                    for (Aluno a : alunos) {
                        System.out.println(a);
                    }
                    System.exit(1);
                }
                if (Util.cpfValido(cpf)) {
                    break;
                } else {
                    System.out.println("CPF invalido!!!");
                }
            } while (true);
            System.out.print("Nome: ");
            nome = teclado.nextLine().toLowerCase();
            alunoTMP = new Aluno(cpf, nome);
            if (!alunos.contains(alunoTMP)) {
                alunos.add(alunoTMP);
            } else {
                System.out.println("Aluno com este cpf ja cadastrado!!");
            }
        } while (true);
    }
}
```
### Exemplo - Classe
```
public class Util {
    /**
     * método que recebe um cpf por string e retorna true se eh valido, ou false caso contrario
     * @param cpf - numero identificador da pessoa física
     * @return true se cpf valido
     */
    public static boolean cpfValido(String cpf) {
        // Remove qualquer caractere que não seja número
        cpf = cpf.replaceAll("\\D", "");

        // CPF deve ter 11 dígitos e não pode ser uma sequência de números iguais
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Cálculo do 1º dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 > 9) digito1 = 0;

            // Cálculo do 2º dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 > 9) digito2 = 0;

            // Verifica se os dígitos calculados batem com os digitados
            return (digito1 == (cpf.charAt(9) - '0') && digito2 == (cpf.charAt(10) - '0'));

        } catch (Exception e) {
            return false;
        }
    }
}

```
## Matrizes Especiais - Unidade 2
- Saber urgente: todo objeto que seja de classe, de matriz/vetor quando passado como parâmetro ou argumento é passado sua referência (endereço). Todo objeto é um ponteiro!!!
  
### Exemplo - Main Principal
```
import java.util.List;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        int dimensao = 10;

        int matriz[][] = new int[dimensao][dimensao];

        Matrizes.inicializarMatrizInteiro(matriz, dimensao, dimensao);

        matriz[0][3] = 1;
        matriz[1][1] = 1;
        matriz[2][4] = 1;
        matriz[5][7] = 1;
        matriz[7][9] = 1;
        matriz[8][8] = 1;
        
        Matrizes.exibirMatriz(matriz, dimensao, dimensao);

        List<Dado> matrizEspecial = new ArrayList<>();
        Matrizes.converter(matriz, dimensao, dimensao, matrizEspecial);
        Matrizes.exibirLista(matrizEspecial);

    }
}

```
### Exemplo - Classe Matrizes 
```
import java.util.List;

public class Matrizes {

    /**
     * método de classe que inicializa com zeros a matriz
     * @param matiz - matriz de inteiro que sera inicializada com zeros
     * @param qtdLinhas - quantidade de linhas
     * @param qtdColunas - quantidade de colunas
     */

    public static void inicializarMatrizInteiro(int m[][], int qtdLinhas, int qtdColunas) {
         for (int lin = 0; lin < qtdLinhas; lin ++){
            for( int col = 0; col < qtdColunas; col++){
                m[lin][col] = 0;
            }
        }
    }

    /**
     * método de classe que exibe uma matriz de qualquer tipo
     * @param m - matriz que será exibida
     * @param qtdLinhas - quantidade de linhas
     * @param qtdColunas - quantidade de colunas
    */

    public static void exibirMatriz(int m[][], int qtdLinhas, int qtdColunas){
        for (int lin = 0; lin < qtdLinhas; lin ++){
            for( int col = 0; col < qtdColunas; col++){
                System.out.print(m[lin][col] + "\t");
            }
            System.out.println( );
        }
    }


    /**
     * método de classe que recebe uma matriz com muitos valores nulos e a converte para uma lista de matrizes especiais
     * @param m - matriz com valores nulos ou sua maioria
     * @param qtdLinhas - quantidade de linhas 
     * @param qtdColunas - quantidade de colunas 
     * @param lista - lista que armazena os valores não nulos da matriz
     */

    public static void converter(int m[][], int qtdLinhas, int qtdColunas, List<Dado> lista ){
        for (int lin = 0; lin < qtdLinhas; lin ++){
            for( int col = 0; col < qtdColunas; col++){
                if(m[lin][col] != 0){
                    lista.add(new Dado(m[lin][col], lin, col));
                }
            }
        }
    }


    /**
     * método de classe que exibe o coneúdo de uma lista de tipo Dado
     * @param lista - contém os dados 
     */

    public static void exibirLista(List<Dado> lista){
        for (Dado item : lista){
            System.out.println(item);
        }
        System.out.println("Total de elementos nao nulos: " + lista.size());
    }
```
### Exemplo - Classe Dado
```
public class Dado {
    int valor;
    int linha;
    int coluna;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public Dado(int valor, int linha, int coluna) {
        this.valor = valor;
        this.linha = linha;
        this.coluna = coluna;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dado other = (Dado) obj;
        if (linha != other.linha)
            return false;
        if (coluna != other.coluna)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dado [valor=" + valor + ", linha=" + linha + ", coluna=" + coluna + "]";
    }
    
}
```
