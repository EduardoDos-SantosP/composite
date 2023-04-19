package src;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SorteadorItens<T> {
    private final Class<T> classe;
    private final ArrayList<T> itens = new ArrayList<>();

    public SorteadorItens(Class<T> classe) {
        this.classe = classe;
        for (Method method : obtenhaMetodosCriacao()) {
            try {
                this.itens.add((T) method.invoke(null));
            } catch (IllegalAccessException | InvocationTargetException ignored) {}
        }
    }

    public ArrayList<T> getItens() {
        return itens;
    }

    public T obtenhaAleatorio() {
        return itens.get(new Random().nextInt(itens.size()));
    }

    private List<Method> obtenhaMetodosCriacao() {
        return Arrays.stream(classe.getMethods())
                .filter(this::ehMetodoCriacao)
                .collect(Collectors.toList());
    }

    private boolean ehMetodoCriacao(Method metodo) {
        int modificadores = metodo.getModifiers();
        return Modifier.isPublic(modificadores) &&
                Modifier.isStatic(modificadores) &&
                metodo.getName().startsWith("crie") &&
                metodo.getReturnType().equals(classe);
    }
}
