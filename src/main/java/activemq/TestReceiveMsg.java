package activemq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.jmx.JmxException;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-07 10:55
 */
public class TestReceiveMsg {

    public static void main(String[] args)throws Exception {
        receiveMsg();
    }

    public static void receiveMsg()throws Exception {
        Connection connection=ActiveMqUtil.getConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue=session.createQueue(ActiveMqUtil.QUEUE_NAME);
        MessageConsumer consumer=session.createConsumer(queue);
//        while (true){
//            //接收等待十秒
//            TextMessage message=(TextMessage) consumer.receive(10000);
//            if (message!=null){
//                System.out.println("receive:"+message.getText());
//            }
//        }

        //接收消息
        consumer.setMessageListener(new MessageListener() {
            //接收到消息的事件
            @Override
            public void onMessage(Message message) {
                //简单打印一下
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //接收键盘输入，当在控制台输入回车时结束。（为了让该方法一直处于执行状态）
        System.in.read();
        //关闭资源
        consumer.close();
        session.close();
        connection.close();

    }
}
