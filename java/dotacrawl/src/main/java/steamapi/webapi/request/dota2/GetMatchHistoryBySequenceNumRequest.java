package steamapi.webapi.request.dota2;

import steamapi.webapi.core.SteamWebApiInterface;
import steamapi.webapi.core.SteamWebApiInterfaceMethod;
import steamapi.webapi.core.SteamWebApiVersion;
import steamapi.webapi.request.SteamWebApiRequest;
import steamapi.webapi.request.builders.AbstractSteamWebApiRequestBuilder;

public class GetMatchHistoryBySequenceNumRequest extends SteamWebApiRequest {
    public GetMatchHistoryBySequenceNumRequest(SteamWebApiRequestBuilder builder) {super(builder);}

    public static class GetMatchHistoryBySequenceNumRequestBuilder extends AbstractSteamWebApiRequestBuilder {
        private Long startAtMatchSeqNum;
        private Integer matchesRequested;

        public static final String REQUEST_PARAM_START_AT_MATCH_SEQ_NUM = "start_at_match_seq_num";

        public static final String REQUEST_PARAM_MATCHES_REQUESTED = "matches_requested";

        public GetMatchHistoryBySequenceNumRequestBuilder startAtMatchSeqNum(Long startAtMatchSeqNum) {
            this.startAtMatchSeqNum = startAtMatchSeqNum;
            return this;
        }

        public GetMatchHistoryBySequenceNumRequestBuilder matchesRequested(Integer matchesRequested) {
            this.matchesRequested = matchesRequested;
            return this;
        }

        @Override
        protected SteamWebApiInterface getInterface() {
            return SteamWebApiInterface.I_DOTA2_MATCH;
        }

        @Override
        protected SteamWebApiInterfaceMethod getInterfaceMethod() {
            return SteamWebApiInterfaceMethod.GET_MATCH_HISTORY_BY_SEQUENCE_NUM;
        }

        @Override
        protected SteamWebApiVersion getVersion() {
            return SteamWebApiVersion.VERSION_ONE;
        }

        @Override
        public GetMatchHistoryBySequenceNumRequest buildRequest() {

            if (startAtMatchSeqNum != null) {
                addParameter(REQUEST_PARAM_START_AT_MATCH_SEQ_NUM,startAtMatchSeqNum);
            }

            if (matchesRequested != null) {
                addParameter(REQUEST_PARAM_MATCHES_REQUESTED,matchesRequested);
            }

            return new GetMatchHistoryBySequenceNumRequest(this);

        }
    }

}