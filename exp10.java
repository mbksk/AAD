package com.example.exp10;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText nameInput, emailInput, passwordInput;
    Button registerBtn, showBtn;
    TextView userData;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        registerBtn = findViewById(R.id.registerBtn);
        showBtn = findViewById(R.id.showBtn);
        userData = findViewById(R.id.userData);

        registerBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String pass = passwordInput.getText().toString();
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                db.insertUser(name, email, pass);
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show();
                nameInput.setText(""); emailInput.setText(""); passwordInput.setText("");
            }
        });

        showBtn.setOnClickListener(v -> {
            String data = db.getAllUsers();
            userData.setText(data);
        });
    }
}package com.example.exp10;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "UserData.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean insertUser(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("password", password);
        long result = db.insert("users", null, cv);
        return result != -1;
    }

    public String getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        StringBuilder data = new StringBuilder();

        if (cursor.getCount() == 0) {
            return "No users found.";
        }

        while (cursor.moveToNext()) {
            data.append("ID: ").append(cursor.getInt(0)).append("\n");
            data.append("Name: ").append(cursor.getString(1)).append("\n");
            data.append("Email: ").append(cursor.getString(2)).append("\n");
            data.append("Password: ").append(cursor.getString(3)).append("\n\n");
        }

        cursor.close();
        return data.toString();
    }
}