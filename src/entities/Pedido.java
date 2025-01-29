package entities;

import entities.enums.StatusPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<ItemPedido> itens;
    private LocalDateTime dataHora;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataHora = LocalDateTime.now();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemPedido(produto, quantidade));
    }

    public double calcularTotal(Desconto desconto) {
        double total = itens.stream().mapToDouble(ItemPedido::calcularTotal).sum();
        return desconto.aplicarDesconto(total);
    }

    public void atualizarStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public String toString() {
        return "Pedido de " + cliente.getNome() +
                "\nStatus: " + status +
                "\nTotal: R$" + calcularTotal(v -> v);
    }
}
