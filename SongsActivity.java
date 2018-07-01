package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // Create a list of songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Addicted", "Simple Plan",
                "No pads, no helmets...just balls",
                R.drawable.album_artwork_simple_plan_no_pads_no_helmets_just_balls_48px));
        songs.add(new Song("My Alien", "Simple Plan"));
        songs.add(new Song("Zoe Jane", "Staind", "14 shades of grey",
                R.drawable.album_artwork_staind_14_shades_of_grey_48px));
        songs.add(new Song("So Far Away", "Staind", "14 shades of grey",
                R.drawable.album_artwork_staind_14_shades_of_grey_48px));
        songs.add(new Song("All I Want", "Staind", "The illusion of progress",
                R.drawable.album_artwork_staind_the_illusion_of_progress_48px));
        songs.add(new Song("Save Me", "Staind", "The illusion of progress",
                R.drawable.album_artwork_staind_the_illusion_of_progress_48px));
        songs.add(new Song("I Promised Myslef", "BassHunter"));
        songs.add(new Song("Freefall", "Armin van Buuren ft. BullySongs"));
        songs.add(new Song("So Far Away ", "Avenged Sevenfold"));
        songs.add(new Song("Runaway", "Avril Lavigne"));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called song_list, which is declared in the
        // activity_songs.xml layout file.
        ListView listView = findViewById(R.id.song_list_view);

        // Make the {@link ListView} use the {@link SongAdapter} which was created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        // Image with ID songs_back_image_view, in activity_songs.xml, return to main activity

        ImageView returnButtonSongs = findViewById(R.id.songs_back_image_view);
        returnButtonSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnToMenuIntent = new Intent(SongsActivity.this, MainActivity.class);
                startActivity(returnToMenuIntent);
            }
        });


    }


}
