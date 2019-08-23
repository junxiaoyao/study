package activemq.activemq_new;
import org.apache.activemq.broker.BrokerService;

/**
 * @description 内嵌一个activemq server
 * @author: jxy
 * @create: 2019-08-23 08:48
 */
public class ActiveMqServer {

    public static void main(String[] args)throws Exception {
        BrokerService brokerService=new BrokerService();
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
