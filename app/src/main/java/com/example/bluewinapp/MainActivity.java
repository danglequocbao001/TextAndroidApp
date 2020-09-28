package com.example.bluewinapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EditUser, EditPassword;
    Button ButtonExit, ButtonLogin, ButtonSignin;
    String name, pass, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        ControlButton();
    }

    private void ControlButton() {
        ButtonExit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder
                (
                        MainActivity.this,android.R.style.Theme_DeviceDefault_DayNight
                );
                builder.setTitle("Are you sure to exit the app?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Yes, please", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("No, i don't", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        ButtonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Handling textbox");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.signin_custom_dialog);
                final EditText SigninUsername = dialog.findViewById(R.id.signinusername);
                final EditText SigninPassword = dialog.findViewById(R.id.signinpassword);
                final EditText SigninCP = dialog.findViewById(R.id.signincp);
                final Button buttonSigninCancel = dialog.findViewById(R.id.buttonSigninCancel);
                final Button buttonSigninAccept = dialog.findViewById(R.id.buttonSigninAccept);
                buttonSigninAccept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = SigninUsername.getText().toString().trim();
                        pass = SigninPassword.getText().toString().trim();
                        confirm = SigninCP.getText().toString().trim();

                        if (SigninUsername.getText().length() != 0 && SigninPassword.getText().length() != 0 && SigninCP.getText().length() != 0) {
                            if (SigninUsername.getText().toString().equals(name) && SigninPassword.getText().toString().equals(pass) && SigninCP.getText().toString().equals(confirm) &&
                                SigninPassword.getText().toString().equals(pass) == SigninCP.getText().toString().equals(confirm)) {
                                Toast.makeText(MainActivity.this,"Signin successed!",Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        } else {
                            Toast.makeText(MainActivity.this,"Please give enough information!",Toast.LENGTH_SHORT).show();
                        }

                        EditUser.setText(name);
                        EditPassword.setText(pass);

                    }
                });
                buttonSigninCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EditUser.getText().length() != 0 && EditPassword.getText().length() != 0 ) {
                    if (EditUser.getText().toString().equals(name) && EditPassword.getText().toString().equals(pass)) {
                        Toast.makeText(MainActivity.this,"Login successed",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else if (EditUser.getText().toString().equals("quocbao001") && EditPassword.getText().toString().equals("20quocbao01")) {
                        Toast.makeText(MainActivity.this,"Login successed!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this,"Wrong password, try again!",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Please give enough information!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Mapping() {
        EditUser = findViewById(R.id.editusername);
        EditPassword = findViewById(R.id.editpassword);
        ButtonExit = findViewById(R.id.exit);
        ButtonLogin = findViewById(R.id.login);
        ButtonSignin = findViewById(R.id.signin);
    }
}