package producers;

import org.apache.kafka.clients.Metadata;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import processors.builders.DotaStatsStreamBuilder;
import processors.core.AbstractKafkaProducer;
import org.apache.kafka.common.requests.OffsetFetchRequest;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DotaKafkaProducer extends AbstractKafkaProducer {

    private static final int GENERIC_NUM_REQUESTS = 1000;
    private DotaStatsStreamBuilder streamBuilder;
    private String apikey;


    public int currentOffset;

    public Integer requestNum;
    public DotaKafkaProducer() {
        super();
        apikey=null;
        streamBuilder=null;
        currentOffset = 0;
        setRequestNum(GENERIC_NUM_REQUESTS);
    }

    public DotaKafkaProducer(String key){
        super();
        apikey=key;
        streamBuilder = new DotaStatsStreamBuilder(key);
        currentOffset = 0;
        setRequestNum(GENERIC_NUM_REQUESTS);
    }
    public DotaKafkaProducer(String topic, String key){
        super();
        apikey=key;
        streamBuilder = new DotaStatsStreamBuilder(key);
        currentOffset=0;
        this.topic=topic;
    }
    public DotaKafkaProducer(String topic,String key, Long ID){
        super();
        apikey=key;
        streamBuilder = new DotaStatsStreamBuilder(key);
        streamBuilder.getDataObject().setSequenceNum(ID);
        currentOffset=0;
        this.topic=topic;
    }
    public DotaKafkaProducer(String address, String key, String topic, Integer port){
        super(address,port);
        apikey=key;
        streamBuilder = new DotaStatsStreamBuilder(key);
        currentOffset=0;
        this.topic=topic;
    }

    public DotaStatsStreamBuilder getStreamBuilder() {
        return streamBuilder;
    }

    public void setStreamBuilder(DotaStatsStreamBuilder streamBuilder) {
        this.streamBuilder = streamBuilder;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void sendStream(){

        for(int i = currentOffset; i < currentOffset+requestNum; i++) {
            String value = this.streamBuilder.getCurrentObjectDataAsJSON().toString();
            String key = String.valueOf(this.streamBuilder.getDataObject().getID());
            Future<Metadata> metadata = this.getProducer().send(new ProducerRecord<String, String>(this.topic,
                    key,
                    value));
            System.out.println("===============");
            try {
                System.out.println(metadata.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("===============");
        }
        this.setCurrentOffset(currentOffset+requestNum);
    }
    public void send(){
        this.setCurrentOffset(this.getCurrentOffset()+1);
        this.getProducer().send(new ProducerRecord<String, String>(this.topic, String.valueOf(currentOffset),
                this.streamBuilder.getCurrentObjectDataAsJSON().toString()));

    }
    public int getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(int requestNum) {
        this.requestNum = requestNum;
    }

    public int getCurrentOffset() {
        return currentOffset;
    }

    public void setCurrentOffset(int currentOffset) {
        this.currentOffset = currentOffset;
    }

}
