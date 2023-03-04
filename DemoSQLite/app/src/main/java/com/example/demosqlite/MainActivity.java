package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    FloatingActionButton btnPlus;

    UserAdapter userAdapter;
    SQLHelper sqlHelper;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref();

        sqlHelper = new SQLHelper(MainActivity.this);
        users = sqlHelper.getUsers();

        userAdapter = new UserAdapter(users, MainActivity.this);

        lv.setAdapter(userAdapter);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.layout_add_user);

                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams windowAtributes = window.getAttributes();
                windowAtributes.gravity = Gravity.CENTER_VERTICAL;
                window.setAttributes(windowAtributes);

                dialog.setCancelable(true);

                EditText edtUsername = dialog.findViewById(R.id.edtUsername);
                EditText edtPassword = dialog.findViewById(R.id.edtPassword);
                Button btnAdd = dialog.findViewById(R.id.btnAdd);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = edtUsername.getText().toString().trim();
                        String password = edtPassword.getText().toString().trim();
                        User user = new User(username, password);
                        sqlHelper.insertUser(user);
                        dialog.dismiss();

                        users.add(user);
                        userAdapter.setUsers(users);
                    }
                });

                dialog.show();
            }
        });
    }

    private void ref() {
        lv = findViewById(R.id.lv);
        btnPlus = findViewById(R.id.btnPlus);
    }
}