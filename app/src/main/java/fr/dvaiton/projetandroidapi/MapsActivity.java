package fr.dvaiton.projetandroidapi;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;

import fr.dvaiton.projetandroidapi.Manager.CacheManager;
import fr.dvaiton.projetandroidapi.Manager.ClusterMark;
import fr.dvaiton.projetandroidapi.Manager.MapsController;
import fr.dvaiton.projetandroidapi.Model.PointDEau;
import fr.dvaiton.projetandroidapi.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private MapsController mapsController;

    private ClusterManager<ClusterMark> ClusManager;

    ArrayList<PointDEau> listPoints = new ArrayList<>();

    PointDEau point2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mapsController = new MapsController();

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        boolean isFavorite = getIntent().getBooleanExtra("isFavorite",false);

        if(isFavorite) {
            point2 = CacheManager.getInstance().getPointDEauFavorite();

        } else {
            point2 = CacheManager.getInstance().getPointDEau();
        }












        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

     //   mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        for (int i = 0; i < point2.getRecords().size(); i++) {
            LatLng point = new LatLng(point2.getRecords().get(i).getFields().getGeoShape().getLongitude(), point2.getRecords().get(i).getFields().getGeoShape().getLatitude());

            String name = point2.getRecords().get(i).getFields().getNature();
            Log.e("Point", point2.getRecords().get(i).getFields().getNature());


            if (point2.getRecords().get(i).getFields().getNature().equals("Station de pompage")) {
                mMap.addMarker(new MarkerOptions().position(point).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
            } else if (point2.getRecords().get(i).getFields().getNature().equals("Autre point d'eau")) {

                    mMap.addMarker(new MarkerOptions().position(point).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));


            } else if (point2.getRecords().get(i).getFields().getNature().equals("Citerne")) {

                    mMap.addMarker(new MarkerOptions().position(point).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


            } else if (point2.getRecords().get(i).getFields().getNature().equals("Source")) {

                    mMap.addMarker(new MarkerOptions().position(point).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));


            } else if (point2.getRecords().get(i).getFields().getNature().equals("Fontaine")) {

                    mMap.addMarker(new MarkerOptions().position(point).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


            } else {
                mMap.addMarker(new MarkerOptions().position(point).title(name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

            }


                mMap.moveCamera(CameraUpdateFactory.newLatLng(point));
            }


        }






    }
