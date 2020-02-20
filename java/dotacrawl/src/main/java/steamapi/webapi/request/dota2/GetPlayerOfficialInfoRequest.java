package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetPlayerOfficialInfoRequest extends SteamWebApiRequest {
    public GetPlayerOfficialInfoRequest(SteamWebApiRequestBuilder builder) { super(builder);}


    public static class GetPlayerOfficialInfoRequestBuilder extends AbstractSteamWebApiRequestBuilder {

        private final String accountId;

        public static final String REQUEST_PARAM_ACCOUNT_ID = "accountid";

        public GetPlayerOfficialInfoRequestBuilder(String accountId) {
            this.accountId = accountId;
        }

        @Override
        public GetPlayerOfficialInfoRequest buildRequest() {

            addParameter(REQUEST_PARAM_ACCOUNT_ID, accountId);
            return new GetPlayerOfficialInfoRequest(this);
        }

        @Override
        protected SteamWebApiInterface getInterface() {
            return SteamWebApiInterface.I_DOTA2_FANTASY;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {
            return SteamWebApiInterfaceMethod.GET_PLAYER_OFFICIAL_INFO;
        }

        @Override
        protected SteamWebApiVersion getVersion() {
            return SteamWebApiVersion.VERSION_ONE;
        }
    }
}