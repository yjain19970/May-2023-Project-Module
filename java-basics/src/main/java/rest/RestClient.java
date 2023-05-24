package rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private JSONPlaceHolderAPI jsonPlaceHolderAPI;

    public RestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        jsonPlaceHolderAPI = retrofit.create(JSONPlaceHolderAPI.class);
    }

    public JSONPlaceHolderAPI getJsonPlaceHolderAPI() throws IllegalCallerException {
        return jsonPlaceHolderAPI;
    }
}
