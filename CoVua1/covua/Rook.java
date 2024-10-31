//package com.khanhtran0111;

public class Rook extends Piece {
    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * checking xem co the di chuyen duoc hay khong.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int deltaX = x - getCoordinatesX();
        int deltaY = y - getCoordinatesY();

        if (deltaY == 0 && deltaX == 0) {
            return true;
        }

        if (Math.abs(deltaX) != 0 && Math.abs(deltaY) != 0) {
            return false;
        }

        int stepX = Integer.compare(deltaX, 0);
        int stepY = Integer.compare(deltaY, 0);

        int currentX = getCoordinatesX() + stepX;
        int currentY = getCoordinatesY() + stepY;

        while (currentX != x || currentY != y) {
            Piece check = board.getAt(currentX, currentY);
            if (check != null) {
                return false;
            }
            currentX += stepX;
            currentY += stepY;
        }

        Piece pieceAtDestination = board.getAt(currentX, currentY);
        if (pieceAtDestination == null) {
            return true;
        } else {
            return !pieceAtDestination.getColor().equals(getColor());
        }
    }

}
