package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    LottieAnimationView lottieAnimationView;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv);

        rl = findViewById(R.id.rl);
        lottieAnimationView = findViewById(R.id.lv);
        lottieAnimationView.setVisibility(View.INVISIBLE);
        startAnimation();
        setRandomImage();

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startAnimation();
            }


        });
    }

    private void setRandomImage() {
        Random random = new Random();
        int rand = 0;
        while (true) {
            rand = random.nextInt(7);
            if (rand == 1 || rand == 2 || rand == 3 || rand == 4 || rand == 5 || rand == 6) break;
        }
        System.out.println(rand);

        if (rand == 1)
            imageView.setImageResource(R.drawable.six);
        else if (rand == 2)
            imageView.setImageResource(R.drawable.two);
        else if (rand == 3)
            imageView.setImageResource(R.drawable.five);
        else if (rand == 4)
            imageView.setImageResource(R.drawable.four);
        else if (rand == 5)
            imageView.setImageResource(R.drawable.three);
        else
            imageView.setImageResource(R.drawable.one);
    }


    private void startAnimation() {
        lottieAnimationView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.INVISIBLE);
        lottieAnimationView.playAnimation();
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                setRandomImage();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                imageView.setVisibility(View.VISIBLE);
                lottieAnimationView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
}

