package projects.lld.spotify.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userid;
    private String username;
    private List<Playlist> playlists;

    public User(String userid, String username) {
        this.userid = userid;
        this.username = username;
        this.playlists = new ArrayList<>();
    }

    public void createPlaylist(String name) {

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
