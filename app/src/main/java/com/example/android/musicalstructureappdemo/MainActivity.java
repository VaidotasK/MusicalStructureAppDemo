package com.example.android.musicalstructureappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.musicalstructureapp.R;

public class MainActivity extends AppCompatActivity {

    //Declaration of global variables;
    String currentSong;
    String currentAuthor;
    String currentAlbumTitle;
    int currentArtWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Take values from Bundle object extra and put into new variables
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentSong = extras.getString("EXTRA_TITLE");
            currentAuthor = extras.getString("EXTRA_ARTIST");
            currentAlbumTitle = extras.getString("EXTRA_ALBUM");
            currentArtWork = extras.getInt("EXTRA_ARTWORK", 0);
        }

        TextView nowPlaying = findViewById(R.id.nowPlayingMenu);

        //Set onClickListener on text element NowPlaying
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //New intent is created
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);

                //Data from this activity is saved in new Intent and
                // send to next activity {NowPlayingActivity}
                nowPlayingIntent.putExtra("EXTRA_TITLE", currentSong);
                nowPlayingIntent.putExtra("EXTRA_ARTIST", currentAuthor);
                nowPlayingIntent.putExtra("EXTRA_ALBUM", currentAlbumTitle);
                nowPlayingIntent.putExtra("EXTRA_ARTWORK", currentArtWork);

                //Start new activity
                startActivity(nowPlayingIntent);
            }
        });

        TextView songs = findViewById(R.id.songsMenu);

        //Set onClickListener on text element Songs
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Create new Intent and start new activity {SongsActivity}
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

    }
}
