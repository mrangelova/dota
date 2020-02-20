package steamapi.webapi.request;

import steamapi.core.SteamApiRequestHandler;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SteamWebApiRequestHandler extends SteamApiRequestHandler {
    public SteamWebApiRequestHandler(boolean useHttps, String key){
        super(useHttps,key);
    }
    public String getWebApiResponse(SteamWebApiRequest request) throws Exception{
        URI requestUrl = getRequestUrl(request);
        return getWebApiResponse(requestUrl);
    }

    URI getRequestUrl(SteamWebApiRequest request) throws Exception{
        String scheme = getProtocol();
        String host = request.getBaseUrl();
        String path = getRequestPath(request);
        List<NameValuePair> parameters = getRequestParameters(request.getParameters());
        URI requestUrl = getRequestUri(scheme,host,path,parameters);
        return requestUrl;
    }

    String getRequestPath(SteamWebApiRequest request){
        StringBuilder requestPath = new StringBuilder();
        requestPath.append("/");
        requestPath.append(request.getApiInterface().toString());
        requestPath.append("/");
        requestPath.append(request.getInterfaceMethod().toString());
        requestPath.append("/");
        requestPath.append(request.getVersion().toString());

        return requestPath.toString();
    }

    List<NameValuePair> getRequestParameters(Map<String,String> parametersMap){
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("key",getKey()));
        for(Map.Entry<String,String> param: parametersMap.entrySet()){
            nvps.add(new BasicNameValuePair(param.getKey(),param.getValue()));
        }
        return nvps;

    }
    URI getRequestUri(String scheme,String host,String path,List<NameValuePair> parameters) throws Exception{
        try{
            URI requestUri = new URIBuilder().setScheme(scheme).setHost(host).setPath(path).setParameters(parameters).build();
            return requestUri;
        }catch(Exception e){
            throw e;
        }
    }
    String getWebApiResponse(URI requestUrl) throws Exception{
        HttpClient client = getHttpClient();
        HttpGet getRequest = new HttpGet(requestUrl);
        try{
            HttpResponse response = client.execute(getRequest);
            Integer statusCode = response.getStatusLine().getStatusCode();
//            if(!statusCode.toString().startsWith("20")){
//                if(statusCode.equals(HttpStatus.SC_UNAUTHORIZED)){
//                    throw new Exception();
//                }
//                throw new Exception();
//            }
            return getHttpResponseAsString(response);
        }catch(Exception e){
            throw e;
        }finally{
            getRequest.releaseConnection();
        }
    }
    HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
    String getHttpResponseAsString(HttpResponse response) throws Exception{
        return EntityUtils.toString(response.getEntity());
    }
}
