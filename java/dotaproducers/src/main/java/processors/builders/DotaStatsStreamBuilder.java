package processors.builders;

import org.json.JSONObject;
import processors.implementation.dataobjects.DotaMatchDataObject;
import processors.implementation.processors.DotaMatchDetailsProcessor;
import processors.implementation.processors.DotaMatchHistoryProcessor;
import steamapi.webapi.request.SteamWebApiRequestHandler;
import steamapi.webapi.request.builders.SteamWebApiRequestFactory;

import java.util.Map;

public class DotaStatsStreamBuilder {
    public DotaMatchDataObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(DotaMatchDataObject dataObject) {
        this.dataObject = dataObject;
    }

    private DotaMatchDataObject dataObject;

    public SteamWebApiRequestHandler getHandler() {
        return handler;
    }

    public void setHandler(SteamWebApiRequestHandler handler) {
        this.handler = handler;
    }

    private SteamWebApiRequestHandler handler;
    public DotaStatsStreamBuilder(){
        this.dataObject = null;
        this.handler=null;

    }
    public DotaStatsStreamBuilder(String key){
        this.handler = new SteamWebApiRequestHandler(true,key);
        this.dataObject = new DotaMatchDataObject(this.handler);
        this.dataObject.setSequenced(false);
        this.dataObject.setLoginInfo(key);
        DotaMatchHistoryProcessor historyProcessor = new DotaMatchHistoryProcessor();
        historyProcessor.setHandler(handler);
        DotaMatchDetailsProcessor detailsProcessor = new DotaMatchDetailsProcessor();
        detailsProcessor.setHandler(handler);
        this.dataObject.getProcessors().add(historyProcessor);
        this.dataObject.getProcessors().add(detailsProcessor);
    }

    public Map<String,String> getCurrentObjectData(){
        return this.dataObject.getDataObject().getDataMap();
    }
    public JSONObject getCurrentObjectDataAsJSON(){return new JSONObject(this.dataObject.getDataObject().getDataMap());}
    public void clear(){
        this.dataObject.flush();
    }
}
