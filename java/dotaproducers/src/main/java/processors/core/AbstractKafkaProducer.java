package processors.core;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;

public abstract class AbstractKafkaProducer {
    private static final int BATCH_SIZE=16384;
    private static final int LINGER_MS=1;
    private static final int BUFFER_MEMORY=33554432;
    private static final int PORT = 9092;
    public Properties props;
    private Producer producer;
    public String topic;
    public String bootstrapServerIp;

    public Integer getPortNum() {
        return portNum;
    }

    public void setPortNum(Integer portNum) {
        this.portNum = portNum;
    }

    private Integer portNum;

    public AbstractKafkaProducer(){
        portNum = PORT;
        props = new Properties();
        props.put("bootstrap.servers",getIpAddress().concat(":").concat(String.valueOf(PORT)));
        props.put("acks","all");
        props.put("retries","0");
        props.put("batch.size",BATCH_SIZE);
        props.put("linger.ms",LINGER_MS);
        props.put("buffer.memory",BUFFER_MEMORY);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());

        producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
    }

    public AbstractKafkaProducer(String address, Integer port){
        this.portNum = port;
        props = new Properties();
        props.put("bootstrap.servers",address.concat(":").concat(String.valueOf(port)));
        props.put("acks","all");
        props.put("retries","0");
        props.put("batch.size",BATCH_SIZE);
        props.put("linger.ms",LINGER_MS);
        props.put("buffer.memory",BUFFER_MEMORY);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());
        producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
    }


    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBootstrapServerIp() {
        return bootstrapServerIp;
    }

    public void setBootstrapServerIp(String bootstrapServerIp) {
        this.bootstrapServerIp = bootstrapServerIp;
    }

    public String getIpAddress(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            String ip = socket.getLocalAddress().getHostAddress();
            return ip;
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;

    }
}
