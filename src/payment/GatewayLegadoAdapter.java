package payment;

import integration.GatewayPagamentoLegado;
import java.math.BigDecimal;
import model.Pedido;

public class GatewayLegadoAdapter implements PagamentoStrategy {

    private final GatewayPagamentoLegado gateway;

    public GatewayLegadoAdapter(GatewayPagamentoLegado gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processar(Pedido pedido) {
        long valorEmCentavos = pedido.getValor()
            .multiply(new BigDecimal("100"))
            .longValueExact();

        boolean aprovado = gateway.realizarCobranca(
            "PED-" + pedido.getNumero(),
            valorEmCentavos
        );

        if (!aprovado) {
            throw new IllegalStateException("Pagamento rejeitado pelo gateway legado.");
        }
    }
}
