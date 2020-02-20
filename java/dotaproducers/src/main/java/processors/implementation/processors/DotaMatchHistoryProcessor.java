package processors.implementation.processors;

import org.json.JSONArray;
import org.json.JSONObject;
import processors.core.DataObject;
import processors.core.Processor;
import processors.implementation.dataobjects.DotaMatchDataObject;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.SteamWebApiRequestHandler;
import steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import steamapi.webapi.request.dota2.GetMatchHistoryRequest;

import java.util.HashMap;
import java.util.Map;

import static steamapi.webapi.request.dota2.GetMatchHistoryRequest.Skill.VERY_HIGH;

public class DotaMatchHistoryProcessor implements Processor {
    public SteamWebApiRequestHandler getHandler() {
        return handler;
    }

    public void setHandler(SteamWebApiRequestHandler handler) {
        this.handler = handler;
    }
    private Long seqNum;

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    private SteamWebApiRequestHandler handler;
    public void process(String apikey, DataObject dataObject) {
        SteamWebApiRequest request;
        if(seqNum==null){
            request = SteamWebApiRequestFactory.createGetMatchHistoryRequest(
                    GetMatchHistoryRequest.GameMode.CAPITAINS_MODE,
                    VERY_HIGH,1
            );
        }else{
            request = SteamWebApiRequestFactory.createGetMatchHistoryBySequenceNumRequest(
                    Long.valueOf(seqNum)+1,1
            );
        }
        JSONObject obj = null;
        try {
            obj = new JSONObject(handler.getWebApiResponse(request).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(obj!=null) {
            dataObject.getJsonObjects().add(obj);
            dataObject.getDataMap().putAll(getJSONObjectInfo(obj));
            this.setSeqNum(Long.valueOf(dataObject.getDataMap().get("seq_num")));
            dataObject.setID(Long.valueOf(dataObject.getDataMap().get("match_id")));
            dataObject.setSequenceNum(Long.valueOf(dataObject.getDataMap().get("seq_num")));
        }
    }

    public Map<String,String> getJSONObjectInfo(JSONObject object) {
        Map<String,String> map = new HashMap<String, String>();
        JSONObject match = object.getJSONObject("result").getJSONArray("matches").getJSONObject(0);
        JSONArray heroIds = match.getJSONArray("players");
        Object id = match.get("match_id");
        Object seqNum = match.get("match_seq_num");
        map.put("match_id",id.toString());
        map.put("seq_num",seqNum.toString());
        return map;
    }


}
