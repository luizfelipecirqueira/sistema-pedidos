package notification;

import model.Pedido;

public class SmsNotificador implements Notificador{

    @Override
    public void enviar(Pedido pedido){
        System.out.println("SMS enviado para " + pedido.getCliente() + " sobre o pedido " + pedido.getNumero() + ".");
    }
}
