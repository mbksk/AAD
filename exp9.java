package com.example.exp9;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Force a theme with an action bar at runtime (no styles.xml or Manifest changes needed)
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_DarkActionBar);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Make the action bar a bit darker
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu resource (res/menu/menu.xml)
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3) {
            Toast.makeText(this, "Item 3 Selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
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

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome to the Menu Example App"
        android:textSize="20sp"
        android:textStyle="bold"
        android:textColor="#000000"/>
</LinearLayout>
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/item1"
        android:title="Item 1"
        android:icon="@android:drawable/ic_menu_add"
        app:showAsAction="ifRoom" />

    <item
        android:id="@+id/item2"
        android:title="Item 2"
        android:icon="@android:drawable/ic_menu_call"
        app:showAsAction="ifRoom" />

    <item
        android:id="@+id/item3"
        android:title="Item 3"
        android:icon="@android:drawable/ic_menu_info_details"
        app:showAsAction="ifRoom" />
</menu>
