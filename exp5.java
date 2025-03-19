MainActivity
package com.example.exp5;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et1=findViewById(R.id.editText1);
        final EditText et2=findViewById(R.id.editText2);
        Button send=findViewById(R.id.button1);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String s= et1.getText().toString();
                String s1= et2.getText().toString();
                Intent it=new Intent(MainActivity.this, SecondActivity.class);
                it.putExtra("uname",s);
                it.putExtra("pwd",s1);
                startActivity(it);
            }
        });
    }
}


secondActivity

package com.example.exp5;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView t1=findViewById(R.id.textView1);
        TextView t2=findViewById(R.id.textView2);
        t1.setText(getIntent().getExtras().getString("uname"));
        t2.setText(getIntent().getExtras().getString("pwd"));
    }

}