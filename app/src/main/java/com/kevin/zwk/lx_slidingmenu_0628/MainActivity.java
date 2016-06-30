package com.kevin.zwk.lx_slidingmenu_0628;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private LinearLayout linearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        linearlayout= (LinearLayout) findViewById(R.id.linearlayout);
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setTitle("我是Toolbar");

        mToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(mToggle);
        //有了这句话ActionBarDrawerToggle才会出来
        mToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Snackbar.make(linearlayout,"点击了"+item.getTitle(),Snackbar.LENGTH_SHORT).setAction("点我", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                   drawerLayout.closeDrawer(Gravity.START);
                    }
                }).show();
                return true;
            }
        });
    }
}
