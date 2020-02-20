package steamapi.webapi.request.builders;

import steamapi.webapi.request.SteamWebApiRequest;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractSteamWebApiRequestBuilder extends SteamWebApiRequest.SteamWebApiRequestBuilder {

    protected Map<String,String> parameters = new HashMap<String,String>();
    static final String REQUEST_PARAM_FORMAT="format";
    static final String REQEUST_PARAM_FORMAT_JSON="json";
    public AbstractSteamWebApiRequestBuilder(){
        parameters.put(REQUEST_PARAM_FORMAT,REQEUST_PARAM_FORMAT_JSON);
    }
    public abstract SteamWebApiRequest buildRequest();
    protected void addParameter(String name,String value){
        parameters.put(name,value);
    }
    protected void addParameter(String name,Integer value){
        parameters.put(name,String.valueOf(value));
    }
    protected void addParameter(String name,Long value){
        parameters.put(name,String.valueOf(value));
    }
    protected void addListParameter(String name, List<String> valueList){
        StringBuilder paramValue = new StringBuilder();
        for(String value: valueList){
            paramValue.append(value);
            paramValue.append(",");
        }
        paramValue.setLength(paramValue.length()-1);
        addParameter(name,paramValue.toString());
    }
    protected void addArrayParameter(String name,List<String> valueList){
        int i = 0;
        for(String value: valueList){
            StringBuilder paramName = new StringBuilder();
            StringBuilder paramValue = new StringBuilder();
            paramName.append(name);
            paramName.append("[");
            paramName.append(i);
            paramName.append("]");

            paramValue.append(value);
            addParameter(paramName.toString(),paramValue.toString());
            i++;
        }
    }
    @Override
    public Map<String,String> getParameters(){
        return Collections.unmodifiableMap(parameters);
    }
}
