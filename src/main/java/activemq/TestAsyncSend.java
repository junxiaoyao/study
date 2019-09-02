package activemq;

import java.util.UUID;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

/**
 * @description
 * @author: jxy
 * @create: 2019-09-02 08:57
 */
public class TestAsyncSend {

    public static void main(String[] args) throws Exception {
        ActiveMQConnection connection = (ActiveMQConnection)ActiveMqUtil.getConnection();
        connection.setUseAsyncSend(true);
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("async_queue");
        ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(queue);
        for (int i = 0; i < 5; i++) {
            TextMessage message = session.createTextMessage();
            String messageId = UUID.randomUUID().toString().substring(0, 10) + "_queue";
            message.setJMSMessageID(messageId);
            producer.send(message, new AsyncCallback() {

                @Override
                public void onSuccess() {

                    System.out.println("send ok :" + messageId);
                }
                @Override
                public void onException(JMSException e) {
                    System.out.println("send fail :" + messageId);
                }
            });
        }
        producer.close();
        session.close();
        connection.close();
    }
}
