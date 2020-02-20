package steamapi.core;

import java.util.Collections;
import java.util.Map;

public abstract class SteamApiRequest {
    public String getBaseUrl() {
        return baseUrl;
    }

    public Map<String, String> getParameters() {
        return Collections.unmodifiableMap(parameters);
    }

    protected final String baseUrl;
    protected final Map<String,String> parameters;
    protected static final String REQUEST_PARAM_BOOLEAN_TRUE = "1";
    public SteamApiRequest(String baseUrl, Map<String,String> parameters){
        this.baseUrl=baseUrl;
        this.parameters=parameters;
    }

}
