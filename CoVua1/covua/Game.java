//package com.khanhtran0111;
import java.util.ArrayList;
import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    Game(Board b) {
        this.board = b;
        this.moveHistory  = new ArrayList<>();
    }

    /**
     * somthing.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Piece capturedPiece = board.getAt(x, y);
            Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
            if (capturedPiece != null) {
                move.setKilledPiece(capturedPiece);
                board.removeAt(x, y);
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            moveHistory.add(move);
        }
    }


    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * ligma.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}