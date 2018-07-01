package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    String currentSong;
    String currentAuthor;
    String currentAlbumTitle;
    int currentArtWork;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentSong = extras.getString("EXTRA_TITLE");
            currentAuthor = extras.getString("EXTRA_ARTIST");
            currentAlbumTitle = extras.getString("EXTRA_ALBUM");
            currentArtWork = extras.getInt("EXTRA_ARTWORK", 0);


            TextView currentSongView = findViewById(R.id.currentTitle);
            currentSongView.setText(currentSong);

            TextView currentAuthorView = findViewById(R.id.currentArtist);
            currentAuthorView.setText(currentAuthor);

            TextView currentAlbumTitleTextView = findViewById(R.id.currentAlbum);
            currentAlbumTitleTextView.setText(currentAlbumTitle);

            ImageView currentArtWorkImageView = findViewById(R.id.current_artwork_nowPlaying);
            if(currentArtWork ==0){
                currentArtWorkImageView.setImageResource(R.drawable.icon_album_artwork_default_48px);
            }
            else {
                currentArtWorkImageView.setImageResource(currentArtWork);
            }
        }


        final ImageView returnButtonNowPlaying = findViewById(R.id.nowPlaying_back_image_view);
        returnButtonNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnToMenuIntent = new Intent(NowPlayingActivity.this, MainActivity.class);

                if (returnButtonNowPlaying != null) {
                    returnToMenuIntent.putExtra("EXTRA_TITLE", currentSong);
                    returnToMenuIntent.putExtra("EXTRA_ARTIST", currentAuthor);
                    returnToMenuIntent.putExtra("EXTRA_ALBUM", currentAlbumTitle);
                    returnToMenuIntent.putExtra("EXTRA_ARTWORK", currentArtWork);
                }
                startActivity(returnToMenuIntent);
            }
        });

    }
}
