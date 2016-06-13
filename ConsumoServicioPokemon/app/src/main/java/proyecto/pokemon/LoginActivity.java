package proyecto.pokemon;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import proyecto.pokemon.entity.PokemonEntity;
import proyecto.pokemon.service.ApiImplementation;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    private List<PokemonEntity> pokemonList;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    String nombre, tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        nombre = mEmailView.getText().toString();
        tipo=mPasswordView.getText().toString();

        final Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        ApiImplementation.getService().getPokemons(new Callback<List<PokemonEntity>>() {

            @Override
            public void success(List<PokemonEntity> lista, Response response) {
                pokemonList = lista;
                    if (nombre.equals("Bulbasaur") == tipo.equals("Planta")){
                        mEmailSignInButton.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i("respuesta","algo salio mal :c");
            }
        });

    }

    private void valido() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

