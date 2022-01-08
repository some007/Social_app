package com.example.social_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.social_app.databinding.ActivityDashboardBinding;
import com.example.social_app.fragments.AddFragment;
import com.example.social_app.fragments.FavtFragment;
import com.example.social_app.fragments.Homefragment;
import com.example.social_app.fragments.ProfileFragment;
import com.example.social_app.fragments.SearchFragment;
import com.iammert.library.readablebottombar.ReadableBottomBar;

public class Dashboard extends AppCompatActivity {

    ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new Homefragment());
        transaction.commit();

        //binding
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.readableBottomnav.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {

                //Fragment Transcation
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (i){
                    case 0:
                        transaction.replace(R.id.container,new Homefragment());
                        break;
                    case 1:
                        transaction.replace(R.id.container,new SearchFragment());
                        break;
                    case 2:
                        transaction.replace(R.id.container,new AddFragment());
                        break;
                    case 3:
                        transaction.replace(R.id.container,new FavtFragment());
                        break;
                    case 4:
                        transaction.replace(R.id.container,new ProfileFragment());
                        break;
                }
                transaction.commit();
            }
        });
    }
}