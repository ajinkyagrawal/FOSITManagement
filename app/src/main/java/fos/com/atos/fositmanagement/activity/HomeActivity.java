package fos.com.atos.fositmanagement.activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import fos.com.atos.fositmanagement.R;
import fos.com.atos.fositmanagement.fragments.AssetsFragment;
import fos.com.atos.fositmanagement.fragments.BacklogFragment;
import fos.com.atos.fositmanagement.fragments.DashboardFragment;
import fos.com.atos.fositmanagement.fragments.HomeFragment;
import fos.com.atos.fositmanagement.fragments.MessageHubFragment;
import fos.com.atos.fositmanagement.fragments.MyActivitiesFragment;
import fos.com.atos.fositmanagement.fragments.MyGroupsFragment;
import fos.com.atos.fositmanagement.fragments.MyProfileFragment;
import fos.com.atos.fositmanagement.fragments.MyTasksFragment;
import fos.com.atos.fositmanagement.fragments.MyTicketsFragment;
import fos.com.atos.fositmanagement.fragments.SystemAvailablityFragment;
import fos.com.atos.fositmanagement.fragments.TicketDetailFragment;
import fos.com.atos.fositmanagement.fragments.UpdateRoasterFragment;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_home);

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dash_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeFragment/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected void logout()
    {
        Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_dashboard:
                fragment = new DashboardFragment();
                break;
            case R.id.nav_system_availability:
                fragment = new SystemAvailablityFragment();
                break;
            case R.id.nav_my_tickets:
                fragment = new MyTicketsFragment();
                break;
            case R.id.nav_assets:
                fragment = new AssetsFragment();
                break;
            case R.id.nav_backlog:
                fragment = new BacklogFragment();
                break;
            case R.id.nav_message_hub:
                fragment = new MessageHubFragment();
                break;
            case R.id.nav_my_groups:
                fragment = new MyGroupsFragment();
                break;
            case R.id.nav_my_tasks:
                fragment = new MyTasksFragment();
                break;
            case R.id.nav_my_activities:
                fragment = new MyActivitiesFragment();
                break;
            case R.id.nav_update_roster:
                fragment = new UpdateRoasterFragment();
                break;
            case R.id.nav_my_profile:
                fragment = new MyProfileFragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
          FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }


}
