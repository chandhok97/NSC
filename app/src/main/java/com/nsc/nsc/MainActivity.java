package com.nsc.nsc;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nsc.nsc.Activities.ListOptionsActivity;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button signinBtn;
    TextView message;
    String corrUsername="abc";  String corrPassword="abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        signinBtn= (Button) findViewById(R.id.signin);
        message= (TextView) findViewById(R.id.textView);


        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateandsignin();
            }
        });

     message.setText("");
    }

    public void validateandsignin()
    {
        String user=username.getText().toString();
        String pass=password.getText().toString();
        if(corrUsername.equals(user) && corrPassword.equals(pass))
        {
            Intent i=new Intent(MainActivity.this, ListOptionsActivity.class);
            startActivity(i);
        }

        else{
            message.setText("Invalid username or password");
        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        message.setText("");
        username.setText("");
        password.setText("");
    }
}
