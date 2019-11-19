package com.hfad.pizzashop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);  // add DrawerToggle into DrawerLayout
        drawerToggle.syncState(); // add drawer icon on toolbar

        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);


        TabLayout tabLayout = findViewById(R.id.fragment_tabs);
        tabLayout.setupWithViewPager(pager);

    }


    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.add: {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.search:
            {
                Toast.makeText(MainActivity.this,item.getTitle()+" Selected!",Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.setting:
            {
                Toast.makeText(MainActivity.this,item.getTitle()+" Selected!",Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.location:
            {
                Toast.makeText(MainActivity.this,item.getTitle()+" Selected!",Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.services:
            {
                Toast.makeText(MainActivity.this,item.getTitle()+" Selected!",Toast.LENGTH_LONG).show();
            }
            break;
            default:
            {
                Toast.makeText(MainActivity.this,"Wrong Item Selected!",Toast.LENGTH_LONG).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private class SectionPagerAdapter extends FragmentPagerAdapter
    {
        SectionPagerAdapter(FragmentManager fragmentManager)
        {
         super(fragmentManager);
        }


        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new PizzaFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new StoresFragment();
            }
            return null;
        }

        @Override
        public int getCount()
        {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:  { return getResources().getText(R.string.Home_fragment); }
                case 1:  { return getResources().getText(R.string.Pizza_fragment);}
                case 2:  { return getResources().getText(R.string.Pasta_fragment);}
                case 3:  { return getResources().getText(R.string.Store_fragment);}
            }

            return null;
        }

    }



}
