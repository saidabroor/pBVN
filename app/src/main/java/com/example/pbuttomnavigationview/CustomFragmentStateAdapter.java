package com.example.pbuttomnavigationview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomFragmentStateAdapter extends FragmentStateAdapter {
    public CustomFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;

        if(position == 0){
            fragment = new HomeFragment();
        } else if(position == 1){
            fragment = new MessageFragment();
        } else{
            fragment = new ProfileFragment();
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
