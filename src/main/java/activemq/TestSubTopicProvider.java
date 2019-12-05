package activemq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * @description 消息发送者（持久化topic）
 * @author: jxy
 * @create: 2019-08-22 14:40
 */
public class TestSubTopicProvider {

    public static void main(String[] args) throws Exception{
        testCreateTopic();
    }
    public static void testCreateTopic()throws Exception{
        Connection connection=ActiveMqUtil.getConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic=session.createTopic(ActiveMqUtil.SUB_TOPIC_NAME);
        MessageProducer producer=session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i=0;i<10;i++){
            TextMessage textMessage=session.createTextMessage();
            textMessage.setText("sub_msg id:"+i);
            producer.send(textMessage);
        }
        producer.close();
        session.close();
        connection.close();
    }
}
