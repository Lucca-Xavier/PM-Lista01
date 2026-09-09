import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;;

public class Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno[] alunos = new Aluno[10];
        int cont = 0;
        System.out.println("Selecione uma opcao: ");
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("1- Cadastrar Aluno");
            System.out.println("2- Listar Alunos");
            System.out.println("3- Listar Alunos De Uma Casa Especifica");
            System.out.println("4- Listar Alunos Por Casa");
            System.out.println("5- Listar Alunos Maiores De Idade");
            System.out.println("6- Listar Alunos Menores De Idade");
            System.out.println("7- Listar Alunos Com Um SObrenome Especifico");
            System.out.println("8- Encerrar");
            System.out.println("-----------------------------------------------------------");
            int opcao = scanner.nextInt();
            if (opcao == 0) {
                break;
            } else if (opcao == 1) {
                if (cont > 9) {
                    System.out.println("Limite de alunos atingido");
                } else {
                    Aluno aluno = new Aluno();
                    System.out.println("Digite o nome do aluno: ");
                    aluno.setNome(scanner.next());
                    System.out.println("Digite o sobrenome do aluno: ");
                    aluno.setSobrenome(scanner.next());

                    boolean dataValida = false;
                    while (!dataValida) {
                        System.out.println("Digite a data de nascimento do aluno: ");
                        String dataNascimento = scanner.next();
                        if (aluno.validarDataNascimento(dataNascimento)) {
                            aluno.setDataNascimento(dataNascimento);
                            dataValida = true;
                        } else {
                            System.out.println("Data invalida!!");
                        }
                    }

                    System.out.println("Digite o valor de coragem do aluno: ");
                    aluno.setCoragem(scanner.nextInt());
                    System.out.println("Digite o valor de inteligencia do aluno: ");
                    aluno.setInteligencia(scanner.nextInt());
                    System.out.println("Digite o valor de ambicao do aluno: ");
                    aluno.setAmbicao(scanner.nextInt());
                    System.out.println("Digite o valor de lealdade do aluno: ");
                    aluno.setLealdade(scanner.nextInt());
                    aluno.calcularCasa();
                    alunos[cont] = aluno;
                    cont += 1;
                    System.out.println("Aluno adicionado com sucesso!");
                }
            } else if(opcao == 2){
                if(cont == 0){
                    System.out.println("Nenhum aluno adicionado");
                }
                else{
                    for(int i = 0; i<cont; i++){
                        System.out.println("Aluno " + i + " ----------------------------------------------------");
                        alunos[i].exibirInformacoes();
                    }
                }
            } else if(opcao == 3){
                System.out.println("Digite a casa desejada");
                String casa = scanner.next();
                casa = casa.substring(0,1).toUpperCase() + casa.substring(1);
                int cont1 = 0;
                for(int i = 0; i< cont; i++){
                    if(alunos[i].getCasa().equals(casa)){
                        alunos[i].exibirInformacoes();
                        cont1 += 1;
                    }
                    System.out.println(cont1 + " Alunos da " + casa);
                }
            } else if(opcao == 4){

            }
        }

        
    }

    static class Aluno {
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

        public String getNome() {
            return nome;
        }

        public String formataNome(String nome) {
            return nome.substring(0,1).toUpperCase() + nome.substring(1);
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
}
