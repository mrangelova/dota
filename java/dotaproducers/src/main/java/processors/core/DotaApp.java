package processors.core;

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
import org.kohsuke.args4j.CmdLineParser;
import processors.builders.DotaStatsStreamBuilder;
import processors.core.DataObject;
import processors.core.DotaAppArgs;
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
    public static final boolean isValidAddress(String address){
        if(address.contains(":")){
            String[] ip = address.split(":");
            if(ip[0].contains(".")){
                String[] dots=ip[0].split(".");
                if(dots.length==4 && ip[1].length()==4){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        //String topicName = args[0].toString();
        //String apikey = args[1].toString();
//        int requestNum = 1;
//        String topicName = "dota";
//        String apikey = "AF1114AC68DB11AD4F8B4E0198AB9845";
//        DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName, apikey);
//        dotaKafkaProducer.setRequestNum(requestNum);
//        dotaKafkaProducer.sendStream();
//        if(args.length == 0){
//            System.out.println("Enter topic name, apikey, request number, match id(optional)");
//            System.out.println(args);
//            return;
//        }
//        System.out.println(args.length);
        DotaAppArgs bean = new DotaAppArgs();
        CmdLineParser parser = new CmdLineParser(bean);
        parser.parseArgument(args);
        parser.printUsage(System.out);
        String apikey = null;
        if(!bean.key.isEmpty()){
            apikey=bean.key;
        }else{
            System.out.println("apikey required!");
            return;
        }
        String topicName=null;
        if(!bean.topic.isEmpty()){
            topicName=bean.topic;
        }else{
            System.out.println("topic name required!");
            return;
        }
        Integer requestNum = null;
        if(!bean.rn.isEmpty()){
            requestNum=Integer.valueOf(bean.rn);
        }else{
            System.out.println("number of requests is required!");
            return;
        }
        String address = null;
        if(!bean.ip.isEmpty()){
            address=bean.ip;
        }else{
            System.out.println("attempting local kafka server...");
        }
        String id = null;
        if(!bean.id.isEmpty()){
            System.out.println("attempting requests starting from provided match id...");
            id = bean.id;
        }else{
            System.out.println("attempting requests...");
        }

        if(id==null && address==null){
            DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName, apikey);
            dotaKafkaProducer.setRequestNum(requestNum);
            dotaKafkaProducer.sendStream();
        }else if(address!=null && id==null){
            if(isValidAddress(address)){
                String[] ipAndPort = address.split(":");
                DotaKafkaProducer dotaKafkaProducer=new DotaKafkaProducer(ipAndPort[0],
                        topicName,apikey,Integer.valueOf(ipAndPort[1]));
                dotaKafkaProducer.setRequestNum(requestNum);
                dotaKafkaProducer.sendStream();
            }else{
                System.out.println("ip address not valid (x.x.x.x:abcd required)");
            }
            DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer();
        }else if(address!=null && id!=null){
            if(isValidAddress(address)){
                String[] ipAndPort = address.split(":");
                DotaKafkaProducer dotaKafkaProducer=new DotaKafkaProducer(ipAndPort[0],
                        topicName,apikey,Integer.valueOf(ipAndPort[1]));
                dotaKafkaProducer.getStreamBuilder().getDataObject().setID(Long.valueOf(id));
                dotaKafkaProducer.setRequestNum(requestNum);
                dotaKafkaProducer.sendStream();
            }else{
                System.out.println("ip address not valid (x.x.x.x:abcd required)");
            }
        }else if(address==null && id!=null){

            DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName,apikey,Long.valueOf(id));
            dotaKafkaProducer.setRequestNum(requestNum);
            dotaKafkaProducer.sendStream();
        }

//        if(args.length == 3) {
////
//            String topicName = args[0].toString();
//            String apikey = args[1].toString();
//            int requestNum = Integer.valueOf(args[2].toString());
//            //String topicName = "dota";
//
//            //String apikey = "AF1114AC68DB11AD4F8B4E0198AB9845";
//            DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName, apikey);
//            dotaKafkaProducer.setRequestNum(requestNum);
//            dotaKafkaProducer.sendStream();
//        }
//        if(args.length==4){
//            String topicName = args[0].toString();
//            String apikey = args[1].toString();
//            int requestNum = Integer.valueOf(args[2].toString());
//            Long id = Long.valueOf(args[3]);
//            DotaKafkaProducer dotaKafkaProducer = new DotaKafkaProducer(topicName,apikey,id);
//            dotaKafkaProducer.setRequestNum(requestNum);
//            dotaKafkaProducer.sendStream();
//        }
    }


}
