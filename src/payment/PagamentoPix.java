package payment;

import java.math.BigDecimal;
import model.Pedido;

public class PagamentoPix implements PagamentoStrategy {

    private static final BigDecimal DESCONTO_PIX = new BigDecimal("0.05");

    @Override
    public void processar(Pedido pedido) {
        pedido.aplicarDesconto(DESCONTO_PIX);

        System.out.printf(
            "PIX processado. Valor com desconto: R$ %s%n",
            pedido.getValor().toPlainString()
        );
    }
}
