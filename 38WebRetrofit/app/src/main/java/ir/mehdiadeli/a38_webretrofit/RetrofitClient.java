package ir.mehdiadeli.a38_webretrofit;

import ir.mehdiadeli.a38_webretrofit.service.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.PUT;

public class RetrofitClient {
    private static Retrofit retrofit=null;
    private static final String BASE_URL="http://jsonplaceholder.typicode.com/";
    public static ApiService getApiService(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}
