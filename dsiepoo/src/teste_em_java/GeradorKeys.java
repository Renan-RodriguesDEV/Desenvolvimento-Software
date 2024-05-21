package teste_em_java;

import java.util.*;
import javax.swing.JOptionPane;

public class GeradorKeys {

    public static void main(String[] args) {
        int comprimento_da_senha = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Qual será o tamanho da senha: "));
        // estanciamento a classe random
        Random gerador = new Random();

        // adicionado letras maisculas a uma variavel guarda_letrasMaisculas
        String guarda_letrasMaisculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // passando tds as guarda_letrasMaisculas pra minusculas c/tolowercase()
        String guarda_letrasMinusculas = guarda_letrasMaisculas.toLowerCase();
        // armazenado os caracters especiais
        String guarda_especiais = "!@#$%&*";
        // criando um array de numeros
        int[] guardaNumeros = new int[comprimento_da_senha];

        // gerando numeros e guardando no array guardaNumeros[];
        for (int i = 0; i < guardaNumeros.length; i++) {
            guardaNumeros[i] = gerador.nextInt(9) + 1;// de 0 a 9 pq casa digito conta como um caracter
        }
        // embaralhando os numeros 100 vezes pra misturar bem
        for (int i = 0; i < 100; i++) {
            int p1 = gerador.nextInt(guardaNumeros.length);
            int p2 = gerador.nextInt(guardaNumeros.length);
            int aux = guardaNumeros[p1];
            guardaNumeros[p1] = guardaNumeros[p2];
            guardaNumeros[p2] = aux;
        }
        // classificando os numeros em ordem
        for (int x = 0; x < guardaNumeros.length; x++) {
            for (int y = x + 1; y < guardaNumeros.length; y++) {
                if (guardaNumeros[x] > guardaNumeros[y]) {
                    // caso o atual seja maior q seu proximo eles caem na ordenacao buble sort
                    int aux = guardaNumeros[x];
                    guardaNumeros[x] = guardaNumeros[y];
                    guardaNumeros[y] = aux;
                }
            }
        }

        // criando meu array que vai armazenar minha senha com o tamanho passado lá no
        // começo
        String[] senha = new String[comprimento_da_senha];

        for (int i = 0; i < comprimento_da_senha; i++) {
            // sorteando um numero para cair em um dos case
            int escolha = gerador.nextInt(4);
            switch (escolha) {
                // case 0: vai gerar uma pegar um numero do array guardaNumeros em uma posiçao
                // aleatoria
                case 0:
                    senha[i] = String.valueOf(guardaNumeros[gerador.nextInt(guardaNumeros.length)]);
                    break;
                // case 1: vai gerar uma caracter especial do guarda_especiais em uma posiçao
                // aleatoria
                case 1:
                    senha[i] = String.valueOf(guarda_especiais.charAt(gerador.nextInt(guarda_especiais.length())));
                    break;
                // case 2: vai gerar uma letra maiuscula do guarda_letrasMaisculas em uma
                // posiçao aleatoria
                case 2:
                    senha[i] = String
                            .valueOf(guarda_letrasMaisculas.charAt(gerador.nextInt(guarda_letrasMaisculas.length())));
                    break;
                // case 3: vai pegar uma letra do guarda_letrasMinusculas em uma posiçao
                // aleatoria
                case 3:
                    senha[i] = String
                            .valueOf(guarda_letrasMinusculas.charAt(gerador.nextInt(guarda_letrasMinusculas.length())));
                    break;
                default:
                    System.out.println("Ops algo de errado nao deu certo");
                    break;
            }

        }

        // mostrando os caracteres disponiveis
        System.out.print("\nCaracters disponiveis: \n" + "Especiais:" + guarda_especiais + "\nLetras maisculas: "
                + guarda_letrasMaisculas + "\nLetras minusculas: " + guarda_letrasMinusculas);
        // exibindo os numeros disponiveis c/ foreach
        System.out.print("\nNumeros: ");
        for (int i : guardaNumeros) {
            System.out.print(i + ",");
        }

        // guardando a senha[] em uma variavel novaSenha para exibila sem precisar de um
        // For, para o JOptionPane
        String novaSenha = " ";
        for (int i = 0; i < senha.length; i++) {
            novaSenha += senha[i] + " ";
        }

        // um loop para inverte a senha onde o começo aumenta e o fim diminui
        int comeco = 0;
        int fim = senha.length - 1;
        while (comeco < fim) {
            // buble sort para inverter a senha
            String aux = senha[comeco];
            senha[comeco] = senha[fim];
            senha[fim] = aux;
            comeco++;
            fim--;
        }

        // pegando a senha q agr esta invertida e concatenando com a senha[] pra pd
        // exibila
        String invertida = " ";
        for (int i = 0; i < senha.length; i++) {
            invertida += senha[i] + " ";
        }

        // por fim a exibicao 👀🙏
        JOptionPane.showConfirmDialog(null,
                "\nSenha Padrão: '" + novaSenha + "'\nSenha invertida: '" + invertida + "'", "Exibição da Key",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

    }
}
