package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

import static androidx.constraintlayout.motion.widget.TransitionBuilder.validate;

public class LoginActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button loginbtn;
    private TextView Info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email=(EditText)findViewById(R.id.inputEmail) ;
        Password=(EditText)findViewById(R.id.inputUsername);
        loginbtn= (Button) findViewById(R.id.btnlogin);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }

            public void validate(String inputEmail, String inputUsername) {
                if((inputEmail.equals("saket@gmail.com"))&&(inputUsername.equals("saket"))){
                    Intent intent = new Intent(LoginActivity.this, Wlcmpage.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "You have successfully logged in", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"Please enter correct credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView btn=findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                loginbtn.setEnabled(false);
            }
        });
    }
}
