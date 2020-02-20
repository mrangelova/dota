import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Arrays;

import kkpp.crawl.steamapi.data.json.ownedgames.Game;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import kkpp.crawl.*;
import org.json.JSONArray;
import org.json.JSONObject;
import processors.builders.DotaStatsStreamBuilder;
import processors.core.DataObject;
import processors.implementation.dataobjects.DotaMatchDataObject;
import processors.implementation.processors.DotaMatchDetailsProcessor;
import processors.implementation.processors.DotaMatchHistoryProcessor;
import producers.DotaKafkaProducer;
import java.net.InetAddress;
import steamapi.webapi.request.SteamWebApiRequestHandler;
import steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import steamapi.webapi.request.dota2.GetMatchDetailsRequest;
import steamapi.webapi.request.dota2.GetMatchHistoryRequest;


import java.util.concurrent.TimeUnit;

import static steamapi.webapi.request.dota2.GetMatchHistoryRequest.Skill.VERY_HIGH;

public class DotaApp {
    public DotaApp(){}
    public static void main(String[] args) throws Exception {
        //String topicName = args[0].toString();
        //String apikey = args[1].toString();
//        int requestNum = 1;
//        String topicName = "dota";
//        String apikey = "AF1114AC68DB11AD4F8B4E0198AB9845";
//        DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName, apikey);
//        dotaKafkaProducer.setRequestNum(requestNum);
//        dotaKafkaProducer.sendStream();
        if(args.length == 0){
            System.out.println("Enter topic name, apikey, request number");
            System.out.println(args);
            return;
        }
        System.out.println(args.length);
        if(args.length == 3) {
//
            String topicName = args[0].toString();
            String apikey = args[1].toString();
            int requestNum = Integer.valueOf(args[2].toString());
            //String topicName = "dota";

            //String apikey = "AF1114AC68DB11AD4F8B4E0198AB9845";
            DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName, apikey);
            dotaKafkaProducer.setRequestNum(requestNum);
            dotaKafkaProducer.sendStream();
        }
        if(args.length==4){
            String topicName = args[0].toString();
            String apikey = args[1].toString();
            int requestNum = Integer.valueOf(args[2].toString());
            Long id = Long.valueOf(args[3]);
            DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName,apikey,id);
            dotaKafkaProducer.setRequestNum(requestNum);
            dotaKafkaProducer.sendStream();
        }
    }
}
