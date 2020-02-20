package steamapi.webapi.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiServiceRequestBuilder;

import java.util.ArrayList;
import java.util.List;

public class GetOwnedGamesRequest extends SteamWebApiRequest {

    private GetOwnedGamesRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GetOwnedGamesRequestServiceParameter extends
            SteamWebApiServiceParameter {

        private String steamId;

        private Integer includeAppInfo;

        private Integer includePlayedFreeGames;

        private List<Integer> appIdsFilter;

        @JsonProperty(GetOwnedGamesRequestBuilder.REQUEST_PARAM_STEAM_ID)
        public String getSteamId() {
            return steamId;
        }

        @JsonProperty(GetOwnedGamesRequestBuilder.REQUEST_PARAM_INCLUDE_APP_INFO)
        public Integer getIncludeAppInfo() {
            return includeAppInfo;
        }

        @JsonProperty(GetOwnedGamesRequestBuilder.REQUEST_PARAM_INCLUDE_PLAYED_FREE_GAMES)
        public Integer getIncludePlayedFreeGames() {
            return includePlayedFreeGames;
        }

        @JsonProperty(GetOwnedGamesRequestBuilder.REQUEST_PARAM_APP_IDS_FILTER)
        public List<Integer> getAppIdsFilter() {
            return appIdsFilter;
        }

        public void setSteamId(String steamId) {
            this.steamId = steamId;
        }

        public void setIncludeAppInfo(Integer includeAppInfo) {
            this.includeAppInfo = includeAppInfo;
        }

        public void setIncludePlayedFreeGames(Integer includePlayedFreeGames) {
            this.includePlayedFreeGames = includePlayedFreeGames;
        }

        public void setAppIdsFilter(List<Integer> appIdsFilter) {
            this.appIdsFilter = appIdsFilter;
        }
    }


    public static class GetOwnedGamesRequestBuilder extends
            AbstractSteamWebApiServiceRequestBuilder {

        private final String steamId;

        private boolean includeAppInfo;

        private boolean includePlayedFreeGames;

        private List<Integer> appIdsFilter = new ArrayList<Integer>();

        public static final String REQUEST_PARAM_STEAM_ID = "steamid";

        public static final String REQUEST_PARAM_INCLUDE_APP_INFO = "include_appinfo";

        public static final String REQUEST_PARAM_INCLUDE_PLAYED_FREE_GAMES = "include_played_free_games";

        public static final String REQUEST_PARAM_APP_IDS_FILTER = "appids_filter";

        public GetOwnedGamesRequestBuilder(String steamId) {

            this.steamId = steamId;
        }

        public GetOwnedGamesRequestBuilder includeAppInfo(boolean includeAppInfo) {

            this.includeAppInfo = includeAppInfo;
            return this;
        }

        public GetOwnedGamesRequestBuilder includePlayedFreeGames(
                boolean includePlayedFreeGames) {

            this.includePlayedFreeGames = includePlayedFreeGames;
            return this;
        }

        public GetOwnedGamesRequestBuilder appIdsFilter(
                List<Integer> appIdsFilter) {

            this.appIdsFilter.addAll(appIdsFilter);
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_PLAYER_SERVICE;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_OWNED_GAMES;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetOwnedGamesRequest buildRequest() {

            GetOwnedGamesRequestServiceParameter serviceParameter = new GetOwnedGamesRequestServiceParameter();

            serviceParameter.setSteamId(steamId);

            if (includeAppInfo) {
                serviceParameter.setIncludeAppInfo(1);
            }

            if (includePlayedFreeGames) {
                serviceParameter.setIncludePlayedFreeGames(1);
            }

            if (!appIdsFilter.isEmpty()) {
                serviceParameter.setAppIdsFilter(appIdsFilter);
            }

            try {
                addServiceParameter(serviceParameter);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new GetOwnedGamesRequest(this);
        }
    }
}