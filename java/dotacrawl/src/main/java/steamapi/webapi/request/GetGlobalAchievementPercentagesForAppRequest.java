package steamapi.webapi.request;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetGlobalAchievementPercentagesForAppRequest extends
        SteamWebApiRequest {

    private GetGlobalAchievementPercentagesForAppRequest(
            SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    public static class GetGlobalAchievementPercentagesForAppRequestBuilder
            extends AbstractSteamWebApiRequestBuilder {

        private final Integer gameId;

        public static final String REQUEST_PARAM_GAME_ID = "gameid";

        public GetGlobalAchievementPercentagesForAppRequestBuilder(
                Integer gameId) {

            this.gameId = gameId;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_STEAM_USER_STATS;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_GLOBAL_ACHIEVEMENT_PERCENTAGES_FOR_APP;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_TWO;
        }

        @Override
        public GetGlobalAchievementPercentagesForAppRequest buildRequest() {

            addParameter(REQUEST_PARAM_GAME_ID, gameId);

            return new GetGlobalAchievementPercentagesForAppRequest(this);
        }
    }
}