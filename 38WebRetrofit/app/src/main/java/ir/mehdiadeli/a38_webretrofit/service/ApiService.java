package ir.mehdiadeli.a38_webretrofit.service;

import java.util.List;

import ir.mehdiadeli.a38_webretrofit.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")
   Call< List<Post>> getPosts();
}
