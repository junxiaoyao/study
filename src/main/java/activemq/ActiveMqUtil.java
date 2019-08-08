package activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-07 10:32
 */
public class ActiveMqUtil {
    public static final String SERVER_IP= "tcp://192.168.8.130:61616";
    public static final String TOPIC_NAME="topic_msg";
    public static final String QUEUE_NAME="queue_msg";
    public static Connection getConnection() {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, SERVER_IP);
        try {
            connection=connectionFactory.createConnection();
            return connection;
        }catch (JMSException e){
            e.printStackTrace();
        }
        return null;
    }
}
