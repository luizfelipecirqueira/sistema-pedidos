import integration.GatewayPagamentoLegado;
import java.math.BigDecimal;
import model.Pedido;
import notification.factory.EmailNotificadorFactory;
import notification.factory.NotificadorFactory;
import payment.GatewayLegadoAdapter;
import payment.PagamentoPix;
import payment.PagamentoStrategy;
import repository.PedidoRepository;
import repository.PedidoRepositoryMemoria;
import service.PedidoService;
import service.ValidadorPedido;

public class Main {

    public static void main(String[] args) {

        executarComPix();
        System.out.println("------------------------------");
        executarComGatewayLegado();
    }

    private static void executarComPix() {
        Pedido pedido = new Pedido(
            1,
            "Maria",
            new BigDecimal("350.00")
        );

        ValidadorPedido validador = new ValidadorPedido();
        PagamentoStrategy pagamento = new PagamentoPix();
        PedidoRepository repository = new PedidoRepositoryMemoria();
        NotificadorFactory notificadorFactory =
            new EmailNotificadorFactory();

        PedidoService service = new PedidoService(
            validador,
            pagamento,
            repository,
            notificadorFactory
        );

        service.finalizar(pedido);
    }

    private static void executarComGatewayLegado() {
        Pedido pedido = new Pedido(
            2,
            "João",
            new BigDecimal("180.00")
        );

        GatewayPagamentoLegado gateway =
            new GatewayPagamentoLegado();

        ValidadorPedido validador = new ValidadorPedido();
        PagamentoStrategy pagamento =
            new GatewayLegadoAdapter(gateway);
        PedidoRepository repository =
            new PedidoRepositoryMemoria();
        NotificadorFactory notificadorFactory =
            new EmailNotificadorFactory();

        PedidoService service = new PedidoService(
            validador,
            pagamento,
            repository,
            notificadorFactory
        );

        service.finalizar(pedido);
    }
}
