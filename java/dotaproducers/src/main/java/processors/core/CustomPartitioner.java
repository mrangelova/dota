package processors.core;

import org.apache.kafka.clients.producer.Partitioner;

import org.apache.kafka.common.Cluster;

import java.util.Map;

public class CustomPartitioner implements Partitioner{

    private static final int PARTITION_COUNT=10;

    @Override
    public void configure(Map<String, ?> configs) {

    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        Long keyInt=Long.valueOf(key.toString());
        return (int) (keyInt % PARTITION_COUNT);

    }

    @Override
    public void close() {

    }

}