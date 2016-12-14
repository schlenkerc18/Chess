package com.hfad.chess;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class GameBoardActivity extends Activity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25, button26, button27, button28, button29, button30, button31, button32, button33, button34, button35, button36, button37, button38, button39, button40, button41, button42, button43, button44, button45, button46, button47, button48, button49, button50, button51, button52, button53, button54, button55, button56, button57, button58, button59, button60, button61, button62, button63, button64;
    Button[][] buttonArray = new Button[8][8];
    Piece[][] pieceArray = new Piece[8][8];
    String[][] checkArray = new String[8][8];
    Piece[] pieces = new Piece[32];
    Piece[] whitePieceTaken = new Piece[16];
    Piece[] blackPieceTaken = new Piece[16];
    int turn = 0;
    TextView turn_message;
    //ChessDatabaseHelper myDB;
    String isLoad = "N";        //"N" = New Game, "L" = Load Game
    String loadPieceArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras == null){
            isLoad = "N";
        } else{
            isLoad = "L";
            loadPieceArray = extras.getString("LOAD_PIECES_ARRAY");
            Log.v("{}{}{}{}", loadPieceArray);
        }
        setContentView(R.layout.activity_game_board);
        turn_message = (TextView) findViewById(R.id.turn_message);
        turn_message.setText("White's Turn");
        //myDB = new ChessDatabaseHelper(this);

        if (isLoad == "N") {
            pieces[0] = pieceArray[0][0] = new Piece("\u265C", "black", 0, 0);
            pieces[1] = pieceArray[0][1] = new Piece("\u265E", "black", 0, 1);
            pieces[2] = pieceArray[0][2] = new Piece("\u265D", "black", 0, 2);
            pieces[3] = pieceArray[0][3] = new Piece("\u265B", "black", 0, 3);
            pieces[4] = pieceArray[0][4] = new Piece("\u265A", "black", 0, 4);
            pieces[5] = pieceArray[0][5] = new Piece("\u265D", "black", 0, 5);
            pieces[6] = pieceArray[0][6] = new Piece("\u265E", "black", 0, 6);
            pieces[7] = pieceArray[0][7] = new Piece("\u265C", "black", 0, 7);

            pieces[8] = pieceArray[1][0] = new Piece("\u265F", "black", 1, 0);
            pieces[9] = pieceArray[1][1] = new Piece("\u265F", "black", 1, 1);
            pieces[10] = pieceArray[1][2] = new Piece("\u265F", "black", 1, 2);
            pieces[11] = pieceArray[1][3] = new Piece("\u265F", "black", 1, 3);
            pieces[12] = pieceArray[1][4] = new Piece("\u265F", "black", 1, 4);
            pieces[13] = pieceArray[1][5] = new Piece("\u265F", "black", 1, 5);
            pieces[14] = pieceArray[1][6] = new Piece("\u265F", "black", 1, 6);
            pieces[15] = pieceArray[1][7] = new Piece("\u265F", "black", 1, 7);

            pieces[16] = pieceArray[6][0] = new Piece("\u2659", "white", 6, 0);
            pieces[17] = pieceArray[6][1] = new Piece("\u2659", "white", 6, 1);
            pieces[18] = pieceArray[6][2] = new Piece("\u2659", "white", 6, 2);
            pieces[19] = pieceArray[6][3] = new Piece("\u2659", "white", 6, 3);
            pieces[20] = pieceArray[6][4] = new Piece("\u2659", "white", 6, 4);
            pieces[21] = pieceArray[6][5] = new Piece("\u2659", "white", 6, 5);
            pieces[22] = pieceArray[6][6] = new Piece("\u2659", "white", 6, 6);
            pieces[23] = pieceArray[6][7] = new Piece("\u2659", "white", 6, 7);

            pieces[24] = pieceArray[7][0] = new Piece("\u2656", "white", 7, 0);
            pieces[25] = pieceArray[7][1] = new Piece("\u2658", "white", 7, 1);
            pieces[26] = pieceArray[7][2] = new Piece("\u2657", "white", 7, 2);
            pieces[27] = pieceArray[7][3] = new Piece("\u2654", "white", 7, 3);
            pieces[28] = pieceArray[7][4] = new Piece("\u2655", "white", 7, 4);
            pieces[29] = pieceArray[7][5] = new Piece("\u2657", "white", 7, 5);
            pieces[30] = pieceArray[7][6] = new Piece("\u2658", "white", 7, 6);
            pieces[31] = pieceArray[7][7] = new Piece("\u2656", "white", 7, 7);
        }

        else{
            String[] rawBDReadSplit = loadPieceArray.split(",");
            int regCounter = 0;
            int[] rank = new int[32];
            int[] file = new int[32];
            String[] type = new String[32];
            String color[] = new String[32];
            for (int i=0; regCounter < 32; i = i + 4) {
                file[regCounter] = Integer.parseInt(rawBDReadSplit[i].replaceAll("\\s+",""));
                regCounter++;
            }
            regCounter = 0;
            for (int i=1; regCounter < 32; i = i + 4) {
                rank[regCounter] = Integer.parseInt(rawBDReadSplit[i]);
                regCounter++;
            }
            regCounter = 0;
            for (int i=2; regCounter < 32; i = i + 4) {
                type[regCounter] = rawBDReadSplit[i];
                regCounter++;
            }
            regCounter = 0;
            for (int i=3; regCounter < 32; i = i + 4) {
                color[regCounter] = rawBDReadSplit[i];
                regCounter++;
            }
            for (int g=0; g < 32; g++){
                pieces[g] = pieceArray[rank[g]][file[g]] = new Piece(type[g], color[g], rank[g], file[g]);
            }
        }

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

        for (int i=0; i < 8; i++){
            for (int n=0; n < 8; n++){
                if (pieceArray[i][n] != null) {
                    buttonArray[i][n].setText(pieceArray[i][n].getType());
                }
            }
        }

        for (int i=0; i < 8; i++){
            for (int n=0; n < 8; n++){
                if (pieceArray[i][n] != null) {
                    buttonArray[i][n].setText(pieceArray[i][n].getType());
                    setTextColor(buttonArray[i][n], pieceArray[i][n]);
                }
            }
        }

        updateBoard();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure you want to exit? Any unsaved progress will be lost.");
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
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

        if (clicked == true && color != pieceArray[x][y].getColor() && (type == "\u2659" || type == "\u265F" || type == "\u2658" || type == "\u265E" || type == "\u2656" || type == "\u265C" || type == "\u2654" || type == "\u265A" || type == "\u2655" || type == "\u265B" || type == "\u2657" || type == "\u265D")) {
            takePiece(xVal, yVal);
        }

        if (type == "\u2659" || type == "\u265F") {
            pawnMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "") {
            moveToOpen(xVal, yVal);
        }

        if (type == "\u2656" || type == "\u265C") {
            rookMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "\u2658" || type == "\u265E") {
            knightMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "\u2654" || type == "\u265A") {
            kingMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "\u2657" || type == "\u265D"){
            bishopMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }

        if (type == "\u2655" || type == "\u265B") {
            queenMove(xVal, yVal, pieceArray[xVal][yVal].getClicked(), pieceArray[xVal][yVal].getColor());
        }
    }

    public void saveGame(View v){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < 8; i++){
            for (int n=0; n < 8; n++){
                if (pieceArray[i][n] != null) {
                    Log.v("________", Integer.toString(i));
                    Log.v("________", Integer.toString(n));
                    Log.v("#TYPE", pieceArray[i][n].getType());
                    Log.v("#COLO", pieceArray[i][n].getColor());
                    Log.v("#XLOC", Integer.toString(pieceArray[i][n].getXLoc()));
                    Log.v("#YLOC", Integer.toString(pieceArray[i][n].getYLOC()));
                    sb.append(Integer.toString(n)).append(",").append(Integer.toString(i)).append(",")
                            .append(pieceArray[i][n].getType()).append(",")
                            .append(pieceArray[i][n].getColor()).append(",");
                    Log.v("SBValue", sb.toString());
                }
            }
        }
        //boolean worked = myDB.insertData(sb.toString(), "", "");
        //Log.v("%%%%%%%", Boolean.toString(worked));

/*
        JSONArray JSONButtonsArray = new JSONArray(Arrays.asList(buttonArray));
        JSONArray JSONPiecesArray = new JSONArray(Arrays.asList(buttonArray));
        JSONArray JSONWhiteTakenArray = new JSONArray(Arrays.asList(buttonArray));
        JSONArray JSONBlackTakenArray = new JSONArray(Arrays.asList(buttonArray));
*/

    }

    public void takePiece(int x, int y) {
        int xVal = -1;
        int yVal = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieceArray[i][j] != null && pieceArray[i][j].getClicked() == true) {
                    //takingPiece = pieceArray[i][j];
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

        emptySpaces();
        changeTurn();
        updateBoard();
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

            if (x < 7 && buttonArray[x+1][y].getText() == "" && checkArray[x + 1][y] != "C"){
                buttonArray[x + 1][y].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x + 1][y].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 7) {
                if (pieceArray[x + 1][y] != null && pieceArray[x + 1][y].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x + 1][y].setClickable(true);
                    buttonArray[x + 1][y].setBackgroundResource(R.color.white);
                }
            }

            if (x > 0 && buttonArray[x-1][y].getText() == "" && checkArray[x - 1][y] != "C"){
                buttonArray[x-1][y].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 0 ) {
                if (pieceArray[x - 1][y] != null && pieceArray[x - 1][y].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x - 1][y].setClickable(true);
                    buttonArray[x - 1][y].setBackgroundResource(R.color.white);
                }
            }

            if (y < 7 && buttonArray[x][y+1].getText() == "" && checkArray[x][y + 1] != "C"){
                buttonArray[x][y+1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y < 7 ) {
                if (pieceArray[x][y + 1] != null && pieceArray[x][y + 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x][y + 1].setClickable(true);
                    buttonArray[x][y + 1].setBackgroundResource(R.color.white);
                }
            }

            if (y > 0 && buttonArray[x][y-1].getText() == "" && checkArray[x][y - 1] != "C"){
                buttonArray[x][y-1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y > 0) {
                if (pieceArray[x][y - 1] != null && pieceArray[x][y - 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x][y - 1].setClickable(true);
                    buttonArray[x][y - 1].setBackgroundResource(R.color.white);
                }
            }

            if ( y < 7 && x < 7  && buttonArray[x+1][y+1].getText() == "" && checkArray[x + 1][y + 1] != "C"){
                buttonArray[x+1][y+1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y < 7 && x < 7) {
                if (pieceArray[x + 1][y + 1] != null && pieceArray[x + 1][y + 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x + 1][y + 1].setClickable(true);
                    buttonArray[x + 1][y + 1].setBackgroundResource(R.color.white);
                }
            }

            if ( y > 0 && x > 0  && buttonArray[x-1][y-1].getText() == "" && checkArray[x - 1][y - 1] != "C"){
                buttonArray[x-1][y-1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y > 0 && x > 0) {
                if (pieceArray[x - 1][y - 1] != null && pieceArray[x - 1][y - 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x - 1][y - 1].setClickable(true);
                    buttonArray[x - 1][y - 1].setBackgroundResource(R.color.white);
                }
            }

            if ( y > 0 && x < 7  && buttonArray[x+1][y-1].getText() == "" && checkArray[x + 1][y - 1] != "C"){
                buttonArray[x+1][y-1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y>0 && x<7 ) {
                if (pieceArray[x + 1][y - 1] != null && pieceArray[x + 1][y - 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x + 1][y - 1].setClickable(true);
                    buttonArray[x + 1][y - 1].setBackgroundResource(R.color.white);
                }
            }

            if ( y < 7 && x > 0  && buttonArray[x-1][y+1].getText() == "" && checkArray[x - 1][y + 1] != "C"){
                buttonArray[x-1][y+1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( y<7 && x>0 ) {
                if (pieceArray[x - 1][y + 1] != null && pieceArray[x - 1][y + 1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x - 1][y + 1].setClickable(true);
                    buttonArray[x - 1][y + 1].setBackgroundResource(R.color.white);
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

            clearWhite();
            setClicks();
        }
    }

    public void markKing(int x, int y) {
        if ((x < 7 && buttonArray[x+1][y].getText() == "") || (x < 7 && pieceArray[x][y].getColor() == "black" && buttonArray[x+1][y].getText() == "\u2654") || (x < 7 && pieceArray[x][y].getColor() == "white" && buttonArray[x+1][y].getText() == "\u265A")){
            checkArray[x+1][y] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x+1) + " Y: " + Integer.toString(y));
        }

        if ((x > 0 && buttonArray[x-1][y].getText() == "") || (x > 0 && pieceArray[x][y].getColor() == "black" && buttonArray[x-1][y].getText() == "\u2654") || (x > 0 && pieceArray[x][y].getColor() == "white" && buttonArray[x-1][y].getText() == "\u265A")){
            checkArray[x-1][y] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x-1) + " Y: " + Integer.toString(y));
        }

        if ((y < 7 && buttonArray[x][y+1].getText() == "") || (y < 7 && pieceArray[x][y].getColor() == "black" && buttonArray[x][y+1].getText() == "\u2654") || (y < 7 && pieceArray[x][y].getColor() == "white" && buttonArray[x][y+1].getText() == "\u265A")) {
            checkArray[x][y+1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x) + " Y: " + Integer.toString(y+1));
        }

        if ((y > 0 && buttonArray[x][y-1].getText() == "") || (y > 0 && pieceArray[x][y].getColor() == "black" && buttonArray[x][y-1].getText() == "\u2654") || (y > 0 && pieceArray[x][y].getColor() == "white" && buttonArray[x][y-1].getText() == "\u265A")) {
            checkArray[x][y-1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x) + " Y: " + Integer.toString(y-1));
        }

        if ((y < 7 && x < 7  && buttonArray[x+1][y+1].getText() == "") || (y < 7 && x < 7  && pieceArray[x][y].getColor() == "black" && buttonArray[x+1][y+1].getText() == "\u2654") || (y < 7 && x < 7  && pieceArray[x][y].getColor() == "white" && buttonArray[x+1][y+1].getText() == "\u265A")) {
            checkArray[x+1][y+1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x+1) + " Y: " + Integer.toString(y+1));
        }

        if ((y > 0 && x > 0  && buttonArray[x-1][y-1].getText() == "") || (y > 0 && x > 0  && pieceArray[x][y].getColor() == "black" && buttonArray[x-1][y-1].getText() == "\u2654") || (y > 0 && x > 0  && pieceArray[x][y].getColor() == "white" && buttonArray[x-1][y-1].getText() == "\u265A")) {
            checkArray[x-1][y-1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x-1) + " Y: " + Integer.toString(y-1));
        }

        if ((y > 0 && x < 7  && buttonArray[x+1][y-1].getText() == "") || (y > 0 && x < 7  && pieceArray[x][y].getColor() == "black" && buttonArray[x+1][y-1].getText() == "\u2654") || (y > 0 && x < 7  && pieceArray[x][y].getColor() == "white" && buttonArray[x+1][y-1].getText() == "\u265A")) {
            checkArray[x+1][y-1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x) + " Y: " + Integer.toString(y));
        }

        if ((y < 7 && x > 0  && buttonArray[x-1][y+1].getText() == "") || (y < 7 && x > 0  && pieceArray[x][y].getColor() == "black" && buttonArray[x-1][y+1].getText() == "\u2654") || (y < 7 && x > 0  && pieceArray[x][y].getColor() == "white" && buttonArray[x-1][y+1].getText() == "\u265A")) {
            checkArray[x-1][y+1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x-1) + " Y: " + Integer.toString(y+1));
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
                buttonArray[x+2][y+1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+2][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 6 && y < 7) {
                if ( pieceArray[x+2][y+1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+2][y+1].setClickable(true);
                    buttonArray[x+2][y+1].setBackgroundResource(R.color.white);
                }
            }

            if ( x < 6 && y > 0 && buttonArray[x+2][y-1].getText() == ""){
                buttonArray[x+2][y-1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+2][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 6 && y > 0) {
                if ( pieceArray[x+2][y-1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+2][y-1].setClickable(true);
                    buttonArray[x+2][y-1].setBackgroundResource(R.color.white);
                }
            }

            if ( x > 1 && y < 7 && buttonArray[x-2][y+1].getText() == ""){
                buttonArray[x-2][y+1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-2][y+1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 1 && y < 7) {
                if ( pieceArray[x-2][y+1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-2][y+1].setClickable(true);
                    buttonArray[x-2][y+1].setBackgroundResource(R.color.white);
                }
            }

            if ( x > 1 && y > 0 && buttonArray[x-2][y-1].getText() == ""){
                buttonArray[x-2][y-1].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-2][y-1].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 1 && y > 0) {
                if ( pieceArray[x-2][y-1].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-2][y-1].setClickable(true);
                    buttonArray[x-2][y-1].setBackgroundResource(R.color.white);
                }
            }

            if ( x < 7 && y < 6 && buttonArray[x+1][y+2].getText() == ""){
                buttonArray[x+1][y+2].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y+2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 7 && y < 6) {
                if ( pieceArray[x+1][y+2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+1][y+2].setClickable(true);
                    buttonArray[x+1][y+2].setBackgroundResource(R.color.white);
                }
            }

            if ( x < 7 && y > 1 && buttonArray[x+1][y-2].getText() == ""){
                buttonArray[x+1][y-2].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x+1][y-2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x < 7 && y > 1) {
                if ( pieceArray[x+1][y-2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x+1][y-2].setClickable(true);
                    buttonArray[x+1][y-2].setBackgroundResource(R.color.white);
                }
            }

            if ( x > 0 && y < 6 && buttonArray[x-1][y+2].getText() == ""){
                buttonArray[x-1][y+2].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y+2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 0 && y < 6) {
                if ( pieceArray[x-1][y+2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-1][y+2].setClickable(true);
                    buttonArray[x-1][y+2].setBackgroundResource(R.color.white);
                }
            }

            if ( x > 0 && y > 1 && buttonArray[x-1][y-2].getText() == ""){
                buttonArray[x-1][y-2].setBackgroundResource(R.color.white);
                buttonArray[x][y].setClickable(true);
                buttonArray[x-1][y-2].setClickable(true);
                pieceArray[x][y].setClicked(true);
            } else if ( x > 0 && y > 1) {
                if ( pieceArray[x-1][y-2].getColor() != pieceArray[x][y].getColor()) {
                    buttonArray[x-1][y-2].setClickable(true);
                    buttonArray[x-1][y-2].setBackgroundResource(R.color.white);
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

            clearWhite();
            setClicks();
        }
    }

    public void markKnight(int x, int y) {
        if ((x < 6 && y < 7 && buttonArray[x+2][y+1].getText() == "") || (x < 6 && y < 7 && pieceArray[x][y].getColor() == "black" && buttonArray[x+2][y+1].getText() == "\u2654") || (x < 6 && y < 7 && pieceArray[x][y].getColor() == "white" && buttonArray[x+2][y+1].getText() == "\u265A")) {
            checkArray[x+2][y+1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x+2) + " Y: " + Integer.toString(y+1));
        }

        if ((x < 6 && y > 0 && buttonArray[x+2][y-1].getText() == "") || (x < 6 && y > 0 && pieceArray[x][y].getColor() == "black" && buttonArray[x+2][y-1].getText() == "\u2654") || (x < 6 && y > 0 && pieceArray[x][y].getColor() == "white" && buttonArray[x+2][y-1].getText() == "\u265A")) {
            checkArray[x+2][y-1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x+2) + " Y: " + Integer.toString(y-1));
        }

        if ((x > 1 && y < 7 && buttonArray[x-2][y+1].getText() == "") || (x > 1 && y < 7 && pieceArray[x][y].getColor() == "black" && buttonArray[x-2][y+1].getText() == "\u2654") || (x > 1 && y < 7 && pieceArray[x][y].getColor() == "white" && buttonArray[x-2][y+1].getText() == "\u265A")) {
            checkArray[x-2][y+1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x-2) + " Y: " + Integer.toString(y+1));
        }

        if ((x > 1 && y > 0 && buttonArray[x-2][y-1].getText() == "") || (x > 1 && y > 0 && pieceArray[x][y].getColor() == "black" && buttonArray[x-2][y-1].getText() == "\u2654") || (x > 1 && y > 0 && pieceArray[x][y].getColor() == "white" && buttonArray[x-2][y-1].getText() == "\u265A")) {
            checkArray[x-2][y-1] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x-2) + " Y: " + Integer.toString(y-1));
        }

        if ((x < 7 && y < 6 && buttonArray[x+1][y+2].getText() == "") || (x < 7 && y < 6 && pieceArray[x][y].getColor() == "black" && buttonArray[x+1][y+2].getText() == "\u2654") || (x < 7 && y < 6 && pieceArray[x][y].getColor() == "white" && buttonArray[x+1][y+2].getText() == "\u265A")) {
            checkArray[x+1][y+2] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x+1) + " Y: " + Integer.toString(y+2));
        }

        if ((x < 7 && y > 1 && buttonArray[x+1][y-2].getText() == "") || (x < 7 && y > 1 && pieceArray[x][y].getColor() == "black" && buttonArray[x+1][y-2].getText() == "\u2654") || (x < 7 && y > 1 && pieceArray[x][y].getColor() == "white" && buttonArray[x+1][y-2].getText() == "\u265A")) {
            checkArray[x+1][y-2] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x+1) + " Y: " + Integer.toString(y-2));
        }

        if ((x > 0 && y < 6 && buttonArray[x-1][y+2].getText() == "") || (x > 0 && y < 6 && pieceArray[x][y].getColor() == "black" && buttonArray[x-1][y+2].getText() == "\u2654") || (x > 0 && y < 6 && pieceArray[x][y].getColor() == "white" && buttonArray[x-1][y+2].getText() == "\u265A")) {
            checkArray[x-1][y+2] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x-1) + " Y: " + Integer.toString(y+2));
        }

        if ((x > 0 && y > 1 && buttonArray[x-1][y-2].getText() == "") || (x > 0 && y > 1 && pieceArray[x][y].getColor() == "black" && buttonArray[x-1][y-2].getText() == "\u2654") || (x > 0 && y > 1 && pieceArray[x][y].getColor() == "white" && buttonArray[x-1][y-2].getText() == "\u265A")) {
            checkArray[x-1][y-2] = "C";
            Log.v("test", "CHECK @ X: " + Integer.toString(x-1) + " Y: " + Integer.toString(y-2));
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
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal + 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal + 1 < 8) {
                    if (buttonArray[i][yVal + 1].getText() == "") {
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal + 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x + 1; i < 8; i++) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal - 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal - 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
                }
            }

            for (int i = x + 1; i < 8; i++) {
                if (buttonArray[i][y].getText() == "") {
                    buttonArray[i][y].setBackgroundResource(R.color.white);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.white);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = x - 1; i >= 0; i--) {
                if (buttonArray[i][y].getText() == "") {
                    buttonArray[i][y].setBackgroundResource(R.color.white);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.white);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y + 1; i < 8; i++) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.white);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.white);
                        buttonArray[x][i].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y - 1; i >= 0; i--) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.white);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.white);
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

            clearWhite();
            setClicks();
        }

    }

    public void markQueen(int x, int y) {
        int yVal = y;

        for (int i = x + 1; i < 8; i++) {
            if (yVal + 1 < 8) {
                if ((buttonArray[i][yVal + 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal + 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal + 1].getText() == "\u265A")) {
                    checkArray[i][yVal +1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal+1));
                    yVal++;
                } else {
                    break;
                }
            }
        }

        yVal = y;

        for (int i = x - 1; i >= 0; i--) {
            if (yVal + 1 < 8) {
                if ((buttonArray[i][yVal + 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal + 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal + 1].getText() == "\u265A")) {
                    checkArray[i][yVal + 1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal+1));
                    yVal++;
                } else {
                    break;
                }
            }
        }

        yVal = y;

        for (int i = x + 1; i < 8; i++) {
            if (yVal - 1 >= 0) {
                if ((buttonArray[i][yVal - 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal - 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal - 1].getText() == "\u265A")) {
                    checkArray[i][yVal - 1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal-1));
                    yVal--;
                } else {
                    break;
                }
            }
        }

        yVal = y;

        for (int i = x - 1; i >= 0; i--) {
            if (yVal - 1 >= 0) {
                if ((buttonArray[i][yVal - 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal - 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal - 1].getText() == "\u265A")) {
                    checkArray[i][yVal - 1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal-1));
                    yVal--;
                } else {
                    break;
                }
            }
        }

        for (int i = x + 1; i < 8; i++) {
            if ((buttonArray[i][y].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][y].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][y].getText() == "\u265A")) {
                checkArray[i][y] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(y));
            } else {
                break;
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            if ((buttonArray[i][y].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][y].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][y].getText() == "\u265A")) {
                checkArray[i][y] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(y));
            } else {
                break;
            }
        }

        for (int i = y + 1; i < 8; i++) {
            if ((buttonArray[x][i].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[x][i].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[x][i].getText() == "\u265A")) {
                checkArray[x][i] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(x) + " Y: " + Integer.toString(i));
            } else {
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if ((buttonArray[x][i].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[x][i].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[x][i].getText() == "\u265A")) {
                checkArray[x][i] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(x) + " Y: " + Integer.toString(i));
            } else {
                break;
            }
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
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal + 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal + 1 < 8) {
                    if (buttonArray[i][yVal + 1].getText() == "") {
                        buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal + 1].setClickable(true);
                        yVal++;
                    } else {
                        if ( pieceArray[i][yVal +1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal + 1].setClickable(true);
                            buttonArray[i][yVal + 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x + 1; i < 8; i++) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal - 1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
                }
            }

            yVal = y;

            for (int i = x - 1; i >= 0; i--) {
                if (yVal - 1 >= 0) {
                    if (buttonArray[i][yVal - 1].getText() == "") {
                        buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        buttonArray[i][yVal - 1].setClickable(true);
                        yVal--;
                    } else {
                        if ( pieceArray[i][yVal -1].getColor() != pieceArray[x][y].getColor()) {
                            buttonArray[i][yVal - 1].setClickable(true);
                            buttonArray[i][yVal - 1].setBackgroundResource(R.color.white);
                        }
                        break;
                    }
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

            clearWhite();
            setClicks();
        }
    }

    public void markBishop(int x , int y) {
        int yVal = y;

        for (int i = x + 1; i < 8; i++) {
            if (yVal + 1 < 8) {
                if ((buttonArray[i][yVal + 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal + 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal + 1].getText() == "\u265A")) {
                    checkArray[i][yVal + 1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal+1));
                    yVal++;
                } else {
                    break;
                }
            }
        }

        yVal = y;

        for (int i = x - 1; i >= 0; i--) {
            if (yVal + 1 < 8) {
                if ((buttonArray[i][yVal + 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal + 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal + 1].getText() == "\u265A")) {
                    checkArray[i][yVal + 1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal+1));
                    yVal++;
                } else {
                    break;
                }
            }
        }

        yVal = y;

        for (int i = x + 1; i < 8; i++) {
            if (yVal - 1 >= 0) {
                if ((buttonArray[i][yVal - 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal - 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal - 1].getText() == "\u265A")) {
                    checkArray[i][yVal - 1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal-1));
                    yVal--;
                } else {
                    break;
                }
            }
        }

        yVal = y;

        for (int i = x - 1; i >= 0; i--) {
            if (yVal - 1 >= 0) {
                if ((buttonArray[i][yVal - 1].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][yVal - 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][yVal - 1].getText() == "\u265A")) {
                    checkArray[i][yVal - 1] = "C";
                    Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(yVal-1));
                    yVal--;
                } else {
                    break;
                }
            }
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
                    buttonArray[i][y].setBackgroundResource(R.color.white);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.white);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = x - 1; i >= 0; i--) {
                if (buttonArray[i][y].getText() == "") {
                    buttonArray[i][y].setBackgroundResource(R.color.white);
                    buttonArray[i][y].setClickable(true);
                } else {
                    if ( pieceArray[i][y].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[i][y].setBackgroundResource(R.color.white);
                        buttonArray[i][y].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y + 1; i < 8; i++) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.white);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.white);
                        buttonArray[x][i].setClickable(true);
                    }
                    break;
                }
            }

            for (int i = y - 1; i >= 0; i--) {
                if (buttonArray[x][i].getText() == "") {
                    buttonArray[x][i].setBackgroundResource(R.color.white);
                    buttonArray[x][i].setClickable(true);
                } else {
                    if ( pieceArray[x][i].getColor() != pieceArray[x][y].getColor()) {
                        buttonArray[x][i].setBackgroundResource(R.color.white);
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

            clearWhite();
            setClicks();
        }
    }

    public void markRook(int x, int y) {
        for (int i = x + 1; i < 8; i++) {
            if ((buttonArray[i][y].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][y].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][y].getText() == "\u265A")) {
                checkArray[i][y] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(y));
            } else {
                break;
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            if ((buttonArray[i][y].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[i][y].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[i][y].getText() == "\u265A")) {
                checkArray[i][y] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(i) + " Y: " + Integer.toString(y));
            } else {
                break;
            }
        }

        for (int i = y + 1; i < 8; i++) {
            if ((buttonArray[x][i].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[x][i].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[x][i].getText() == "\u265A")) {
                checkArray[x][i] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(x) + " Y: " + Integer.toString(i));
            } else {
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if ((buttonArray[x][i].getText() == "") || (pieceArray[x][y].getColor() == "black" && buttonArray[x][i].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[x][i].getText() == "\u265A")) {
                checkArray[x][i] = "C";
                Log.v("test", "CHECK @ X: " + Integer.toString(x) + " Y: " + Integer.toString(i));
            } else {
                break;
            }
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
                            buttonArray[x + 1][y + 1].setBackgroundResource(R.color.white);
                            //buttonArray[x + 1][y + 1].setText("\u2219");
                        }
                    }
                }

                if ( x < 7 && y > 0) {
                    if (buttonArray[x + 1][y - 1].getText() != null) {
                        if (pieceArray[x + 1][y - 1] != null && pieceArray[x + 1][y - 1].getColor() == "white") {
                            buttonArray[x + 1][y - 1].setClickable(true);
                            buttonArray[x + 1][y - 1].setBackgroundResource(R.color.white);
                            //buttonArray[x + 1][y - 1].setText("\u2219");
                        }
                    }
                }

                if (buttonArray[x + 1][y].getText() == "") {
                    buttonArray[x + 1][y].setBackgroundResource(R.color.white);
                    //buttonArray[x + 1][y].setText("\u2219");
                    buttonArray[x][y].setClickable(true);
                    buttonArray[x + 1][y].setClickable(true);

                    if ( x == 1  && buttonArray[x+2][y].getText() == ""){
                        buttonArray[x+2][y].setClickable(true);
                        buttonArray[x+2][y].setBackgroundResource(R.color.white);
                        //buttonArray[x + 2][y].setText("\u2219");
                    }

                    pieceArray[x][y].setClicked(true);

                }

            } else {

                if ( y < 7 && x > 0) {
                    if (buttonArray[x - 1][y + 1].getText() != null) {
                        if (pieceArray[x - 1][y + 1] != null && pieceArray[x - 1][y + 1].getColor() == "black") {
                            buttonArray[x - 1][y + 1].setClickable(true);
                            buttonArray[x - 1][y + 1].setBackgroundResource(R.color.white);
                            //buttonArray[x - 1][y + 1].setText("\u2219");
                        }
                    }
                }

                if ( x > 0 && y > 0 ) {
                    if (buttonArray[x - 1][y - 1].getText() != null) {
                        if (pieceArray[x - 1][y - 1] != null && pieceArray[x - 1][y - 1].getColor() == "black") {
                            buttonArray[x - 1][y - 1].setClickable(true);
                            buttonArray[x - 1][y - 1].setBackgroundResource(R.color.white);
                            //buttonArray[x - 1][y - 1].setText("\u2219");
                        }
                    }
                }

                if (buttonArray[x - 1][y].getText() == "") {
                    buttonArray[x - 1][y].setBackgroundResource(R.color.white);
                    //buttonArray[x - 1][y].setText("\u2219");
                    buttonArray[x][y].setClickable(true);
                    buttonArray[x - 1][y].setClickable(true);
                    setTextColor(buttonArray[x-1][y], pieceArray[x][y]);

                    if ( x == 6 && buttonArray[x-2][y].getText() == "") {
                        buttonArray[x-2][y].setClickable(true);
                        buttonArray[x-2][y].setBackgroundResource(R.color.white);
                        //buttonArray[x - 2][y].setText("\u2219");

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

            clearWhite();
            setClicks();
        }
    }

    public void markPawn(int x, int y, String color) {


        if (color == "black") {

            if ( x < 7 && y < 7) {
                if ((buttonArray[x + 1][y + 1].getText() == "") || (buttonArray[x + 1][y + 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[x + 1][y + 1].getText() == "\u265A")) {
                    //if ((buttonArray[x + 1][y + 1].getText() == "" || buttonArray[x + 1][y + 1].getText() == "\u2654") && pieceArray[x + 1][y + 1] != null && pieceArray[x + 1][y + 1].getColor() == "white") {
                        Log.v("test", "/////////// markPawn to right called");
                        checkArray[x + 1][y + 1] = "C";
                        Log.v("test", "CHECK @ X: " + Integer.toString(x+1) + " Y: " + Integer.toString(y+1));
                    //}
                }
            }

            if ( x < 7 && y > 0) {
                if ((buttonArray[x + 1][y - 1].getText() == "") || (buttonArray[x + 1][y - 1].getText() == "\u2654") || (pieceArray[x][y].getColor() == "white" && buttonArray[x + 1][y - 1].getText() == "\u265A")) {
                        Log.v("test", "/////////// markPawn to left called");
                        checkArray[x + 1][y - 1] = "C";
                        Log.v("test", "CHECK @ X: " + Integer.toString(x+1) + " Y: " + Integer.toString(y-1));
                }
            }

        } else {
            if ( y < 7 && x > 0) {
                if ((buttonArray[x - 1][y + 1].getText() == "") || (buttonArray[x - 1][y + 1].getText() == "\u265A") || (pieceArray[x][y].getColor() == "white" && buttonArray[x - 1][y + 1].getText() == "\u265A")) {
                        checkArray[x - 1][y + 1] = "C";
                        Log.v("test", "CHECK @ X: " + Integer.toString(x-1) + " Y: " + Integer.toString(y+1));
                }
            }

            if ( x > 0 && y > 0 ) {
                if ((buttonArray[x - 1][y - 1].getText() == "") || (buttonArray[x - 1][y - 1].getText() == "\u265A") || (pieceArray[x][y].getColor() == "white" && buttonArray[x - 1][y - 1].getText() == "\u265A")) {
                        checkArray[x - 1][y - 1] = "C";
                        Log.v("test", "CHECK @ X: " + Integer.toString(x-1) + " Y: " + Integer.toString(y-1));
                }
            }
        }
    }

    public void check() {
        if (turn == 0) {
            for (int i = 7; i >= 0; i--) {
                for (int j = 7; j >= 0; j--) {
                    if (buttonArray[i][j].getText() == "\u265A") {
                        markKing(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u265B") {
                        markQueen(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u265C") {
                        markRook(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u265D") {
                        markBishop(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u265E") {
                        markKnight(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u265F") {
                        markPawn(i, j, pieceArray[i][j].getColor());
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "\u2654") {
                        markKing(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u2655") {
                        markQueen(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u2656") {
                        markRook(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u2657") {
                        markBishop(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u2658") {
                        markKnight(i, j);
                    }

                    if (buttonArray[i][j].getText() == "\u2659") {
                        markPawn(i, j, pieceArray[i][j].getColor());
                    }
                }
            }
        }
    }

    public void clearCheck() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                checkArray[i][j] = null;
            }
        }
    }

    public void changeTurn() {
        int counter = 0;

        if (turn == 0) {
            turn = 1;
            turn_message.setText("Black's Turn");

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "\u2654" || buttonArray[i][j].getText() == "\u2655" || buttonArray[i][j].getText() == "\u2656" || buttonArray[i][j].getText() == "\u2657" || buttonArray[i][j].getText() == "\u2658" || buttonArray[i][j].getText() == "\u2659" || buttonArray[i][j].getText() == "") {
                        buttonArray[i][j].setClickable(false);
                        counter++;
                    }
                }
            }
        } else {
            turn = 0;
            turn_message.setText("White's Turn");

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "\u265A" || buttonArray[i][j].getText() == "\u265B" || buttonArray[i][j].getText() == "\u265C" || buttonArray[i][j].getText() == "\u265D" || buttonArray[i][j].getText() == "\u265E" || buttonArray[i][j].getText() == "\u265F" || buttonArray[i][j].getText() == "") {
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

        clearWhite();
        clearCheck();
        check();
        checkKing();
        checkmateKing();
        showCs();

        if ( turn_message.getText() == "White Player Wins"  || turn_message.getText() == "Black Player Wins") {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttonArray[i][j].setClickable(false);
                }
            }
        }
    }

    public void gameOver() {
        int kings = 0;

        for ( int i = 0; i < 8; i++) {
            for ( int j = 0; j < 8; j++ ) {
                if ( pieceArray[i][j] != null && (pieceArray[i][j].getType() == "\u2654" || pieceArray[i][j].getType() == "\u265A") ) {
                    kings++;
                }
            }
        }

        if ( kings != 2 ) {
            for ( int i = 0; i < 8; i++) {
                for ( int j = 0; j < 8; j++) {
                    if ( pieceArray[i][j] != null && (pieceArray[i][j].getType() == "\u2654" || pieceArray[i][j].getType() == "\u265A")) {
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

    public void clearWhite() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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
    }

    public void setClicks() {
        if (turn == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "" || (pieceArray[i][j] != null && pieceArray[i][j].getColor() == "black")) {
                        buttonArray[i][j].setClickable(false);
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "" || (pieceArray[i][j] != null && pieceArray[i][j].getColor() == "white")) {
                        buttonArray[i][j].setClickable(false);
                    }
                }
            }
        }
    }

    public void checkmateKing() {
        int counter = 0;
        int checks = 0;
        int x = -1;
        int y = -1;

        if (turn == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "\u2654") {
                        x = i;
                        y = j;
                    }
                }
            }

            if (x < 7 && buttonArray[x + 1][y].getText() == "") {
                counter++;

                if (checkArray[x + 1][y] == "C") {
                    checks++;
                }
            }

            if (x < 7 && y < 7 && buttonArray[x + 1][y + 1].getText() == "") {
                counter++;

                if (checkArray[x + 1][y + 1] == "C") {
                    checks++;
                }
            }

            if (y < 7 && buttonArray[x][y + 1].getText() == "") {
                counter++;

                if (checkArray[x][y + 1] == "C") {
                    checks++;
                }
            }

            if (y > 0 && buttonArray[x][y - 1].getText() == "") {
                counter++;

                if (checkArray[x][y - 1] == "C") {
                    checks++;
                }
            }

            if (x < 7 && y > 0 && buttonArray[x + 1][y - 1].getText() == "") {
                counter++;

                if (checkArray[x + 1][y - 1] == "C") {
                    checks++;
                }
            }

            if (x > 0 && buttonArray[x - 1][y].getText() == "") {
                counter++;

                if (checkArray[x - 1][y] == "C") {
                    checks++;
                }
            }

            if (x > 0 && y > 0 && buttonArray[x - 1][y - 1].getText() == "") {
                counter++;

                if (checkArray[x - 1][y - 1] == "C") {
                    checks++;
                }
            }

            if (x > 0 && y < 7 && buttonArray[x - 1][y + 1].getText() == "") {
                counter++;

                if (checkArray[x - 1][y + 1] == "C") {
                    checks++;
                }
            }

            if (checks != 0 && counter != 0 && checks == counter) {
                Toast.makeText(GameBoardActivity.this, "Checkmate!", Toast.LENGTH_LONG).show();
                turn_message.setText("Black Player Wins");

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        buttonArray[i][j].setClickable(false);
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "\u265A") {
                        x = i;
                        y = j;
                    }
                }
            }

            if (x < 7 && buttonArray[x + 1][y].getText() == "") {
                counter++;

                if (checkArray[x + 1][y] == "C") {
                    checks++;
                }
            }

            if (x < 7 && y < 7 && buttonArray[x + 1][y + 1].getText() == "") {
                counter++;

                if (checkArray[x + 1][y + 1] == "C") {
                    checks++;
                }
            }

            if (y < 7 && buttonArray[x][y + 1].getText() == "") {
                counter++;

                if (checkArray[x][y + 1] == "C") {
                    checks++;
                }
            }

            if (y > 0 && buttonArray[x][y - 1].getText() == "") {
                counter++;

                if (checkArray[x][y - 1] == "C") {
                    checks++;
                }
            }

            if (x < 7 && y > 0 && buttonArray[x + 1][y - 1].getText() == "") {
                counter++;

                if (checkArray[x + 1][y - 1] == "C") {
                    checks++;
                }
            }

            if (x > 0 && buttonArray[x - 1][y].getText() == "") {
                counter++;

                if (checkArray[x - 1][y] == "C") {
                    checks++;
                }
            }

            if (x > 0 && y > 0 && buttonArray[x - 1][y - 1].getText() == "") {
                counter++;

                if (checkArray[x - 1][y - 1] == "C") {
                    checks++;
                }
            }

            if (x > 0 && y < 7 && buttonArray[x - 1][y + 1].getText() == "") {
                counter++;

                if (checkArray[x - 1][y + 1] == "C") {
                    checks++;
                }
            }

            if (checks != 0 && counter != 0 && checks == counter) {
                Toast.makeText(GameBoardActivity.this, "Checkmate!", Toast.LENGTH_LONG).show();
                turn_message.setText("White Player Wins");

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        buttonArray[i][j].setClickable(false);
                    }
                }
            }
        }
    }

    public void checkKing() {
        if (turn == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "\u2654" && checkArray[i][j] == "C") {
                        Toast.makeText(GameBoardActivity.this, "Check!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttonArray[i][j].getText() == "\u265A" && checkArray[i][j] == "C") {
                        Toast.makeText(GameBoardActivity.this, "Check!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    public void showCs() {
        String str = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (checkArray[i][j] == "C") {
                    str = str + "[" + checkArray[i][j] + "]";
                }

                if (checkArray[i][j] == null) {
                    str = str + "[ ]";
                }
            }

            str = str + "\n";
        }

        Log.v("test", str);
    }
    
    public void promotePawn() {
        for ( int i = 0; i < 8; i++ ){
            if (pieceArray[0][i] != null && pieceArray[0][i].getType() == "\u2659" ) {

                AlertDialog alertDialog = new AlertDialog.Builder(GameBoardActivity.this).create();
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Promote your pawn:");
                final int finalI = i;
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "\u2655", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        buttonArray[0][finalI].setText("\u2655");
                        pieceArray[0][finalI].changeType("\u2655");
                    }
                });

                alertDialog.show();
            }

        }

        for ( int i = 0; i < 8; i++ ){
            if ( pieceArray[7][i] != null && pieceArray[7][i].getType() == "\u265F" ) {

                AlertDialog alertDialog = new AlertDialog.Builder(GameBoardActivity.this).create();
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Promote your pawn:");
                final int finalI = i;
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "\u265B", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        buttonArray[7][finalI].setText("\u265B");
                        pieceArray[7][finalI].changeType("\u265B");
                    }
                });

                alertDialog.show();
            }

        }

    }
    
}
