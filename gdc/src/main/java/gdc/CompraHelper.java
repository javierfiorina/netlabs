package main.java.gdc;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompraHelper {
	public static void createAlerta(String productoNombre, int cantidad){
		Logger logger = LoggerFactory.getLogger(CompraHelper.class);		
        Runnable sendTask = () -> {
        	String activemqUrl =  System.getenv("ACTIVEMQ_URL");
    		String activemqUser =  System.getenv("ACTIVEMQ_USER");
    		String activemqPass =  System.getenv("ACTIVEMQ_PASS");
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(activemqUrl);
            Connection connection = null;
            try {
                connection = connectionFactory.createConnection(activemqUser, activemqPass);
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("Alerta producto bajo stock");
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                String text = "Producto: "+productoNombre+" bajo en stock: "+Integer.toString(cantidad);
                TextMessage message = session.createTextMessage(text);
                logger.info("Sent message hash code: "+ message.hashCode() + " : " + text);
                producer.send(message);
                session.close();
                connection.close();
            } catch (JMSException e) {
                logger.error("Sender createTask method error", e);                
            }
        };
        new Thread(sendTask).start();
    }
   
		  
}
