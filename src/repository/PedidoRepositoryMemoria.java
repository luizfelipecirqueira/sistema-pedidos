package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import model.Pedido;

public class PedidoRepositoryMemoria implements PedidoRepository {

    private final Map<Integer, Pedido> pedidos = new HashMap<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.put(pedido.getNumero(), pedido);
        System.out.println("Pedido " + pedido.getNumero() + " salvo em memória.");
    }

    @Override
    public Optional<Pedido> buscarPorNumero(int numero) {
        return Optional.ofNullable(pedidos.get(numero));
    }
}
