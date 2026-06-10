import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) throws IOException { 

        List <Candidato> candidatos = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("candidatos.csv"));

        br.readLine();
        String linha;
        
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            Candidato candidato = new Candidato(
                    dados[0],
                    dados[1],
                    Integer.parseInt(dados[2]),
                    Integer.parseInt(dados[3]),
                    dados[4].equalsIgnoreCase("Sim"),
                    dados[5].equalsIgnoreCase("Sim")
            );
            
            candidatos.add(candidato);
        }
        br.close();

        Scanner scanner = new Scanner(System.in);
        int opcao;                                 

        do {

            System.out.println("1 - Exibir candidatos que possuem maioridade legal E possuem curso técnico completo.");
            System.out.println("2 - Exibir candidatos que tragam maturidade profissional (mínimo 3 anos de experiência) OU que possuam domínio da língua inglesa. ");
            System.out.println("3 - Exibir candidatos com menos de 25 anos que já possuam alguma qualificação (curso técnico OU experiência mínima de 1 ano). ");
            System.out.println("4 - Sair do programa");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1: {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getIdade() >= 18 && candidato.isCursoTecnicoCompleto()) {
                            System.out.println(candidato);
                        }
                    }
                    break;
                }

                case 2: {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getExperiencia() >= 3 || candidato.isIngles()) {
                            System.out.println(candidato);
                        }
                    }
                    break;
                }

                case 3: {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getIdade() < 25 && (candidato.isCursoTecnicoCompleto() || candidato.getExperiencia() >= 1)) {
                            System.out.println(candidato);
                        }
                    }
                    break;
                }

                case 4: {
                    System.out.println("Saindo do programa...");
                    break;
                }

            } 

        } while (opcao != 4);

        System.out.println("Programa encerrado.");
        
        scanner.close();

    }
}
