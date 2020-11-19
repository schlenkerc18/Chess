package com.hfad.chess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartGame extends Activity {

    String user = null;
    //TextView user;
    TextView nameDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        user = extras.getString("USER_NAME");
        setContentView(R.layout.activity_main);
        nameDisplay = (TextView) findViewById(R.id.USER);
        nameDisplay.setText(user);
    }

    public void onNewGameClicked(View view) {
        Intent intent = new Intent(StartGame.this, GameBoardActivity.class);
        intent.putExtra("USER_NAME", user);
        startActivity(intent);
    }

    public void onLoadSavedGameClicked(View view) {
        Intent intent = new Intent(StartGame.this, LoadSavedGameActivity.class);
        intent.putExtra("USER_NAME", user);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure you want to log out?");
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
                Intent intent = new Intent(StartGame.this, LogInScreen.class);
                startActivity(intent);
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

    public void onLogOut(View v) {
        Intent intent = new Intent(StartGame.this, LogInScreen.class);
        startActivity(intent);
    }


}
