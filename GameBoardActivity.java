package com.hfad.chess;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameBoardActivity extends Activity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25, button26, button27, button28, button29, button30, button31, button32, button33, button34, button35, button36, button37, button38, button39, button40, button41, button42, button43, button44, button45, button46, button47, button48, button49, button50, button51, button52, button53, button54, button55, button56, button57, button58, button59, button60, button61, button62, button63, button64;
    Button[][] buttonArray = new Button[8][8];
    Piece[][] pieceArray = new Piece[8][8];
    Piece[] pieces = new Piece[32];
    Piece[] whitePieceTaken = new Piece[16];
    Piece[] blackPieceTaken = new Piece[16];
    int turn = 0;
    TextView turn_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        turn_message = (TextView) findViewById(R.id.turn_message);
        turn_message.setText("White's Turn");

        pieces[0] = pieceArray[0][0] = new Piece("R", "black", 0, 0);
        pieces[1] = pieceArray[0][1] = new Piece("N", "black", 0, 1);
        pieces[2] = pieceArray[0][2] = new Piece("B", "black", 0, 2);
        pieces[3] = pieceArray[0][3] = new Piece("Q", "black", 0, 3);
        pieces[4] = pieceArray[0][4] = new Piece("K", "black", 0, 4);
        pieces[5] = pieceArray[0][5] = new Piece("B", "black", 0, 5);
        pieces[6] = pieceArray[0][6] = new Piece("N", "black", 0, 6);
        pieces[7] = pieceArray[0][7] = new Piece("R", "black", 0, 7);

        pieces[8] = pieceArray[1][0] = new Piece("P", "black", 1, 0);
        pieces[9] = pieceArray[1][1] = new Piece("P", "black", 1, 1);
        pieces[10] = pieceArray[1][2] = new Piece("P", "black", 1, 2);
        pieces[11] = pieceArray[1][3] = new Piece("P", "black", 1, 3);
        pieces[12] = pieceArray[1][4] = new Piece("P", "black", 1, 4);
        pieces[13] = pieceArray[1][5] = new Piece("P", "black", 1, 5);
        pieces[14] = pieceArray[1][6] = new Piece("P", "black", 1, 6);
        pieces[15] = pieceArray[1][7] = new Piece("P", "black", 1, 7);

        pieces[16] = pieceArray[6][0] = new Piece("P", "white", 6, 0);
        pieces[17] = pieceArray[6][1] = new Piece("P", "white", 6, 1);
        pieces[18] = pieceArray[6][2] = new Piece("P", "white", 6, 2);
        pieces[19] = pieceArray[6][3] = new Piece("P", "white", 6, 3);
        pieces[20] = pieceArray[6][4] = new Piece("P", "white", 6, 4);
        pieces[21] = pieceArray[6][5] = new Piece("P", "white", 6, 5);
        pieces[22] = pieceArray[6][6] = new Piece("P", "white", 6, 6);
        pieces[23] = pieceArray[6][7] = new Piece("P", "white", 6, 7);

        pieces[24] = pieceArray[7][0] = new Piece("R", "white", 7, 0);
        pieces[25] = pieceArray[7][1] = new Piece("N", "white", 7, 1);
        pieces[26] = pieceArray[7][2] = new Piece("B", "white", 7, 2);
        pieces[27] = pieceArray[7][3] = new Piece("K", "white", 7, 3);
        pieces[28] = pieceArray[7][4] = new Piece("Q", "white", 7, 4);
        pieces[29] = pieceArray[7][5] = new Piece("B", "white", 7, 5);
        pieces[30] = pieceArray[7][6] = new Piece("N", "white", 7, 6);
        pieces[31] = pieceArray[7][7] = new Piece("R", "white", 7, 7);

        buttonArray[0][0] = (Button) findViewById(R.id.button1);
        buttonArray[0][1] = (Button) findViewById(R.id.button2);
        buttonArray[0][2] = (Button) findViewById(R.id.button3);
        buttonArray[0][3] = (Button) findViewById(R.id.button4);
        buttonArray[0][4] = (Button) findViewById(R.id.button5);
        buttonArray[0][5] = (Button) findViewById(R.id.button6);
        buttonArray[0][6] = (Button) findViewById(R.id.button7);
        buttonArray[0][7] = (Button) findViewById(R.id.button8);
        buttonArray[1][0] = (Button) findViewById(R.id.button9);
        buttonArray[1][1] = (Button) findViewById(R.id.button10);
        buttonArray[1][2] = (Button) findViewById(R.id.button11);
        buttonArray[1][3] = (Button) findViewById(R.id.button12);
        buttonArray[1][4] = (Button) findViewById(R.id.button13);
        buttonArray[1][5] = (Button) findViewById(R.id.button14);
        buttonArray[1][6] = (Button) findViewById(R.id.button15);
        buttonArray[1][7] = (Button) findViewById(R.id.button16);
        buttonArray[2][0] = (Button) findViewById(R.id.button17);
        buttonArray[2][1] = (Button) findViewById(R.id.button18);
        buttonArray[2][2] = (Button) findViewById(R.id.button19);
        buttonArray[2][3] = (Button) findViewById(R.id.button20);
        buttonArray[2][4] = (Button) findViewById(R.id.button21);
        buttonArray[2][5] = (Button) findViewById(R.id.button22);
        buttonArray[2][6] = (Button) findViewById(R.id.button23);
        buttonArray[2][7] = (Button) findViewById(R.id.button24);
        buttonArray[3][0] = (Button) findViewById(R.id.button25);
        buttonArray[3][1] = (Button) findViewById(R.id.button26);
        buttonArray[3][2] = (Button) findViewById(R.id.button27);
        buttonArray[3][3] = (Button) findViewById(R.id.button28);
        buttonArray[3][4] = (Button) findViewById(R.id.button29);
        buttonArray[3][5] = (Button) findViewById(R.id.button30);
        buttonArray[3][6] = (Button) findViewById(R.id.button31);
        buttonArray[3][7] = (Button) findViewById(R.id.button32);
        buttonArray[4][0] = (Button) findViewById(R.id.button33);
        buttonArray[4][1] = (Button) findViewById(R.id.button34);
        buttonArray[4][2] = (Button) findViewById(R.id.button35);
        buttonArray[4][3] = (Button) findViewById(R.id.button36);
        buttonArray[4][4] = (Button) findViewById(R.id.button37);
        buttonArray[4][5] = (Button) findViewById(R.id.button38);
        buttonArray[4][6] = (Button) findViewById(R.id.button39);
        buttonArray[4][7] = (Button) findViewById(R.id.button40);
        buttonArray[5][0] = (Button) findViewById(R.id.button41);
        buttonArray[5][1] = (Button) findViewById(R.id.button42);
        buttonArray[5][2] = (Button) findViewById(R.id.button43);
        buttonArray[5][3] = (Button) findViewById(R.id.button44);
        buttonArray[5][4] = (Button) findViewById(R.id.button45);
        buttonArray[5][5] = (Button) findViewById(R.id.button46);
        buttonArray[5][6] = (Button) findViewById(R.id.button47);
        buttonArray[5][7] = (Button) findViewById(R.id.button48);
        buttonArray[6][0] = (Button) findViewById(R.id.button49);
        buttonArray[6][1] = (Button) findViewById(R.id.button50);
        buttonArray[6][2] = (Button) findViewById(R.id.button51);
        buttonArray[6][3] = (Button) findViewById(R.id.button52);
        buttonArray[6][4] = (Button) findViewById(R.id.button53);
        buttonArray[6][5] = (Button) findViewById(R.id.button54);
        buttonArray[6][6] = (Button) findViewById(R.id.button55);
        buttonArray[6][7] = (Button) findViewById(R.id.button56);
        buttonArray[7][0] = (Button) findViewById(R.id.button57);
        buttonArray[7][1] = (Button) findViewById(R.id.button58);
        buttonArray[7][2] = (Button) findViewById(R.id.button59);
        buttonArray[7][3] = (Button) findViewById(R.id.button60);
        buttonArray[7][4] = (Button) findViewById(R.id.button61);
        buttonArray[7][5] = (Button) findViewById(R.id.button62);
        buttonArray[7][6] = (Button) findViewById(R.id.button63);
        buttonArray[7][7] = (Button) findViewById(R.id.button64);

        buttonArray[0][0].setClickable(false);
        buttonArray[0][1].setClickable(false);
        buttonArray[0][2].setClickable(false);
        buttonArray[0][3].setClickable(false);
        buttonArray[0][4].setClickable(false);
        buttonArray[0][5].setClickable(false);
        buttonArray[0][6].setClickable(false);
        buttonArray[0][7].setClickable(false);
        buttonArray[1][0].setClickable(false);
        buttonArray[1][1].setClickable(false);
        buttonArray[1][2].setClickable(false);
        buttonArray[1][3].setClickable(false);
        buttonArray[1][4].setClickable(false);
        buttonArray[1][5].setClickable(false);
        buttonArray[1][6].setClickable(false);
        buttonArray[1][7].setClickable(false);
        buttonArray[2][0].setClickable(false);
        buttonArray[2][1].setClickable(false);
        buttonArray[2][2].setClickable(false);
        buttonArray[2][3].setClickable(false);
        buttonArray[2][4].setClickable(false);
        buttonArray[2][5].setClickable(false);
        buttonArray[2][6].setClickable(false);
        buttonArray[2][7].setClickable(false);
        buttonArray[3][0].setClickable(false);
        buttonArray[3][1].setClickable(false);
        buttonArray[3][2].setClickable(false);
        buttonArray[3][3].setClickable(false);
        buttonArray[3][4].setClickable(false);
        buttonArray[3][5].setClickable(false);
        buttonArray[3][6].setClickable(false);
        buttonArray[3][7].setClickable(false);
        buttonArray[4][0].setClickable(false);
        buttonArray[4][1].setClickable(false);
        buttonArray[4][2].setClickable(false);
        buttonArray[4][3].setClickable(false);
        buttonArray[4][4].setClickable(false);
        buttonArray[4][5].setClickable(false);
        buttonArray[4][6].setClickable(false);
        buttonArray[4][7].setClickable(false);
        buttonArray[5][0].setClickable(false);
        buttonArray[5][1].setClickable(false);
        buttonArray[5][2].setClickable(false);
        buttonArray[5][3].setClickable(false);
        buttonArray[5][4].setClickable(false);
        buttonArray[5][5].setClickable(false);
        buttonArray[5][6].setClickable(false);
        buttonArray[5][7].setClickable(false);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                buttonArray[i][j].setText(pieceArray[i][j].getType());
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttonArray[i][j].setText(pieceArray[i][j].getType());
                setTextColor(buttonArray[i][j], pieceArray[i][j]);
            }
        }

        updateBoard();
    }

    public void setTextColor(Button button, Piece piece) {
        if (piece.getColor() == "black") {
            button.setTextColor(getResources().getColor(R.color.black));
        } else {
            button.setTextColor(getResources().getColor(R.color.white));
        }
    }

    public void onClick(View v) {
        CharSequence type = ((Button) v).getText();
        Button b = (Button) v;
        int xVal = -1;
        int yVal = -1;
        int x = -1;
        int y = -1;
        boolean clicked = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieceArray[i][j] != null && pieceArray[i][j].getClicked() == true) {
                    clicked = true;
                    x = i;
                    y = j;
                }

                if (buttonArray[i][j] == b) {
                    xVal = i;
                    yVal = j;
                }
            }
        }

        String color = "";

        if (pieceArray[xVal][yVal] != null) {
            color = pieceArray[xVal][yVal].getColor();
        }

        if (clicked == true && color != pieceArray[x][y].getColor() && (type == "P" || type == "N" || type == "R" || type == "K" || type == "Q" || type == "B")) {
            takePiece(xVal, yVal);
        }

        if (type == "P") {
            pawnMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "") {
            moveToOpen(xVal, yVal);
        }

        if (type == "R") {
            rookMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "N") {
            knightMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "K") {
            kingMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "B"){
            bishopMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "Q") {
            queenMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }
    }

    public void takePiece(int x, int y) {
        Piece takingPiece;
        int xVal = -1;
        int yVal = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieceArray[i][j] != null && pieceArray[i][j].getClicked() == true) {
                    takingPiece = pieceArray[i][j];
                    xVal = i;
                    yVal = j;
                }
            }
        }

        buttonArray[x][y].setText("");
        if (pieceArray[x][y].getColor() == "black") {
            for (int i = 0; i < 16; i++) {
                if (blackPieceTaken[i] == null) {
                    blackPieceTaken[i] = pieceArray[x][y];
                    break;
                }
            }
        } else {
            for (int i = 0; i < 16; i++) {
                if (whitePieceTaken[i] == null) {
                    whitePieceTaken[i] = pieceArray[x][y];
                    break;
                }
            }
        }

        pieceArray[x][y] = null;
        pieceArray[x][y] = pieceArray[xVal][yVal];
        pieceArray[xVal][yVal] = null;
        buttonArray[x][y].setText(pieceArray[x][y].getType());
        buttonArray[xVal][yVal].setText("");

        if (turn_message.getText() == "Black Player Wins" || turn_message.getText() == "White Player Wins") {
             for (int i = 0; i < 8; i++) {
                 for (int j = 0; j < 8; j++) {
                     buttonArray[i][j].setClickable(false);
                 }
             }
        }

        updateBoard();
        emptySpaces();
        changeTurn();
        gameOver();
    }

    public void moveToOpen(int xVal, int yVal) {
        int x = -1;
        int y = -1;
        Piece piece = null;

        for (int i = 0; i < 32; i++) {
            if (pieces[i].getClicked() == true) {
                piece = pieces[i];
                piece.setClicked(false);
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieceArray[i][j] == piece) {
                    buttonArray[xVal][yVal].setText(piece.getType());
                    x = i;
                    y = j;
                    buttonArray[x][y].setText("");
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttonArray[i][j].setClickable(true);
            }
        }

        if (xVal % 2 == 0 && yVal % 2 == 0) {
            buttonArray[xVal][yVal].setBackgroundResource(R.color.tan);
        } else {
            buttonArray[xVal][yVal].setBackgroundResource(R.color.brown);
        }

        pieceArray[xVal][yVal] = piece;
        pieceArray[x][y] = null;
        changeTurn();
        emptySpaces();
        updateBoard();
    }

    public void kingMove( int x, int y, boolean clicked, String color) {
        if ( clicked == false) {
            for (int i = 0; i < 8; i++) {
                for ( int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(false);
                }
            }

            if (x < 7 && buttonArray[x+1][y].getText() == ""){
                buttonArray[x + 1][y].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x + 1][y].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 7) {
                if (pieceArray[x + 1][y].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x + 1][y].setClickable(true);
                    buttonArray[x + 1][y].setBackgroundResource(R.color.green);
                }
            }

            if (x > 0 && buttonArray[x-1][y].getText() == ""){
                buttonArray[x-1][y].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 0 ) {
                if (pieceArray[x - 1][y].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x - 1][y].setClickable(true);
                    buttonArray[x - 1][y].setBackgroundResource(R.color.green);
                }
            }

            if (y < 7 && buttonArray[x][y+1].getText() == ""){
                buttonArray[x][y+1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y < 7 ) {
                if (pieceArray[x][y + 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x][y + 1].setClickable(true);
                    buttonArray[x][y + 1].setBackgroundResource(R.color.green);
                }
            }

            if (y > 0 && buttonArray[x][y-1].getText() == ""){
                buttonArray[x][y-1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y > 0) {
                if (pieceArray[x][y - 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x][y - 1].setClickable(true);
                    buttonArray[x][y - 1].setBackgroundResource(R.color.green);
                }
            }

            if ( y < 7 && x < 7  && buttonArray[x+1][y+1].getText() == ""){
                buttonArray[x+1][y+1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y < 7 && x < 7) {
                if (pieceArray[x + 1][y + 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x + 1][y + 1].setClickable(true);
                    buttonArray[x + 1][y + 1].setBackgroundResource(R.color.green);
                }
            }

            if ( y > 0 && x > 0  && buttonArray[x-1][y-1].getText() == ""){
                buttonArray[x-1][y-1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y > 0 && x > 0) {
                if (pieceArray[x - 1][y - 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x - 1][y - 1].setClickable(true);
                    buttonArray[x - 1][y - 1].setBackgroundResource(R.color.green);
                }
            }

            if ( y > 0 && x < 7  && buttonArray[x+1][y-1].getText() == ""){
                buttonArray[x+1][y-1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y>0 && x<7 ) {
                if (pieceArray[x + 1][y - 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x + 1][y - 1].setClickable(true);
                    buttonArray[x + 1][y - 1].setBackgroundResource(R.color.green);
                }
            }

            if ( y < 7 && x > 0  && buttonArray[x-1][y+1].getText() == ""){
                buttonArray[x-1][y+1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y<7 && x>0 ) {
                if (pieceArray[x - 1][y + 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x - 1][y + 1].setClickable(true);
                    buttonArray[x - 1][y + 1].setBackgroundResource(R.color.green);
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);
        } else {
            pieceArray[x][y].setClicked(false);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(true);
                }
            }

            updateBoard();
        }
    }

    public void knightMove(int x, int y, boolean clicked, String color) {
        if ( clicked == false ) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++ ) {
                    buttonArray[i][j].setClickable(false);
                }
            }

            if ( x < 6 && y < 7 && buttonArray[x+2][y+1].getText() == ""){
                buttonArray[x+2][y+1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+2][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 6 && y < 7) {
                if ( pieceArray[x+2][y+1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+2][y+1].setClickable(true);
                    buttonArray[x+2][y+1].setBackgroundResource(R.color.green);
                }
            }

            if ( x < 6 && y > 0 && buttonArray[x+2][y-1].getText() == ""){
                buttonArray[x+2][y-1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+2][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 6 && y > 0) {
                if ( pieceArray[x+2][y-1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+2][y-1].setClickable(true);
                    buttonArray[x+2][y-1].setBackgroundResource(R.color.green);
                }
            }

            if ( x > 1 && y < 7 && buttonArray[x-2][y+1].getText() == ""){
                buttonArray[x-2][y+1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-2][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 1 && y < 7) {
                if ( pieceArray[x-2][y+1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-2][y+1].setClickable(true);
                    buttonArray[x-2][y+1].setBackgroundResource(R.color.green);
                }
            }

            if ( x > 1 && y > 0 && buttonArray[x-2][y-1].getText() == ""){
                buttonArray[x-2][y-1].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-2][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 1 && y > 0) {
                if ( pieceArray[x-2][y-1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-2][y-1].setClickable(true);
                    buttonArray[x-2][y-1].setBackgroundResource(R.color.green);
                }
            }

            if ( x < 7 && y < 6 && buttonArray[x+1][y+2].getText() == ""){
                buttonArray[x+1][y+2].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y+2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 7 && y < 6) {
                if ( pieceArray[x+1][y+2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+1][y+2].setClickable(true);
                    buttonArray[x+1][y+2].setBackgroundResource(R.color.green);
                }
            }

            if ( x < 7 && y > 1 && buttonArray[x+1][y-2].getText() == ""){
                buttonArray[x+1][y-2].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y-2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 7 && y > 1) {
                if ( pieceArray[x+1][y-2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+1][y-2].setClickable(true);
                    buttonArray[x+1][y-2].setBackgroundResource(R.color.green);
                }
            }

            if ( x > 0 && y < 6 && buttonArray[x-1][y+2].getText() == ""){
                buttonArray[x-1][y+2].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y+2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 0 && y < 6) {
                if ( pieceArray[x-1][y+2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-1][y+2].setClickable(true);
                    buttonArray[x-1][y+2].setBackgroundResource(R.color.green);
                }
            }

            if ( x > 0 && y > 1 && buttonArray[x-1][y-2].getText() == ""){
                buttonArray[x-1][y-2].setBackgroundResource(R.color.green);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y-2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 0 && y > 1) {
                if ( pieceArray[x-1][y-2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-1][y-2].setClickable(true);
                    buttonArray[x-1][y-2].setBackgroundResource(R.color.green);
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);
        } else {
            pieceArray[x][y].setClicked(false);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(true);
                }
            }

            updateBoard();
        }
    }

    public void queenMove(int x, int y, boolean clicked, String color) {
        if (clicked == false) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(false);
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);
            int yVal = y;

            for (int i = x + 1; i < 8; i++) {
                if (yVal + 1 < 8) {
                    if (buttonArray[i][yVal + 1].getText() == "") {
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal + 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal + 1 < 8) {
                    if (buttonArray[i][yVal + 1].getText() == "") {
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal + 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x + 1; i < 8; i++) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal - 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal - 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x + 1; i < 8; i++) {
                if (buttonArray[i][y].getText() == "") {
                    buttonArray[i][y].setBackgroundResource(R.color.green);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.green);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = x - 1; i >= 0; i--) {
                if (buttonArray[i][y].getText() == "") {
                    buttonArray[i][y].setBackgroundResource(R.color.green);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.green);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y + 1; i < 8; i++) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.green);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.green);
                        buttonArray[x][i].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y - 1; i >= 0; i--) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.green);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.green);
                        buttonArray[x][i].setClickable(true);
                    }
                    break;
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);

        } else {
            pieceArray[x][y].setClicked(false);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(true);
                }
            }

            updateBoard();
        }

    }

    public void bishopMove(int x, int y, boolean clicked, String color) {
        if (clicked == false) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(false);
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);
            int yVal = y;

            for (int i = x + 1; i < 8; i++) {
                if (yVal + 1 < 8) {
                    if (buttonArray[i][yVal + 1].getText() == "") {
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal + 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal + 1 < 8) {
                    if (buttonArray[i][yVal + 1].getText() == "") {
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal +1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x + 1; i < 8; i++) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal - 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal -1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.green);
                        }
                        break;
                    }
                }
            }

            yVal = y;
            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);
        } else {
            pieceArray[x][y].setClicked(false);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(true);
                }
            }

            updateBoard();
        }
    }

    public void rookMove(int x, int y, boolean clicked, String color) {
        if (clicked == false) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(false);
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);

            for (int i = x + 1; i < 8; i++) {
                if (buttonArray[i][y].getText() == "") {
                    buttonArray[i][y].setBackgroundResource(R.color.green);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.green);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = x - 1; i >= 0; i--) {
                if (buttonArray[i][y].getText() == "") {
                    buttonArray[i][y].setBackgroundResource(R.color.green);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.green);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y + 1; i < 8; i++) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.green);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.green);
                        buttonArray[x][i].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y - 1; i >= 0; i--) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.green);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.green);
                        buttonArray[x][i].setClickable(true);
                    }
                    break;
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);
        } else {
            pieceArray[x][y].setClicked(false);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(true);
                }
            }

            updateBoard();
        }
    }

    public void pawnMove(int x, int y, boolean clicked, String color) {
        if (clicked == false) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(false);
                }
            }

            if (color == "black") {

                if ( x < 7 && y < 7) {
                    if (buttonArray[x + 1][y + 1].getText() != null) {
                        if (pieceArray[x + 1][y + 1] != null && pieceArray[x + 1][y + 1].getColor() == "white") {
                            buttonArray[x + 1][y + 1].setClickable(true);
                            buttonArray[x + 1][y + 1].setBackgroundResource(R.color.green);
                        }
                    }
                }

                if ( x < 7 && y > 0) {
                    if (buttonArray[x + 1][y - 1].getText() != null) {
                        if (pieceArray[x + 1][y - 1] != null && pieceArray[x + 1][y - 1].getColor() == "white") {
                            buttonArray[x + 1][y - 1].setClickable(true);
                            buttonArray[x + 1][y - 1].setBackgroundResource(R.color.green);
                        }
                    }
                }

                if (buttonArray[x + 1][y].getText() == "") {
                    buttonArray[x + 1][y].setBackgroundResource(R.color.green);
                    buttonArray[x][y].setClickable(true);
                    buttonArray[x + 1][y].setClickable(true);

                    if ( x == 1  && buttonArray[x+2][y].getText() == ""){
                        buttonArray[x+2][y].setClickable(true);
                        buttonArray[x+2][y].setBackgroundResource(R.color.green);
                    }

                    pieceArray[x][y].setClicked(true);

                }

            } else {

                if ( y < 7 && x > 0) {
                    if (buttonArray[x - 1][y + 1].getText() != null) {
                        if (pieceArray[x - 1][y + 1] != null && pieceArray[x - 1][y + 1].getColor() == "black") {
                            buttonArray[x - 1][y + 1].setClickable(true);
                            buttonArray[x - 1][y + 1].setBackgroundResource(R.color.green);
                        }
                    }
                }

                if ( x > 0 && y > 0 ) {
                    if (buttonArray[x - 1][y - 1].getText() != null) {
                        if (pieceArray[x - 1][y - 1] != null && pieceArray[x - 1][y - 1].getColor() == "black") {
                            buttonArray[x - 1][y - 1].setClickable(true);
                            buttonArray[x - 1][y - 1].setBackgroundResource(R.color.green);
                        }
                    }
                }

                if (buttonArray[x - 1][y].getText() == "") {
                    buttonArray[x - 1][y].setBackgroundResource(R.color.green);
                    buttonArray[x][y].setClickable(true);
                    buttonArray[x - 1][y].setClickable(true);
                    setTextColor(buttonArray[x-1][y], pieceArray[x][y]);

                    if ( x == 6 && buttonArray[x-2][y].getText() == "") {
                        buttonArray[x-2][y].setClickable(true);
                        buttonArray[x-2][y].setBackgroundResource(R.color.green);
                    }

                    pieceArray[x][y].setClicked(true);
                }
            }

            buttonArray[x][y].setClickable(true);
            pieceArray[x][y].setClicked(true);
        } else {
            pieceArray[x][y].setClicked(false);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(true);
                }
            }

            updateBoard();
        }
    }

    public void changeTurn() {
        if (turn == 0) {
            turn = 1;
            turn_message.setText("Black's Turn");

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (pieceArray[i][j] != null && pieceArray[i][j].getColor() == "white") {
                        buttonArray[i][j].setClickable(false);
                    }
                }
            }
        } else if (turn == 1) {
            turn = 0;
            turn_message.setText("White's Turn");

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (pieceArray[i][j] != null && pieceArray[i][j].getColor() == "black") {
                        buttonArray[i][j].setClickable(false);
                    }
                }
            }
        }
    }

    public void emptySpaces(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                if ( buttonArray[i][j].getText() == ""){
                    buttonArray[i][j].setClickable(false);
                }
            }
        }
    }

    public void updateBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieceArray[i][j] != null) {
                    setTextColor(buttonArray[i][j], pieceArray[i][j]);
                }

                if (i % 2 == 0 && j % 2 == 0) {
                    buttonArray[i][j].setBackgroundResource(R.color.tan);
                } else if ( i % 2 == 0 && j % 2 != 0) {
                    buttonArray[i][j].setBackgroundResource(R.color.brown);
                } else if ( i % 2 != 0 && j % 2 == 0) {
                    buttonArray[i][j].setBackgroundResource(R.color.brown);
                } else {
                    buttonArray[i][j].setBackgroundResource(R.color.tan);
                }
            }
        }

        TextView black = (TextView) findViewById(R.id.black_pieces_captured);
        String blackStr = "Black pieces captured: ";
        TextView white = (TextView) findViewById(R.id.white_pieces_captured);
        String whiteStr = "White pieces captured: ";

        for (int i = 0; i < 16; i++) {
            if (whitePieceTaken[i] != null) {
                whiteStr = whiteStr + whitePieceTaken[i].getType();
            }

            if (blackPieceTaken[i] != null) {
                blackStr = blackStr + blackPieceTaken[i].getType();
            }
        }

        black.setText(blackStr);
        white.setText(whiteStr);

        if ( turn_message.getText() == "White Player Wins"  || turn_message.getText() == "Black Player Wins") {
            for ( int i = 0; i < 8; i++) {
                for ( int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(false);
                }
            }
        }


    }

    public void gameOver() {
        int kings = 0;

        for ( int i = 0; i < 8; i++) {
            for ( int j = 0; j < 8; j++ ) {
                if ( pieceArray[i][j] != null && pieceArray[i][j].getType() == "K" ) {
                    kings++;
                }
            }
        }

        if ( kings != 2 ) {
            for ( int i = 0; i < 8; i++) {
                for ( int j = 0; j < 8; j++) {
                    if ( pieceArray[i][j] != null && pieceArray[i][j].getType() == "K") {
                        if ( pieceArray[i][j].getColor() == "white") {
                            turn_message.setText("White Player Wins");
                        } else {
                            turn_message.setText("Black Player Wins");
                        }
                    }
                }
            }
            Toast.makeText(GameBoardActivity.this,"Game Over", Toast.LENGTH_LONG).show();
        }


    }
}
