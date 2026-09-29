import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Aluno {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String codigoMatricula;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private String casa;

    public Aluno(){
        this.nome = "";
    }

    public String getNome() {
        return nome;
    }

    public String formataNome(String nome) {
        return nome.substring(0, 1).toUpperCase() + nome.substring(1);
    }

    public void setNome(String nome) {
        this.nome = formataNome(nome);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = formataNome(sobrenome);
    }

    public boolean verificarSobrenome(String sobrenome) {
        if (this.sobrenome.contains(sobrenome)) {
            return true;
        } else {
            return false;
        }
    }

    public String gerarNomeUsuario() {
        char primeiraLetra = this.nome.charAt(0);
        String sobrenome = this.sobrenome.toLowerCase();
        return (primeiraLetra + sobrenome);
    }

    public String gerarCodigoMatricula(int posicao) {
        char inicialNome = this.nome.charAt(0);
        char inicialSobrenome = this.sobrenome.charAt(0);
        int anoAtual = LocalDate.now().getYear();
        return ("" + inicialNome + inicialSobrenome + "-" + anoAtual + posicao);
    }

    public void setCodigoMatricula(int posicao) {
        this.codigoMatricula = gerarCodigoMatricula(posicao);
    }

    public String getCodigoMatricula() {
        return this.codigoMatricula;
    }

    public boolean verificarCasa(String casa) {
        String casaFormatada = formataNome(casa);
        if (this.casa.equals(casaFormatada)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarDataNascimento(String dataNascimento) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, formater);
            LocalDate dataAtual = LocalDate.now();

            if (dataNascimentoFormatada.isAfter(dataAtual)) {
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, formater);
        this.dataNascimento = dataNascimentoFormatada;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade() {
        Period periodo = Period.between(dataNascimento, LocalDate.now());
        this.idade = periodo.getYears();
    }

    public boolean verificarMaioridadeMagica() {
        if (this.idade < 17) {
            return false;
        } else {
            return true;
        }
    }

    public int getCoragem() {
        return coragem;
    }

    public void setCoragem(int coragem) {
        this.coragem = coragem;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAmbicao() {
        return ambicao;
    }

    public void setAmbicao(int ambicao) {
        this.ambicao = ambicao;
    }

    public int getLealdade() {
        return lealdade;
    }

    public void setLealdade(int lealdade) {
        this.lealdade = lealdade;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String exibirInformacoes() {
        return ("nome: " + this.nome + "\n" + "sobrenome: " + this.sobrenome + "\n" + "idade: " + this.idade + "\n"
                + "coragem: " + this.coragem + "\n" + "inteligencia: " + this.inteligencia + "\n" + "ambicao: "
                + this.ambicao + "\n" + "lealdade: " + this.lealdade + "\n" + "casa: " + this.casa + "\n");
    }

    public void calcularCasa() {
        int grifinoria = (2 * this.coragem) + this.lealdade;
        int sonserina = (2 * this.ambicao) + this.inteligencia;
        int corvinal = (2 * this.inteligencia) + this.coragem;
        int lufalufa = (2 * this.lealdade) + this.coragem;
        String casa = "Grifinoria";

        if (sonserina > grifinoria) {
            casa = "Sonserina";
        } else if (corvinal > sonserina) {
            casa = "Corvinal";
        } else if (lufalufa > corvinal) {
            casa = "Lufa-Lufa";
        }
        this.casa = casa;
    }
}
