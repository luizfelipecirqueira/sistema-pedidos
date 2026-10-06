package payment;

import model.Pedido;

public interface PagamentoStrategy {
    void processar(Pedido pedido);
}
