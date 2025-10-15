package ir.mehdiadeli.a38_webretrofit;

import android.database.DatabaseUtils;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import java.util.List;

import ir.mehdiadeli.a38_webretrofit.databinding.ActivityMainBinding;
import ir.mehdiadeli.a38_webretrofit.model.Post;
import ir.mehdiadeli.a38_webretrofit.service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        fetchPosts();
    }
    private void fetchPosts(){
        ApiService service=RetrofitClient.getApiService();
        Call<List<Post>> call= service.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()){
                    List<Post> posts=response.body();
                    if (posts!=null || posts.isEmpty()){
                        StringBuilder builder=new StringBuilder();
                        for (Post post :
                                posts) {
                            builder.append(post.getTitle());
                            builder.append("\n");
                        }
                        binding.txtView.setText(builder.toString());
                    }
                    else {
                        binding.txtView.setText("هیچ پستی وجود ندارد");
                    }
                }else
                    binding.txtView.setText("Error in Response");
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                binding.txtView.setText("Network error \n"+t.getMessage());
            }
        });
    }
}