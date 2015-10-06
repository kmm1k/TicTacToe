import java.util.Random;

/**
 * Created by kmmii on 23.09.2015.
 */
public class TicTacToe {

    public final Board board;
    private char[][] boardLayout;
    public BoardChecker boardChecker;
    private boolean gameOver;
    public String winner;
    private final Random random;

    public TicTacToe() {
        board = new Board();
        boardChecker = new BoardChecker();
        random = new Random();
        boardLayout = board.getBoardLayout();
    }

    public int selectWhoStartsTheGame() {
        return 0;
    }

    public void playerMakeMove(int x, int y) {
        board.setSlot(x, y, 'x');
    }

    public void enemyMakeMove(int x, int y) {
        board.setSlot(x, y, 'o');
    }

    public boolean hasEnemyWon() {
        char[][] boardLayout = this.boardLayout;
        char player = 'o';
        return hasAnybodyWon(boardLayout, player);
    }

    public boolean hasPlyerWon() {
        char[][] boardLayout = this.boardLayout;
        char player = 'x';
        return hasAnybodyWon(boardLayout, player);
    }

    private boolean hasAnybodyWon(char[][] boardLayout, char player) {
        if (boardChecker.checkAllCols(boardLayout, player) ||
                boardChecker.checkAllRows(boardLayout, player) ||
                boardChecker.checkAllDiag(boardLayout, player)) {
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public SlotPosition pickRandomSlot() {
        int x = randInt(0, 2);
        int y = randInt(0, 2);
        while (!boardChecker.checkIfSlotIsOpen(boardLayout, x, y)) {
            x = randInt(0, 2);
            y = randInt(0, 2);
        }
        return new SlotPosition(x, y);
    }

    public void endChecker() {
        if (hasAnybodyWon(boardLayout, 'x')) {
            winner = "player";
            gameOver = true;
        } else if (hasAnybodyWon(boardLayout, 'o')) {
            winner = "enemy";
            gameOver = true;
        } else if (boardChecker.areAllBoardSlotsFilled(boardLayout)) {
            winner = "none";
            gameOver = true;
        }
    }

    public int randInt(int min, int max) {
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
