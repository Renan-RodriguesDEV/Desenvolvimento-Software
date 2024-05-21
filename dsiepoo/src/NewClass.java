import java.util.*;

public class NewClass {

    public static void main(String[] args) {
        
        //estanciando a Ak da classe arma
        Arma ak = new Arma();
        Scanner sc = new Scanner(System.in);
        //atribuindo valores a estancia
        System.out.println("Qual modelo da sua arma: ");
        ak.model = sc.nextLine();
        System.out.println("Qual calibre da sua arma: ");
        ak.calibre = sc.nextFloat();
        System.out.println("Qual chassi da sua arma: ");
        ak.chassi = sc.nextInt();
        System.out.println("Quanto de municao tem sua arma: ");
        ak.municao = sc.nextInt();
        
        //chamando metodos
        ak.qtd_municao(ak.municao);
        ak.getModelo();
        ak.status();
        ak.carregar();
        ak.setDestravar();
        ak.Atirar();
        
    }
}
