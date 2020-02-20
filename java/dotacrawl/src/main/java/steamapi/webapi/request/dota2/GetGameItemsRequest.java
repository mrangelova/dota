package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetGameItemsRequest extends SteamWebApiRequest {
    public GetGameItemsRequest(SteamWebApiRequestBuilder builder) {super(builder);}


    public static class GetGameItemsRequestBuilder extends AbstractSteamWebApiRequestBuilder {
        private String language;

        public static final String REQUEST_PARAM_LANGUAGE = "language";

        @Override
        protected SteamWebApiVersion getVersion() {
            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        protected SteamWebApiInterface getInterface() {
            return SteamWebApiInterface.I_ECON_DOTA2;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {
            return SteamWebApiInterfaceMethod.GET_GAME_ITEMS;
        }

        @Override
        public GetGameItemsRequest buildRequest() {
            if (language != null) {
                addParameter(REQUEST_PARAM_LANGUAGE, language);
            }
            return new GetGameItemsRequest(this);
        }
    }
}