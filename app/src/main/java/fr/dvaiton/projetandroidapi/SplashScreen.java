package fr.dvaiton.projetandroidapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000; // 3 seconds7
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.imageViewLogo);
        textView = findViewById(R.id.Namapptxt);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.txtanimspach);
        imageView.startAnimation(animation);
        textView.startAnimation(animation2);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}