package chapter4;

import java.util.List;

public class Team {

    public List<Player> players = List.of(new BaseBallPlayer(), new FootBallPlayer(), new SoccerPlayer());

    public List<Player> getPlayers() {
        return players;
    }

    public int playerSalary() {
        return players.stream().mapToInt(Player::getSalary).sum();
    }

}
