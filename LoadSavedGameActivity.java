package com.hfad.chess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoadSavedGameActivity extends Activity {

    ChessDatabaseHelper myDB;
    EditText gameID;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        user = extras.getString("USER_NAME");
        setContentView(R.layout.activity_load_saved_game);
        myDB = new ChessDatabaseHelper(this);
        gameID = (EditText) findViewById(R.id.gameID);

    }

    public void displayGames(){
        myDB = new ChessDatabaseHelper(this);
        Cursor res = myDB.getGames();
        StringBuilder buffer = new StringBuilder();
        if (res.getCount() == 0){
            return;
        }
        else {
            while (res.moveToNext()) {
                buffer.append(res.getString(0));
            }
        }
    }

    public void loadGame(View v){
        int saveNum = Integer.parseInt(gameID.getText().toString());
        //myDB = new ChessDatabaseHelper(this);
        Cursor myGames = myDB.getUserName(saveNum);
        Cursor res = myDB.getPieceArray(saveNum);
        Cursor res1 = myDB.getWTaken(saveNum);
        Cursor res2 = myDB.getBTaken(saveNum);
        while (myGames.moveToNext()) {
            if ( myGames.getString(0).equals(user)) {
                if (res.getCount() == 0){
                    return;
                } else{
                    StringBuilder buffer = new StringBuilder();
                    StringBuilder buffer1 = new StringBuilder();
                    StringBuilder buffer2 = new StringBuilder();
                    while (res.moveToNext()) {
                        buffer.append(res.getString(0));
                    }
                    while (res.moveToNext()) {
                        buffer.append(res1.getString(0));
                    }
                    while (res.moveToNext()) {
                        buffer.append(res2.getString(0));
                    }
                    String pieceArray = buffer.toString();
                    String WTaken = buffer1.toString();
                    String BTaken = buffer2.toString();
                    Intent intent = new Intent(LoadSavedGameActivity.this, GameBoardActivity.class);
                    intent.putExtra("LOAD_PIECES_ARRAY", pieceArray);
                    intent.putExtra("LOAD_WHITE_TAKE", WTaken);
                    intent.putExtra("LOAD_BLACK_TAKEN", BTaken);
                    intent.putExtra("LOAD_NUM", saveNum);
                    intent.putExtra("USER_NAME", user);
                    startActivity(intent);
                }
            }
        }
        displayGames();
    }

    public void onDeleteGame(View v) {
        int deletedRows = myDB.deleteGame(Integer.parseInt(gameID.getText().toString()));
        if ( deletedRows > 0) {
            Toast.makeText(LoadSavedGameActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoadSavedGameActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
        }
    }

    public void onBackButton(View v) {
        Intent intent = new Intent(LoadSavedGameActivity.this, StartGame.class);
        intent.putExtra("USER_NAME", user);
        startActivity(intent);
    }

    public void onShowGames(View v) {
        Cursor res = myDB.getGames();
        if ( res.getCount() == 0 ) {
            showGames("Error", "No Games Found");
            return;
        }

        int k = 0;
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            if ( res.getString(4).equals(user)) {
                buffer.append("Game ID: " + res.getString(0) + "\n\n");
                k = 1;
            }
        }
        if (k == 0){
            showGames("Error", "No Games Found");
            return;
        }

        showGames("Games:", buffer.toString());
    }

    public void showGames(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
