package steamapi.webapi.request;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetPlayerAchievementsRequest extends SteamWebApiRequest {

    private GetPlayerAchievementsRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    public static class GetPlayerAchievementsRequestBuilder extends
            AbstractSteamWebApiRequestBuilder {

        private final String steamId;

        private final Integer appId;

        private String language = null;

        public static final String REQUEST_PARAM_STEAM_ID = "steamid";

        public static final String REQUEST_PARAM_APP_ID = "appid";

        public static final String REQUEST_PARAM_LANGUAGE = "l";

        public GetPlayerAchievementsRequestBuilder(String steamId, Integer appId) {

            this.steamId = steamId;
            this.appId = appId;
        }

        public GetPlayerAchievementsRequestBuilder language(String language) {

            this.language = language;
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_STEAM_USER_STATS;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_PLAYER_ACHIEVEMENTS;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetPlayerAchievementsRequest buildRequest() {

            addParameter(REQUEST_PARAM_APP_ID, appId);
            addParameter(REQUEST_PARAM_STEAM_ID, steamId);

            if (language != null) {
                addParameter(REQUEST_PARAM_LANGUAGE, language);
            }

            return new GetPlayerAchievementsRequest(this);
        }
    }
}