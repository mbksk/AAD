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

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp">

    <EditText
        android:id="@+id/editText1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"
        android:hint="Enter Username"
        android:inputType="textPersonName"
        android:minHeight="48dp" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="24dp"
        android:hint="Enter Password"
        android:inputType="textPassword"
        android:minHeight="48dp" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send" />
</LinearLayout>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp">

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Username will appear here"
        android:textSize="18sp"
        android:textStyle="bold"
        android:layout_marginBottom="12dp" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Password will appear here"
        android:textSize="18sp"
        android:textStyle="bold" />
</LinearLayout>