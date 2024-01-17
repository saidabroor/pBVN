package com.example.pbuttomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

BottomNavigationView bottomNavigationView;
ViewPager2 viewPager;
private CustomFragmentStateAdapter adapter;
HomeFragment homeFragment;
MessageFragment messageFragment;
ProfileFragment profileFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        viewPager = findViewById(R.id.viewPager);
        adapter = new CustomFragmentStateAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0){
                    bottomNavigationView.setSelectedItemId(R.id.messageTab);
                } else if(position == 1){
                    bottomNavigationView.setSelectedItemId(R.id.homeTab);

                } else{
                    bottomNavigationView.setSelectedItemId(R.id.personTab);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.messageTab){
//                    messageFragment = new MessageFragment();
                    viewPager.setCurrentItem(1);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, messageFragment).addToBackStack(null).commit();
                } else if(item.getItemId() == R.id.homeTab){
//                    homeFragment = new HomeFragment();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, homeFragment).addToBackStack(null).commit();
                    viewPager.setCurrentItem(0);


                } else if (item.getItemId() == R.id.personTab) {
//                    profileFragment = new ProfileFragment();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, profileFragment).addToBackStack(null).commit();
                    viewPager.setCurrentItem(2);

                }
                return true;
            }
        });
    }


}