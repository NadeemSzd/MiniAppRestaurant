package com.hfad.pizzashop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DrawerLayout drawerLayout;
    static ViewPager pager;

    static int Tab_Number=0;


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
        pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        int tabnumber=0;
        Intent intent = getIntent();
        if(intent.hasExtra("TabNumber"))
        {
            tabnumber = intent.getIntExtra("TabNumber",0);
        }
        pager.setCurrentItem(tabnumber);
        Tab_Number = pager.getCurrentItem();

        TabLayout tabLayout = findViewById(R.id.fragment_tabs);
        tabLayout.setupWithViewPager(pager);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.MyDialogueTheme);
            builder.setTitle("Exit App")
                    .setMessage("Do you really want to exit the app!")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
            //super.onBackPressed();
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
            case R.id.search|R.id.setting|R.id.location|R.id.services:
            {
                Toast.makeText(MainActivity.this,item.getTitle()+" Selected!",Toast.LENGTH_SHORT).show();
            }
            break;
            default:
            {
                Toast.makeText(MainActivity.this,"Wrong Item Selected!",Toast.LENGTH_SHORT).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        Fragment fragment = null;
        int page_number=0;

        switch (id)
        {
            case R.id.show_PizzaDetail:
            {
                page_number=1;
                fragment = new PizzaFragment();
            }
            break;
            case R.id.show_PastaDetail:
            {
                page_number = 2;
                fragment = new PastaFragment();
            }
            break;
            case R.id.show_BranchDetail:
            {
                page_number = 3;
                fragment = new StoresFragment();
            }
            break;
        }

        if(fragment != null)
        {
           // System.out.println("ID of selected Item is : "+page_number);
            pager.setCurrentItem(page_number);
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
                case 0: {
                    return new HomeFragment();
                }
                case 1: {
                    return new PizzaFragment();
                }
                case 2: {
                    return new PastaFragment();
                }
                case 3: {
                    return new StoresFragment();
                }
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
