package activemq;

import java.util.Scanner;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.command.ActiveMQTextMessage;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-07 10:37
 */
public class TestSendMsg {
    public int cs=5;
    public static void main(String[] args) {
        //        sendMsg("差三岁");
        inputMsg();
    }

    public static void inputMsg() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入信息");
        String msgStr = scanner.nextLine();
        while (!msgStr.equals("end")) {
            sendMsg(msgStr);
            System.out.println("输入信息");
            msgStr = scanner.nextLine();
        }

    }

    public static void sendMsg(String msg) {
        try {
            Connection connection = ActiveMqUtil.getConnection();
            /*
             * 参数介绍
             *        第一个参数(参数类型boolean)：是否开启事务。(一般不开启事务：false)
             *        第二个参数(参数类型int)：应答模式。(一般设置为自动应答：AUTO_ACKNOWLEDGE)
             *                应答模式分为三种：
             *                          AUTO_ACKNOWLEDGE(自动应答)
             *                          CLIENT_ACKNOWLEDGE(手动应答)
             *                          DUPS_OK_ACKNOWLEDGE
             *
             *   注意：当开启事务的时候，第二个参数值设置哪一种都一样，即第二个参数无意义。
             */
            //开启连接
            connection.start();
            //使用连接对象获取Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建队列，队列名字
            Queue queue = session.createQueue(ActiveMqUtil.QUEUE_NAME);
            //创建生产者对象
            MessageProducer producer = session.createProducer(queue);
            //创建消息对象
            TextMessage message = new ActiveMQTextMessage();
            message.setText(msg);
            producer.send(message);
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
