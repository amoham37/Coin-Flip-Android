package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import  android.widget.Toast;
import java.util.Random;

import static com.example.coinflip.R.drawable.heads;
import static com.example.coinflip.R.drawable.tails;

public class MainActivity extends AppCompatActivity {

    private Random random;
    private ImageView coinView;
    private Button btn;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        coinView = (ImageView) findViewById(R.id.coin);
        coinView.setX(250);
        coinView.setY(250);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCoin();
            }

        });
    }

    private void flipCoin(){
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                random = new Random();

                int side = random.nextInt(2);

                if (side == 1 ) {
                    coinView.setImageResource(tails);
                    textView.setText("TAILS");
                } else if (side == 0) {
                    coinView.setImageResource(heads);
                    textView.setText("HEADS");
//                    Toast.makeText(getApplicationContext(), "Heads", Toast.LENGTH_SHORT).show();
                }





                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new DecelerateInterpolator());
                fadeIn.setDuration(1000);
                fadeIn.setFillAfter(true);

                coinView.startAnimation(fadeIn);
                textView.startAnimation(fadeIn);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



        coinView.startAnimation(fadeOut);
        textView.startAnimation(fadeOut);





    }
}
