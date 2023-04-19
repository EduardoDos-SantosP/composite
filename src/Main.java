package src;

public class Main {
    public static void main(String[] args) {
        var caixa = Caixa.criePrata();
        caixa.preencher();
        System.out.println(caixa.getPreco());
        System.out.println(caixa);
    }
}
