package com.nao.sabina.projectnao;

import android.content.ClipData;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import fragments.ActionFragment;
import fragments.ConnectWithNaoFragment;
import fragments.ConnectWithPCFragment;
import fragments.ConnectWithServerFragment;
import fragments.ControllFragment;
import fragments.NaoInfoFragment;


/* MainPage
 * Author: Sabina Brantner
 * Description: This Java Class handles the UI of the app. On start, it creates a View with a Toolbar and a Fragment.
 * It implements also a Drawer which ensures that the User can handle the app easily.
 */
public class MainPage extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_page);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ConnectWithNaoFragment connectWithNaoFragment = new ConnectWithNaoFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,connectWithNaoFragment);
        fragmentTransaction.commit();

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View headerView = navigationView.inflateHeaderView(R.layout.header_of_drawer);
        ImageView profileImage = (ImageView) headerView.findViewById(R.id.profile_image);
        Picasso.with(this).load(R.drawable.nao_pic).fit().centerInside().into(profileImage);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){
                    case R.id.connectWithNao:
                        Toast.makeText(getApplicationContext(), "Connect with Nao Selected", Toast.LENGTH_SHORT).show();
                        ConnectWithNaoFragment connectWithNaoFragment = new ConnectWithNaoFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,connectWithNaoFragment);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.naoInfo:
                        Toast.makeText(getApplicationContext(), "Nao Info Selected", Toast.LENGTH_SHORT).show();
                        NaoInfoFragment naoInfoFragment = new NaoInfoFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,naoInfoFragment);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.actionsOfNao:
                        Toast.makeText(getApplicationContext(), "Actions Selected", Toast.LENGTH_SHORT).show();
                        ActionFragment actionFragment = new ActionFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, actionFragment);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.controllNao:
                        Toast.makeText(getApplicationContext(), "Controll Selected", Toast.LENGTH_SHORT).show();
                        ControllFragment controllFragment = new ControllFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, controllFragment);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.downloadServer:
                        Toast.makeText(getApplicationContext(), "Download from Server Selected", Toast.LENGTH_SHORT).show();
                        ConnectWithServerFragment connectWithServerFragment = new ConnectWithServerFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, connectWithServerFragment);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.downloadPc:
                        Toast.makeText(getApplicationContext(), "Download from PC Selected", Toast.LENGTH_SHORT).show();
                        ConnectWithPCFragment connectWithPCFragment = new ConnectWithPCFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, connectWithPCFragment);
                        fragmentTransaction.commit();
                        return true;

                    // For rest of the options we just show a toast on click
                    default:
                        Toast.makeText(getApplicationContext(),"Something is wrong",Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}