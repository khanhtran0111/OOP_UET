package com.khanhtran0111;

public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color = "white";

    public Piece(int x, int y) {
        coordinatesX = x;
        coordinatesY = y;
    }

    /**
     * khoi tao 3 thuoc tinh.
     */
    public Piece(int x, int y, String color) {
        coordinatesX = x;
        coordinatesY = y;
        this.color = color;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * lmao.
     */
    public abstract String getSymbol();

    /**
     * bruh bruh.
     */
    public boolean checkPosition(Piece piece) {
        return piece.coordinatesX == coordinatesX && piece.coordinatesY == coordinatesY;
    }

    /**
     * javadoc.
     */
    public abstract boolean canMove(Board board, int x, int y);
}