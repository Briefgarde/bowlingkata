package he.arc.business;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Frame> frames;
    private int nbRoll;

    public TableauAffichage tableauAffichage;

    public Game() {
        frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
        nbRoll = 0;

    }

    public void roll(int pins) {
        Frame currentFrame = frames.get(nbRoll / 2);
        if (nbRoll % 2 == 0) {
            currentFrame.getRoll1().setPins(pins);
            if (pins == 10) { // Strike
                nbRoll += 2;
            } else {
                nbRoll++;
            }
        } else {
            currentFrame.getRoll2().setPins(pins);
            nbRoll++;
        }
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            if (frame.isStrike()) {
                score += 10;
                if (i + 1 < frames.size()) {
                    score += frames.get(i + 1).getRoll1().getPins();
                    if (frames.get(i + 1).isStrike() && i + 2 < frames.size()) {
                        score += frames.get(i + 2).getRoll1().getPins();
                    } else if (i + 1 < frames.size()) {
                        score += frames.get(i + 1).getRoll2().getPins();
                    }
                }
            } else if (frame.isSpare()) {
                score += 10;
                if (i + 1 < frames.size()) {
                    score += frames.get(i + 1).getRoll1().getPins();
                }
            } else {
                score += frame.score();
            }
        }
        return score;
    }

    public void clear() {
        frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }
}
