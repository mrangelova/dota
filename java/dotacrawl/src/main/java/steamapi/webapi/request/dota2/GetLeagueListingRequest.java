package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetLeagueListingRequest extends SteamWebApiRequest {
    public GetLeagueListingRequest(SteamWebApiRequestBuilder builder) {super(builder);}

    public static class GetLeagueListingRequestBuilder extends AbstractSteamWebApiRequestBuilder {


        private String language;
        public static final String REQUEST_PARAM_LANGUAGE = "language";

        public GetLeagueListingRequestBuilder language(String language) {
            this.language = language;
            return this;
        }

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
            return SteamWebApiInterfaceMethod.GET_LEAGUE_LISTING;
        }

        @Override
        public GetLeagueListingRequest buildRequest() {

            if (language != null) {
                addParameter(REQUEST_PARAM_LANGUAGE,language);
            }

            return new GetLeagueListingRequest(this);
        }
    }
}