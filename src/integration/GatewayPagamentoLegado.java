package integration;

public class GatewayPagamentoLegado {

    public boolean realizarCobranca(String codigoPedido, long valorEmCentavos) {
        System.out.printf(
            "Gateway legado: cobrança %s no valor de %d centavos.%n",
            codigoPedido,
            valorEmCentavos
        );

        return true;
    }
}
