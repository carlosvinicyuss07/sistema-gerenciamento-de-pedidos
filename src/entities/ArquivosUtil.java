package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivosUtil {

    public static void salvarPedidos(List<Pedido> pedidos, String arquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Pedido pedido : pedidos) {
                bw.write(pedido.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
