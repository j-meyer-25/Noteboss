package com.onu.noteboss;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

public class NotecardMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sticker setup
        ImageView sticker1 = (ImageView) findViewById(R.id.sticker1);
        ImageView sticker2 = (ImageView) findViewById(R.id.sticker2);
        ImageView sticker3 = (ImageView) findViewById(R.id.sticker3);
        ImageView sticker1Stuck = (ImageView) findViewById(R.id.sticker1Stuck);
        ImageView sticker2Stuck = (ImageView) findViewById(R.id.sticker2Stuck);
        ImageView sticker3Stuck = (ImageView) findViewById(R.id.sticker3Stuck);
        ImageView front = (ImageView) findViewById(R.id.front);
        ImageView back = (ImageView) findViewById(R.id.back);

        // Notecard setup
        Button flip = (Button) findViewById(R.id.flip);
        Button scrollFlip = (Button) findViewById(R.id.scrollFlip);

        EditText frontHeader = (EditText) findViewById(R.id.headerText);
        EditText backHeader = (EditText) findViewById(R.id.headerText2);
        EditText frontText = (EditText) findViewById(R.id.mainText);
        EditText backText = (EditText) findViewById(R.id.mainText2);

        // Category sidebar setup
        ScrollView categoryScroll = (ScrollView) findViewById(R.id.categoryScroll);
        ScrollView imageScroll = (ScrollView) findViewById(R.id.imageScroll);

        // Set backside views to be invisible
        backHeader.setVisibility(View.INVISIBLE);
        backText.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        imageScroll.setVisibility(View.INVISIBLE);

        // Sort stickers into an array, so we can loop-add click events to each sticker
        ImageView[] stickers = {sticker1, sticker2, sticker3};
        ImageView[] stuckStickers = {sticker1Stuck, sticker2Stuck, sticker3Stuck};
        // Iterate over stickers and attach button
        for (int i = 0; i < stickers.length; i++) {
            ImageView sticker = stickers[i];
            ImageView stuckSticker = stuckStickers[i];
            sticker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toggle stuck visibility
                    stuckSticker.setVisibility(stuckSticker.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE);
                }
            });
        }

        // On click, this will flip the notecard to its back side
        flip.setOnClickListener(new View.OnClickListener() {
            private boolean facingFront = true;

            @Override
            public void onClick(View view) {
                if (this.facingFront) {
                    // Flip to back side of notecard
                    front.setVisibility(View.INVISIBLE);
                    back.setVisibility(View.VISIBLE);

                    backHeader.setVisibility(View.VISIBLE);
                    frontHeader.setVisibility(View.INVISIBLE);
                    backText.setVisibility(View.VISIBLE);
                    frontText.setVisibility(View.INVISIBLE);
                }
                else {
                    // Flip to front side of notecard
                    back.setVisibility(View.INVISIBLE);
                    front.setVisibility(View.VISIBLE);

                    backHeader.setVisibility(View.INVISIBLE);
                    frontHeader.setVisibility(View.VISIBLE);
                    backText.setVisibility(View.INVISIBLE);
                    frontText.setVisibility(View.VISIBLE);
                }
                facingFront = !facingFront;
            }
        });


        // This is a temporary button that switches between categories and notecards
        // Due to having only 1 functional notecard
        scrollFlip.setOnClickListener(new View.OnClickListener() {
            private boolean showingCategories = true;
            @Override
            public void onClick(View view) {
                if (this.showingCategories) {
                    // Show individual cards
                    categoryScroll.setVisibility(View.INVISIBLE);
                    imageScroll.setVisibility(View.VISIBLE);
                } else {
                    // Show categories
                    categoryScroll.setVisibility(View.VISIBLE);
                    imageScroll.setVisibility(View.INVISIBLE);
                }
                showingCategories = !showingCategories;
            }
        });
     }
}