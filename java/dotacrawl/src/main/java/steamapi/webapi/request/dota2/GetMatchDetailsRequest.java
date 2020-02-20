package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;
public class GetMatchDetailsRequest extends SteamWebApiRequest {
    public GetMatchDetailsRequest(SteamWebApiRequestBuilder builder) {super(builder);}


    public static class GetMatchDetailsRequestBuilder extends AbstractSteamWebApiRequestBuilder {
    private final String matchId;
    public static final String REQUEST_PARAM_MATCH_ID = "match_id";

    public GetMatchDetailsRequestBuilder(String matchId) {
        this.matchId = matchId;
    }

    @Override
    protected SteamWebApiInterface getInterface() {
        return SteamWebApiInterface.I_DOTA2_MATCH;
    }

    @Override
    protected SteamWebApiInterfaceMethod getInterfaceMethod() {
        return SteamWebApiInterfaceMethod.GET_MATCH_DETAILS;
    }

    @Override
    protected SteamWebApiVersion getVersion() {
        return SteamWebApiVersion.VERSION_ONE;
    }

    @Override
    public GetMatchDetailsRequest buildRequest() {
        addParameter(REQUEST_PARAM_MATCH_ID,matchId);

        return new GetMatchDetailsRequest(this);
    }
}


}