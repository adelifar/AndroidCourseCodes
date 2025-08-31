package ir.mehdiadeli.a31_pagertab;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
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


        viewPager2=findViewById(R.id.viewPager);
        FragmentManager manager=getSupportFragmentManager();
        Lifecycle lifecycle = getLifecycle();
        MyPagerAdapter adapter=new MyPagerAdapter(manager, lifecycle);
        adapter.addFragment(new Fragment1());
        adapter.addFragment(new Fragment2());
        adapter.addFragment(new Fragment3());
        viewPager2.setAdapter(adapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        tabLayout=findViewById(R.id.tabLayout1);

        TabLayoutMediator mediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                tab.setText("Fragment"+(i+1));
            }
        });
        mediator.attach();

    }
}