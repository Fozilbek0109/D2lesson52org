package com.example.d2lesson52.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.d2lesson52.GsonSingleton;
import com.example.d2lesson52.R;
import com.example.d2lesson52.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SiginActivity extends AppCompatActivity {
    private EditText email, user, password, retypePas;
    private Button sigin_btn;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        sharedPreferences = getSharedPreferences("Android_temp", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setUI();


        sigin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo malumotni saqlash+
                //todo malumotlarni otish
                //todo Aktivitiyni yopish
                if (isValid()) {
                    String email1 = email.getText().toString();
                    String username = user.getText().toString();
                    String password1 = password.getText().toString();
                    String repassword = retypePas.getText().toString();
                    User u1 = new User(email1, username, password1, repassword);
                    String usersJsonString = sharedPreferences.getString("users", "");
                    List<User> userlist;
                    if (usersJsonString.equalsIgnoreCase("")) {
                        userlist = new ArrayList<>();
                    } else {
                        Type type = new TypeToken<List<User>>() {
                        }.getType();
                        userlist = GsonSingleton.getInstance().getGson().fromJson(usersJsonString, type);

                    }
                    userlist.add(u1);
                    String s = GsonSingleton.getInstance().getGson().toJson(userlist);
                    editor.putString("users", s);
                    editor.commit();
                    Intent intent = new Intent();
                    intent.putExtra("email", email1);
                    intent.putExtra("password", password1);
                    setResult(1, intent);
                    finish();

                }
            }
        });

    }

    private void setUI() {
        email = findViewById(R.id.email_sig);
        user = findViewById(R.id.user_sig);
        password = findViewById(R.id.passwod_sig);
        retypePas = findViewById(R.id.retype_passwod);
        sigin_btn = findViewById(R.id.sigin_btn);

    }
    private boolean isValid() {
        if (email.getText().toString().isEmpty()){
            Toast.makeText(this, "Email kiritilmagan", Toast.LENGTH_SHORT).show();
            return false;
        } else if (user.getText().toString().isEmpty()) {
            Toast.makeText(this, "name kiritilmagan", Toast.LENGTH_SHORT).show();

            return false;
        }
        else if (password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Parol kiritilmagan", Toast.LENGTH_SHORT).show();

            return false;
        }
        else if (retypePas.getText().toString().isEmpty()) {
            Toast.makeText(this, "reparol kiritilmagan", Toast.LENGTH_SHORT).show();

            return false;
        }
        else if (!password.getText().toString().equalsIgnoreCase(retypePas.getText().toString())) {
            Toast.makeText(this, "Parollar birxil emas", Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;

    }
}

