package com.astra.acan.epart_sa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentTransaction fragmenTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fragmenTransaction = getSupportFragmentManager().beginTransaction();
        fragmenTransaction.add(R.id.frame_layout, new Cari());
        fragmenTransaction.commit();
        getSupportActionBar().setTitle("Cari Data");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_cari:
                fragmenTransaction = getSupportFragmentManager().beginTransaction();
                fragmenTransaction.replace(R.id.frame_layout, new Cari());
                fragmenTransaction.commit();
                getSupportActionBar().setTitle("Cari");
                item.setChecked(true);

                break;


            case R.id.nav_part_cart:
                fragmenTransaction = getSupportFragmentManager().beginTransaction();
                fragmenTransaction.replace(R.id.frame_layout, new ListPart());
                fragmenTransaction.commit();
                getSupportActionBar().setTitle("List Part");
                item.setChecked(true);
                break;


            case R.id.nav_estimasi:
                fragmenTransaction = getSupportFragmentManager().beginTransaction();
                fragmenTransaction.replace(R.id.frame_layout, new ListEstimasi());
                fragmenTransaction.commit();
                getSupportActionBar().setTitle("List Estimasi");
                item.setChecked(true);
                break;

            case R.id.nav_cetak:
                fragmenTransaction = getSupportFragmentManager().beginTransaction();
                fragmenTransaction.replace(R.id.frame_layout, new Cetak());
                fragmenTransaction.commit();
                getSupportActionBar().setTitle("Cetak");
                item.setChecked(true);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
