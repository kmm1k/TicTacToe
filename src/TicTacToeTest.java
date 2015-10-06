import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kmmii on 23.09.2015.
 */
public class TicTacToeTest {

    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testGameCreated() {
        assertNotNull(game);
    }

    @Test
    public void testBoardCreated() {
        assertNotNull(game.board);
    }

    @Test
    public void testBoardLayoutCreated() {
        assertNotNull(game.board.getBoardLayout());
    }

    @Test
    public void testChooseWhoStarts() {
        assertTrue(game.selectWhoStartsTheGame() == 0 ||
                game.selectWhoStartsTheGame() == 1);
    }

    @Test
    public void testCheckBoardSize() {
        assertEquals(game.board.getBoardLayout().length, 3);
        assertEquals(game.board.getBoardLayout()[0].length, 3);
        assertEquals(game.board.getBoardLayout()[1].length, 3);
        assertEquals(game.board.getBoardLayout()[2].length, 3);
    }

    @Test
    public void testPlayerMakeMoveOnEmpty() {
        game.playerMakeMove(0, 0);
        assertEquals(game.board.getSlot(0, 0), 'x');
        game.playerMakeMove(1, 1);
        assertEquals(game.board.getSlot(1, 1), 'x');
    }

    @Test
    public void testEnemyMakeMoveOnEmpty() {
        game.enemyMakeMove(2, 2);
        assertEquals(game.board.getSlot(2, 2), 'o');
    }

    @Test
    public void testSetSlot() {
        game.board.setSlot(1, 1, 'o');
        assertEquals(game.board.getSlot(1, 1), 'o');
    }

    @Test
    public void testBoardCheckerCreated() {
        assertNotNull(game.boardChecker);
    }

    @Test
    public void testWinnerCheckersWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 2);
        assertTrue(game.hasPlyerWon());
    }

    @Test
    public void testWinnerCheckersWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 1);
        game.enemyMakeMove(2, 2);
        assertTrue(game.hasEnemyWon());
    }

    @Test
    public void testWinnerCheckersNoWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 1);
        assertFalse(game.hasEnemyWon());
    }

    @Test
    public void testCheckColOneForWinHasWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(0, 1);
        game.playerMakeMove(0, 2);
        assertTrue(game.boardChecker.checkCol(0, game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckColOneForWinHasWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(0, 1);
        game.enemyMakeMove(0, 2);
        assertTrue(game.boardChecker.checkCol(0, game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckColTwoForWinHasWinEnemy() {
        game.enemyMakeMove(1, 0);
        game.enemyMakeMove(1, 1);
        game.enemyMakeMove(1, 2);
        assertTrue(game.boardChecker.checkCol(1, game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckColOneForWinHasNoWinEnemy() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(0, 1);
        assertFalse(game.boardChecker.checkCol(0, game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckColOneForWinHasNoWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(0, 1);
        assertFalse(game.boardChecker.checkCol(0, game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckRowOneForWinHasWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(1, 0);
        game.playerMakeMove(2, 0);
        assertTrue(game.boardChecker.checkRow(0, game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckRowOneForWinHasWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.enemyMakeMove(2, 0);
        assertTrue(game.boardChecker.checkRow(0, game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckRowOneForWinHasNoWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        assertFalse(game.boardChecker.checkRow(0, game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckDiagRightForWinHasWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 1);
        game.enemyMakeMove(2, 2);
        assertTrue(game.boardChecker.checkDiag(0, game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckDiagRightForWinHasWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 2);
        assertTrue(game.boardChecker.checkDiag(0, game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckDiagRightForWinHasNoWinPlayer() {
        game.playerMakeMove(2, 0);
        game.playerMakeMove(1, 1);
        assertFalse(game.boardChecker.checkDiag(0, game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckDiagLeftForWinHasWinEnemy() {
        game.enemyMakeMove(2, 0);
        game.enemyMakeMove(1, 1);
        game.enemyMakeMove(0, 2);
        assertTrue(game.boardChecker.checkDiag(1, game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckDiagLeftForWinHasWinPlayer() {
        game.playerMakeMove(2, 0);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(0, 2);
        assertTrue(game.boardChecker.checkDiag(1, game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckDiagLeftForWinHasNoWinPlayer() {
        game.playerMakeMove(2, 0);
        game.playerMakeMove(1, 1);
        assertFalse(game.boardChecker.checkDiag(1, game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckAllDiagLeftWinPlayer() {
        game.playerMakeMove(2, 0);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(0, 2);
        assertTrue(game.boardChecker.checkAllDiag(game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckAllDiagLeftNoWinPlayer() {
        game.playerMakeMove(2, 0);
        game.playerMakeMove(1, 1);
        assertFalse(game.boardChecker.checkAllDiag(game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckAllDiagRightWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 2);
        assertTrue(game.boardChecker.checkAllDiag(game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckAllColsWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(0, 1);
        game.playerMakeMove(0, 2);
        assertTrue(game.boardChecker.checkAllCols(game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckAllColsNoWinPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(0, 1);
        assertFalse(game.boardChecker.checkAllCols(game.board.getBoardLayout(), 'x'));
    }

    @Test
    public void testCheckAllRowsWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.enemyMakeMove(2, 0);
        assertTrue(game.boardChecker.checkAllRows(game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testCheckAllColsNoWinEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        assertFalse(game.boardChecker.checkAllRows(game.board.getBoardLayout(), 'o'));
    }

    @Test
    public void testAreAllSlotsFilled() {
        game.playerMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.playerMakeMove(2, 0);
        game.enemyMakeMove(0, 1);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 1);
        game.enemyMakeMove(0, 2);
        game.playerMakeMove(1, 2);
        game.enemyMakeMove(2, 2);
        assertTrue(game.boardChecker.areAllBoardSlotsFilled(game.board.getBoardLayout()));
    }

    @Test
    public void testAreAllButOneSlotsFilled() {
        game.playerMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.playerMakeMove(2, 0);
        game.enemyMakeMove(0, 1);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 1);
        game.enemyMakeMove(0, 2);
        game.playerMakeMove(1, 2);
        assertFalse(game.boardChecker.areAllBoardSlotsFilled(game.board.getBoardLayout()));
    }

    @Test
    public void testCheckIfGameIsOverAllSlotsFilled() {
        game.playerMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.playerMakeMove(2, 0);
        game.enemyMakeMove(0, 1);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 1);
        game.enemyMakeMove(0, 2);
        game.playerMakeMove(1, 2);
        game.enemyMakeMove(2, 2);
        game.endChecker();
        assertTrue(game.isGameOver());
    }

    @Test
    public void testSeeWhoWonPlayer() {
        game.playerMakeMove(0, 0);
        game.playerMakeMove(1, 0);
        game.playerMakeMove(2, 0);
        game.endChecker();
        assertEquals(game.winner, "player");
    }

    @Test
    public void testSeeWhoWonEnemy() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.enemyMakeMove(2, 0);
        game.endChecker();
        assertEquals(game.winner, "enemy");
    }

    @Test
    public void testCheckGameOverSetter() {
        game.enemyMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.enemyMakeMove(2, 0);
        game.endChecker();
        assertTrue(game.isGameOver());
    }

    @Test
    public void testRandomSlotPickerOneSlotRemaining() {
        game.playerMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.playerMakeMove(2, 0);
        game.enemyMakeMove(0, 1);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 1);
        game.enemyMakeMove(0, 2);
        game.playerMakeMove(1, 2);
        assertEquals(game.pickRandomSlot().getX(), new SlotPosition(2, 2).getX());
        assertEquals(game.pickRandomSlot().getY(), new SlotPosition(2, 2).getY());
    }

    @Test
    public void testRandomSlotPickerOneSlotRemainingOneTwo() {
        game.playerMakeMove(0, 0);
        game.enemyMakeMove(1, 0);
        game.playerMakeMove(2, 0);
        game.enemyMakeMove(0, 1);
        game.playerMakeMove(1, 1);
        game.playerMakeMove(2, 1);
        game.enemyMakeMove(0, 2);
        game.playerMakeMove(2, 2);
        assertEquals(game.pickRandomSlot().getX(), new SlotPosition(1, 2).getX());
        assertEquals(game.pickRandomSlot().getY(), new SlotPosition(1, 2).getY());
    }

    @Test
    public void testCheckIfSlotIsOpenTrue() {
        assertEquals(game.boardChecker.checkIfSlotIsOpen(game.board.getBoardLayout(), 2, 2), true);
    }

    @Test
    public void testCheckIfSlotIsOpenFalse() {
        game.playerMakeMove(2, 2);
        assertEquals(game.boardChecker.checkIfSlotIsOpen(game.board.getBoardLayout(), 2, 2), false);
    }

    @Test
    public void testGenerateRandomNumberInRange() {
        assertTrue(game.randInt(0, 2) == 0 ||
                game.randInt(0, 2) == 1 ||
                game.randInt(0, 2) == 2);
    }

}