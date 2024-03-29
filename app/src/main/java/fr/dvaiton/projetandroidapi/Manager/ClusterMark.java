package fr.dvaiton.projetandroidapi.Manager;


import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class ClusterMark implements ClusterItem {

        private final LatLng mPosition;
        private String mTitle;
        private String mSnippet;

        public ClusterMark(double lat, double lng) {
            mPosition = new LatLng(lat, lng);
        }

        public ClusterMark(double lat, double lng, String title, String snippet) {
            mPosition = new LatLng(lat, lng);
            mTitle = title;
            mSnippet = snippet;
        }

        @Override
        public LatLng getPosition() {
            return mPosition;
        }

        public String getTitle() {
            return mTitle;
        }

        public String getSnippet() {
            return mSnippet;
        }
}
