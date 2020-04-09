package br.elas.no.sobremesasapp.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import br.elas.no.sobremesasapp.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText email;
    private TextInputEditText senha;
    private Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaCampos()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void initViews() {
    email = findViewById(R.id.inputEmail);
    senha = findViewById(R.id.InputSenha);
    botaoEntrar = findViewById(R.id.button_login);
}
    private boolean validaCampos() {
        String email1 = email.getText().toString();
        String senha1 = senha.getText().toString();

            if (email1.isEmpty() && email1.isEmpty()) {
                email.setError("Preencha os campos!");
                senha.setError("Preencha os campos!");
                return false;
            } else {
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return true;
            }
        }
    }
