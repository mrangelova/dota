package steamapi.webapi.request.builders;


import com.fasterxml.jackson.databind.ObjectMapper;
import steamapi.webapi.request.SteamWebApiServiceParameter;

public abstract class AbstractSteamWebApiServiceRequestBuilder extends AbstractSteamWebApiRequestBuilder{

    static final String REQUEST_PARAM_INPUT_JSON="input_json";
    private final ObjectMapper mapper = new ObjectMapper();

    protected void addServiceParameter(SteamWebApiServiceParameter serviceParameter) throws Exception{
        try{
            String serviceParameterJson = mapper.writeValueAsString(serviceParameter);
        }catch(Exception e){
            throw e;
        }

    }
}
