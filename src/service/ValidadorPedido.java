package service;

import java.math.BigDecimal;
import model.Pedido;
import model.StatusPedido;

public class ValidadorPedido {

    public void validar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido é obrigatório.");
        }

        if (pedido.getCliente().isBlank()) {
            throw new IllegalArgumentException("Cliente é obrigatório.");
        }

        if (pedido.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do pedido deve ser maior que zero.");
        }

        if (pedido.getStatus() != StatusPedido.CRIADO) {
            throw new IllegalStateException("Somente pedidos criados podem ser finalizados.");
        }
    }
}
