package steamapi.webapi.core;
//import steamapi.data.json.dota2.GetMatchHistory;
//import kkpp.crawl.steamapi.data.json.dota2.matchhistory.Get
//import steamapi.schema.dota2.matchhistory.*;


import kkpp.crawl.steamapi.data.json.achievementpercentages.GetGlobalAchievementPercentagesForApp;
import kkpp.crawl.steamapi.data.json.appnews.GetNewsForApp;
import kkpp.crawl.steamapi.data.json.dota2.fantasyplayerstats.GetFantasyPlayerStats;
import kkpp.crawl.steamapi.data.json.dota2.gameitems.GetGameItems;
import kkpp.crawl.steamapi.data.json.dota2.heroes.GetHeroes;
import kkpp.crawl.steamapi.data.json.dota2.leaguelisting.GetLeagueListing;
import kkpp.crawl.steamapi.data.json.dota2.liveleaguegames.GetLiveLeagueGames;
import kkpp.crawl.steamapi.data.json.dota2.matchdetails.GetMatchDetails;
import kkpp.crawl.steamapi.data.json.dota2.matchhistory.GetMatchHistory;
import kkpp.crawl.steamapi.data.json.dota2.matchhistorybysequencenum.GetMatchHistoryBySequenceNum;
import kkpp.crawl.steamapi.data.json.dota2.playerofficialinfo.GetPlayerOfficialInfo;
import kkpp.crawl.steamapi.data.json.dota2.proplayerlist.GetProPlayerList;
import kkpp.crawl.steamapi.data.json.dota2.teaminfobyteamid.GetTeamInfoByTeamID;
import kkpp.crawl.steamapi.data.json.friendslist.GetFriendList;
import kkpp.crawl.steamapi.data.json.getglobalstatsforgame.GetGlobalStatsForGame;
import kkpp.crawl.steamapi.data.json.getplayerbans.GetPlayerBans;
import kkpp.crawl.steamapi.data.json.getschemaforgame.GetSchemaForGame;
import kkpp.crawl.steamapi.data.json.isplayingsharedgame.IsPlayingSharedGame;
import kkpp.crawl.steamapi.data.json.ownedgames.GetOwnedGames;
import kkpp.crawl.steamapi.data.json.playerachievements.GetPlayerAchievements;
import kkpp.crawl.steamapi.data.json.playerstats.GetUserStatsForGame;
import kkpp.crawl.steamapi.data.json.playersummaries.GetPlayerSummaries;
import kkpp.crawl.steamapi.data.json.recentlyplayedgames.GetRecentlyPlayedGames;

public enum SteamWebApiInterfaceMethod {

    GET_NEWS_FOR_APP("GetNewsForApp", GetNewsForApp.class), GET_GLOBAL_ACHIEVEMENT_PERCENTAGES_FOR_APP(
            "GetGlobalAchievementPercentagesForApp",
            GetGlobalAchievementPercentagesForApp.class), GET_GLOBAL_STATS_FOR_GAME("GetGlobalStatsForGame", GetGlobalStatsForGame.class), GET_PLAYER_SUMMARIES(
            "GetPlayerSummaries", GetPlayerSummaries.class), GET_FRIEND_LIST(
            "GetFriendList", GetFriendList.class), GET_PLAYER_ACHIEVEMENTS(
            "GetPlayerAchievements", GetPlayerAchievements.class), GET_USER_STATS_FOR_GAME(
            "GetUserStatsForGame", GetUserStatsForGame.class), GET_OWNED_GAMES(
            "GetOwnedGames", GetOwnedGames.class), GET_RECENTLY_PLAYED_GAMES(
            "GetRecentlyPlayedGames", GetRecentlyPlayedGames.class), IS_PLAYING_SHARED_GAME(
            "IsPlayingSharedGame", IsPlayingSharedGame.class), GET_SCHEMA_FOR_GAME(
            "GetSchemaForGame", GetSchemaForGame.class), GET_PLAYER_BANS(
            "GetPlayerBans", GetPlayerBans.class), GET_HEROES(
            "GetHeroes", GetHeroes.class), GET_MATCH_DETAILS(
            "GetMatchDetails", GetMatchDetails.class),GET_MATCH_HISTORY(
            "GetMatchHistory", GetMatchHistory.class), GET_LEAGUE_LISTING(
            "GetLeagueListing", GetLeagueListing.class), GET_LIVE_LEAGUE_GAMES(
            "GetLiveLeagueGames", GetLiveLeagueGames.class), GET_MATCH_HISTORY_BY_SEQUENCE_NUM(
            "GetMatchHistoryBySequenceNum", GetMatchHistoryBySequenceNum.class), GET_TEAM_INFO_BY_TEAM_ID(
            "GetTeamInfoByTeamID", GetTeamInfoByTeamID.class), GET_GAME_ITEMS(
            "GetGameItems", GetGameItems.class), GET_PRO_PLAYER_LIST(
            "GetProPlayerList", GetProPlayerList.class), GET_PLAYER_OFFICIAL_INFO(
            "GetPlayerOfficialInfo", GetPlayerOfficialInfo.class), GET_FANTASY_PLAYER_STATS(
            "GetFantasyPlayerStats", GetFantasyPlayerStats.class)
    ;

    private final String interfaceMethod;

    private final Class<?> responseType;

    private SteamWebApiInterfaceMethod(String interfaceMethod,
                                       Class<?> responseType) {

        this.interfaceMethod = interfaceMethod;
        this.responseType = responseType;
    }

    public Class<?> getResponseType() {
        return responseType;
    }

    @Override
    public String toString() {
        return interfaceMethod;
    }
}