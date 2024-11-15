//package com.khanhtran0111;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    Board() {

    }

    /**
     * them quan co.
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
                && !pieces.contains(piece)) {
            pieces.add(piece);
        }
    }

    /**
     * validate function.
     */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT;
    }

    /**
     * xoa tai mot o (x,y).
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece a = pieces.get(i);
            if (a.getCoordinatesX() == x && a.getCoordinatesY() == y) {
                pieces.remove(i);
                return;
            }
        }
    }

    /**
     * lay tai (x,y).
     */
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece a = pieces.get(i);
            if (a.getCoordinatesX() == x && a.getCoordinatesY() == y) {
                return a;
            }
        }
        return null;
    }

    /**
     * lmao lmao.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * bruh bruh.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}