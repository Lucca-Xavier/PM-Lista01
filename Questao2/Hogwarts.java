
import java.util.Scanner;

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
}
