/**
 * Created by kmmii on 03.10.2015.
 */
public class BoardChecker {

    public boolean checkCol(int colNumber, char[][] boardLayout, char characterOfPlayer) {
        int nrOfchars = 0;
        for (int i = 0; i < boardLayout.length; i++) {
            if (boardLayout[colNumber][i] == characterOfPlayer) nrOfchars++;
        }
        if (nrOfchars == boardLayout.length) return true;
        return false;
    }

    public boolean checkRow(int rowNumber, char[][] boardLayout, char characterOfPlayer) {
        int nrOfchars = 0;
        for (int i = 0; i < boardLayout.length; i++) {
            if (boardLayout[i][rowNumber] == characterOfPlayer) nrOfchars++;
        }
        if (nrOfchars == boardLayout.length) return true;
        return false;
    }

    public boolean checkDiag(int diagOrientation, char[][] boardLayout, char characterOfPlayer) {
        int nrOfchars = 0;
        nrOfchars = getNrOfchars(diagOrientation, boardLayout, characterOfPlayer, nrOfchars);
        if (nrOfchars == boardLayout.length) return true;
        return false;
    }

    private int getNrOfchars(int diagOrientation, char[][] boardLayout, char characterOfPlayer, int nrOfchars) {
        if (diagOrientation == 1) {
            for (int i = 0; i < boardLayout.length; i++) {
                if (boardLayout[i][(boardLayout.length - 1) - i] == characterOfPlayer) nrOfchars++;
            }
        } else if (diagOrientation == 0) {
            for (int i = 0; i < boardLayout.length; i++) {
                if (boardLayout[i][i] == characterOfPlayer) nrOfchars++;
            }
        }
        return nrOfchars;
    }

    public boolean checkAllDiag(char[][] boardLayout, char characterOfPlayer) {
        boolean hasDiagWin = false;
        if (checkDiag(0, boardLayout, characterOfPlayer) || checkDiag(1, boardLayout, characterOfPlayer)) {
            hasDiagWin = true;
        }
        return hasDiagWin;
    }

    public boolean checkAllRows(char[][] boardLayout, char characterOfPlayer) {
        if (checkRow(0, boardLayout, characterOfPlayer) ||
                checkRow(1, boardLayout, characterOfPlayer) ||
                checkRow(2, boardLayout, characterOfPlayer)) {
            return true;
        }
        return false;
    }

    public boolean checkAllCols(char[][] boardLayout, char characterOfPlayer) {
        if (checkCol(0, boardLayout, characterOfPlayer) ||
                checkCol(1, boardLayout, characterOfPlayer) ||
                checkCol(2, boardLayout, characterOfPlayer)) {
            return true;
        }
        return false;
    }

    public boolean areAllBoardSlotsFilled(char[][] boardLayout) {
        for (int i = 0; i < boardLayout.length; i++) {
            for (int k = 0; k < boardLayout.length; k++) {
                if (boardLayout[i][k] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkIfSlotIsOpen(char[][] boardLayout, int x, int y) {
        if (boardLayout[x][y] == 0) return true;
        return false;
    }

}
