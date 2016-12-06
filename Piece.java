package com.hfad.chess;

/**
 * Created by Schlenker18 on 11/15/2016.
 */

public class Piece {

    String TYPE;
    String COLOR;
    int XLOC;
    int YLOC;
    boolean clicked = false;

    public Piece(String type, String color, int yLoc, int xLoc) {
        TYPE = type;
        COLOR = color;
        XLOC = xLoc;
        YLOC = yLoc;
    }

    public void setClicked(boolean bool) {
        clicked = bool;
    }

    public boolean getClicked() {
        return  clicked;
    }

    public String getType() {
        return TYPE;
    }

    public String getColor() {
        return COLOR;
    }

    public int getXLoc() {
        return XLOC;
    }

    public int getYLOC() {
        return YLOC;
    }
}
