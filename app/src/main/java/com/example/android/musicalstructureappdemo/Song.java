package com.example.android.musicalstructureappdemo;

/**
 * Created by Garra on 2018-05-22.
 */

public class Song {

    /**
     * Constant value if no album title was provided for  the song
     */
    private static final String NO_ALBUM_TITLE = "";
    /**
     * Constant value if no image was provided for  the song
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Private String variable for song Title
     */
    private String mSongTitle;
    /**
     * Private String variable for song Artist
     */
    private String mArtist;
    /**
     * Private String variable for song album
     */
    private String mAlbumTitle = NO_ALBUM_TITLE;
    /**
     * Image resource ID for the song
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new com.example.android.musicalstructureapp.Songs object.
     *
     * @param songTitle
     * @param artist
     */
    public Song(String songTitle, String artist) {
        mSongTitle = songTitle;
        mArtist = artist;
    }

    /**
     * Create a new com.example.android.musicalstructureapp.Song object.
     *
     * @param songTitle
     * @param artist
     * @param albumTitle
     * @param imageResourceId is the drawable resource ID for the image artwork associated with the song
     */
    public Song(String songTitle, String artist, String albumTitle, int imageResourceId) {
        mSongTitle = songTitle;
        mArtist = artist;
        mAlbumTitle = albumTitle;
        mImageResourceId = imageResourceId;
    }


    /**
     * Method to return song Title
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Method to return song Artist
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Method to return song Album title
     */
    public String getAlbumTitle() {
        return mAlbumTitle;
    }


    /**
     * Returns whether or not there is album title for this song.
     */
    public boolean hasAlbumTitle() {
        return mAlbumTitle != (NO_ALBUM_TITLE);
    }


    /**
     * Return the image resource ID of the song.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this song.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
