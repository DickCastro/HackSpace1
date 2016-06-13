package proyecto.pokemon;
import android.app.Activity;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.snowdream.android.widget.SmartImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import proyecto.pokemon.entity.PokemonEntity;
/**
 * Created by CASTRO on 12/06/2016.
 */
public class PokemonAdapter extends BaseAdapter {

    String url ;
    private List<PokemonEntity> pokemons;
    private Activity context;

    public PokemonAdapter( Activity context ,List<PokemonEntity>pokemons){
        this.pokemons = pokemons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = context.getLayoutInflater().inflate(R.layout.item_activity, null);

            viewHolder.nombre = (TextView) convertView.findViewById(R.id.txtnomre);
            viewHolder.tipo = (TextView) convertView.findViewById(R.id.txttipo);
            viewHolder.imagen= (SmartImageView) convertView.findViewById(R.id.Imagen);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PokemonEntity pokemon = (PokemonEntity) getItem(position);
        viewHolder.nombre.setText(pokemon.getNombre());
        viewHolder.tipo.setText(pokemon.getTipo());
        Rect rect = new Rect(viewHolder.imagen.getLeft(),viewHolder.imagen.getTop(),viewHolder.imagen.getRight(),viewHolder.imagen.getBottom());
        viewHolder.imagen.setImageUrl(pokemon.getImagen(),rect);

        return convertView;
    }
     class ViewHolder {
        private TextView id, nombre,tipo;
        private SmartImageView imagen;
    }
}
