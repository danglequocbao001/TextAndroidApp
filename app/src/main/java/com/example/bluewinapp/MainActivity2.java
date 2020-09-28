package com.example.bluewinapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText SigninUsername, SigninPassword, SigninCP;
    Button upbuttoncancel, upbuttonaccept, ButtonSigninAccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Mapping();
        ControlButton();
    }

    private void ControlButton() {
        upbuttoncancel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder
                        (
                                MainActivity2.this,android.R.style.Theme_DeviceDefault_DayNight
                        );
                builder.setTitle("Are you really want to exit the update?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        upbuttonaccept.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder
                        (
                                MainActivity2.this,android.R.style.Theme_DeviceDefault_DayNight
                        );
                Toast.makeText(MainActivity2.this,"Updated!",Toast.LENGTH_SHORT).show();
                builder.setTitle("Your information updated!");
                builder.setIcon(android.R.drawable.sym_def_app_icon);
                builder.setPositiveButton("Done and exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Return and continue editing", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    private void Mapping() {
        upbuttonaccept = findViewById(R.id.upbuttonaccept);
        upbuttoncancel = findViewById(R.id.upbuttoncancel);
        SigninUsername = findViewById(R.id.signinusername);
        SigninPassword = findViewById(R.id.signinpassword);
        SigninCP = findViewById(R.id.signincp);
        ButtonSigninAccept = findViewById(R.id.buttonSigninAccept);
    }
}