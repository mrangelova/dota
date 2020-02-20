package steamapi.webapi.request;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetSchemaForGameRequest extends SteamWebApiRequest {

    private GetSchemaForGameRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    public static class GetSchemaForGameRequestBuilder extends
            AbstractSteamWebApiRequestBuilder {

        private final Integer appId;

        public static final String REQUEST_PARAM_APP_ID = "appid";

        public GetSchemaForGameRequestBuilder(Integer appId) {

            this.appId = appId;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_STEAM_USER_STATS;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_SCHEMA_FOR_GAME;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_TWO;
        }

        @Override
        public GetSchemaForGameRequest buildRequest() {

            addParameter(REQUEST_PARAM_APP_ID, appId);

            return new GetSchemaForGameRequest(this);
        }
    }
}