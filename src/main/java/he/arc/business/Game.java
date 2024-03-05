package he.arc.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public List<Frame> frames;
    public Game(){
        frames = new ArrayList<>();
        for (int i = 0;i<10;i++){
            frames.add(new Frame());
        }
    }

    public void roll(int pins){
        for (Frame frame : frames){
            if (frame.getRoll1().getPins() == -1) {
                frame.getRoll1().setPins(pins);
                break;
            } else if ((frame.getRoll2().getPins() == -1) && (frame.getRoll1().getPins() != 10)) {
                frame.getRoll2().setPins(pins);
                break;
            }
        }
    }
    public int score(){
        int score = 0;
        for (int i = 0; i < frames.size(); i++){
            Frame frame = frames.get(i);
            if (frame.isStrike()) {
                score += 10;
                if (i + 1 < frames.size()) {
                    score += frames.get(i + 1).getRoll1().getPins();
                    if (frames.get(i + 1).isStrike() && i + 2 < frames.size()) {
                        score += frames.get(i + 2).getRoll1().getPins();
                    } else {
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

    public void clear(){
        frames = new ArrayList<>();
        for (int i = 0;i<10;i++){
            frames.add(new Frame());
        }
    }
}
