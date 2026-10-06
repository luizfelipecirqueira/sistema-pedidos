package repository;

import java.util.Optional;
import model.Pedido;

public interface PedidoRepository {
    void salvar(Pedido pedido);
    Optional<Pedido> buscarPorNumero(int numero);
}
