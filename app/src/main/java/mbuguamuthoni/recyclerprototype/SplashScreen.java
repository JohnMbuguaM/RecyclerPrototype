package mbuguamuthoni.recyclerprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView txtWelcome, tvKikaMe, tvSacco, tvRieng;
    ImageView imageview;

    Animation frombottom, fromtop, infromright, fadein;



    private void initializeWidget() {
        txtWelcome = findViewById(R.id.welcom);
        tvKikaMe = findViewById(R.id.mekikathi);
        tvSacco = findViewById(R.id.sacco);
        tvRieng = findViewById(R.id.rieng);
        imageview = findViewById(R.id.tukpic);

    }

    private void showSplashScreen() {

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        infromright = AnimationUtils.loadAnimation(this, R.anim.infromright);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        tvKikaMe.setAnimation(frombottom);
        txtWelcome.setAnimation(fromtop);
        imageview.setAnimation(infromright);
        tvRieng.setAnimation(fadein);

    }
    private void goToDashMain() {
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    super.run();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        this.initializeWidget();
        this.showSplashScreen();
        this.goToDashMain();


    }



}
