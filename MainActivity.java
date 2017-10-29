package com.example.lenovo.messaging_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMessage;
    Button btnSms,btnEmail,btnSend,btnWhatsapp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = (EditText) findViewById(R.id.etMessage);
        btnSms = (Button) findViewById(R.id.btnSms);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnWhatsapp = (Button) findViewById(R.id.btnWhatsapp);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();
                if(msg.length() == 0)
                {
                    etMessage.setError("Message Empty");
                    etMessage.requestFocus();
                    return;
                }

                Intent i = new Intent(getApplicationContext(),SmsActivity.class);
                i.putExtra("msg",msg);
                startActivity(i);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();
                if(msg.length() == 0)
                {
                    etMessage.setError("Message Empty");
                    etMessage.requestFocus();
                    return;
                }

                Intent i = new Intent(getApplicationContext(),Email_Activity.class);
                i.putExtra("msg",msg);
                startActivity(i);

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();
                if(msg.length() == 0)
                {
                    etMessage.setError("Message Empty");
                    etMessage.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,msg);
                startActivity(i);

            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();
                if(msg.length() == 0)
                {
                    etMessage.setError("Message Empty");
                    etMessage.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_TEXT,msg);
               try{
                   startActivity(i);
               }
               catch (Exception e) //if wa not there, so try catch
               {
                   Toast.makeText(getApplicationContext(), "wa not installed", Toast.LENGTH_LONG).show();
               }

            }
        });

    } // end of OnCreate()
} // end of class
