package projects.lld.spotify.entity;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String playlistid;
    private String name;
    private List<Song> songs;
    private String userid;

    public Playlist(String playlistid, String name, String userid) {
        this.playlistid = playlistid;
        this.name = name;
        this.userid = userid;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {

    }

    public void removeSong(String songid) {

    }
}
