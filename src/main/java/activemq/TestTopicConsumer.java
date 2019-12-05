package activemq;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQMessageConsumer;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-07 14:54
 */

public class TestTopicConsumer implements Runnable {
    private String clientName;
    public static void main(String[] args) throws Exception {
        TestTopicConsumer consumer1 = new TestTopicConsumer();
        TestTopicConsumer consumer2 = new TestTopicConsumer();
        consumer1.setClientName("client1");
        consumer2.setClientName("client2");
        new Thread(consumer1).start();
        new Thread(consumer2).start();
//        consumer2.consumerTopic("client2");
//        consumer1.consumerTopic("client1");

    }

    public void consumerTopic(String clientName) throws Exception {
        Connection connection = ActiveMqUtil.getConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(ActiveMqUtil.TOPIC_NAME);
        MessageConsumer consumer = session.createConsumer(topic);
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(clientName + " receive topic:" + message.getText());
        }
    }

    @Override
    public void run() {
        try {
            this.consumerTopic(clientName);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
