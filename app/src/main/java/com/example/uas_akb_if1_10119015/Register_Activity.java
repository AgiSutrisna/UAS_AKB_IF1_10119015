package com.example.uas_akb_if1_10119015;

/*
    Nama    : Agi Sutrisna
    Nim     : 10119015
    Kelas   : IF1
 */

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private Button btnSignUp;
    private TextView btnSignIn;
    private ImageView back;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnSignUp = (Button) findViewById(R.id.btn_register);
        btnSignIn = (TextView) findViewById(R.id.txt_login);
        back = (ImageView) findViewById(R.id.back);
        auth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError("Email harus diisi!");
                } else if (TextUtils.isEmpty(password)) {
                    inputPassword.setError("Password harus diisi!");
                } else if (password.length() < 6) {
                    inputPassword.setError("Password minimal 6 karakter!");
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Register_Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register_Activity.this, "User dengan Email dan Password berhasil dibuat", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register_Activity.this, "Otentikasi Gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register_Activity.this, Login_Activity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register_Activity.this, Awal_Activity.class));
            }
        });
    }
}
