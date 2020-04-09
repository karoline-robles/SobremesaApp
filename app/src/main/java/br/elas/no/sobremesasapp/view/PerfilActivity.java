package br.elas.no.sobremesasapp.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.elas.no.sobremesasapp.R;

public class PerfilActivity extends AppCompatActivity {
    private Button botaoSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Perfil");

        botaoSave = findViewById(R.id.buttonSaveProfile);
        botaoSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.dados_sucesso, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
        return;
    }
}