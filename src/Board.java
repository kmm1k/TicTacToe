/**
 * Created by kmmii on 23.09.2015.
 */
public class Board {

    private char[][] boardLayout = new char[3][3];

    public Board() {

    }

    public void setSlot(int x, int y, char characterOfPlayer) {
        boardLayout[x][y] = characterOfPlayer;
    }

    public char getSlot(int x, int y) {
        return boardLayout[x][y];
    }

    public char[][] getBoardLayout() {
        return boardLayout;
    }

}
