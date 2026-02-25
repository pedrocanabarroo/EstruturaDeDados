import java.util.ArrayList;
import java.util.Scanner;

public class exemplo1 {

    public static void main(String[] args) {    
        ArrayList<String> listaNomes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String nome;

        listaNomes.add("Guilherme");
        listaNomes.add("Pedro");
        listaNomes.add("Maria");

        System.out.println(listaNomes);

        if(listaNomes.size() != 0){
            System.out.println("Digite um nome: ");
            nome = sc.nextLine();
            if (listaNomes.contains(nome)){
                listaNomes.remove(nome);
            } else{
                System.out.println("Nome não localizado");
            }

            System.out.println("Total de elementos..." +listaNomes.size());
            System.out.println(listaNomes);

        }
    }
}
