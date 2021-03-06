package com.example.android.musicalstructureappdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

/**
 * Created by Garra on 2018-05-22.
 */

public class SongAdapter extends ArrayAdapter<Song> {


    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs
     */
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        final Song currentSong = getItem(position);

        // Find the TextView in the song_list_item.xml layout with the ID song_title_text_view.
        TextView songTitleTextView = listItemView.findViewById(R.id.song_title_text_view);
        // Get the Song Title  from the currentSong object and set this text on
        // the songTitle TextView.
        songTitleTextView.setText(currentSong.getSongTitle());

        // Find the TextView in the song_list_item.xml layout with the ID song_artist_text_view.
        TextView artistTextView = listItemView.findViewById(R.id.song_artist_text_view);
        // Get the Song Artist  from the currentSong object and set this text on
        // the artist TextView.
        artistTextView.setText(currentSong.getArtist());


        // Find the ImageView in the song_list_item.xml layout with the album_artwork_image_view ID .
        ImageView imageView = listItemView.findViewById(R.id.song_artwork_image_view);
        // Check if an image is provided for this song or not
        if (currentSong.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentSong.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise show default image and (set visibility to VISIBLE)
            imageView.setImageResource(R.drawable.icon_album_artwork_default);
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }

        /* Setting OnClickListener working on any item of the listview to get to a nowplaying activity
        after clicking on any song
         */
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Create new intent to open NowPlaying activity
                Intent nowPlayingSongIntent = new Intent(getContext(), NowPlayingActivity.class);
                //Save current song Title and put it in nowPlayingSongIntent intent
                nowPlayingSongIntent.putExtra("EXTRA_TITLE", currentSong.getSongTitle());
                //Save current song Artist and put it in nowPlayingSongIntent intent
                nowPlayingSongIntent.putExtra("EXTRA_ARTIST", currentSong.getArtist());

                //If current song has album title
                //Save current song album Title and put it in nowPlayingSongIntent intent
                if (currentSong.hasAlbumTitle()) {
                    nowPlayingSongIntent.putExtra("EXTRA_ALBUM", currentSong.getAlbumTitle());
                } else {
                    //If current song doesn't have album leave empty and put empty value in intent
                    nowPlayingSongIntent.putExtra("EXTRA_ALBUM", "");
                }

                //If current song has artwork for album
                //Save current song's album artwork and put it in nowPlayingSongIntent intent
                if (currentSong.hasImage()) {
                    nowPlayingSongIntent.putExtra("EXTRA_ARTWORK", currentSong.getImageResourceId());

                    //If current song doesn't have album artwork, set it to default image
                    ////Save default artwork and put it in nowPlayingSongIntent intent
                } else {
                    nowPlayingSongIntent.putExtra("EXTRA_ARTWORK", R.drawable.icon_album_artwork_default);
                }

                //start new activity {nowPlayingActivity}
                getContext().startActivity(nowPlayingSongIntent);

                // Here should be code for music playing, after the song is picked.


            }
        });

        return listItemView;
    }


}
