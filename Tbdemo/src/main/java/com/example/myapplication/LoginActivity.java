package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private Button login,quxiao;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button) findViewById(R.id.login_btn);
        username=(EditText) findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        quxiao=(Button) findViewById(R.id.quxiao);
    }
    public void Login(View view){
        String t1=username.getText().toString();
        String t2=password.getText().toString();
        if (t1.equals("admin")&&t2.equals("123456")){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this, "用户名或密码不正确，请重新输入。。", Toast.LENGTH_SHORT).show();
        }
    }
    public void QuXiao(View view){
        finish();
    }
}
