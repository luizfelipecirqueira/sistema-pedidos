package notification;

import model.Pedido;

public class EmailNotificador implements Notificador {

    @Override
    public void enviar(Pedido pedido) {
        System.out.println(
            "E-mail enviado para " + pedido.getCliente()
            + " sobre o pedido " + pedido.getNumero() + "."
        );
    }
}
