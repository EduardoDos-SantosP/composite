package src;

import java.util.*;
import java.util.stream.Collectors;

public class Caixa implements Produto/*, List<Produto>*/ {
    private final int maximoItens;
    private final ArrayList<Produto> itens = new ArrayList<>();

    public static Caixa crieBronze() {
        return new Caixa(3);
    }

    public static Caixa criePrata() {
        return new Caixa(5);
    }

    public static Caixa crieOuro() {
        return new Caixa(7);
    }

    public static Caixa criePlatina() {
        return new Caixa(10);
    }

    private Caixa(int maximoItens) {
        this.maximoItens = maximoItens;
    }

    @Override
    public float getPreco() {
        return itens.stream()
                .map(Produto::getPreco)
                .reduce(Float::sum)
                .orElse(0F);
    }

    public void preencher() {
        var sorteador = new SorteadorItens<>(Item.class);
        for (int i = 0; i < maximoItens; i++) {
            itens.add(sorteador.obtenhaAleatorio());
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (var item : itens) str.append(item).append("\n");
        str.append("Total: ").append(getPreco());

        return str.toString();
    }

    /*@Override
    public int size() {
        return itens.size();
    }

    @Override
    public boolean isEmpty() {
        return itens.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return itens.contains(o);
    }

    @Override
    public Iterator<Produto> iterator() {
        return itens.iterator();
    }

    @Override
    public Object[] toArray() {
        return itens.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return itens.toArray(a);
    }

    @Override
    public boolean add(Produto produto) {
        return itens.add(produto);
    }

    @Override
    public boolean remove(Object o) {
        return itens.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return itens.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Produto> c) {
        return itens.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Produto> c) {
        return itens.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return itens.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return itens.retainAll(c);
    }

    @Override
    public void clear() {
        itens.clear();
    }

    @Override
    public Produto get(int index) {
        return itens.get(index);
    }

    @Override
    public Produto set(int index, Produto element) {
        return itens.set(index, element);
    }

    @Override
    public void add(int index, Produto element) {
        itens.add(index, element);
    }

    @Override
    public Produto remove(int index) {
        return itens.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return itens.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return itens.lastIndexOf(o);
    }

    @Override
    public ListIterator<Produto> listIterator() {
        return itens.listIterator();
    }

    @Override
    public ListIterator<Produto> listIterator(int index) {
        return itens.listIterator(index);
    }

    @Override
    public List<Produto> subList(int fromIndex, int toIndex) {
        return itens.subList(fromIndex, toIndex);
    }*/
}
