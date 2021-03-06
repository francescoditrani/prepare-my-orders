package com.droidconuk.frasam.preparemyorders;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.droidconuk.frasam.preparemyorders.dialogs.GenericYesNoFragmentDialog;
import com.droidconuk.frasam.preparemyorders.fakedb.FakeDB;
import com.droidconuk.frasam.preparemyorders.fragments.ProductListFragment;
import com.droidconuk.frasam.preparemyorders.fragments.ProductListFragment_;
import com.droidconuk.frasam.preparemyorders.model.Cart;
import com.droidconuk.frasam.preparemyorders.model.Product;
import com.google.firebase.database.FirebaseDatabase;

import org.androidannotations.annotations.EActivity;

import java.util.UUID;


@EActivity
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ProductListFragment.ProductListFragmentListener,
        GenericYesNoFragmentDialog.GenericYesNoFragmentDialogListener,
        SensorEventListener{

    public static final String CONFIRM_ADD_PRODUCT = "add_product";
    private Cart mCart;
    private String currentProductCode;
    private FirebaseDatabase mDatabase;
    static private SensorManager mSensorManager;
    static private Sensor mMagnetometer;
    private String cartId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mCart = new Cart();
        mDatabase = FirebaseDatabase.getInstance();
        cartId = "cart_"+UUID.randomUUID().toString();


        Fragment fragment = new ProductListFragment_().builder()
                .arg("productList", FakeDB.halloweenProducts).build();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainLayout, fragment)
                .addToBackStack(null)
                .commit();



    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this, mMagnetometer);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.cart) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onProductFragmentItemClick(Product product) {
        currentProductCode = product.getBarcode();
        FragmentManager fm = getSupportFragmentManager();
        GenericYesNoFragmentDialog
                .newInstance("", product.getName(), CONFIRM_ADD_PRODUCT).show(fm, CONFIRM_ADD_PRODUCT);
    }


    @Override
    public void onYesGenericDialogFragment(String requestCode) {
        mCart.addItemToCart(currentProductCode);
        mDatabase.getReference(cartId).setValue(mCart);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[event.values.length-1] < -100) {
            CartQrCodeActivity_.intent(this).extra("cartId", cartId).start();
            mSensorManager.unregisterListener(this, mMagnetometer);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
