
public class CalculadoraIMC {
    public CalculadoraIMC() {
    }

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Lucca", "Xavier", 20, (double) 1.75F, (double) 70.0F);
        p1.CalcularIMC();
        p1.InformaObesidade();
    }

    public static class Pessoa {
        private String nome;
        private String sobrenome;
        private int idade;
        private double altura;
        private double peso;
        private double imc;

        public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.idade = idade;
            this.altura = altura;
            this.peso = peso;
        }

        public void CalcularIMC() {
            this.imc = this.peso / (this.altura * this.altura);
            System.out.printf("%.2f%n", this.imc);
        }

        public void InformaObesidade() {
            if (this.imc < (double) 18.5F) {
                System.out.println("Abaixo do peso");
            } else if (this.imc <= 24.9) {
                System.out.println("Peso normal");
            } else if (this.imc <= 29.9) {
                System.out.println("Sobrepeso");
            } else if (this.imc <= 34.9) {
                System.out.println("Obesidade grau 1");
            } else if (this.imc <= 39.9) {
                System.out.println("Obesidade grau 2");
            } else {
                System.out.println("Obesidade grau 3");
            }

        }

        public String getNome() {
            return this.nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return this.sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public int getIdade() {
            return this.idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public double getAltura() {
            return this.altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public double getPeso() {
            return this.peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        public double getImc() {
            return this.imc;
        }

        public void setImc(double imc) {
            this.imc = imc;
        }
    }

}
