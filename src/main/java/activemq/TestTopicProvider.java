package activemq;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.command.ActiveMQTextMessage;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-07 14:36
 */
public class TestTopicProvider {

    public static void main(String[] args) throws Exception{
        topicProvider();
    }

    public static void topicProvider() throws Exception{
        Connection connection=ActiveMqUtil.getConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic=session.createTopic(ActiveMqUtil.TOPIC_NAME);
        MessageProducer producer=session.createProducer(topic);
        TextMessage message=new ActiveMQTextMessage();
        for (int i=0;i<100;i++) {
            message.setText("topic消息发送"+i);
            producer.send(message);
        }
        producer.close();
        session.close();
        connection.close();
    }

}
