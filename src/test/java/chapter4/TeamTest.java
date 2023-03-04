package chapter4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TeamTest {


    @Test
    void testGetPlayerListBad() {

        Team sut = new Team();

        List<Player> players = sut.getPlayers();

        assertThat(players.get(0)).isInstanceOf(BaseBallPlayer.class);
        assertThat(players.get(1)).isInstanceOf(FootBallPlayer.class);
        assertThat(players.get(2)).isInstanceOf(SoccerPlayer.class);
    }

    @Test
    void testGetPlayerListGood() {

        Team sut = new Team();

        List<Player> players = sut.getPlayers();

        assertThat(players).isNotNull();
    }

}