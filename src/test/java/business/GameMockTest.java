package business;

import he.arc.Mock.GameMock;
import he.arc.business.TableauAffichage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class GameMockTest {
    private GameMock game;
    private TableauAffichage tableauAffichage;

    @BeforeEach
    void setUp(){
        tableauAffichage = Mockito.mock(TableauAffichage.class);
        game = new GameMock(tableauAffichage);
    }

    @Test
    public void gameConstructor_GivenTableau_ShouldUseSeConnecter(){
        Mockito.verify(tableauAffichage, times(1)).seConnecter();
    }
}
