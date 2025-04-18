package com.example.exp42;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private EditText et1,et2,et3,et4,et5;
    private Spinner s;
    private TextView out;
    private RadioGroup r;
    private String[] states={"Ap","usa","tamilnadu","ausrtalia"};
    private Button b;
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.editTextText);
        et2=findViewById(R.id.editTextTextPassword);
        et3=findViewById(R.id.editTextText5);
        et4=findViewById(R.id.editTextText4);
        et5=findViewById(R.id.editTextText2);
        r=findViewById(R.id.RadioGroup);
        s=findViewById(R.id.spinner);
        ArrayAdapter<String> a=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,states);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       s.setAdapter(a);
       b=findViewById(R.id.button);
       out=findViewById(R.id.textView7);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String s1=et1.getText().toString();
               String s2=et2.getText().toString();
               String s3=et3.getText().toString();
               String s4=et4.getText().toString();
               String s5=et5.getText().toString();
               int f=r.getCheckedRadioButtonId();
               String s7=f!=-1?((RadioButton) findViewById(f)).getText().toString():"Not Selected";
               String s6=s.getSelectedItem().toString();
               String userInfo = "Hello " + s1 + "!\n" +
                       "Password: " +s2+ "\n" +
                       "Address: " + s3 + "\n" +
                       "Gender: " + s7 + "\n" +
                       "Date of Birth: " + s4 + "\n" +
                       "Age: " + s5 + "\n" +
                       "State: " + s6;

               out.setText(userInfo);
           }
       });
    }
}
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <!-- User Name -->
        <EditText
            android:id="@+id/etUserName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Enter User Name" />

        <!-- Password -->
        <EditText
            android:id="@+id/etPassword"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Enter Password"
            android:inputType="textPassword" />

        <!-- Address -->
        <EditText
            android:id="@+id/etAddress"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Enter Address"
            android:inputType="textMultiLine" />

        <!-- Gender (Radio Buttons) -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select Gender:" />

        <RadioGroup
            android:id="@+id/radioGroupGender"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <RadioButton
                android:id="@+id/rbMale"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Male" />

            <RadioButton
                android:id="@+id/rbFemale"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Female" />
        </RadioGroup>

        <!-- Age -->
        <EditText
            android:id="@+id/etAge"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Enter Age"
            android:inputType="number" />

        <!-- Date of Birth (Date Picker) -->
        <Button
            android:id="@+id/btnSelectDOB"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select Date of Birth" />

        <TextView
            android:id="@+id/tvSelectedDOB"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="DOB: " />

        <!-- State (Spinner) -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select State:" />

        <Spinner
            android:id="@+id/spinnerState"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <!-- Submit Button -->
        <Button
            android:id="@+id/btnSubmit"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Submit" />

        <!-- Output Text -->
        <TextView
            android:id="@+id/tvResult"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:paddingTop="16dp" />
    </LinearLayout>
</ScrollView>
