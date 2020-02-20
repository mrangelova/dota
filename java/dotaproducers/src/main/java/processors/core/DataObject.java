package processors.core;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DataObject {
    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public Long getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public Long sequenceNum;
    public String getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(String loginInfo) {
        this.loginInfo = loginInfo;
    }

    String loginInfo;
    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    private Map<String,String> dataMap;
    private Long ID;
    private JSONObject jsonObject;

    public List<JSONObject> getJsonObjects() {
        return jsonObjects;
    }

    public void setJsonObjects(List<JSONObject> jsonObjects) {
        this.jsonObjects = jsonObjects;
    }

    private List<JSONObject> jsonObjects;
    public List<Processor> getProcessors() {
        return processors;
    }

    public void setProcessors(List<Processor> processors) {
        this.processors = processors;
    }

    private List<Processor> processors;
    public DataObject(){
        this.dataMap=new HashMap<String, String>();
        this.jsonObject=new JSONObject();
        this.jsonObjects = new ArrayList<JSONObject>();
        this.ID=null;
        this.processors = new ArrayList<Processor>();
    }
    public DataObject(Map<String,String> map,Integer id, JSONObject object){
        this.dataMap=map;
        this.ID=null;
        this.jsonObject=object;
        this.processors= new ArrayList<Processor>();
    }
    public DataObject getDataObject(){
        for(Processor processor:this.processors){
            processor.process(this.loginInfo,this);
        }
        return this;
    }
    public void flush(){
        this.jsonObjects.clear();
        this.dataMap.clear();
    }
}
