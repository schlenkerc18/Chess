

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

public class LogInScreen extends Activity {

    LogInDatabaseHelper myDB;
    String psWd = null;
    TextView inv_user;
    EditText usrName;
    EditText passWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
        inv_user = (TextView) findViewById(R.id.inv_user);
        usrName = (EditText) findViewById(R.id.usrName) ;
        passWord = (EditText) findViewById(R.id.passWord);
        Bundle extras = new Bundle();
        psWd = extras.getString("USER_NAME");
        myDB = new LogInDatabaseHelper(this);
    }

    public void onRegister(View v){

        String tmpUsrName = usrName.getText().toString();
        Cursor res = myDB.logIn(tmpUsrName);
        if ( res.getCount() == 0 ) {
            boolean registered = myDB.registerUsr(usrName.getText().toString(), passWord.getText().toString());
            inv_user.setText("");
            if ( registered == true) {
                Toast.makeText(LogInScreen.this, "Registered Successfully!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(LogInScreen.this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
            }
        } else {
            inv_user.setText(R.string.not_logging);
            inv_user.setTextColor(R.color.red);
        }
    }

    public void onLogIn(View v){

        StringBuilder sb = new StringBuilder();
        String tmpUsrNme = usrName.getText().toString();
        Cursor res = myDB.logIn(tmpUsrNme);
        int breaker = 0;
        if (res.getCount() == 0){
            inv_user.setText("Invalid Username or Password");
            return;
        }else {
            while(res.moveToNext() && breaker != 1){
                sb.append(res.getString(0));
                breaker =1;
            }
            Log.v("::::::", sb.toString());
            Log.v("::::::", passWord.getText().toString());
            Log.v("::::::", Boolean.toString(sb.toString() == passWord.getText().toString()));
        }
        if (sb.toString().equals(passWord.getText().toString())){
            Log.v("psWb", "Check");
            Intent intent = new Intent(LogInScreen.this, StartGame.class);
            intent.putExtra("USER_NAME", usrName.getText().toString());
            startActivity(intent);
            inv_user.setText("");
        } else {
            inv_user.setText("Invalid Username or Password");
        }
    }

    public void onDelete(View v){
        int deletedRows = myDB.deleteData(usrName.getText().toString());
        if ( deletedRows > 0) {
            Toast.makeText(LogInScreen.this, "Data Deleted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LogInScreen.this, "Data not Deleted", Toast.LENGTH_LONG).show();
        }
        inv_user.setText("");
    }

    public void onViewUsers(View v) {
        Cursor res = myDB.getUsers();
        if ( res.getCount() == 0 ) {
            showUsers("Error", "No Users Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("USR_NAME: " + res.getString(1) + "\n");
            buffer.append("PASSWORD: " + res.getString(2) + "\n\n");
        }

        showUsers("Users:", buffer.toString());


    }

    public void showUsers(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    @Override
    public void onBackPressed() {
        //do nothing
    }
}
