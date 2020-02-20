import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import kkpp.crawl.steamapi.data.json.dota2.matchhistory.GetMatchHistory;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.SteamWebApiRequestHandler;
import steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import steamapi.webapi.request.dota2.*;
import org.json.*;

public class DotaApp {
    public static void main(String[] args) throws Exception{
        String apikey = "AF1114AC68DB11AD4F8B4E0198AB9845";
        SteamWebApiRequestHandler handler = new SteamWebApiRequestHandler(true,apikey);
        GetMatchHistoryRequest request = SteamWebApiRequestFactory.createGetMatchHistoryRequest(GetMatchHistoryRequest.GameMode.CAPITAINS_MODE,
                GetMatchHistoryRequest.Skill.VERY_HIGH,1);

        //GetLiveLeagueGamesRequest request1 = SteamWebApiRequestFactory.createGetLiveLeagueGamesRequest();
        //GetLeagueListingRequest request2 = SteamWebApiRequestFactory.createGetLeagueListingRequest();
        //System.out.println(handler.getWebApiResponse(request).toString());
        JSONObject obj = new JSONObject(handler.getWebApiResponse(request).toString());
        JSONObject match = obj.getJSONObject("result").getJSONArray("matches").getJSONObject(0);
        JSONArray heroIds = match.getJSONArray("players");
        Object id = match.get("match_id");
        Object seqNum = match.get("match_seq_num");
        //arr.toString();
        System.out.println(match);
        System.out.println(id);
        GetMatchDetailsRequest matchDetailsRequest = SteamWebApiRequestFactory.createGetMatchDetailsRequest(id.toString());
        JSONObject obj1= new JSONObject(handler.getWebApiResponse(matchDetailsRequest).toString());
        JSONObject result = obj1.getJSONObject("result");
        System.out.println(result);
        Boolean radiantWin = result.getBoolean("radiant_win");
        JSONArray players = result.getJSONArray("players");
        for(int i = 0; i < players.length(); i++){
            System.out.println(players.getJSONObject(i));
        }
        System.out.println(id);
        System.out.println(radiantWin);
        System.out.println(heroIds.toString());
        System.out.println(seqNum.toString());
        GetMatchHistoryBySequenceNumRequest request2 = SteamWebApiRequestFactory.createGetMatchHistoryBySequenceNumRequest(Long.valueOf(seqNum.toString())+1,1);
        JSONObject obj2 = new JSONObject(handler.getWebApiResponse(request2).toString());
        JSONObject match2 = obj2.getJSONObject("result").getJSONArray("matches").getJSONObject(0);
        JSONArray heroIds2 = match2.getJSONArray("players");
        Object id2 = match2.get("match_id");
        Object seqNum2 = match2.get("match_seq_num");
        //arr.toString();
        System.out.println(match2);
        System.out.println(id2);
        GetMatchDetailsRequest matchDetailsRequest2 = SteamWebApiRequestFactory.createGetMatchDetailsRequest(id2.toString());
        JSONObject obj3= new JSONObject(handler.getWebApiResponse(matchDetailsRequest2).toString());
        JSONObject result2 = obj3.getJSONObject("result");
        System.out.println(result2);
        Boolean radiantWin2 = result2.getBoolean("radiant_win");
        JSONArray players2 = result2.getJSONArray("players");
        for(int i = 0; i < players2.length(); i++){
            System.out.println(players2.getJSONObject(i));
        }
        System.out.println(seqNum2);
    }
}