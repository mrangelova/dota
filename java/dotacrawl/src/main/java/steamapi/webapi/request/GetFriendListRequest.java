package steamapi.webapi.request;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetFriendListRequest extends SteamWebApiRequest {

    private GetFriendListRequest(SteamWebApiRequestBuilder builder) {
        super(builder);
    }


    public enum Relationship {

        ALL("all"),
        FRIEND("friend");

        private final String relationship;

        private Relationship(String relationship) {

            this.relationship = relationship;
        }

        @Override
        public String toString() {

            return relationship;
        }
    }


    public static class GetFriendListRequestBuilder extends
            AbstractSteamWebApiRequestBuilder {

        private final String steamId;

        private Relationship relationship = null;

        public static final String REQUEST_PARAM_STEAM_ID = "steamid";

        public static final String REQUEST_PARAM_RELATIONSHIP = "relationship";

        public GetFriendListRequestBuilder(String steamId) {

            this.steamId = steamId;
        }

        public GetFriendListRequestBuilder relationship(
                Relationship relationship) {

            this.relationship = relationship;
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {

            return SteamWebApiInterface.I_STEAM_USER;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {

            return SteamWebApiInterfaceMethod.GET_FRIEND_LIST;
        }

        @Override
        protected SteamWebApiVersion getVersion() {

            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetFriendListRequest buildRequest() {

            addParameter(REQUEST_PARAM_STEAM_ID, steamId);

            if (relationship != null) {
                addParameter(REQUEST_PARAM_RELATIONSHIP,
                        relationship.toString());
            }

            return new GetFriendListRequest(this);
        }
    }
}