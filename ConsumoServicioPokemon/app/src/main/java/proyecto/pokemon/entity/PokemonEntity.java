package proyecto.pokemon.entity;

import android.graphics.Bitmap;

/**
 * Created by Victor Casas on 15/02/2016.
 */
public class PokemonEntity {
    private int id;
    private String nombre;
    private String tipo;
    private String imagen;
    private Bitmap bitmap;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public PokemonEntity(){

    }

    public PokemonEntity(int id, String imagen, String nombre, String tipo) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.tipo = tipo;
    }
}
