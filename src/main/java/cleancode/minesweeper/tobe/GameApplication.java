package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.*;

public class GameApplication {
    public static void main(String[] args) {
        GameLevel gameLevel = new VeryBeginner();

        Minesweeper minesweeper = new Minesweeper(gameLevel);
        minesweeper.run();
    }

}
