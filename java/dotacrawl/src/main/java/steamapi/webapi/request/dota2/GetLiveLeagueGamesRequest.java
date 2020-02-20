package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetLiveLeagueGamesRequest extends SteamWebApiRequest {
    public GetLiveLeagueGamesRequest(SteamWebApiRequestBuilder builder) {super(builder);}

    public static class GetLiveLeagueGamesRequestBuilder extends AbstractSteamWebApiRequestBuilder {
        @Override
        protected SteamWebApiVersion getVersion() {
            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        protected SteamWebApiInterface getInterface() {
            return SteamWebApiInterface.I_DOTA2_MATCH;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {
            return SteamWebApiInterfaceMethod.GET_LIVE_LEAGUE_GAMES;
        }

        @Override
        public GetLiveLeagueGamesRequest buildRequest() {
            return new GetLiveLeagueGamesRequest(this);
        }
    }
}