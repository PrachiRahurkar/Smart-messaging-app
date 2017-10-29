package com.example.lenovo.messaging_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email_Activity extends AppCompatActivity {

    TextView tvEmailMsg;
    EditText etAddress,etSuject;
    Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_);

        tvEmailMsg = (TextView) findViewById(R.id.tvEmailMsg);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etSuject = (EditText) findViewById(R.id.etSubject);
        btnSendEmail = (Button) findViewById(R.id.btnSendEmail);

        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        tvEmailMsg.setText(msg);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add = etAddress.getText().toString();
                String sub = etSuject.getText().toString();

                if(add.length() == 0)
                {
                    etAddress.setError("Invalid Address");
                    etAddress.requestFocus();
                    return;
                }

                if(sub.length() == 0)
                {
                    etSuject.setError("Empty Subject");
                    etSuject.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"+add));
                i.putExtra(Intent.EXTRA_SUBJECT, sub);
                i.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(i);

            }
        });

    }
}
