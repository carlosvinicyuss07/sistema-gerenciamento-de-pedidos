package application;

import entities.*;

import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {

        Map<String, Produto> estoque = new HashMap<>();
        estoque.put("Notebook", new Produto("Notebook", 3500.00));
        estoque.put("Mouse", new Produto("Mouse", 3500.00));

        Cliente cliente = new Cliente("João", "joao@email.com");
        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem(estoque.get("Notebook"), 1);
        pedido.adicionarItem(estoque.get("Mouse"), 2);

        Desconto desconto10 = valor -> valor * 0.9;
        System.out.println("Total com desconto: R$" + pedido.calcularTotal(desconto10));

        Repositorio<Pedido> repositorio = new Repositorio<>();
        repositorio.adicionar(pedido);

        ArquivosUtil.salvarPedidos(repositorio.listarTodos(), "pedidos.txt");

    }
}
