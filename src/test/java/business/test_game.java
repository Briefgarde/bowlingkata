package business;

import he.arc.business.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test_game {
    @Test
    public void score_Given20rolls_at_0_shouldbe0(){
        Game game = new Game();
        for (int i = 0; i<20;i++){
            game.roll(0);
        }
        int score = game.score();
        Assertions.assertEquals(0, score);
    }

    @Test
    public void score_Given20rolls_at_1_shouldbe20(){
        Game game = new Game();
        for (int i = 0; i<20;i++){
            game.roll(1);
        }
        int score = game.score();
        Assertions.assertEquals(20, score);
    }

    @Test
    public void score_Given_1spare_thenroll3_shouldbe16(){
        Game game = new Game();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        int score = game.score();
        Assertions.assertEquals(16, score);
    }
    @Test
    public void score_Given_1strike_thenroll3_roll4_shouldbe24(){
        Game game = new Game();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        int score = game.score();
        Assertions.assertEquals(24, score);
    }
    @Test
    public void score_Given_10Strike_shouldbe300(){
        Game game = new Game();
        for (int i = 0; i<12;i++){
            game.roll(10);
        }
        int score = game.score();
        Assertions.assertEquals(300, score);
    }
}
