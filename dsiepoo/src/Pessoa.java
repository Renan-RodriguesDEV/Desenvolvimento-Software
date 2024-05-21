
import java.util.*;

public class Pessoa {

    // estanciando o scanner
    Scanner sc = new Scanner(System.in);

    // attbs
    String nomeCompleto;
    int idade;
    int idadeDps;
    float peso;
    float altura;

    // metodo construtor
    public Pessoa() {
        System.out.println("Ql seu nome completo");
        this.nomeCompleto = sc.nextLine();
        System.out.println("Ql sua idade: ");
        this.idade = sc.nextInt();
        this.idadeDps = idade++;
        System.out.println("Ql seu peso: ");
        this.peso = sc.nextFloat();
        System.out.println("Ql sua altura: ");
        this.altura = sc.nextFloat();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdadeDps() {
        return idade++;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    void statusPessoa() {
        System.out.println("Mostrando seus status!!!");
        System.out.println("Seu nome: " + this.getNomeCompleto());
        System.out.println("Sua idade: " + this.getIdade());
        System.out.println("Sua altura: " + this.getAltura());
        System.out.println("Seu peso: " + this.getPeso());
        System.out.println("Sua idade ano que vem: " + this.getIdadeDps());
    }

}
