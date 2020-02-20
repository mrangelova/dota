package steamapi.webapi.request;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

import java.util.List;

public class GetPlayerSummariesRequest extends SteamWebApiRequest {

    private GetPlayerSummariesRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    public static class GetPlayerSummariesRequestBuilder extends
            AbstractSteamWebApiRequestBuilder {

        private final List<String> steamIds;

        public static final String REQUEST_PARAM_STEAM_IDS = "steamids";

        public GetPlayerSummariesRequestBuilder(List<String> steamIds) {

            if (steamIds.isEmpty()) {
                throw new IllegalArgumentException(
                        "You must supply at least 1 Steam ID!");
            }

            this.steamIds = steamIds;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_STEAM_USER;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_PLAYER_SUMMARIES;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_TWO;
        }

        @Override
        public GetPlayerSummariesRequest buildRequest() {

            addListParameter(REQUEST_PARAM_STEAM_IDS, steamIds);

            return new GetPlayerSummariesRequest(this);
        }
    }
}