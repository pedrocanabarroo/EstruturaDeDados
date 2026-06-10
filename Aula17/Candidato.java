public class Candidato {

    private String id;
    private String nome;
    private int idade;
    private int experiencia;
    private boolean cursoTecnicoCompleto;
    private boolean ingles;

    public Candidato(String id, String nome, int idade, int experiencia, boolean cursoTecnicoCompleto, boolean ingles) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.experiencia = experiencia;
        this.cursoTecnicoCompleto = cursoTecnicoCompleto;
        this.ingles = ingles;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public boolean isCursoTecnicoCompleto() {
        return cursoTecnicoCompleto;
    }

    public boolean isIngles() {
        return ingles;
    }

    
}
