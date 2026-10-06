package payment;

import model.Pedido;

public class PagamentoCartao implements PagamentoStrategy {

    @Override
    public void processar(Pedido pedido) {
        System.out.printf(
            "Pagamento no cartão processado: R$ %s%n",
            pedido.getValor().toPlainString()
        );
    }
}
