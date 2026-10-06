package notification.factory;

import notification.Notificador;
import notification.WhatsAppNotificador;

public class WhatsAppNotificadorFactory extends NotificadorFactory {

    @Override
    public Notificador criarNotificador() {
        return new WhatsAppNotificador();
    }
}
