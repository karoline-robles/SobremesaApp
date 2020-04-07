package br.elas.no.sobremesasapp.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import br.elas.no.sobremesasapp.MainActivity;
import br.elas.no.sobremesasapp.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText email;
    private TextInputEditText senha;
    private Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.textEmail);
        senha = findViewById(R.id.textSenhaLogin);
        botaoEntrar = findViewById(R.id.button_login);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = email.getText().toString();
                String senha1 = senha.getText().toString();

                validarEmailSenha(email1, senha1);
            }
        });
    }
    private boolean validarEmailSenha(String emailInput, String senhaInput) {
        if (emailInput.isEmpty() && senhaInput.isEmpty()) {
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