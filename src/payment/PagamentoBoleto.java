package payment;

import model.Pedido;

public class PagamentoBoleto implements PagamentoStrategy{

    @Override
    public void processar(Pedido pedido){
        System.out.printf("Boleto gerado para o pedido %d no valor de R$ %s%n", pedido.getNumero(), pedido.getValor().toPlainString());
    }
}
