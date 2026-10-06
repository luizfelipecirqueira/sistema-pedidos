package notification.factory;

import notification.EmailNotificador;
import notification.Notificador;

public class EmailNotificadorFactory extends NotificadorFactory {

    @Override
    public Notificador criarNotificador() {
        return new EmailNotificador();
    }
}
