package steamapi.webapi.request;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

import java.util.List;

public class GetPlayerBansRequest extends SteamWebApiRequest {

    private GetPlayerBansRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    public static class GetPlayerBansRequestBuilder extends
            AbstractSteamWebApiRequestBuilder {

        private final List<String> steamIds;

        public static final String REQUEST_PARAM_STEAM_IDS = "steamids";

        public GetPlayerBansRequestBuilder(List<String> steamIds) {

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

            return SteamWebApiInterfaceMethod.GET_PLAYER_BANS;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetPlayerBansRequest buildRequest() {

            addListParameter(REQUEST_PARAM_STEAM_IDS, steamIds);

            return new GetPlayerBansRequest(this);
        }
    }
}