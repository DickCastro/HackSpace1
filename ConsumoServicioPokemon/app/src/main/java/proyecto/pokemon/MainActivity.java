package proyecto.pokemon;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import proyecto.pokemon.entity.PokemonEntity;
import proyecto.pokemon.service.ApiImplementation;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
public class MainActivity extends Activity {

    private List<PokemonEntity> pokemonList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);

        ApiImplementation.getService().getPokemons(new Callback<List<PokemonEntity>>() {

            @Override
            public void success(List<PokemonEntity> lista, Response response) {
                pokemonList = lista;
                refreshListUser();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                    Log.i("respuesta","algo salio mal :c");
            }
        });
    }

    private void refreshListUser() {
        PokemonAdapter adapter = new PokemonAdapter(this,pokemonList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
