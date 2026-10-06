package service;

import model.Pedido;
import notification.Notificador;
import notification.factory.NotificadorFactory;
import payment.PagamentoStrategy;
import repository.PedidoRepository;

public class PedidoService {

    private final ValidadorPedido validador;
    private final PagamentoStrategy pagamento;
    private final PedidoRepository repository;
    private final NotificadorFactory notificadorFactory;

    public PedidoService(
        ValidadorPedido validador,
        PagamentoStrategy pagamento,
        PedidoRepository repository,
        NotificadorFactory notificadorFactory
    ) {
        this.validador = validador;
        this.pagamento = pagamento;
        this.repository = repository;
        this.notificadorFactory = notificadorFactory;
    }

    public void finalizar(Pedido pedido) {
        validador.validar(pedido);
        pagamento.processar(pedido);
        pedido.marcarComoPago();
        repository.salvar(pedido);

        Notificador notificador = notificadorFactory.criarNotificador();
        notificador.enviar(pedido);

        System.out.println("Pedido finalizado com sucesso.");
    }
}
