package steamapi.webapi.client;
import com.fasterxml.jackson.databind.ObjectMapper;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.SteamWebApiRequestHandler;

import java.io.IOException;

public class SteamWebApiClient {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final String key;
    private final boolean useHttps;
    private final SteamWebApiRequestHandler requestHandler;

    private SteamWebApiClient(SteamWebApiClientBuilder builder){
        this.key = builder.key;
        this.useHttps = builder.useHttps;
        this.requestHandler = new SteamWebApiRequestHandler(useHttps,key);
    }

    @SuppressWarnings({ "unchecked" })
    public <T> T processRequest(SteamWebApiRequest request) throws Exception{
        T result = null;
        String response = requestHandler.getWebApiResponse(request);
        try{
            result = (T)MAPPER.readValue(response,request.getResponseType());

        }catch(IOException e){
            throw new Exception();
        }
        return result;
    }

    public String getKey(){
        return key;
    }
    public boolean isUseHttps(){
        return useHttps;
    }

    public static class SteamWebApiClientBuilder{
        private final String key;
        private boolean useHttps = true;

        public SteamWebApiClientBuilder(String key){
            this.key=key;
        }
        public SteamWebApiClientBuilder useHttps(boolean useHttps){
            this.useHttps = useHttps;
            return this;
        }

        public SteamWebApiClient build(){
            return new SteamWebApiClient(this);
        }
    }



}
