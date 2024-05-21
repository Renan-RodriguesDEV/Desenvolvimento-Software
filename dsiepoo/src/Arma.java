public class Arma {

    // atributos
    int chassi;
    String model;
    float calibre;
    private boolean carregamento;
    int municao;

    // metodos

    void carregar() {
        if (this.municao != 0) {
            System.out.println("Carregando... ");
        } else {
            System.out.println("Sem municao!! ");
            this.carregamento = false;
        }

    }

    void Atirar() {
        if (this.carregamento == false) {
            System.out.println("Algo deu errado ");
        } else {
            System.out.println("PARARATUDUM");
        }

    }

    // metodo set sem retorno e sem parametros
    void setDestravar() {
        if (this.municao != 0 && this.carregamento == false) {
            this.carregamento = true;
        } else {
            System.out.println("Nao foi possivel destravar!! ");
            this.carregamento = false;
        }

    }

    // metodo set sem retorno e sem parametros
    public void setTravar() {
        if (this.carregamento == true) {
            this.carregamento = false;
        } else {
            System.out.println("Ja esta travada!! ");
        }
    }

    // metodo sem retorno e com parametros
    void qtd_municao(int m) {
        m = this.municao;
        System.out.println("Vc tem " + m + " municao");
    }

    // metodo get c retorno e sem parametros
    String getModelo() {
        return this.model;
    }

    void status() {
        this.getModelo();
        System.out.println("Municao: " + this.municao + "\n"
                + "Chassi: " + this.chassi + "\n"
                + "Calibre: " + this.calibre);

    }
}
