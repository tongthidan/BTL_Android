package com.example.app_btl;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.app_btl.DB.SQLiteBook;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView navigation;
    FragmentBottomAdapter adapter;
    AppBarLayout optionMenu;
    SQLiteBook sqLiteBook;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteBook = new SQLiteBook(this);
//        optionMenu  = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        navigation = findViewById(R.id.navigation);
        adapter = new FragmentBottomAdapter(getSupportFragmentManager(),
                FragmentBottomAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        navigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mHome:viewPager.setCurrentItem(0);
                        break;
                    case R.id.mKhoSach:viewPager.setCurrentItem(1);
                        break;
                    case R.id.mHelp:viewPager.setCurrentItem(2);
                        break;

                }
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: navigation.getMenu().findItem(R.id.mHome).setChecked(true);
                        break;
                    case 1: navigation.getMenu().findItem(R.id.mKhoSach).setChecked(true);
                        break;
                    case 2: navigation.getMenu().findItem(R.id.mHelp).setChecked(true);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menuoption,menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.mSearch:
//                break;
//            default:
//                break;
//        }
//        return true;
//    }
}
//}