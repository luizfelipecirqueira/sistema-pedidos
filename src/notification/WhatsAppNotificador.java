package notification;

import model.Pedido;

public class WhatsAppNotificador implements Notificador {

    @Override
    public void enviar(Pedido pedido) {
        System.out.println(
            "WhatsApp enviado para " + pedido.getCliente()
            + " sobre o pedido " + pedido.getNumero() + "."
        );
    }
}
