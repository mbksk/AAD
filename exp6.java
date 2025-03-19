package com.example.rough;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1=findViewById(R.id.editTextText3);
                EditText e2=findViewById(R.id.editTextText4);
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Intent it=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",s1,null));
                it.putExtra("sms_body",s2);
                startActivity(it);

            }
        });
    }
}
