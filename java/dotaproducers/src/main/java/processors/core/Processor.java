package processors.core;

import org.json.JSONObject;

import java.util.Map;

public interface Processor {
    void process(String loginInfo, DataObject dataObject);
    Map<String,String> getJSONObjectInfo(JSONObject object);
}
