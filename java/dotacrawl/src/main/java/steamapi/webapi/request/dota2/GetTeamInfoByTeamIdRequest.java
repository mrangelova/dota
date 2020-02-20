package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetTeamInfoByTeamIdRequest extends SteamWebApiRequest{
    public GetTeamInfoByTeamIdRequest(SteamWebApiRequest.SteamWebApiRequestBuilder builder) {super(builder);}

    public static class GetTeamInfoByTeamIDRequestBuilder extends AbstractSteamWebApiRequestBuilder {

        private Long startAtTeamId;

        private Integer teamsRequested;

        public static final String REQUEST_PARAM_START_AT_TEAM_ID = "start_at_team_id ";

        public static final String REQUEST_PARAM_TEAMS_REQUESTED = "teams_requested";

        public GetTeamInfoByTeamIDRequestBuilder startAtTeamId(Long startAtTeamId) {
            this.startAtTeamId = startAtTeamId;
            return this;
        }

        public GetTeamInfoByTeamIDRequestBuilder teamsRequested(Integer teamsRequested) {
            this.teamsRequested = teamsRequested;
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {
            return SteamWebApiInterface.I_DOTA2_MATCH;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {
            return SteamWebApiInterfaceMethod.GET_TEAM_INFO_BY_TEAM_ID;
        }

        @Override
        protected SteamWebApiVersion getVersion() {
            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetTeamInfoByTeamIdRequest buildRequest() {

            if (startAtTeamId != null) {
                addParameter(REQUEST_PARAM_START_AT_TEAM_ID,startAtTeamId);
            }

            if (teamsRequested != null) {
                addParameter(REQUEST_PARAM_TEAMS_REQUESTED,teamsRequested);
            }

            return new GetTeamInfoByTeamIdRequest(this);
        }
    }
}