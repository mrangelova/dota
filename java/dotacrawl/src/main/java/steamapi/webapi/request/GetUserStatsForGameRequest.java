package steamapi.webapi.request;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetUserStatsForGameRequest extends SteamWebApiRequest {

    private GetUserStatsForGameRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    public static class GetUserStatsForGameRequestBuilder extends
            AbstractSteamWebApiRequestBuilder {

        private final String steamId;

        private final Integer appId;

        private String language = null;

        public static final String REQUEST_PARAM_STEAM_ID = "steamid";

        public static final String REQUEST_PARAM_APP_ID = "appid";

        public static final String REQUEST_PARAM_LANGUAGE = "l";

        public GetUserStatsForGameRequestBuilder(String steamId, Integer appId) {

            this.steamId = steamId;
            this.appId = appId;
        }

        public GetUserStatsForGameRequestBuilder language(String language) {

            this.language = language;
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_STEAM_USER_STATS;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_USER_STATS_FOR_GAME;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_TWO;
        }

        @Override
        public GetUserStatsForGameRequest buildRequest() {

            addParameter(REQUEST_PARAM_APP_ID, appId);
            addParameter(REQUEST_PARAM_STEAM_ID, steamId);

            if (language != null) {
                addParameter(REQUEST_PARAM_LANGUAGE, language);
            }

            return new GetUserStatsForGameRequest(this);
        }
    }
}