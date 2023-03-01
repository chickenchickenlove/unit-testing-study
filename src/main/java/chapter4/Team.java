package chapter4;

import java.util.List;

public class Team {

    private List<Player> players = List.of(new BaseBallPlayer(), new FootBallPlayer(), new SoccerPlayer());

    public List<Player> getPlayers() {
        return players;
    }




}
