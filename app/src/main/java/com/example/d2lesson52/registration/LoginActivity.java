package com.example.d2lesson52.registration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d2lesson52.GsonSingleton;
import com.example.d2lesson52.R;
import com.example.d2lesson52.models.User;
import com.example.d2lesson52.ui.MainActivity;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
private EditText userLog,passworLog;
private Button log_btn;
private TextView sigin;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("Android_temp", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setContentView(R.layout.activity_login);
        setUI();

        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "registratsia", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(LoginActivity.this,SiginActivity.class);
                startActivityForResult(intent,0);
            }
        });

        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = userLog.getText().toString();
                String s1 = passworLog.getText().toString();
                boolean isHave = false;
                String usersJson = sharedPreferences.getString("users", "");
                Type type = new TypeToken<List<User>>() {
                }.getType();
                List<User> users = GsonSingleton.getInstance().getGson().fromJson(usersJson, type);
                for (User user : users) {
                    if (user.getEmail().equalsIgnoreCase(s) && user.getPassword().equalsIgnoreCase(s1)){
                        isHave = true;
                    }
                }
                if (isHave){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Parol yoki login xato", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String email = data.getStringExtra("email");
        String pass = data.getStringExtra("password");
        userLog.setText(email);
        passworLog.setText(pass);


        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setUI() {
        log_btn = findViewById(R.id.login_btn);
        userLog = findViewById(R.id.user_log);
        passworLog = findViewById(R.id.passwod_log);
        sigin = findViewById(R.id.sigin_txt);

    }


    @Override
    protected void onResume() {
        String users = sharedPreferences.getString("users", "");
        List<User> list;
        boolean isHave2 = false;
        if (users.equalsIgnoreCase("")){
            list = new ArrayList<>();
        }else {

            Type type = new TypeToken<List<User>>() {
            }.getType();
            list = GsonSingleton.getInstance().getGson().fromJson(users, type);

            if (!list.get(list.size() - 1).getEmail().isEmpty() && !list.get(list.size() - 1).getPassword().isEmpty()) {
                isHave2 = true;
            }


            if (isHave2 == true) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "sdasdadas", Toast.LENGTH_SHORT).show();
            }
        }
        super.onResume();
    }
}