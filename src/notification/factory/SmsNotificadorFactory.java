package notification.factory;

import notification.Notificador;
import notification.SmsNotificador;

public class SmsNotificadorFactory extends NotificadorFactory {
        @Override
        public Notificador criarNotificador(){
            return new SmsNotificador();
        }
}
