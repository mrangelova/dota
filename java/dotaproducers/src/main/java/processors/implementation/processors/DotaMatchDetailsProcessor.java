package processors.implementation.processors;

import org.json.JSONArray;
import org.json.JSONObject;
import processors.core.DataObject;
import processors.core.Processor;
import steamapi.webapi.request.SteamWebApiRequestHandler;
import steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import steamapi.webapi.request.dota2.GetMatchDetailsRequest;

import java.util.HashMap;
import java.util.Map;

public class DotaMatchDetailsProcessor implements Processor {
    private static final int PLAYER_SLOT_DELIMITER=100;
    public SteamWebApiRequestHandler getHandler() {
        return handler;
    }

    public void setHandler(SteamWebApiRequestHandler handler) {
        this.handler = handler;
    }

    private SteamWebApiRequestHandler handler;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    private String matchId;
    public void process(String loginInfo, DataObject dataObject) {
        setMatchId(String.valueOf(dataObject.getID()));
        GetMatchDetailsRequest matchDetailsRequest = SteamWebApiRequestFactory.createGetMatchDetailsRequest(getMatchId());
        JSONObject object = null;
        try {
            object = new JSONObject(handler.getWebApiResponse(matchDetailsRequest));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(object!=null) {
            JSONObject result = object.getJSONObject("result");
            dataObject.getJsonObjects().add(result);

            Boolean radiantWin = result.getBoolean("radiant_win");
            dataObject.getDataMap().put("radiant_win",radiantWin.toString());
            JSONArray players = result.getJSONArray("players");
            for (int i = 0; i < players.length(); i++) {
                dataObject.getDataMap().putAll(getJSONObjectInfo(players.getJSONObject(i)));
            }
        }
    }

    public Map<String, String> getJSONObjectInfo(JSONObject object) {
        Map<String,String> map = new HashMap<String, String>();
        Object playerSlot = object.get("player_slot");
        map.put("player_slot".concat("_").concat(playerSlot.toString()),playerSlot.toString());
        if(Integer.valueOf(playerSlot.toString()) > PLAYER_SLOT_DELIMITER){
            map.put("team_id".concat("_").concat(playerSlot.toString()),"dire");
        }else{
            map.put("team_id".concat("_").concat(playerSlot.toString()),"radiant");
        }
        map.put("hero_id".concat("_").concat(playerSlot.toString()),object.get("hero_id").toString());
        map.put("kills".concat("_").concat(playerSlot.toString()),object.get("kills").toString());
        map.put("deaths".concat("_").concat(playerSlot.toString()),object.get("deaths").toString());
        map.put("assists".concat("_").concat(playerSlot.toString()),object.get("assists").toString());
        map.put("gpm".concat("_").concat(playerSlot.toString()),object.get("gold_per_min").toString());
        map.put("xpm".concat("_").concat(playerSlot.toString()),object.get("xp_per_min").toString());
        map.put("level".concat("_").concat(playerSlot.toString()),object.get("level").toString());
        map.put("last_hits".concat("_").concat(playerSlot.toString()),object.get("last_hits").toString());
        map.put("hero_heal".concat("_").concat(playerSlot.toString()),object.get("hero_healing").toString());
        map.put("hero_dmg".concat("_").concat(playerSlot.toString()),object.get("hero_damage").toString());
        map.put("gold_spent".concat("_").concat(playerSlot.toString()),object.get("gold_spent").toString());

        return map;
    }
}
