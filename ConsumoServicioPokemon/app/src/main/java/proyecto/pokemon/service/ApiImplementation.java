package proyecto.pokemon.service;

import retrofit.RestAdapter;

/**
 * Created by Victor Casas on 15/02/2016.
 */
public class ApiImplementation {
    private static RestAdapter adapter = new RestAdapter.Builder()
            .setEndpoint("http://www.victorcasass.com/api/")
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

    public static ApiService getService(){
        return adapter.create(ApiService.class);
    }
}
