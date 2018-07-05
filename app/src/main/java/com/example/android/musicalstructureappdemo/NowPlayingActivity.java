package com.example.android.musicalstructureappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.R;

public class NowPlayingActivity extends AppCompatActivity {

    //Declaration of global variables
    String currentSong;
    String currentAuthor;
    String currentAlbumTitle;
    int currentArtWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Take values from Bundle object extra and put into new variables
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentSong = extras.getString("EXTRA_TITLE");
            currentAuthor = extras.getString("EXTRA_ARTIST");
            currentAlbumTitle = extras.getString("EXTRA_ALBUM");
            currentArtWork = extras.getInt("EXTRA_ARTWORK", 0);

            //Find TextView for current Song title and set value using chosen song
            TextView currentSongView = findViewById(R.id.currentTitle);
            currentSongView.setText(currentSong);

            //Find TextView for current Song artist and set value using chosen song
            TextView currentAuthorView = findViewById(R.id.currentArtist);
            currentAuthorView.setText(currentAuthor);

            //Find TextView for current Song album and set value using chosen song
            TextView currentAlbumTitleTextView = findViewById(R.id.currentAlbum);
            currentAlbumTitleTextView.setText(currentAlbumTitle);

            //Find TextView for current Song artwork and set value using chosen song
            ImageView currentArtWorkImageView = findViewById(R.id.current_artwork_nowPlaying);
            //If user goes from menu straight to nowplaying, currentArtWork is 0, so default artwork
            //is set
            if (currentArtWork == 0) {
                currentArtWorkImageView.setImageResource(R.drawable.icon_album_artwork_default);
            }
            //Find ImageView for current Song artwork and set artWork using chosen song
            else {
                currentArtWorkImageView.setImageResource(currentArtWork);
            }
        }

        //Set onClickListener to go back from Nowplaying to Menu
        final ImageView returnButtonNowPlaying = findViewById(R.id.nowPlaying_back_image_view);
        returnButtonNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new Intent
                Intent returnToMenuIntent = new Intent(NowPlayingActivity.this, MainActivity.class);

                //Save data from variables and put into new intent, to send it to next activity
                if (returnButtonNowPlaying != null) {
                    returnToMenuIntent.putExtra("EXTRA_TITLE", currentSong);
                    returnToMenuIntent.putExtra("EXTRA_ARTIST", currentAuthor);
                    returnToMenuIntent.putExtra("EXTRA_ALBUM", currentAlbumTitle);
                    returnToMenuIntent.putExtra("EXTRA_ARTWORK", currentArtWork);
                }
                //Start new activity {MainActivity}
                startActivity(returnToMenuIntent);
            }
        });

    }
}
