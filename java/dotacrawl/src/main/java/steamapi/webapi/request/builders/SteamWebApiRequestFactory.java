package steamapi.webapi.request.builders;

import steamapi.webapi.request.*;
import steamapi.webapi.request.dota2.*;

import java.util.Date;
import java.util.List;

public abstract class SteamWebApiRequestFactory {

    public static GetNewsForAppRequest createGetNewsForAppRequest(int appId) {

        return new GetNewsForAppRequest.GetNewsForAppRequestBuilder(appId).buildRequest();
    }

    public static GetNewsForAppRequest createGetNewsForAppRequest(int appId,
                                                                  int count, int maxLength) {

        return new GetNewsForAppRequest.GetNewsForAppRequestBuilder(appId).count(count)
                .maxLength(maxLength).buildRequest();
    }

    public static GetGlobalAchievementPercentagesForAppRequest createGetGlobalAchievementPercentagesForAppRequest(
            int gameId) {

        return new GetGlobalAchievementPercentagesForAppRequest.GetGlobalAchievementPercentagesForAppRequestBuilder(gameId)
                .buildRequest();
    }

    public static GetGlobalStatsForGameRequest createGetGlobalStatsForGameRequest(
            int gameId, int count, List<String> names) {

        return new GetGlobalStatsForGameRequest.GetGlobalStatsForGameRequestBuilder(gameId, count, names)
                .buildRequest();
    }

    public static GetPlayerSummariesRequest createGetPlayerSummariesRequest(
            List<String> steamIds) {

        return new GetPlayerSummariesRequest.GetPlayerSummariesRequestBuilder(steamIds).buildRequest();
    }

    public static GetFriendListRequest createGetFriendListRequest(String steamId) {

        return new GetFriendListRequest.GetFriendListRequestBuilder(steamId).buildRequest();
    }

    public static GetFriendListRequest createGetFriendListRequest(
            String steamId, GetFriendListRequest.Relationship relationship) {

        return new GetFriendListRequest.GetFriendListRequestBuilder(steamId).relationship(
                relationship).buildRequest();
    }

    public static GetPlayerAchievementsRequest createGetPlayerAchievementsRequest(
            int appId, String steamId) {

        return new GetPlayerAchievementsRequest.GetPlayerAchievementsRequestBuilder(steamId, appId)
                .buildRequest();
    }

    public static GetPlayerAchievementsRequest createGetPlayerAchievementsRequest(
            int appId, String steamId, String language) {

        return new GetPlayerAchievementsRequest.GetPlayerAchievementsRequestBuilder(steamId, appId)
                .language(language).buildRequest();
    }

    public static GetUserStatsForGameRequest createGetUserStatsForGameRequest(
            int appId, String steamId) {

        return new GetUserStatsForGameRequest.GetUserStatsForGameRequestBuilder(steamId, appId)
                .buildRequest();
    }

    public static GetUserStatsForGameRequest createGetUserStatsForGameRequest(
            int appId, String steamId, String language) {

        return new GetUserStatsForGameRequest.GetUserStatsForGameRequestBuilder(steamId, appId).language(
                language).buildRequest();
    }

    public static GetOwnedGamesRequest createGetOwnedGamesRequest(String steamId) {

        return new GetOwnedGamesRequest.GetOwnedGamesRequestBuilder(steamId).buildRequest();
    }

    public static GetOwnedGamesRequest createGetOwnedGamesRequest(
            String steamId, boolean includeAppInfo,
            boolean includePlayedFreeGames, List<Integer> appIdsFilter) {

        return new GetOwnedGamesRequest.GetOwnedGamesRequestBuilder(steamId)
                .includeAppInfo(includeAppInfo)
                .includePlayedFreeGames(includePlayedFreeGames)
                .appIdsFilter(appIdsFilter).buildRequest();
    }

    public static GetRecentlyPlayedGamesRequest createGetRecentlyPlayedGamesRequest(
            String steamId) {

        return new GetRecentlyPlayedGamesRequest.GetRecentlyPlayedGamesRequestBuilder(steamId).buildRequest();
    }

    public static GetRecentlyPlayedGamesRequest createGetRecentlyPlayedGamesRequest(
            String steamId, Integer count) {

        return new GetRecentlyPlayedGamesRequest.GetRecentlyPlayedGamesRequestBuilder(steamId).count(count)
                .buildRequest();
    }

    public static IsPlayingSharedGameRequest createIsPlayingSharedGameRequest(
            String steamId, Integer appIdPlaying) {

        return new IsPlayingSharedGameRequest.IsPlayingSharedGameRequestBuilder(steamId, appIdPlaying)
                .buildRequest();
    }

    public static GetSchemaForGameRequest createGetSchemaForGameRequest(
            Integer appId) {

        return new GetSchemaForGameRequest.GetSchemaForGameRequestBuilder(appId).buildRequest();
    }

    public static GetPlayerBansRequest createGetPlayerBansRequest(
            List<String> steamIds) {

        return new GetPlayerBansRequest.GetPlayerBansRequestBuilder(steamIds).buildRequest();
    }

    public static GetGameItemsRequest createGetGameItemsRequest() {
        return new GetGameItemsRequest.GetGameItemsRequestBuilder().buildRequest();
    }

    public static GetHeroesRequest createGetHeroesRequest() {
        return new GetHeroesRequest.GetHeroesRequestBuilder().language("en").buildRequest();
    }

    public static GetLeagueListingRequest createGetLeagueListingRequest() {
        return new GetLeagueListingRequest.GetLeagueListingRequestBuilder().language("en").buildRequest();
    }

    public static GetLiveLeagueGamesRequest createGetLiveLeagueGamesRequest() {
        return new GetLiveLeagueGamesRequest.GetLiveLeagueGamesRequestBuilder().buildRequest();
    }

    public static GetMatchDetailsRequest createGetMatchDetailsRequest(String matchId) {
        return new GetMatchDetailsRequest.GetMatchDetailsRequestBuilder(matchId).buildRequest();
    }

    public static GetMatchHistoryBySequenceNumRequest createGetMatchHistoryBySequenceNumRequest(Long startAtMatchSeqMum,Integer matchesRequested ) {
        return new GetMatchHistoryBySequenceNumRequest.GetMatchHistoryBySequenceNumRequestBuilder()
                .startAtMatchSeqNum(startAtMatchSeqMum)
                .matchesRequested(matchesRequested)
                .buildRequest();
    }
    public static GetMatchHistoryRequest createGetMatchHistoryRequest(GetMatchHistoryRequest.GameMode gameMode,
                                                                      GetMatchHistoryRequest.Skill skill,
                                                                      Integer gamesRequested) {
        return new GetMatchHistoryRequest.GetMatchHistoryRequestBuilder()
                .gameMode(gameMode)
                .skill(skill)
                .matchesRequested(gamesRequested)
                .buildRequest();
    }
    public static GetMatchHistoryRequest createGetMatchHistoryRequest(GetMatchHistoryRequest.GameMode gameMode,
                                                                      GetMatchHistoryRequest.Skill skill,
                                                                      String matchId,
                                                                      Integer gamesRequested) {
        return new GetMatchHistoryRequest.GetMatchHistoryRequestBuilder()
                .gameMode(gameMode)
                .skill(skill)
                .startAtMatchId(matchId)
                .matchesRequested(gamesRequested)
                .buildRequest();
    }

    public static GetTeamInfoByTeamIdRequest createGetTeamInfoByTeamIDRequest(Long teamId) {
        return new GetTeamInfoByTeamIdRequest.GetTeamInfoByTeamIDRequestBuilder()
                .startAtTeamId(teamId)
                .teamsRequested(1)
                .buildRequest();
    }

    public static GetFantasyPlayerStatsRequest createGetFantasyPlayerStatsRequest(String fantasyLeagueId) {
        return new GetFantasyPlayerStatsRequest.GetFantasyPlayerStatsRequestBuilder(fantasyLeagueId).buildRequest();
    }

    public static GetFantasyPlayerStatsRequest createGetFantasyPlayerStatsRequest(String fantasyLeagueId, Date startTime, Date endTime, String playerAccountID) {
        return new GetFantasyPlayerStatsRequest.GetFantasyPlayerStatsRequestBuilder(fantasyLeagueId)
                .startTime(startTime)
                .endTime(endTime)
                .playerAccountID(playerAccountID)
                .buildRequest();
    }

    public static GetFantasyPlayerStatsRequest createGetFantasyPlayerStatsRequest(String fantasyLeagueId, Integer seriesId, String playerAccountID) {
        return new GetFantasyPlayerStatsRequest.GetFantasyPlayerStatsRequestBuilder(fantasyLeagueId)
                .seriesID(seriesId)
                .playerAccountID(playerAccountID)
                .buildRequest();
    }


    public static GetFantasyPlayerStatsRequest createGetFantasyPlayerStatsRequest(String fantasyLeagueId, String matchId, String playerAccountID) {
        return new GetFantasyPlayerStatsRequest.GetFantasyPlayerStatsRequestBuilder(fantasyLeagueId)
                .matchId(matchId)
                .playerAccountID(playerAccountID)
                .buildRequest();
    }


    public static GetPlayerOfficialInfoRequest createGetPlayerOfficialInfoRequest(String accountId) {
        return new GetPlayerOfficialInfoRequest.GetPlayerOfficialInfoRequestBuilder(accountId).buildRequest();
    }

    public static GetProPlayerListRequest createGetProPlayerListRequest() {
        return new GetProPlayerListRequest.GetProPlayerListRequestBuilder().buildRequest();
    }
}