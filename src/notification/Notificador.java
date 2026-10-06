package notification;

import model.Pedido;

public interface Notificador {
    void enviar(Pedido pedido);
}
