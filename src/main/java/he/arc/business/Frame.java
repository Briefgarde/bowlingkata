package he.arc.business;

public class Frame {

    private Roll roll1 = new Roll();
    private Roll roll2 = new Roll();
    public Frame(){}
    public int score(){

        if (roll1.getPins() == -1){
            return 0;
        }
        int score = roll1.getPins() + roll2.getPins();
        return score;
    }

    public boolean isSpare(){
        return (roll1.getPins() + roll2.getPins()) == 10;
    }
    public boolean isStrike(){
        return roll1.getPins() == 10;
    }

    public Roll getRoll1() {
        return roll1;
    }

    public Roll getRoll2() {
        return roll2;
    }

}
