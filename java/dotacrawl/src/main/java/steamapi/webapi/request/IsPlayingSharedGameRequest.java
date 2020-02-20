package steamapi.webapi.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiServiceRequestBuilder;

public class IsPlayingSharedGameRequest extends SteamWebApiRequest {

    private IsPlayingSharedGameRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class IsPlayingSharedGameRequestServiceParameter extends
            SteamWebApiServiceParameter {

        private String steamId;

        private Integer appIdPlaying;

        @JsonProperty(IsPlayingSharedGameRequestBuilder.REQUEST_PARAM_STEAM_ID)
        public String getSteamId() {
            return steamId;
        }

        @JsonProperty(IsPlayingSharedGameRequestBuilder.REQUEST_PARAM_APP_ID_PLAYING)
        public Integer getAppIdPlaying() {
            return appIdPlaying;
        }

        public void setSteamId(String steamId) {
            this.steamId = steamId;
        }

        public void setAppIdPlaying(Integer appIdPlaying) {
            this.appIdPlaying = appIdPlaying;
        }
    }

    /**
     * Builder object to create instances of {@link SteamWebApiRequest} for
     * request type {@link IsPlayingSharedGameRequest}.
     *
     * @author lpradel
     *
     */
    public static class IsPlayingSharedGameRequestBuilder extends
            AbstractSteamWebApiServiceRequestBuilder {

        private final String steamId;

        private final Integer appIdPlaying;

        public static final String REQUEST_PARAM_STEAM_ID = "steamid";

        public static final String REQUEST_PARAM_APP_ID_PLAYING = "appid_playing";

        public IsPlayingSharedGameRequestBuilder(String steamId,
                                                 Integer appIdPlaying) {

            this.steamId = steamId;
            this.appIdPlaying = appIdPlaying;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_PLAYER_SERVICE;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.IS_PLAYING_SHARED_GAME;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public IsPlayingSharedGameRequest buildRequest() {

            IsPlayingSharedGameRequestServiceParameter serviceParameter = new IsPlayingSharedGameRequestServiceParameter();

            serviceParameter.setSteamId(steamId);
            serviceParameter.setAppIdPlaying(appIdPlaying);

            try {
                addServiceParameter(serviceParameter);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new IsPlayingSharedGameRequest(this);
        }
    }
}