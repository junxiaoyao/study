package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Auther: jxy
 * @Date: 2019/3/28 16:12
 * @Description:
 */
public class TestActiveMq {
    public static void main(String[] args) throws Exception{
        TestActiveMq mq=new TestActiveMq();
        mq.testMQProducerQueue();
    }
    public void testMQProducerQueue() throws Exception {
        //1、创建工厂连接对象，需要制定ip和端口号
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://118.24.188.79:61616");

            connectionFactory.setUserName("admin");
            connectionFactory.setPassword("admin");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("mys-queue");
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hello!test-queue");
        //8、发送消息
        producer.send(textMessage);
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
    }


}
