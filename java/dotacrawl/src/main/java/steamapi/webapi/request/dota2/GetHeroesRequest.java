package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetHeroesRequest extends SteamWebApiRequest {

    private GetHeroesRequest(SteamWebApiRequest.SteamWebApiRequestBuilder builder) {
        super(builder);
    }

    public static class GetHeroesRequestBuilder extends
            AbstractSteamWebApiRequestBuilder {

        private String language;
        private Boolean itemizedonly;

        public static final String REQUEST_PARAM_LANGUAGE = "language";

        public static final String REQUEST_PARAM_ITEMIZEDONLY = "itemizedonly";

        public GetHeroesRequestBuilder language(String language) {

            this.language = language;
            return this;
        }

        public GetHeroesRequestBuilder itemizedonly(Boolean itemizedonly) {
            this.itemizedonly = itemizedonly;
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_ECON_DOTA2;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {
            //return null;
            return SteamWebApiInterfaceMethod.GET_HEROES;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetHeroesRequest buildRequest() {

            if (language != null) {
                addParameter(REQUEST_PARAM_LANGUAGE,language);
            }

            if (itemizedonly != null) {
                addParameter(REQUEST_PARAM_ITEMIZEDONLY,itemizedonly.toString());
            }

            return new GetHeroesRequest(this);
        }
    }
}