package src;

public class Item implements Produto {
    private final String nome;
    private final float preco;

    public static Item crieQuadrinho() {
        return new Item("Quadrinho", 15);
    }

    public static Item crieChaveiro() {
        return new Item("Chaveiro", 5);
    }

    public static Item crieBusto() {
        return new Item("Busto", 10);
    }

    public static Item crieAdesivo() {
        return new Item("Adesivo", 1);
    }

    public static Item criePoster() {
        return new Item("Poster", 25);
    }

    public static Item crieCamiseta() {
        return new Item("Camiseta", 25);
    }

    public static Item crieCaneta() {
        return new Item("Caneta", 3);
    }

    public static Item crieMiniatura() {
        return new Item("Miniatura", 20);
    }

    private Item(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + ": " + preco;
    }
}
