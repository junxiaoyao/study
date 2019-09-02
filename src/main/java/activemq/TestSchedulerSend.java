package activemq;

import java.util.UUID;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;
import org.apache.activemq.ScheduledMessage;

/**
 * @description
 * @author: jxy
 * @create: 2019-09-02 10:07
 */
public class TestSchedulerSend {

    public static void main(String[] args) throws Exception {
        Connection connection = ActiveMqUtil.getConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("scheduler_queue");
        ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(queue);
        long delay = 3 * 1000;
        long period = 5 * 1000;
        int repeat = 4;
        for (int i = 0; i < 4; i++) {
            TextMessage message = session.createTextMessage();
            message.setText(UUID.randomUUID().toString());
            String messageId = UUID.randomUUID().toString().substring(0, 10) + "_queue";
            message.setJMSMessageID(messageId);
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            message.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);
            producer.send(message, new AsyncCallback() {

                @Override
                public void onSuccess() {
                    System.out.println("message:" + messageId + " is been to send");
                }

                @Override
                public void onException(JMSException e) {
                    System.out.println("message:" + messageId + " is been to send failed");
                }
            });

        }
        System.in.read();
        producer.close();
        session.close();
        connection.close();
    }
}
