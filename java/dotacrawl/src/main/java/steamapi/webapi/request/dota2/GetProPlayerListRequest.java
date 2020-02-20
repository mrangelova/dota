package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetProPlayerListRequest extends SteamWebApiRequest {
    public GetProPlayerListRequest(SteamWebApiRequestBuilder builder) {super(builder);}


    public static class GetProPlayerListRequestBuilder extends AbstractSteamWebApiRequestBuilder {
        @Override
        protected SteamWebApiVersion getVersion() {
            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        protected SteamWebApiInterface getInterface() {
            return SteamWebApiInterface.I_DOTA2_FANTASY;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {
            return SteamWebApiInterfaceMethod.GET_PRO_PLAYER_LIST;
        }

        @Override
        public GetProPlayerListRequest buildRequest() {
            return new GetProPlayerListRequest(this);
        }
    }
}