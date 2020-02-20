package steamapi.webapi.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiServiceRequestBuilder;

public class GetRecentlyPlayedGamesRequest extends SteamWebApiRequest {

    private GetRecentlyPlayedGamesRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GetRecentlyPlayedGamesRequestServiceParameter extends
            SteamWebApiServiceParameter {

        private String steamId;

        private Integer count;

        @JsonProperty(GetRecentlyPlayedGamesRequestBuilder.REQUEST_PARAM_STEAM_ID)
        public String getSteamId() {
            return steamId;
        }

        @JsonProperty(GetRecentlyPlayedGamesRequestBuilder.REQUEST_PARAM_COUNT)
        public Integer getCount() {
            return count;
        }

        public void setSteamId(String steamId) {
            this.steamId = steamId;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }


    public static class GetRecentlyPlayedGamesRequestBuilder extends
            AbstractSteamWebApiServiceRequestBuilder {

        private final String steamId;

        private Integer count;

        public static final String REQUEST_PARAM_STEAM_ID = "steamid";

        public static final String REQUEST_PARAM_COUNT = "count";

        public GetRecentlyPlayedGamesRequestBuilder(String steamId) {

            this.steamId = steamId;
        }

        public GetRecentlyPlayedGamesRequestBuilder count(Integer count) {

            this.count = count;
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_PLAYER_SERVICE;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_RECENTLY_PLAYED_GAMES;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetRecentlyPlayedGamesRequest buildRequest() {

            GetRecentlyPlayedGamesRequestServiceParameter serviceParameter = new GetRecentlyPlayedGamesRequestServiceParameter();

            serviceParameter.setSteamId(steamId);

            if (count != null) {
                serviceParameter.setCount(count);
            }

            try {
                addServiceParameter(serviceParameter);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new GetRecentlyPlayedGamesRequest(this);
        }
    }
}