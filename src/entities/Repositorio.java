package entities;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {

    private List<T> elementos = new ArrayList<>();

    public void adicionar(T elemento) {
        elementos.add(elemento);
    }

    public List<T> listarTodos() {
        return elementos;
    }
}
