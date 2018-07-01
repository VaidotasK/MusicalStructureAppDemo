package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String currentSong;
    String currentAuthor;
    String currentAlbumTitle;
    int currentArtWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentSong = extras.getString("EXTRA_TITLE");
            currentAuthor = extras.getString("EXTRA_ARTIST");
            currentAlbumTitle = extras.getString("EXTRA_ALBUM");
            currentArtWork = extras.getInt("EXTRA_ARTWORK", 0);
        }

        TextView nowPlaying = findViewById(R.id.nowPlayingMenu);

        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);

                    nowPlayingIntent.putExtra("EXTRA_TITLE", currentSong);
                    nowPlayingIntent.putExtra("EXTRA_ARTIST", currentAuthor);
                    nowPlayingIntent.putExtra("EXTRA_ALBUM", currentAlbumTitle);
                    nowPlayingIntent.putExtra("EXTRA_ARTWORK", currentArtWork);


                startActivity(nowPlayingIntent);
            }
        });

        TextView songs = findViewById(R.id.songsMenu);

        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

    }
}
