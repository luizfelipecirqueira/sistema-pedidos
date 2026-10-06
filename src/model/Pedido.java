package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Pedido {

    private final int numero;
    private final String cliente;
    private BigDecimal valor;
    private StatusPedido status;

    public Pedido(int numero, String cliente, BigDecimal valor) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número do pedido deve ser positivo.");
        }

        this.numero = numero;
        this.cliente = Objects.requireNonNull(cliente, "Cliente é obrigatório.");
        this.valor = Objects.requireNonNull(valor, "Valor é obrigatório.");
        this.status = StatusPedido.CRIADO;
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void aplicarDesconto(BigDecimal percentual) {
        if (percentual == null
                || percentual.compareTo(BigDecimal.ZERO) < 0
                || percentual.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("Percentual de desconto inválido.");
        }

        BigDecimal desconto = valor.multiply(percentual);
        valor = valor.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
    }

    public void marcarComoPago() {
        this.status = StatusPedido.PAGO;
    }

    public void cancelar() {
        this.status = StatusPedido.CANCELADO;
    }
}
