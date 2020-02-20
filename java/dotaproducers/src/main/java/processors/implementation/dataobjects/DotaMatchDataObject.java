package processors.implementation.dataobjects;

import processors.core.DataObject;
import steamapi.webapi.request.SteamWebApiRequestHandler;

import java.util.List;
import java.util.Map;

public class DotaMatchDataObject extends DataObject {
    public DotaMatchDataObject(SteamWebApiRequestHandler handler){
        super();
        this.handler=handler;
    }
    public SteamWebApiRequestHandler getHandler() {
        return handler;
    }

    public void setHandler(SteamWebApiRequestHandler handler) {
        this.handler = handler;
    }

    public boolean isSequenced() {
        return isSequenced;
    }

    public void setSequenced(boolean sequenced) {
        isSequenced = sequenced;
    }

    private boolean isSequenced;

    public Long getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public Long sequenceNum;
    private SteamWebApiRequestHandler handler;
}
