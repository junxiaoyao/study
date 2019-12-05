package activemq;

import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

/**
 * @description topic消息订阅
 * @author: jxy
 * @create: 2019-08-22 14:29
 */
public class TestSubTop {

    public static void main(String[] args) throws Exception {
        testSubTop();
    }

    public static void testSubTop() throws Exception {
        String clientId="c1";
        Connection connection = ActiveMqUtil.getConnection();
        connection.setClientID(clientId);
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(ActiveMqUtil.SUB_TOPIC_NAME);
        TopicSubscriber subscriber = session.createDurableSubscriber(topic, clientId);
        connection.start();
        subscriber.setMessageListener((message -> {
            try {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(clientId+" receive:" + textMessage.getText());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }));
    }
}
